package com.resideo.utils.stat.mqtt;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.resideo.commons.coreframework.Keyword;
import com.resideo.commons.coreframework.SuiteConstants;
import com.resideo.commons.coreframework.TestCases;
import com.resideo.commons.coreframework.SuiteConstants.SuiteConstantTypes;
import com.resideo.commons.report.FailType;

import java.io.IOException;
import java.io.InputStream;
import java.time.Duration;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.TimeUnit;
import java.util.function.Function;
import java.util.regex.Pattern;

import org.json.JSONArray;
import org.json.JSONObject;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;

public class MqttManager {

	private static boolean isSerialMethod = false;
	private static String deviceName = "Denali";

	public static boolean getIsSerialMethod() {
		return isSerialMethod;
	}

	public static void setIsSerialMethod(boolean serialMethod) {
		isSerialMethod = serialMethod;
	}

	public static boolean setMode(TestCases testCase, String featureKey, String modeType) {
		try {
			String setTopic = MqttJsonConfig.generateSetTopic(deviceName, featureKey);
			String payload = MqttJsonConfig.getPayloadValue(deviceName, featureKey, modeType);

			if (getMode(testCase, featureKey).equalsIgnoreCase(modeType)) {
				Keyword.ReportStep_Pass(testCase, "Mode already set to: " + modeType);
				return true;
			}
			if (publishMqttCommand(testCase, setTopic, payload)) {
				Keyword.ReportStep_Pass(testCase, "Published message to topic: " + setTopic + " Payload: " + payload);

				FluentWait<TestCases> wait = new FluentWait<>(testCase).withTimeout(Duration.ofSeconds(20))
						.pollingEvery(Duration.ofSeconds(2)).ignoring(Exception.class);
				boolean result = wait.until(new Function<TestCases, Boolean>() {
					public Boolean apply(TestCases t) {
						String currentMode = getMode(testCase, featureKey);
						System.out.println("Current Mode is: " + currentMode);
						if (currentMode.equalsIgnoreCase(modeType)) {
							Keyword.ReportStep_Pass(testCase, "Mode set successfully to: " + currentMode);
							return true;
						} else {
							publishMqttCommand(testCase, MqttJsonConfig.generateGetTopic(deviceName, featureKey), "");
							return false;
						}
					}
				});
				return result;
			}
		} catch (Exception e) {
			System.out.println("Error in setMode: " + e.getMessage());
			Keyword.ReportStep_Fail(testCase, FailType.FUNCTIONAL_FAILURE, "An error occurred: " + e.getMessage());
			e.printStackTrace();
		}
		return false;
	}

	public static String getMode(TestCases testCase, String featureKey) {
		String getTopic = MqttJsonConfig.generateGetTopic(deviceName, featureKey);
		String expPayloadString = null;
		String response = null;

		if (featureKey.toUpperCase().contains("SYSTEMMODE")) {
			expPayloadString = "CurrentMode";
		} else if (featureKey.toUpperCase().contains("FAN")) {
			expPayloadString = "SwitchPosition";
		}

		String parentTopic = MqttJsonConfig.deriveResponseTopic(MqttJsonConfig.getTopic(deviceName, featureKey),
				"parentTopic");
		if (publishMqttCommand(testCase, getTopic, "")) {
			Keyword.ReportStep_Pass(testCase, "Get request sent to topic: " + getTopic);
			response = getRequiredMsgFromResponse(parentTopic);
			if (response != null) {
				try {
					JSONObject jsonObject = new JSONObject(response);
					String currentModes = String.valueOf(jsonObject.getInt(expPayloadString));
					return MqttJsonConfig.getKeyOfPayloadValue(deviceName, featureKey, currentModes);
				} catch (Exception e) {
					System.out.println("An error occurred: " + e.getMessage());
				}
			}
		}
		return null;
	}

	public static boolean modifyHeatCoolSp(TestCases testCase, String heatCool, String heatCoolSpValue) {
		try {
			String setTopic = MqttJsonConfig.generateSetTopic(deviceName, "SpStatus");
			String heatCoolSp = MqttJsonConfig.getPayloadValue(deviceName, "SpStatus", heatCool);
			String payload = String.format("{\"%s\": %s, \"Status\": 3}", heatCoolSp, heatCoolSpValue);

			if (!heatCool.equalsIgnoreCase(getMode(testCase, "SystemMode"))
					&& !setMode(testCase, "SystemMode", heatCool)) {
				Keyword.ReportStep_Fail(testCase, FailType.FUNCTIONAL_FAILURE,
						"Failed to modify SystemMode to: " + heatCool);
				return false;
			}
			if (heatCoolSpValue.equalsIgnoreCase(getHeatCoolSpValue(testCase, heatCoolSp)))
				return true;
			if (!publishMqttCommand(testCase, setTopic, payload))
				return false;

			return new FluentWait<>(testCase).withTimeout(Duration.ofSeconds(20)).pollingEvery(Duration.ofSeconds(2))
					.ignoring(Exception.class).until(t -> {
						String actualSP = getHeatCoolSpValue(testCase, heatCoolSp);
						return actualSP != null && actualSP.equalsIgnoreCase(heatCoolSpValue);
					});
		} catch (Exception e) {
			Keyword.ReportStep_Fail(testCase, FailType.FUNCTIONAL_FAILURE,
					"Exception in modifyHeatCoolSp: " + e.getMessage());
			return false;
		}
	}

