package com.resideo.utils.stat.mqtt;

import com.resideo.commons.coreframework.Keyword;
import com.resideo.commons.coreframework.TestCases;
import com.resideo.commons.report.FailType;
//import com.resideo.utils.app.HomeUtils;
import com.resideo.utils.resideo_app.HomeUtils;

import java.util.List;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.TimeUnit;

import org.eclipse.paho.mqttv5.client.MqttAsyncClient;
import org.eclipse.paho.mqttv5.client.MqttConnectionOptions;
import org.eclipse.paho.mqttv5.client.MqttDisconnectResponse;
import org.eclipse.paho.mqttv5.common.MqttMessage;
import org.eclipse.paho.mqttv5.client.IMqttToken;
import org.eclipse.paho.mqttv5.client.MqttCallback;
import org.eclipse.paho.mqttv5.common.MqttException;
import org.eclipse.paho.mqttv5.common.packet.MqttProperties;

public class MqttClientController {
	private static MqttAsyncClient client;
	private static final String CLIENT_ID = "ClientID_" + System.currentTimeMillis();
	private static final ConcurrentHashMap<String, List<String>> receivedMessages = new ConcurrentHashMap<>();

	public static void startMQTTClient() {
		final int maxRetries = 5;
		final int retryDelayInSeconds = 3;
		try {
			if (client != null) {
				if (client.isConnected()) {
					System.out.println("MQTT Client already connected.");
					return;
				} else {
					try {
						client.disconnect();
						client.close();
						System.out.println("Cleaned stale MQTT client instance.");
					} catch (Exception e) {
						System.err.println("Error cleaning old client: " + e.getMessage());
						e.printStackTrace();
					}
				}
			}

			client = new MqttAsyncClient(HomeUtils.getBrokerUrl(), CLIENT_ID);
			MqttConnectionOptions options = new MqttConnectionOptions();
			options.setAutomaticReconnect(false);
			options.setCleanStart(true);
			options.setSessionExpiryInterval(0L);

			client.setCallback(new MqttCallback() {
				@Override
				public void disconnected(MqttDisconnectResponse disconnectResponse) {
					System.err.println("Disconnected: " + disconnectResponse.getReasonString());
				}

				@Override
				public void mqttErrorOccurred(MqttException exception) {
					System.err.println("MQTT Error: " + exception.getMessage());
				}

				@Override
				public void messageArrived(String topic, MqttMessage message) {
					String payload = new String(message.getPayload()).trim();
					receivedMessages.putIfAbsent(topic, new CopyOnWriteArrayList<>());
					receivedMessages.get(topic).add(payload.isEmpty() ? "<EMPTY>" : payload);
				}

				@Override
				public void deliveryComplete(IMqttToken token) {
				}

				@Override
				public void connectComplete(boolean reconnect, String serverURI) {
					System.out
							.println("Connected to MQTT Broker at: " + serverURI + (reconnect ? " (reconnected)" : ""));
				}

				@Override
				public void authPacketArrived(int reasonCode, MqttProperties properties) {
				}
			});

			boolean connected = false;
			int attempt = 0;

			while (!connected && attempt < maxRetries) {
				attempt++;
				try {
					System.out.println("Connecting... Attempt " + attempt);
					IMqttToken token = client.connect(options);
					token.waitForCompletion(10000);
					client.subscribe("#", 1);
					connected = client.isConnected();
				} catch (MqttException e) {
					System.err.println("Connect attempt " + attempt + " failed: " + e.getMessage());
					e.printStackTrace();
					if (attempt < maxRetries) {
						System.out.println("Retrying after " + retryDelayInSeconds + " seconds...");
						try {
							TimeUnit.SECONDS.sleep(retryDelayInSeconds);
						} catch (InterruptedException ie) {
							System.err.println("Retry sleep interrupted: " + ie.getMessage());
							Thread.currentThread().interrupt();
							break;
						}
					}
				}
			}
			if (!connected) {
				String brokerUrl = HomeUtils.getBrokerUrl();
				throw new RuntimeException(
						"MQTT Connection failed after " + maxRetries + " attempts to broker: " + brokerUrl);
			}
		} catch (Exception e) {
			System.err.println("MQTT Startup Failure: " + e.getMessage());
			e.printStackTrace();
			throw new RuntimeException("MQTT Startup Failure", e);
		}
	}


