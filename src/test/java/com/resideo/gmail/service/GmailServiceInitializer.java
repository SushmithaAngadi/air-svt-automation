package com.resideo.gmail.service;

import com.google.api.client.auth.oauth2.Credential;
import com.google.api.client.extensions.java6.auth.oauth2.AuthorizationCodeInstalledApp;
import com.google.api.client.extensions.jetty.auth.oauth2.LocalServerReceiver;
import com.google.api.client.googleapis.auth.oauth2.GoogleAuthorizationCodeFlow;
import com.google.api.client.googleapis.auth.oauth2.GoogleClientSecrets;
import com.google.api.client.googleapis.javanet.GoogleNetHttpTransport;
import com.google.api.client.http.javanet.NetHttpTransport;
import com.google.api.client.json.JsonFactory;
import com.google.api.client.json.gson.GsonFactory;
import com.google.api.client.util.store.FileDataStoreFactory;
import com.google.api.services.gmail.Gmail;
import com.google.api.services.gmail.GmailScopes;

import java.io.*;
import java.security.GeneralSecurityException;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class GmailServiceInitializer {
    /**
     * Application name.
     */
    private static final String APPLICATION_NAME = "Gmail API Java";
    /**
     * Global instance of the JSON factory.
     */
    private static final JsonFactory JSON_FACTORY = GsonFactory.getDefaultInstance();
    /**
     * Directory to store authorization tokens for this application.
     */
    private static final String TOKENS_DIRECTORY_PATH = "tokens";
    /**
     * Global instance of the scopes required to initialize the required gmail services.
     * If modifying these scopes, delete your previously saved tokens/ folder.
     */
    private static final List<String> SCOPES = new ArrayList<>();
    private static final String CREDENTIALS_FILE_PATH = "src/test/resources/credentials.json";
    static GmailServiceInitializer gmailServiceInitializer = new GmailServiceInitializer();

    /**
     * Singleton implementation of the class
     */
    public static synchronized GmailServiceInitializer getInstance() {
        System.out.println("-----------Initializing Gmail Service------------");
        if (Objects.isNull(gmailServiceInitializer)) {
            gmailServiceInitializer = new GmailServiceInitializer();
        }
        return gmailServiceInitializer;
    }

    private static Credential getCredentials(final NetHttpTransport httpTransport)
            throws IOException {
        // Load client secrets.
        System.out.println("-----------Getting Credentials------------");
        String credentialFile = System.getProperty("user.dir") + File.separator + CREDENTIALS_FILE_PATH;
        System.out.println("Generating tokens from file in project Directory: " + credentialFile);
        InputStream inputStream = new FileInputStream(CREDENTIALS_FILE_PATH);
        GoogleClientSecrets clientSecrets =
                GoogleClientSecrets.load(JSON_FACTORY, new InputStreamReader(inputStream));
        //SCOPES.add(GmailScopes.GMAIL_READONLY);
        SCOPES.add(GmailScopes.MAIL_GOOGLE_COM);
//        SCOPES.add(GmailScopes.GMAIL_MODIFY);
//        SCOPES.add(GmailScopes.GMAIL_LABELS);
        System.out.println("Gmail scopes: " + SCOPES);
        // Build flow and trigger user authorization request.
        GoogleAuthorizationCodeFlow flow = new GoogleAuthorizationCodeFlow.Builder(
                httpTransport, JSON_FACTORY, clientSecrets, SCOPES)
                .setDataStoreFactory(new FileDataStoreFactory(new File(TOKENS_DIRECTORY_PATH)))
                .setAccessType("offline")
                .build();
        System.out.println("Tokens generated successfully - Path - " + TOKENS_DIRECTORY_PATH);
        LocalServerReceiver receiver = new LocalServerReceiver.Builder().setPort(8888).build();
        return new AuthorizationCodeInstalledApp(flow, receiver).authorize("user");
    }

    public Gmail getService() throws GeneralSecurityException, IOException {
        System.out.println("----------Gmail Service provider------------");
        // Build a new authorized API client service.
        final NetHttpTransport httpTransport = GoogleNetHttpTransport.newTrustedTransport();
        return new Gmail.Builder(httpTransport, JSON_FACTORY, getCredentials(httpTransport))
                .setApplicationName(APPLICATION_NAME)
                .build();
    }

}