	public static String getHeatCoolSpValue(TestCases testCase, String heatCoolSp) {
		String topic = MqttJsonConfig.getTopic(deviceName, "SpStatus");
		String getTopic = MqttJsonConfig.generateGetTopic(deviceName, "SpStatus");
		String response = null;

		String parentTopic = MqttJsonConfig.deriveResponseTopic(topic, "childTopic");
		if (publishMqttCommand(testCase, getTopic, "")) {
			Keyword.ReportStep_Pass(testCase, "Get request sent to topic: " + getTopic);
			response = getRequiredMsgFromResponse(parentTopic);
			if (response != null) {
				try {
					JSONObject jsonObject = new JSONObject(response);
					return String.valueOf(jsonObject.getInt(heatCoolSp));
				} catch (Exception e) {
					Keyword.ReportStep_Fail(testCase, FailType.FUNCTIONAL_FAILURE,
							"An error occurred: " + e.getMessage());
				}
			}
		}
		return null;
	}

	public static String convertToFahrenheit(String tempStr) {
		/**
		 * Converts the given temperature (C or F) to a set point value (F) and
		 * multiplies by 100. return the calculated heat or cool set point value as a
		 * String
		 */
		if (tempStr == null || tempStr.trim().isEmpty()) {
			throw new IllegalArgumentException("Temperature string cannot be null or empty");
		}

		tempStr = tempStr.toUpperCase().trim();
		String numericPart = tempStr.replaceAll("[^\\d.]", "");
		double value;
		if (tempStr.contains("C")) {
			value = (Double.parseDouble(numericPart) * 1.8) + 32;
		} else {
			value = Double.parseDouble(numericPart);
		}
		return String.valueOf((int) Math.round(value * 100));
	}

	public static boolean verifyRelayStatus(TestCases testCase, String relayType, String expectedStatus,
			Duration timeout) {
		try {
			FluentWait<Boolean> fWait = new FluentWait<>(true).pollingEvery(Duration.ofSeconds(5)).withTimeout(timeout)
					.ignoring(Exception.class);

			return fWait.until(flag -> {
				try {
					String topic = MqttJsonConfig.getTopic(deviceName, "Relays");
					String getTopic = MqttJsonConfig.generateGetTopic(deviceName, "Relays");
					String parentTopic = MqttJsonConfig.deriveResponseTopic(topic, "Parent");
					String response = null;
					if (publishMqttCommand(testCase, getTopic, "")) {
						Keyword.ReportStep_Pass(testCase, "Get request sent to topic: " + getTopic);
						response = getRequiredMsgFromResponse(parentTopic);
						if (response != null) {
							ObjectMapper mapper = new ObjectMapper();
							JsonNode relaysNode = mapper.readTree(response).get("Relays_");
							if (relaysNode == null || !relaysNode.isArray()) {
								Keyword.ReportStep_Fail(testCase, FailType.FUNCTIONAL_FAILURE,
										"Missing 'Relays_' array in response.");
								return false;
							}

							List<String> expectedRelays = new ArrayList<>();
							List<String> actualRelaysOn = new ArrayList<>();
							List<String> mismatchedRelays = new ArrayList<>();

							for (String singleRelay : relayType.split(":")) {
								String relayName = singleRelay.trim();
								expectedRelays.add(relayName);

								JsonNode relayIdNode = MqttJsonConfig.getPayload(deviceName, "Relays").get(relayName);
								if (relayIdNode == null || !relayIdNode.isInt()) {
									Keyword.ReportStep_Fail(testCase, FailType.FUNCTIONAL_FAILURE,
											"Relay mapping missing or invalid for: " + relayName);
									mismatchedRelays.add(relayName);
									continue;
								}

								int relayId = relayIdNode.asInt();
								JsonNode relayData = relaysNode.get(relayId);
								if (relayData == null || !relayData.has("active")) {
									Keyword.ReportStep_Fail(testCase, FailType.FUNCTIONAL_FAILURE,
											"No 'active' data found for relay ID: " + relayId);
									mismatchedRelays.add(relayName);
									continue;
								}

								int active = relayData.get("active").asInt();
								String actual = (active == 1) ? "ON" : "OFF";
								String expected = expectedStatus.equalsIgnoreCase("ON") ? "ON" : "OFF";

								if (actual.equalsIgnoreCase(expected)) {
									actualRelaysOn.add(relayName);
								} else {
									mismatchedRelays.add(relayName);
								}
							}

							Keyword.ReportStep_Pass(testCase, "Expected Relays : " + expectedRelays + " to be ["
									+ expectedStatus.toUpperCase() + "]");
							Keyword.ReportStep_Pass(testCase,
									"Actual Relays   : " + expectedRelays + " are ["
											+ (actualRelaysOn.size() == expectedRelays.size()
													? expectedStatus.toUpperCase()
													: "not " + expectedStatus.toUpperCase())
											+ "]");

							if (!mismatchedRelays.isEmpty()) {
								Keyword.ReportStep_Pass(testCase, mismatchedRelays + " are not in expected ["
										+ expectedStatus.toUpperCase() + "] state.");
								return false;
							}
							return true;
						} else {
							Keyword.ReportStep_Fail(testCase, FailType.FUNCTIONAL_FAILURE,
									"No response received from topic: " + parentTopic);
							return false;
						}
					}
					return false;
				} catch (Exception e) {
					Keyword.ReportStep_Fail(testCase, FailType.FUNCTIONAL_FAILURE,
							"Retrying due to error: " + e.getMessage());
					return false;
				}
			});
		} catch (Exception e) {
			Keyword.ReportStep_Fail(testCase, FailType.FUNCTIONAL_FAILURE,
					"Error while verifying relay status: " + e.getMessage());
			return false;
		}
	}

