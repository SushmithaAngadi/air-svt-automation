package com.resideo.utils.stat.mqtt;


import org.json.JSONObject;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.resideo.fileio.utils.JsonUtils;

public class MqttJsonConfig {
	private static final String JSON_FILE_NAME = "Mqtt_config.json";
	private static JSONObject rootNode;
	private static final ObjectMapper objectMapper = new ObjectMapper();

	static {
		try {
			rootNode = JsonUtils.ReadJosn(JSON_FILE_NAME);
			if (rootNode == null) {
				throw new Exception("Failed to load Mqtt_config.json!");
			}
		} catch (Exception e) {
			System.err.println("Error loading Mqtt_config.json: " + e.getMessage());
			e.printStackTrace();
		}
	}

	public static String getTopic(String category, String key) {
		if (rootNode != null && rootNode.has(category)) {
			JSONObject categoryNode = rootNode.getJSONObject(category);
			if (categoryNode.has(key)) {
				return categoryNode.getJSONObject(key).getString("Topic");
			}
		}
		return null;
	}

	public static String generateSetTopic(String category, String key) {
		String baseTopic = getTopic(category, key);
		return (baseTopic != null) ? "@/SET" + baseTopic : null;
	}

	public static String generateGetTopic(String category, String key) {
		String baseTopic = getTopic(category, key);
		return (baseTopic != null) ? "@/GET" + baseTopic : null;
	}

	public static String getPayloadValue(String category, String key, String payloadKey) {
		try {
			if (rootNode.has(category) && rootNode.getJSONObject(category).has(key)) {
				JSONObject keyNode = rootNode.getJSONObject(category).getJSONObject(key);
				if (keyNode.has("Payload")) {
					JSONObject payloadNode = keyNode.getJSONObject("Payload");

					for (String field : payloadNode.keySet()) {
						if (field.equalsIgnoreCase(payloadKey)) {
							return payloadNode.optString(field, "UNKNOWN");
						}
					}
				}
			}
			return "UNKNOWN";
		} catch (Exception e) {
			e.printStackTrace();
			return "ERROR";
		}
	}

	public static String getKeyByTopic(String topic) {
		try {
			JSONObject rootNode = JsonUtils.ReadJosn(JSON_FILE_NAME);

			for (String category : rootNode.keySet()) {
				JSONObject categoryNode = rootNode.getJSONObject(category);

				for (String key : categoryNode.keySet()) {
					JSONObject keyNode = categoryNode.getJSONObject(key);
					if (keyNode.has("Topic") && keyNode.getString("Topic").equals(topic)) {
						return key;
					}
				}
			}
		} catch (Exception e) {
			System.out.println("Error fetching key by topic: " + e.getMessage());
		}
		return null;
	}

	public static JsonNode getPayload(String category, String key) {
		try {
			if (!rootNode.has(category)) {
				System.out.println("Category '" + category + "' not found in JSON!");
				return null;
			}

			JSONObject categoryNode = rootNode.getJSONObject(category);
			if (!categoryNode.has(key)) {
				System.out.println("Key '" + key + "' not found under category '" + category + "'!");
				return null;
			}

			JSONObject keyNode = categoryNode.getJSONObject(key);
			if (!keyNode.has("Payload")) {
				System.out.println("Payload not found for key '" + key + "'!");
				return null;
			}

			JSONObject payloadJson = keyNode.getJSONObject("Payload");
			JsonNode jsonNode = objectMapper.readTree(payloadJson.toString());
			return jsonNode;
		} catch (Exception e) {
			System.out.println("Error fetching payload: " + e.getMessage());
			e.printStackTrace();
			return null;
		}
	}

	public static String getKeyOfPayloadValue(String category, String key, String payloadValue) {
		try {
			if (rootNode.has(category) && rootNode.getJSONObject(category).has(key)) {
				JSONObject keyNode = rootNode.getJSONObject(category).getJSONObject(key);
				if (keyNode.has("Payload")) {
					JSONObject payloadNode = keyNode.getJSONObject("Payload");

					for (String field : payloadNode.keySet()) {
						if (payloadNode.optString(field).equals(payloadValue)) {
							return field;
						}
					}
				}
			}
			return "UNKNOWN";
		} catch (Exception e) {
			e.printStackTrace();
			return "ERROR";
		}
	}

	public static String deriveResponseTopic(String topic, String parent) {
		if (topic == null || topic.isEmpty())
			return topic;
		if (parent.toUpperCase().contains("PARENT")) {
			if (topic.startsWith("@/")) {
				topic = topic.substring(2);
			}
			int lastSlashIndex = topic.lastIndexOf("/");
			if (lastSlashIndex > 0) {
				return "@" + topic.substring(0, lastSlashIndex);
			}
		}
		return "@" + topic;
	}
	
	public static String getKeyOfPayloadValueOfISU(String deviceName, String featureKey, String isuKey, int value) {
		try {
			if (rootNode.has(deviceName) && rootNode.getJSONObject(deviceName).has(featureKey)) {
				JSONObject keyNode = rootNode.getJSONObject(deviceName).getJSONObject(featureKey);
				if (keyNode.has("Payload")) {
					JSONObject payloadNode = keyNode.getJSONObject("Payload");
					if (payloadNode.has(isuKey)) {
						JSONObject isuItemVAlueKey = payloadNode.getJSONObject(isuKey).getJSONObject("ItemValue");
						for (String field : isuItemVAlueKey.keySet()) {
							if (isuItemVAlueKey.get(field).equals(value)) {
								return field;
							}
						}
					}
				}
			}
			return "UNKNOWN";
		} catch (Exception e) {
			e.printStackTrace();
			return "ERROR";
		}
	}
}