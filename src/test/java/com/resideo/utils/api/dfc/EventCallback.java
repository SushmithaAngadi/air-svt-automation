package com.resideo.utils.api.dfc;

/*import com.microsoft.azure.sdk.iot.device.IotHubMessageResult;
//import com.microsoft.azure.sdk.iot.device.IotHubEventCallback;
import com.microsoft.azure.sdk.iot.device.IotHubStatusCode;
import com.microsoft.azure.sdk.iot.device.Message;
import com.microsoft.azure.sdk.iot.device.MessageCallback;

public class EventCallback implements MessageCallback {

//	@Override
//	public void execute(IotHubStatusCode status, Object context)
//    {
//        Message msg = (Message) context;
//        
//        System.out.println("IoT Hub responded to message "+ msg.getMessageId()  + " with status " + status.name());
//    }

	@Override
	public IotHubMessageResult onCloudToDeviceMessageReceived(Message message, Object callbackContext) {
		// TODO Auto-generated method stub
		return null;
	}
}*/

import java.util.ArrayList;
import java.util.List;

//import com.microsoft.azure.sdk.iot.device.IotHubEventCallback;
import com.microsoft.azure.sdk.iot.device.IotHubStatusCode;
import com.microsoft.azure.sdk.iot.device.Message;
import com.microsoft.azure.sdk.iot.device.MessageSentCallback;
import com.microsoft.azure.sdk.iot.device.exceptions.IotHubClientException;

//public class EventCallback implements IotHubEventCallback {
//
//	@Override
//	public void execute(IotHubStatusCode status, Object context)
//    {
//        Message msg = (Message) context;
//        
//        System.out.println("IoT Hub responded to message "+ msg.getMessageId()  + " with status " + status.name());
//    }
//}

public class EventCallback implements MessageSentCallback
{
	private  static final List<String> failedMessageListOnClose = new ArrayList<>(); 
	
	
    public void onMessageSent(Message sentMessage, IotHubClientException exception,  Object context)
    {
        Message msg = (Message) context;

        IotHubStatusCode status = exception == null ? IotHubStatusCode.OK : exception.getStatusCode();
        System.out.println("IoT Hub responded to message "+ msg.getMessageId()  + " with status " + status.name());

        if (status==IotHubStatusCode.MESSAGE_CANCELLED_ONCLOSE)
        {
            failedMessageListOnClose.add(msg.getMessageId());
        }
    }
}