	public static boolean setIndoorTemp(TestCases testCase, String expTempValue) {
		String setTopic = MqttJsonConfig.generateSetTopic(deviceName, "IndoorTemp");
		String payload = String.format("{\"Status\": \"Ok\", \"Value\": %s}", expTempValue);

		if (expTempValue.equals(getIndoorTemp(testCase))) {
			Keyword.ReportStep_Pass(testCase, "Indoor temperature is already set to expected value: " + expTempValue);
			return true;
		}

		if (publishMqttCommand(testCase, setTopic, payload)) {
			Keyword.ReportStep_Pass(testCase, "Message published to topic: " + setTopic + " Payload: " + payload);
			FluentWait<Boolean> wait = new FluentWait<>(true).withTimeout(Duration.ofMinutes(3))
					.pollingEvery(Duration.ofSeconds(2)).ignoring(Exception.class);
			return wait.until(flag -> {
				return expTempValue.equals(getIndoorTemp(testCase));
			});
		}
		return false;
	}

	public static String getIndoorTemp(TestCases testCase) {
		String response = null;
		String getTopic = MqttJsonConfig.generateGetTopic(deviceName, "IndoorTemp");
		String parentTopic = MqttJsonConfig.deriveResponseTopic(MqttJsonConfig.getTopic(deviceName, "IndoorTemp"),
				"Child");

		if (publishMqttCommand(testCase, getTopic, "")) {
			Keyword.ReportStep_Pass(testCase, "Get request sent to topic: " + getTopic);
			response = getRequiredMsgFromResponse(parentTopic);
			if (response != null) {
				try {
					JSONObject jsonObject = new JSONObject(response);
					return String.valueOf(jsonObject.getInt("Value"));
				} catch (Exception e) {
					System.out.println("An Exception Occurred:" + e.getMessage());
				}
			}
		}
		return null;
	}

	public static boolean setISU(TestCases testCase, String featureKey, String isuKey, String isuValue) {
		boolean flag = false;
		if (setIsuSessionOpen(testCase, true)) {
			if (isuValue.equalsIgnoreCase(getISU(testCase, featureKey, isuKey))) {
				flag = true;
				Keyword.ReportStep_Pass(testCase,
						"Required value is already set , ISU item :" + isuKey + ", ISU Value: " + isuValue);
			} else {
				if (setIsuItem(testCase, featureKey, isuKey)) {
					Keyword.ReportStep_Pass(testCase, "Successfully set the ISU item to: " + isuKey);
					if (setIsuInfoValue(testCase, "IsuItemValue", isuKey, isuValue)) {
						flag = true;
						Keyword.ReportStep_Pass(testCase, "Successfully set the ISU Value to: " + isuValue);
					} else {
						Keyword.ReportStep_Fail(testCase, FailType.COSMETIC_FAILURE,
								"Failed To set the ISU Value :" + isuValue);
					}
				} else {
					Keyword.ReportStep_Fail(testCase, FailType.COSMETIC_FAILURE,
							"Failed To set the ISU item :" + isuKey);
				}
			}
		} else {
			Keyword.ReportStep_Fail(testCase, FailType.COSMETIC_FAILURE, "Failed to open the IsIsuSessionOpen");
		}
		return flag;
	}

	public static String getISU(TestCases testCase, String featureKey, String isuKey) {
		if (setIsuSessionOpen(testCase, true)) {
			if (setIsuItem(testCase, featureKey, isuKey)) {
				Keyword.ReportStep_Pass(testCase, "Successfully set the ISU item in Mqtt.");
				return getIsuInfoValue(testCase, "IsuItemValue", isuKey);
			} else {
				Keyword.ReportStep_Fail(testCase, FailType.COSMETIC_FAILURE, "Failed To set the ISU item :" + isuKey);
			}
		} else {
			Keyword.ReportStep_Fail(testCase, FailType.COSMETIC_FAILURE, "Failed to open the IsIsuSessionOpen");
		}
		return null;
	}

