package com.resideo.gmail.actions;

import com.google.api.services.gmail.Gmail;
import com.google.api.services.gmail.model.*;
import com.google.common.reflect.TypeToken;
import com.google.gson.Gson;
import com.resideo.gmail.service.GmailServiceInitializer;
import com.jayway.jsonpath.JsonPath;
import org.json.JSONArray;
import org.json.JSONObject;
import org.jsoup.Jsoup;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.lang.reflect.Type;
import java.nio.charset.StandardCharsets;
import java.text.SimpleDateFormat;
import java.util.*;

public class GmailActions {
    private static final String USER_ID = "me";
    private static GmailActions gmailActions;
    private final Gmail service;
    private final String UNREAD_MESSAGE = "UNREAD";
    private final String CUSTOM_REPORT_DIR;

    private GmailActions() {
        System.out.println("----------------Initializing the gmail service-----------------");

        GmailServiceInitializer gmailCredentials = GmailServiceInitializer.getInstance();
        try {
            service = gmailCredentials.getService();
            CUSTOM_REPORT_DIR = System.getProperty("user.dir") + File.separator + "src/test/resources/LOGS_FOLDER/FA_AppLogs_Comfort_System_Automation_" + new SimpleDateFormat("yyyy_MM_dd_HH_mm_ss").format(new Date());
        } catch (Exception exception) {
            System.out.println("Unable to initiate the Gmail service Exception" + exception.getMessage());
            throw new RuntimeException();
        }
    }

    public static GmailActions getInstance() {
        if (Objects.isNull(gmailActions))
            gmailActions = new GmailActions();
        return gmailActions;
    }

    public List<Message> listMessagesMatchingQuery(String userId,
                                                   String query) throws IOException {
        ListMessagesResponse response = service.users().messages().list(userId).setQ(query).execute();
        List<Message> messages = new ArrayList<>();
        while (response.getMessages() != null) {
            messages.addAll(response.getMessages());
            if (response.getNextPageToken() != null) {
                String pageToken = response.getNextPageToken();
                response = service.users().messages().list(userId).setQ(query)
                        .setPageToken(pageToken).execute();
            } else {
                break;
            }
        }
        return messages;
    }

    private Message getMessage(List<Message> messages)
            throws IOException {
        System.out.println("Getting messages from the user");
        return service.users().messages().get(USER_ID, messages.get(0).getId()).execute();
    }

    private JSONObject getMessageResponse(String subject) {
        Message message;
        List<Message> messages;
        try {
            messages = listMessagesMatchingQuery(USER_ID, subject);
            message = getMessage(messages);
        } catch (Exception e) {
            throw new RuntimeException("Unable to find the email: " + subject);
        }
        return new JSONObject(message.toString());
    }

    private List<MessagePart> getMessageParts(Message message) {
        return message.getPayload().getParts();
    }

    private String getMessageBody(String subject) {
        System.out.println("Getting the unread message of subject: " + subject);
        JSONObject messageResponse = getMessageResponse(subject);
        JSONArray labelsArray = messageResponse.getJSONArray("labelIds");
        List<String> labels = getLabels(labelsArray);
        String body = null;
        if (labels.contains(UNREAD_MESSAGE)) {
            try {
                body = new String(Base64.getUrlDecoder().decode(JsonPath.read(messageResponse.toString(), "payload.parts[0].body.data").toString().replace("null", "")), StandardCharsets.UTF_8);
            } catch (Exception parseBodyFirst) {
                try {
                    body = new String(Base64.getUrlDecoder().decode(JsonPath.read(messageResponse.toString(), "payload.parts[0].parts[0].body.data").toString().replace("null", "")), StandardCharsets.UTF_8);
                } catch (Exception parseBodySecond) {
                    System.out.println("Unable to find the body of of the email, hence returning null. Make sure the email has proper body data : " + parseBodySecond.getMessage());
                    body = new RuntimeException("Unable to find the body of of the email, hence returning null. Make sure the email has proper body data").getMessage();
                }
            }
        }
        return body;
    }