	public static boolean hasMessage(String topic) {
		return receivedMessages.containsKey(topic) && !receivedMessages.get(topic).isEmpty();
	}

	public static String getLastMessage(String topic) {
		if (hasMessage(topic)) {
			List<String> messages = receivedMessages.get(topic);
			return messages.get(messages.size() - 1);
		}
		return null;
	}

	public static boolean destroyMQTTClient(TestCases testCase) {
		boolean flag = false;
		try {
			if (client != null && client.isConnected()) {
				client.disconnect();
				client.close();
				Keyword.ReportStep_Pass(testCase, "Disconnected from MQTT Broker at: " + HomeUtils.getBrokerUrl());
				flag = true;
			}
		} catch (MqttException e) {
			e.printStackTrace();
			Keyword.ReportStep_Fail(testCase, FailType.FUNCTIONAL_FAILURE,
					"Failed to disconnect from MQTT Broker: " + HomeUtils.getBrokerUrl() + e.getMessage());
		}
		return flag;
	}

	public static boolean publish(TestCases testCase, String topic, String payload) {
		int maxRetries = 5;
		int retryDelaySeconds = 3;
		boolean reconnectedAndRetried = false;

		for (int attempt = 1; attempt <= maxRetries; attempt++) {
			try {
				if (client == null || !client.isConnected()) {
					System.err.println("MQTT client disconnected before publish. Attempting reconnect...");
					Keyword.ReportStep_Pass(testCase,
							"MQTT client disconnected before publish. Attempting reconnect...");
					startMQTTClient();
				}
				MqttMessage message = new MqttMessage(payload.getBytes());
				message.setQos(1);
				IMqttToken token = client.publish(topic, message);
				token.waitForCompletion(5000);
				Keyword.ReportStep_Pass(testCase, "[PASS] Published message to topic: " + topic);
				return true;
			} catch (Exception e) {
				String errorMessage = (e.getMessage() != null) ? e.getMessage() : "";
				Keyword.ReportStep_Pass(testCase, "Publish attempt " + attempt + " failed: " + errorMessage);
				if (errorMessage.contains("Connection lost") || errorMessage.contains("SocketException")
						|| errorMessage.contains("Timed out")) {
					if (attempt < maxRetries) {
						System.out.println("Retrying publish after " + retryDelaySeconds + " seconds...");
						Keyword.ReportStep_Pass(testCase,
								"Retrying publish after " + retryDelaySeconds + " seconds...");
						try {
							TimeUnit.SECONDS.sleep(retryDelaySeconds);
						} catch (InterruptedException ex) {
							Keyword.ReportStep_Fail(testCase, FailType.FUNCTIONAL_FAILURE,
									"Retry sleep interrupted: " + ex.getMessage());
							Thread.currentThread().interrupt();
							break;
						}
					} else if (!reconnectedAndRetried) {
						System.err.println("Retries exhausted. Trying reconnect and final publish...");
						Keyword.ReportStep_Pass(testCase, "Retries exhausted. Trying reconnect and final publish...");
						startMQTTClient();
						try {
							MqttMessage message = new MqttMessage(payload.getBytes());
							message.setQos(1);
							IMqttToken token = client.publish(topic, message);
							token.waitForCompletion(5000);
							Keyword.ReportStep_Pass(testCase,
									"Published message after reconnect to topic: " + topic);
							return true;
						} catch (Exception finalEx) {
							System.err.println("Final publish after reconnect failed: " + finalEx.getMessage());
							Keyword.ReportStep_Fail(testCase, FailType.FUNCTIONAL_FAILURE,
									"Final publish after reconnect failed: " + finalEx.getMessage());
							break;
						}
					}
				} else {
					System.out.println("Unrecoverable publish error. Not retrying further.");
					Keyword.ReportStep_Fail(testCase, FailType.FUNCTIONAL_FAILURE,
							"Unrecoverable publish error. Not retrying further. Check payload or topic.");
					break;
				}
			}
		}
		System.err.println("Failed to publish message to topic: " + topic + " after full retries and reconnect.");
		Keyword.ReportStep_Fail(testCase, FailType.FUNCTIONAL_FAILURE,
				"Failed to publish message to topic: " + topic + " after full retries and reconnect.");
		return false;
	}

	public static void clearReceivedMessagesBuffer(TestCases testCase) {
		receivedMessages.clear();
		System.out.println("Received messages list cleared.");
		Keyword.ReportStep_Pass(testCase, "Received messages list cleared.");
	}
}