	public static boolean setIsuInfoValue(TestCases testCase, String featureKey, String isuKey, String isuValue) {
		boolean flag = false;

		try {
			Map<Integer, Integer> valueMap = new LinkedHashMap<>();

			JsonNode itemJson = MqttJsonConfig.getPayload(deviceName, "IsuItem").get(isuKey);
			int primaryItemId = itemJson.get("Item").asInt();
			int primaryValue = itemJson.get("ItemValue").get(isuValue).asInt();
			valueMap.put(primaryItemId, primaryValue);

			if (isuValue.contains("ISU_2071_HEAT_STAGES") || isuValue.contains("ISU_2070_COOL_STAGES")) {
				String counterpartKey = isuValue.contains("ISU_2071_HEAT_STAGES") ? "ISU_COOL_STAGES"
						: "ISU_HEAT_STAGES";
				JsonNode counterpartNode = MqttJsonConfig.getPayload(deviceName, "IsuItem").get(counterpartKey);
				int counterpartItemId = counterpartNode.get("Item").asInt();

				if (publishMqttCommand(testCase, MqttJsonConfig.generateGetTopic(deviceName, featureKey), "")) {
					String getResponse = getRequiredMsgFromResponse(MqttJsonConfig
							.deriveResponseTopic(MqttJsonConfig.getTopic(deviceName, featureKey), "Child"));
					if (getResponse != null) {
						JSONObject jsonObject = new JSONObject(getResponse);
						JSONArray valuesArray = jsonObject.getJSONArray("Values");

						for (int i = 0; i < valuesArray.length(); i++) {
							JSONObject item = valuesArray.getJSONObject(i);
							if (item.getInt("ItemID") == counterpartItemId) {
								int currentValue = item.getInt("Value");
								valueMap.put(counterpartItemId, currentValue);
							}
						}
					}
				}
			}

			JSONArray valuesArray = new JSONArray();
			valueMap.entrySet().stream().sorted(Map.Entry.comparingByKey()).forEach(entry -> {
				JSONObject item = new JSONObject();
				item.put("ItemID", entry.getKey());
				item.put("Value", entry.getValue());
				valuesArray.put(item);
			});

			JSONObject payloadJson = new JSONObject();
			payloadJson.put("Values", valuesArray);
			String payload = payloadJson.toString();

			System.out.println("Final dynamic payload: " + payload);

			if (publishMqttCommand(testCase, MqttJsonConfig.generateSetTopic(deviceName, featureKey), payload)) {
				long startTime = System.currentTimeMillis();
				long timeoutMillis = 20000;
				long pollIntervalMillis = 2000;
				boolean validated = false;

				while ((System.currentTimeMillis() - startTime) < timeoutMillis) {
					String response = getRequiredMsgFromResponse(MqttJsonConfig.deriveResponseTopic(MqttJsonConfig.getTopic(deviceName, featureKey),
							"Child"));
					Keyword.ReportStep_Pass(testCase, "Response received: " + response);
					if (response == null || response.trim().isEmpty()) {
						System.out.println("No response received, sending GET again...");
						Keyword.ReportStep_Pass(testCase, "No response received, sending GET again...");
						if (publishMqttCommand(testCase, MqttJsonConfig.generateGetTopic(deviceName, featureKey), "")) {
							Thread.sleep(pollIntervalMillis);
							continue;
						}
					}
					JSONObject jsonObject = new JSONObject(response);
					JSONArray responseValues = jsonObject.getJSONArray("Values");
					Set<Integer> matchedItems = new HashSet<>();

					for (int i = 0; i < responseValues.length(); i++) {
						JSONObject resp = responseValues.getJSONObject(i);
						int itemId = resp.getInt("ItemID");
						int actualVal = resp.getInt("Value");

						if (valueMap.containsKey(itemId)) {
							int expectedVal = valueMap.get(itemId);
							if (actualVal == expectedVal) {
								matchedItems.add(itemId);
							} else {
								System.out.println("Mismatch for ISU item " + itemId + ": Expected " + expectedVal
										+ ", Found " + actualVal);
							}
						}
					}
					if (matchedItems.containsAll(valueMap.keySet())) {
						System.out.println("ISU item(s) validated successfully: " + valueMap);
						Keyword.ReportStep_Pass(testCase, "ISU item(s) set successfully: " + valueMap);
						validated = true;
						break;
					} else {
						System.out.println("Values not matched yet, sending GET again...");
						publishMqttCommand(testCase, MqttJsonConfig.generateGetTopic(deviceName, featureKey), "");
						Thread.sleep(pollIntervalMillis);
					}
				}
				if (validated) {
					flag = true;
				} else {
					Keyword.ReportStep_Fail(testCase, FailType.COSMETIC_FAILURE,
							"ISU item validation failed. Expected: " + valueMap);
				}
			}
		} catch (Exception e) {
			System.out.println("Error in setIsuInfoValue: " + e.getMessage());
			e.printStackTrace();
		}
		return flag;
	}

	public static String getIsuInfoValue(TestCases testCase, String featureKey, String isuKey) {
		String response;
		String getTopic = MqttJsonConfig.generateGetTopic(deviceName, featureKey);
		if (publishMqttCommand(testCase, getTopic, "")) {
			response = getRequiredMsgFromResponse(MqttJsonConfig.getTopic(deviceName, featureKey));
			if (response != null) {
				try {
					JSONObject jsonObject = new JSONObject(response);
					JSONArray valuesArray = jsonObject.getJSONArray("Values");
					if (valuesArray.length() > 0) {
						JSONObject firstItem = valuesArray.getJSONObject(0);
						int value = firstItem.getInt("Value");
						return MqttJsonConfig.getKeyOfPayloadValueOfISU(deviceName, "IsuItem", isuKey, value);
					} else {
						System.out.println("Values array is empty");
					}
				} catch (Exception e) {
					System.out.println("An error occurred: " + e.getMessage());
				}
			}
		}
		return null;
	}

	public static boolean setIsuItem(TestCases testCase, String featureKey, String isuKey) {
		boolean flag = false;
		if (setIsuSessionOpen(testCase, true)) {
			String payload = MqttJsonConfig.getPayload(deviceName, featureKey).get(isuKey).get("Item").asText();
			String response = null;
			if (publishMqttCommand(testCase, MqttJsonConfig.generateSetTopic(deviceName, featureKey), payload)) {
				String parentTopic = MqttJsonConfig.deriveResponseTopic(MqttJsonConfig.getTopic(deviceName, featureKey),
						"Parent");
				if (publishMqttCommand(testCase, MqttJsonConfig.generateGetTopic(deviceName, featureKey), "")) {
					response = getRequiredMsgFromResponse(parentTopic);
				} else {
					Keyword.ReportStep_Fail(testCase, FailType.COSMETIC_FAILURE,
							"Failed to send the get command for featureKey:" + featureKey);
				}
				if (response != null) {
					try {
						JSONObject jsonObject = new JSONObject(response);
						int value = jsonObject.getInt("Item");
						if (payload.equalsIgnoreCase(String.valueOf(value))) {
							flag = true;
							Keyword.ReportStep_Pass(testCase, "Item is Set to : " + payload + " Successfully");
						} else {
							Keyword.ReportStep_Fail(testCase, FailType.COSMETIC_FAILURE,
									"Mismatch in item vaalue,Expected: " + payload + ", Observed: " + value);
						}
					} catch (Exception e) {
						System.out.println("An error occurred: " + e.getMessage());
					}
				}
			}
		}
		return flag;
	}

