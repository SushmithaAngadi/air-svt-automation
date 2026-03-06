package com.resideo.utils.aat;

import java.time.Duration;
import java.util.concurrent.TimeUnit;
import java.util.function.Function;

import org.openqa.selenium.support.ui.FluentWait;

import com.resideo.commons.coreframework.Keyword;
import com.resideo.commons.coreframework.TestCases;
import com.resideo.commons.report.FailType;

public class ThermostatController {

	private final AatCommandHandler handler;

	public ThermostatController(AatCommandHandler handler) {
		this.handler = handler;
	}

	public boolean setSystemMode(TestCases testCase, ThermostatConstant.SystemSwitch expected, int maxWaitMs) {
		try {
			ThermostatConstant.SystemSwitch current = getSystemMode(testCase);
			if (current != null && current == expected) {
				Keyword.ReportStep_Pass(testCase, "System Mode already set to: " + expected);
				return true;
			}

			byte[] payload = new byte[] { (byte) expected.value };
			System.out.println("AAT Payload for System Mode Change: " + (payload[0] & 0xFF));

			if (!handler.AATChange(ThermostatConstant.ChangeMsgId.SYSTEM_MODE_CHANGE.value, payload, 3000)) {
				Keyword.ReportStep_Fail(testCase, FailType.FUNCTIONAL_FAILURE,
						"Failed to send/receive ACK for AAT System Mode Change → " + expected);
				return false;
			}

			Keyword.ReportStep_Pass(testCase, "Sending AAT System Mode Change → " + expected);
			TimeUnit.MILLISECONDS.sleep(400);

			FluentWait<TestCases> wait = new FluentWait<>(testCase).withTimeout(Duration.ofMillis(maxWaitMs))
					.pollingEvery(Duration.ofMillis(350)).ignoring(Exception.class);

			boolean result = wait.until(new Function<TestCases, Boolean>() {
				public Boolean apply(TestCases t) {
					ThermostatConstant.SystemSwitch now = getSystemMode(testCase);

					if (now != null && now == expected) {
						Keyword.ReportStep_Pass(testCase, "System Mode correctly updated → " + now);
						return true;
					}

					System.out.println("[AAT][SystemMode] Waiting... expected=" + expected + ", current=" + now);
					return false;
				}
			});
			if (!result) {
				Keyword.ReportStep_Fail(testCase, FailType.FUNCTIONAL_FAILURE,
						"System Mode MISMATCH after wait, Expected: " + expected + ", but got: "
								+ getSystemMode(testCase));
			}
			return result;
		} catch (Exception e) {
			Keyword.ReportStep_Fail(testCase, FailType.FUNCTIONAL_FAILURE,
					"Failed to set System Mode via AAT: " + e.getMessage());
			return false;
		}
	}

	public ThermostatConstant.SystemSwitch getSystemMode(TestCases testCase) {
		try {
			byte[] payload = new byte[0];
			if (!handler.AATQuery(ThermostatConstant.QueryMsgId.SYSTEM_MODE_QUERY.value, payload, 4000)) {
				Keyword.ReportStep_Fail(testCase, FailType.FUNCTIONAL_FAILURE,
						"Failed to send AAT System Mode QUERY or receive response.");
				return null;
			}

			byte[] responseData = handler.getAATResponseDataOfMsgID(ThermostatConstant.AAT.MSG_ID_TYPE.RESPONSE.value,
					ThermostatConstant.ResponseMsgId.SYSTEM_MODE_RESPONSE.value, 3000);

			if (responseData == null || responseData.length == 0) {
				Keyword.ReportStep_Fail(testCase, FailType.FUNCTIONAL_FAILURE,
						"System Mode Query returned empty response data.");
				return null;
			}

			int modeValue = responseData[0] & 0xFF;
			ThermostatConstant.SystemSwitch mode = ThermostatConstant.SystemSwitch.fromValue(modeValue);
			Keyword.ReportStep_Pass(testCase, "System Mode value returned: " + modeValue + " (" + mode + ")");
			return mode;
		} catch (Exception e) {
			Keyword.ReportStep_Fail(testCase, FailType.FUNCTIONAL_FAILURE,
					"Failed to get System Mode: " + e.getMessage());
			return null;
		}
	}