    private List<String> getGmailAttachments(List<MessagePart> messageParts, String customFileName) throws RuntimeException {
        System.out.println("Finding the attachments");
        List<String> fileNames = new ArrayList<>();
        String outPutDirectory;
        List<String> attachmentsList = new ArrayList<>();
        String dir = createDirectoryIfNotExists();
        if (!dir.endsWith("/")) {
            dir += "/";
        }
        if (messageParts != null) {
            for (MessagePart part : messageParts) {
                //For each part, see if it has a file name, if it does it's an attachment
                if ((part.getFilename() != null && part.getFilename().length() > 0)) {
                    String filename = part.getFilename();
                    String attId = part.getBody().getAttachmentId();
                    MessagePartBody attachPart;
                    FileOutputStream fileOutFile = null;
                    try {
                        //Go get the attachment part and get the bytes
                        attachPart = service.users().messages().attachments().get(USER_ID, part.getPartId(), attId).execute();
                        byte[] fileByteArray = Base64.getUrlDecoder().decode(attachPart.getData());
                        //Write the attachment to the output dir
                        outPutDirectory = dir;
                        attachmentsList.add(outPutDirectory);
                        fileOutFile = new FileOutputStream(dir + customFileName);
                        fileOutFile.write(fileByteArray);
                        fileOutFile.close();
                        System.out.println("Location of the downloaded attachment : " + outPutDirectory);
                        fileNames.add(filename);
                    } catch (IOException e) {
                        System.out.println("Attachments not found with this email");
                        throw new RuntimeException(e);
                    } finally {
                        if (fileOutFile != null) {
                            try {
                                fileOutFile.close();
                            } catch (IOException e) {
                                // probably doesn't matter
                            }
                        }
                    }
                } else if (part.getMimeType().equals("multipart/related") && part.getParts() != null) {
                    getGmailAttachments(part.getParts(), customFileName);
                }
            }
        }
        return attachmentsList;
    }

    private void markAsRead(String messageId) {
        System.out.println("Marking email as Read");
        String inbox = "INBOX";
        ModifyMessageRequest mods =
                new ModifyMessageRequest()
                        .setAddLabelIds(Collections.singletonList(inbox))
                        .setRemoveLabelIds(Collections.singletonList(UNREAD_MESSAGE));
        Message message;
        if (Objects.nonNull(messageId)) {
            try {
                message = service.users().messages().modify(USER_ID, messageId, mods).execute();
                System.out.println("Message id marked as read: " + message.getId());
            } catch (Exception e) {
                System.out.println("Unable to mark email as read: " + e.getMessage());
                throw new RuntimeException("Unable to mark message as Read");
            }
        }
    }

    private void deleteEmail(String messageId) {
        System.out.println("Deleting the message");
        if (Objects.nonNull(messageId)) {
            try {
                service.users().messages().delete("me", messageId).execute();
                System.out.println("Deleted the message with id: " + messageId);
            } catch (Exception e) {
                System.out.println("Unable to mark email as read: " + e.getMessage());
                throw new RuntimeException("Unable to mark message as Read");
            }
        }
    }


    /**
     * Creates a directory for storing attachments if it doesn't exist
     *
     * @return Path to the created or existing directory
     */
    private String createDirectoryIfNotExists() {
        File dir = new File(CUSTOM_REPORT_DIR);
        if (!dir.exists()) {
            if (dir.mkdirs()) {
                System.out.println("Created directory: " + CUSTOM_REPORT_DIR);
            } else {
                System.out.println("Failed to create directory: " + CUSTOM_REPORT_DIR);
                throw new RuntimeException("Failed to create directory: " + CUSTOM_REPORT_DIR);
            }
        }
        return CUSTOM_REPORT_DIR;
    }

    public List<String> getLabels(JSONArray jsonArray) {
        Gson converter = new Gson();
        Type type = new TypeToken<List<String>>() {
        }.getType();
        return converter.fromJson(String.valueOf(jsonArray), type);
    }

    public JSONObject getGmailResponse(String subject, String customFileName) {
        String query = "subject:".concat(subject);
        Map<String, String> gmailDataMap = new LinkedHashMap<>();
        List<Message> messages;
        Message message;
        System.out.println("------------Gmail Response --------------");
        try {
            messages = listMessagesMatchingQuery(USER_ID, query);
            message = getMessage(messages);
        } catch (Exception exception) {
            throw new RuntimeException("Unable to get the message:");
        }
        JSONObject messageResponse = getMessageResponse(query);
        JSONArray labelsArray = messageResponse.getJSONArray("labelIds");
        List<String> labels = getLabels(labelsArray);
        System.out.println("Gmail Labels: " + labels);
        String gmailBody;
        List<String> gmailAttachments;
        if (labels.contains(UNREAD_MESSAGE)) {
            System.out.println("Reading the the Gmail contains label as UNREAD: " + subject);
            gmailBody = Jsoup.parse(getMessageBody(query)).text();
            gmailAttachments = getGmailAttachments(getMessageParts(message), customFileName);
            gmailDataMap.put("subject", subject);
            System.out.println("Gmail Subject: " + subject);
            gmailDataMap.put("body", gmailBody);
            System.out.println("Gmail Body post parsing the HTML: " + gmailBody);
            if (Objects.nonNull(gmailAttachments)) {
                gmailDataMap.put("attachments", gmailAttachments.toString());
                System.out.println("Attachments: " + gmailAttachments);
            } else {
                System.out.println("This Gmail: " + subject + " - doesn't contains attachments");
            }
            markAsRead(message.getId());
            System.out.println("Successfully Latest UNREAD Gmail: " + subject);
            deleteEmail(message.getId());
            System.out.println("Returning the JSONObject contains 'body', 'subject' & 'attachments'");
            return new JSONObject(gmailDataMap);
        }
        System.out.println("Unable to find the latest UNREAD gmail with subject: " + subject);

        return null;
    }
}