	public static boolean setIsuSessionOpen(TestCases testCase, boolean sessionOpen) {
		boolean flag = false;
		try {
			if (publishMqttCommand(testCase, MqttJsonConfig.generateGetTopic(deviceName, "IsuIsSessionOpen"), "")) {
				String response = getRequiredMsgFromResponse(MqttJsonConfig
						.deriveResponseTopic(MqttJsonConfig.getTopic(deviceName, "IsuIsSessionOpen"), "Parent"));
				if (response != null) {
					try {
						JSONObject jsonObject = new JSONObject(response);
						boolean currentSessionState = jsonObject.getBoolean("IsSessionOpen");
						if (currentSessionState == sessionOpen) {
							return true;
						}
					} catch (Exception e) {
						System.out.println("Error parsing initial session open response: " + e.getMessage());
					}
				}

				if (publishMqttCommand(testCase, MqttJsonConfig.generateSetTopic(deviceName, "IsuIsSessionOpen"), String.valueOf(sessionOpen))) {
					Wait<TestCases> wait = new FluentWait<>(testCase).withTimeout(Duration.ofSeconds(20))
							.pollingEvery(Duration.ofSeconds(2)).ignoring(Exception.class);

					flag = wait.until(testCaseWait -> {
						if (publishMqttCommand(testCaseWait, MqttJsonConfig.generateGetTopic(deviceName, "IsuIsSessionOpen"), "")) {
							String updatedResponse = getRequiredMsgFromResponse(MqttJsonConfig
									.deriveResponseTopic(MqttJsonConfig.getTopic(deviceName, "IsuIsSessionOpen"), "Parent"));

							if (updatedResponse != null) {
								try {
									JSONObject jsonObject = new JSONObject(updatedResponse);
									boolean updatedSessionState = jsonObject.getBoolean("IsSessionOpen");
									return updatedSessionState == sessionOpen;
								} catch (Exception ex) {
									System.out.println("Error parsing during fluent wait: " + ex.getMessage());
								}
							}
						}
						return false;
					});
				}
			}
		} catch (Exception e) {
			System.out.println("Error in setIsuSessionOpen: " + e.getMessage());
			Keyword.ReportStep_Fail(testCase, FailType.FUNCTIONAL_FAILURE,
					"Exception in setIsuSessionOpen: " + e.getMessage());
		}
		if (!flag) {
			Keyword.ReportStep_Fail(testCase, FailType.FUNCTIONAL_FAILURE,
					"Failed to set ISU session open state to: " + sessionOpen);
		}
		return flag;
	}


	public static boolean publishMqttCommand(TestCases testCase, String topic, String payload) {
		if (isSerialMethod) {
			return MqttSerialController.sendCommandToPort("mosquitto_pub -t " + topic + " -m '" + payload + "'");
		} else {
			return MqttClientController.publish(testCase, topic, payload);
		}
	}
	