	public boolean setReset(TestCases testCase, int resetType, int maxWaitMs) {
		try {
			byte[] payload = new byte[] { (byte) (resetType & 0xFF) };
			System.out.println("[AAT][Reset] CHANGE payload: " + (payload[0] & 0xFF));

			if (!handler.AATChange(ThermostatConstant.ChangeMsgId.RESET_CHANGE.value, payload, 3000)) {
				Keyword.ReportStep_Fail(testCase, FailType.FUNCTIONAL_FAILURE,
						"Failed to send/receive ACK for AAT RESET_CHANGE. resetType=" + resetType);
				return false;
			}

			Keyword.ReportStep_Pass(testCase, "RESET_CHANGE ACK received. Waiting for reset event: MsgID=0x"
					+ String.format("%04X", ThermostatConstant.EventMsgId.AAT_STAT_RESET_E.value) + " ...");

			TimeUnit.MILLISECONDS.sleep(2000);

			return getReset(testCase, maxWaitMs);
		} catch (Exception e) {
			Keyword.ReportStep_Fail(testCase, FailType.FUNCTIONAL_FAILURE,
					"Failed to run RESET via AAT: " + e.getMessage());
			return false;
		}
	}

	public boolean getReset(TestCases testCase, int maxWaitMs) {
		try {
			int resetEventMsgId = ThermostatConstant.EventMsgId.AAT_STAT_RESET_E.value;
			System.out
					.println("[AAT][Reset] Waiting for reset event MsgID=0x" + String.format("%04X", resetEventMsgId));

			byte[] rawEvent = handler.waitForAATMsgId(resetEventMsgId, ThermostatConstant.AAT.MSG_ID_TYPE.EVENT.value,
					maxWaitMs);
			if (rawEvent == null) {
				Keyword.ReportStep_Fail(testCase, FailType.FUNCTIONAL_FAILURE, "Reset event not received within "
						+ maxWaitMs + "ms. MsgID=0x" + String.format("%04X", resetEventMsgId));
				return false;
			}

			System.out.println("[AAT][Reset] EVENT <- " + handler.toHex(rawEvent));
			Keyword.ReportStep_Pass(testCase,
					"Reset event received → AAT_STAT_RESET_E (MsgID=0x" + String.format("%04X", resetEventMsgId) + ")");
			return true;
		} catch (Exception e) {
			Keyword.ReportStep_Fail(testCase, FailType.FUNCTIONAL_FAILURE,
					"Failed to verify reset event: " + e.getMessage());
			return false;
		}
	}
	
	public boolean changeButtonState(TestCases testCase, String buttonType) {
		try {
			int override = 1;
			String buttonName = buttonType.trim().toUpperCase();
			int buttonId;
			switch (buttonName) {
			case "NONE":
				buttonId = 0;
				break;
			case "MENU":
			case "MENU BUTTON":
				buttonId = 1;
				break;
			case "BACK":
			case "BACK BUTTON":
				buttonId = 2;
				break;
			case "HOLD":
			case "HOLD BUTTON":
				buttonId = 4;
				break;
			case "UP":
			case "UP BUTTON":
				buttonId = 8;
				break;
			case "DOWN":
			case "DOWN BUTTON":
				buttonId = 16;
				break;
			case "MULTIPURPOSE":
			case "NEXT":
			case "MULTIPURPOSE BUTTON":
				buttonId = 32;
				break;
			default:
				Keyword.ReportStep_Fail(testCase, FailType.FUNCTIONAL_FAILURE, "Unsupported button type: " + buttonType
						+ " (Supported: MENU/BACK/HOLD/UP/DOWN/MULTIPURPOSE/NONE)");
				return false;
			}

			byte[] payload = new byte[] { (byte) (override & 0xFF), (byte) (buttonId & 0xFF) };

			System.out.println("[AAT][ButtonState] CHANGE payload: "
					+ String.format("%02X %02X", payload[0] & 0xFF, payload[1] & 0xFF) + " | override=" + override
					+ ", button=" + buttonName + ", buttonId=" + buttonId);

			if (!handler.AATChange(ThermostatConstant.ChangeMsgId.BUTTON_STATE_CHANGE.value, payload, 6000)) {
				Keyword.ReportStep_Fail(testCase, FailType.FUNCTIONAL_FAILURE,
						"Failed to send/receive ACK for AAT Button State Change → button=" + buttonName + ", override="
								+ override + ", buttonId=" + buttonId);
				return false;
			}

			Keyword.ReportStep_Pass(testCase, "Sending AAT Button State Change → button=" + buttonName + ", override="
					+ override + ", buttonId=" + buttonId);

			// "post-action wait"
			TimeUnit.MILLISECONDS.sleep(1000);

			return true;
		} catch (Exception e) {
			Keyword.ReportStep_Fail(testCase, FailType.FUNCTIONAL_FAILURE,
					"Failed to click button via AAT: " + e.getMessage());
			return false;
		}
	}

}