	public static String getRequiredMsgFromResponse(String reqTopic) {
		String reqResponse = null;
		int count = 0;
		if (isSerialMethod) {
			try {
				do {
					count++;
					InputStream inputStream = MqttSerialController.getInputStram();

					reqResponse = MqttSerialController.waitForSerialResponse(inputStream, 10000);

					if (reqResponse != null && reqResponse.toUpperCase().contains(reqTopic.toUpperCase())) {
						String reqResponseFromSerial = reqResponse.split(Pattern.quote(reqTopic + " | Payload:"), 2)[1]
								.trim().split("\n")[0];
						int start = reqResponseFromSerial.indexOf("{\"$tag");
						if (start == -1)
							return null;

						int curlyCount = 0;
						int squareCount = 0;
						boolean inString = false;
						boolean escape = false;

						for (int i = start; i < reqResponseFromSerial.length(); i++) {
							char c = reqResponseFromSerial.charAt(i);

							if (c == '"' && !escape) {
								inString = !inString;
							}

							if (!inString) {
								if (c == '{')
									curlyCount++;
								else if (c == '}')
									curlyCount--;
								else if (c == '[')
									squareCount++;
								else if (c == ']')
									squareCount--;
							}

							escape = (c == '\\') && !escape;

							if (curlyCount == 0 && squareCount == 0 && i > start) {
								return reqResponseFromSerial.substring(start, i + 1);
							}
						}

					}
				} while (count < 3);
			} catch (IOException e) {
				e.printStackTrace();
			}
		} else {
			try {
				int attempts = 0;
				while (attempts < 3) {
					Thread.sleep(2000);
					if (MqttClientController.hasMessage(reqTopic)) {
						reqResponse = MqttClientController.getLastMessage(reqTopic);
						break;
					}
					attempts++;
				}
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		return reqResponse;
	}

	public static String getIsuInfoJson(TestCases testCase, String featureKey) {
		String response = null;
		String getTopic = MqttJsonConfig.generateGetTopic(deviceName, featureKey);
		if (publishMqttCommand(testCase, getTopic, "")) {
			response = getRequiredMsgFromResponse(MqttJsonConfig.getTopic(deviceName, featureKey));
		} else {
			Keyword.ReportStep_Fail(testCase, FailType.COSMETIC_FAILURE, "Failed to mPublish the command.");
		}
		return response;
	}

	public static float getMaxMin_TempValue(TestCases testCase, String isu) {
		String minMaxValues = null;
		if (setIsuSessionOpen(testCase, true)) {
			if (setIsuItem(testCase, "IsuItem", "ISU_MIN_COOL_SP")) {
				minMaxValues = getIsuInfoJson(testCase, "IsuItemValue");
			} else {
				Keyword.ReportStep_Fail(testCase, FailType.COSMETIC_FAILURE, "Failed To set the ISU item.");
			}
		} else {
			Keyword.ReportStep_Fail(testCase, FailType.COSMETIC_FAILURE, "Failed to open the IsIsuSessionOpen");
		}

		int itemIdOfMinMaxValue = 0;
		if (isu.contains("ISU_MIN_COOL_SP")) {
			itemIdOfMinMaxValue = MqttJsonConfig.getPayload(deviceName, "IsuItem").get("ISU_MIN_COOL_SP").get("Item")
					.asInt();
		} else if (isu.contains("ISU_MAX_COOL_SP")) {
			itemIdOfMinMaxValue = MqttJsonConfig.getPayload(deviceName, "IsuItem").get("ISU_MAX_COOL_SP").get("Item")
					.asInt();
		} else if (isu.contains("ISU_MIN_HEAT_SP")) {
			itemIdOfMinMaxValue = MqttJsonConfig.getPayload(deviceName, "IsuItem").get("ISU_MIN_HEAT_SP").get("Item")
					.asInt();
		} else if (isu.contains("ISU_MAX_HEAT_SP")) {
			itemIdOfMinMaxValue = MqttJsonConfig.getPayload(deviceName, "IsuItem").get("ISU_MAX_HEAT_SP").get("Item")
					.asInt();
		}
		try {
			ObjectMapper mapper = new ObjectMapper();
			JsonNode root = mapper.readTree(minMaxValues);
			JsonNode values = root.get("Values");

			if (values != null && values.isArray()) {
				for (JsonNode item : values) {
					if (item.get("ItemID").asInt() == itemIdOfMinMaxValue) {
						return item.get("Value").asInt();
					}
				}
				Keyword.ReportStep_Fail(testCase, FailType.COSMETIC_FAILURE, "Required Item ID is not present.");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return 0;
	}
	
	public static boolean setReset(TestCases testCase, String featureKey, String trueFalse)
			throws InterruptedException {
		String setTopic = MqttJsonConfig.generateSetTopic(deviceName, featureKey);
		boolean flag = false;
		if (publishMqttCommand(testCase, setTopic, trueFalse)) {
			try {
				if (isSerialMethod) {
					InputStream inputStream = MqttSerialController.getInputStram();

					String reqResponse = MqttSerialController.waitForSerialResponse(inputStream, 10000).toUpperCase();
					if (reqResponse.contains("REBOOT") && reqResponse.contains("RESTARTING SYSTEM")) {
						flag = true;
						Keyword.ReportStep_Pass(testCase, "Successfully sent the: " + featureKey
								+ " command, and received Msg in Console - reboot: Restarting system ");
					} else {
						Keyword.ReportStep_Fail(testCase, FailType.FUNCTIONAL_FAILURE,
								"Did not received Msg from as - reboot: Restarting system ");
					}
					TimeUnit.SECONDS.sleep(20);
					flag = flag && MqttSerialController.sendUsernameAndPassword();
				} else {
					int attempts = 0;
					while (attempts < 3) {
						TimeUnit.SECONDS.sleep(2);
						if (MqttClientController.hasMessage(setTopic)) {
							if (MqttClientController.getLastMessage(setTopic).toUpperCase().contains("TRUE")) {
								Keyword.ReportStep_Pass(testCase, "Successfully sent the: " + featureKey
										+ " command, and received Msg in Console - reboot: Restarting system ");
								flag=true;
								break;
							}
						}
						attempts++;
					}
					TimeUnit.SECONDS.sleep(25);
					MqttClientController.startMQTTClient();
				}

			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		return flag;
	}
	public static boolean setAlert(TestCases testCase, String alertState, String alertName) {
	    String setTopic = MqttJsonConfig.generateSetTopic(deviceName, "Alert");
	    int state = 0;
	    boolean override = true;

	    if (alertState.contains("INACTIVE")) {
	        state = MqttJsonConfig.getPayload(deviceName, "Alert").get("State").get("Inactive").asInt();
	        override = false;
	    } else if (alertState.contains("ACTIVE")) {
	        state = MqttJsonConfig.getPayload(deviceName, "Alert").get("State").get("Active").asInt();
	    } else if (alertState.contains("SNOOZE")) {
	        state = MqttJsonConfig.getPayload(deviceName, "Alert").get("State").get("Snooze").asInt();
	    } else if (alertState.contains("DISMISS")) {
	        state = MqttJsonConfig.getPayload(deviceName, "Alert").get("State").get("Dismiss").asInt();
	    }

	    int alertId = MqttJsonConfig.getPayload(deviceName, "Alert").get(alertName).get("Id").asInt();
	    int alertCode = MqttJsonConfig.getPayload(deviceName, "Alert").get(alertName).get("AlertCode").asInt();

	    String payload = String.format("[{\"Id\": %d, \"State\": %d, \"Override\": %s}]", alertId, state, override);

	    try {
	        String currentAlertValue = getAlert(testCase);
	        boolean isAlertInExpState = (!alertState.contains("INACTIVE") && currentAlertValue != null && currentAlertValue.contains("\"AlertId\":" + alertCode))
	                || (alertState.contains("INACTIVE") && (currentAlertValue == null || !currentAlertValue.contains("\"AlertId\":" + alertCode)));

	        if (isAlertInExpState) {
	            Keyword.ReportStep_Pass(testCase, "Alert [" + alertName + "] is already in desired state: " + alertState);
	            return true;
	        }
	        if (publishMqttCommand(testCase, setTopic, payload)) {
	            Keyword.ReportStep_Pass(testCase, "Set alert [" + alertName + "] with payload: " + payload);
	            boolean alertStatusVerified = new FluentWait<>(testCase).withTimeout(Duration.ofSeconds(15))
	                    .pollingEvery(Duration.ofSeconds(2)).ignoring(Exception.class)
	                    .until(t -> {
	                        String latestAlertValue = getAlert(testCase);
	                        if (alertState.contains("INACTIVE")) {
	                            return latestAlertValue == null || !latestAlertValue.contains("\"AlertId\":" + alertCode);
	                        } else {
	                            return latestAlertValue != null && latestAlertValue.contains("\"AlertId\":" + alertCode);
	                        }
	                    });
	            if (alertStatusVerified) {
	                Keyword.ReportStep_Pass(testCase, "Alert [" + alertName + "] successfully set to [" + alertState + "]");
	                return true;
	            } else {
	                Keyword.ReportStep_Fail(testCase, 0, "Alert [" + alertName + "] not correctly set to [" + alertState + "]");
	            }
	        }
	    } catch (Exception e) {
	        System.out.println("Error during setting alert: " + e.getMessage());
	        Keyword.ReportStep_Fail(testCase, FailType.FUNCTIONAL_FAILURE, "Exception in setAlert: " + e.getMessage());
	    }
	    Keyword.ReportStep_Fail(testCase, FailType.FUNCTIONAL_FAILURE, "Failed to publish alert command for [" + alertName + "]");
	    return false;
	}

	public static String getAlert(TestCases testCase) {
		String response = null;
		String getTopic = MqttJsonConfig.generateGetTopic(deviceName, "Alert");
		String parentTopic = MqttJsonConfig.deriveResponseTopic(MqttJsonConfig.getTopic(deviceName, "Alert"), "Parent");

		if (publishMqttCommand(testCase, getTopic, "")) {
			Keyword.ReportStep_Pass(testCase, "Get request sent to topic: " + getTopic);
			response = getRequiredMsgFromResponse(parentTopic);

			if (response != null) {
				try {
					JSONObject jsonObject = new JSONObject(response);
					JSONArray activeAlerts = jsonObject.getJSONArray("Active");

					if (activeAlerts.length() == 0) {
						return null;
					}
					return activeAlerts.toString();
				} catch (Exception e) {
					System.out.println("An error occurred while parsing alert: " + e.getMessage());
				}
			}
		}
		return null;
	}
	
	public static String getDeviceName(TestCases testCase) {
		String getTopic = MqttJsonConfig.generateGetTopic(deviceName, "");
		String expPayloadString = null;
		String response = null;

		String parentTopic = MqttJsonConfig.deriveResponseTopic(MqttJsonConfig.getTopic(deviceName, ""),
				"parentTopic");
		if (publishMqttCommand(testCase, getTopic, "")) {
			Keyword.ReportStep_Pass(testCase, "Get request sent to topic: " + getTopic);
			response = getRequiredMsgFromResponse(parentTopic);
			if (response != null) {
				try {
					JSONObject jsonObject = new JSONObject(response);
					String currentModes = String.valueOf(jsonObject.getInt(expPayloadString));
					return MqttJsonConfig.getKeyOfPayloadValue(deviceName, "", currentModes);
				} catch (Exception e) {
					System.out.println("An error occurred: " + e.getMessage());
				}
			}
		}
		return null;
	}
	
	public static boolean enableDisableBroadCasting(String enableDisable, TestCases testCase,boolean isconnectable) {
		try {
			String enable_disable = enableDisable.toUpperCase().contains("TRUE")
					|| enableDisable.toUpperCase().contains("ENABLE") ? "true" : "false";
			String setTopic = MqttJsonConfig.generateSetTopic(deviceName, "BleBroadcast");
			String payload = "{\"Channel\":\"DIY\", \"Active\": " + enable_disable;
			String deviceName = SuiteConstants
			        .getConstantValue(SuiteConstantTypes.PROJECT_SPECIFIC, "DEVICE_UNDER_TEST")
			        .trim();
			if (deviceName.contains("GLENEAGLES")) {
			    payload += ",\"Connectable\":"+isconnectable+"";
			}
			payload += "}";
			if (publishMqttCommand(testCase, setTopic, payload)) {
				Keyword.ReportStep_Pass(testCase, "Published message to topic: " + setTopic + " Payload: " + payload);
				FluentWait<TestCases> wait = new FluentWait<>(testCase).withTimeout(Duration.ofSeconds(20))
						.pollingEvery(Duration.ofSeconds(2)).ignoring(Exception.class);
				boolean result = wait.until(new Function<TestCases, Boolean>() {
					public Boolean apply(TestCases t) {
						if (!isconnectable) {
							String bleAdvertisementStatus = getBleAdvertisementStatus(testCase);
							System.out.println("Current Ble Advertisement Status is: " + bleAdvertisementStatus);
							Keyword.ReportStep_Pass(testCase,
									"Ble Advertisement Status successfully set to: " + bleAdvertisementStatus);
							
							return bleAdvertisementStatus.equalsIgnoreCase(enableDisable);
						}else if(isconnectable) {
//							boolean connectableStatus = getBleConnectableStatus(testCase);
//							System.out.println("Current Ble connectableStatus is: " + connectableStatus);
//							Keyword.ReportStep_Pass(testCase,
//									"Ble Connectable Current Status is: " + connectableStatus);
//							return connectableStatus;
							return true;
						}else {
							Keyword.ReportStep_Pass(testCase, "Failed to set Ble Advertisement/Connectable Status.");
							return false;
						}
					}
				});
				return result;
			}
		} catch (Exception e) {
			System.out.println("Error in setMode: " + e.getMessage());
			Keyword.ReportStep_Fail(testCase, FailType.FUNCTIONAL_FAILURE, "An error occurred: " + e.getMessage());
			e.printStackTrace();
		}
		return false;
	}
	
	public static String getBleAdvertisementStatus(TestCases testCase) {
		int count = 0;
		do {
			count++;
			String getTopic = MqttJsonConfig.generateGetTopic(deviceName, "BleAdvertisement");
			String response = null;
			String parentTopic = MqttJsonConfig
					.deriveResponseTopic(MqttJsonConfig.getTopic(deviceName, "BleAdvertisement"), "Topic");
			if (publishMqttCommand(testCase, getTopic, "")) {
				Keyword.ReportStep_Pass(testCase, "Get request sent to topic: " + getTopic);
				response = getRequiredMsgFromResponse(parentTopic);
				if (response != null) {
					try {
						JSONObject jsonObject = new JSONObject(response);
						return String.valueOf(jsonObject.getBoolean("Status"));
					} catch (Exception e) {
						System.out.println("An error occurred: " + e.getMessage());
					}
				}
			}
		} while (count < 3);
		return null;
	}
	
	public static String getThermostatName(TestCases testCase) {
		int count = 0;
		do {
			count++;
			String getTopic = MqttJsonConfig.generateGetTopic(deviceName, "ThermostatRoomName");
			if(publishMqttCommand(testCase, getTopic, "")) {
			String response = getRequiredMsgFromResponse(MqttJsonConfig.deriveResponseTopic(MqttJsonConfig.getTopic(deviceName, "ThermostatRoomName"), "ParentTopic"));
			if (response != null) {
				try {
					JSONObject jsonObject = new JSONObject(response);
					return jsonObject.getString("ThermostatRoom");
				} catch (Exception e) {
					System.out.println("An error occurred: " + e.getMessage());
				}
			} 
		}
		} while (count < 3);
		return null;
	}
	
	public static String getModelNumber() {
		int count = 0;
		String modelNo = null;
		do {
			count++;
			TestCases testCase = null;
			String response = null;
			String getTopic = MqttJsonConfig.generateGetTopic(deviceName, "DeviceModelNumber");
			String parentTopic = MqttJsonConfig
					.deriveResponseTopic(MqttJsonConfig.getTopic(deviceName, "DeviceModelNumber"), "parent");
			if (publishMqttCommand(testCase, getTopic, "")) {
				Keyword.ReportStep_Pass(testCase, "Get request sent to topic: " + getTopic);
				response = getRequiredMsgFromResponse(parentTopic);
				if (response != null) {
					try {
						JSONObject jsonObject = new JSONObject(response);
						modelNo = jsonObject.getString("ModelNumber");
					} catch (Exception e) {
						System.out.println("An Exception Occurred:" + e.getMessage());
					}
				}
			}
		} while (count < 3 && modelNo == null);
		return modelNo;
	}

	public static String getMacId() {
		TestCases testCase = null;
		String response = null;
		String getTopic = MqttJsonConfig.generateGetTopic(deviceName, "DeviceMacId");
		String parentTopic = MqttJsonConfig.deriveResponseTopic(MqttJsonConfig.getTopic(deviceName, "DeviceMacId"),
				"parent");
		if (publishMqttCommand(testCase, getTopic, "")) {
			Keyword.ReportStep_Pass(testCase, "Get request sent to topic: " + getTopic);
			response = getRequiredMsgFromResponse(parentTopic);
			if (response != null) {
				try {
					JSONObject jsonObject = new JSONObject(response);
					return jsonObject.getString("MacId");
				} catch (Exception e) {
					System.out.println("An Exception Occurred:" + e.getMessage());
				}
			}
		}
		return null;
	}
	
	public static String getAuthCode() {
		if(isSerialMethod) {
			return MqttSerialController.getAuthCode();
		}else {
			String response = null;
			int count = 0;
			String topic = MqttJsonConfig.deriveResponseTopic(MqttJsonConfig.getTopic(deviceName, "AuthCode"), "child");
			do {
				count++;
				response = getRequiredMsgFromResponse(topic);
				if (response != null) {
					response = response.replaceAll("\"", "");
					return response;
				}
			} while (count < 5);
			return null;
		}
	}
	
	public static boolean getBleConnectableStatus(TestCases testCase) {
		int count = 0;
		do {
			count++;
			String getTopic = MqttJsonConfig.generateGetTopic(deviceName, "BleConnectable");
			String response = null;
			String parentTopic =MqttJsonConfig.getTopic(deviceName, "BleBroadcast");
			if (publishMqttCommand(testCase, getTopic, "")) {
				Keyword.ReportStep_Pass(testCase, "Get request sent to topic: " + getTopic);
				response = getRequiredMsgFromResponse(parentTopic);
				if (response != null) {
					try {
						JSONObject jsonObject = new JSONObject(response);
						return jsonObject.getBoolean("Connectable");
					} catch (Exception e) {
						System.out.println("An error occurred: " + e.getMessage());
					}
				}
			}
		} while (count < 3);
		return false;
	}
}