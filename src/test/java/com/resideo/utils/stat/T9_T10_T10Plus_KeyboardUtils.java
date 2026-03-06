package com.resideo.utils.stat;

import java.awt.Point;
import com.resideo.commons.coreframework.Keyword;
import com.resideo.commons.coreframework.SuiteConstants;
import com.resideo.commons.coreframework.SuiteConstants.SuiteConstantTypes;
import com.resideo.commons.coreframework.TestCases;
import com.resideo.utils.stat.cattgrpccommands.screenshotData;
//import com.resideo.robotic_arm.supportConstant.ArmConstants;

public class T9_T10_T10Plus_KeyboardUtils {

	static String keyboardLayout;

	public static boolean sendKey(String chars) {
		boolean flag = false;
		if (chars.equals("CHANGE_LAYOUT")) {
			Point pnt = keyboardAction("CHANGE_LAYOUT");
			flag = StatCommands.getInstance().cattCommandsStub
					.clickOnExactButton(
							screenshotData.newBuilder().setXEndCordinate(pnt.x).setYEndCoordinate(pnt.y).build())
					.getBoolVal();
		} else if (chars.equals("SHIFT")) {
			Point pnt = keyboardAction("SHIFT");
			flag = StatCommands.getInstance().cattCommandsStub
					.clickOnExactButton(
							screenshotData.newBuilder().setXEndCordinate(pnt.x).setYEndCoordinate(pnt.y).build())
					.getBoolVal();
		} else if (chars.equals("BACKSPACE")) {
			Point pnt = keyboardAction("BACKSPACE");
			flag = StatCommands.getInstance().cattCommandsStub
					.clickOnExactButton(
							screenshotData.newBuilder().setXEndCordinate(pnt.x).setYEndCoordinate(pnt.y).build())
					.getBoolVal();
		} else if (chars.equals("SPACE")) {
			Point pnt = keyboardAction("SPACE");
			flag = StatCommands.getInstance().cattCommandsStub
					.clickOnExactButton(
							screenshotData.newBuilder().setXEndCordinate(pnt.x).setYEndCoordinate(pnt.y).build())
					.getBoolVal();
		} else if (chars.equals("NEXT")) {
			Point pnt = keyboardAction("NEXT");
			flag = StatCommands.getInstance().cattCommandsStub
					.clickOnExactButton(
							screenshotData.newBuilder().setXEndCordinate(pnt.x).setYEndCoordinate(pnt.y).build())
					.getBoolVal();
		} else {
			char[] charArray = chars.toCharArray();
			for (char c : charArray) {
				Point pnt = keyboardAction(String.valueOf(c));
				flag = StatCommands.getInstance().cattCommandsStub
						.clickOnExactButton(
								screenshotData.newBuilder().setXEndCordinate(pnt.x).setYEndCoordinate(pnt.y).build())
						.getBoolVal();
			}
		}
		return flag;
	}

	public static Point keyboardAction(String atChar) {
		Point point = new Point();
		switch (atChar) {
		case "A":
		case "a":
		case "-":
		case "_": {
			point.setLocation(30, 333);
		}

			break;
		case "B":
		case "b":
		case "'": {
			point.setLocation(182, 390);
		}

			break;
		case "C":
		case "c":
		case "?": {
			point.setLocation(117, 389);
		}

			break;
		case "D":
		case "d":
		case ":":
		case "|": {
			point.setLocation(96, 333);
		}

			break;
		case "E":
		case "e":
		case "3":
		case "{": {
			point.setLocation(81, 274);
		}

			break;
		case "F":
		case "f":
		case ";":
		case "`": {
			point.setLocation(129, 333);
		}

			break;
		case "G":
		case "g":
		case "(":
		case "<": {
			point.setLocation(162, 332);
		}

			break;
		case "H":
		case "h":
		case ")":
		case ">": {
			point.setLocation(191, 333);
		}

			break;
		case "I":
		case "i":
		case "8":
		case "*": {
			point.setLocation(240, 274);
		}
			break;
		case "J":
		case "j":
		case "$": {
			point.setLocation(226, 333);
		}

			break;
		case "K":
		case "k":
		case "&": {
			point.setLocation(256, 333);
		}

			break;
		case "L":
		case "l":
		case "@": {
			point.setLocation(284, 333);
		}

			break;
		case "M":
		case "m": {
			point.setLocation(245, 388);
		}

			break;
		case "N":
		case "n":
		case "\"\"": {
			point.setLocation(213, 388);
		}
			break;
		case "O":
		case "o":
		case "9":
		case "+": {
			point.setLocation(270, 273);
		}

			break;
		case "P":
		case "p":
		case "0":
		case "=": {
			point.setLocation(304, 273);
		}

			break;
		case "Q":
		case "q":
		case "1":
		case "[": {
			point.setLocation(15, 274);
		}

			break;
		case "R":
		case "r":
		case "4":
		case "}": {
			point.setLocation(111, 274);
		}
			break;
		case "S":
		case "s":
		case "/": {
			point.setLocation(63, 333);
		}
			break;
		case "T":
		case "t":
		case "5":
		case "#": {
			point.setLocation(142, 273);
		}

			break;
		case "U":
		case "u":
		case "7":
		case "^": {
			point.setLocation(207, 275);
		}
			break;
		case "V":
		case "v":
		case "!": {
			point.setLocation(149, 388);
		}

			break;
		case "W":
		case "w":
		case "2":
		case "]": {
			point.setLocation(48, 274);
		}
			break;
		case "X":
		case "x":
		case ",": {
			point.setLocation(83, 389);
		}

			break;
		case "Y":
		case "y":
		case "6":
		case "%": {
			point.setLocation(175, 273);
		}

			break;
		case "Z":
		case "z":
		case ".": {
			point.setLocation(53, 388);
		}

			break;
		case "SHIFT": {
			point.setLocation(18, 390);
		}

			break;
		case "BACKSPACE": {
			point.setLocation(292, 388);
		}

			break;
		case "SPACE": {
			point.setLocation(156, 448);
		}
			break;
		case "CHANGE_LAYOUT": {
			point.setLocation(34, 446);
		}
			break;
		case "NEXT": {
			point.setLocation(289, 448);
		}
			break;
		default:
			break;
		}
		return point;
	}

	public static boolean designKeyboardLayout(TestCases testCase, String screenName, String sendKey) {
		String currentKeyboard = null;
//		boolean isSecondupperCase = false;
		boolean flag = false;
		try {
			int upperCaseCount = 0;
			try {
				if (screenName != null && (screenName.contains("SSID_NAME") || screenName.contains("SSID_PASSWORD"))) {
					currentKeyboard = screenName(screenName);
				} else {
					currentKeyboard = keyboardlayoutName();
				}
			} catch (Exception e) {
				System.out.println("Screen name layout");
			}
			Thread.sleep(2000);
			boolean isKeyboardChanged = false;
			char[] charArray = sendKey.toCharArray();
			for (char c : charArray) {

				String keyboardNeedtoChange = characterAnalysis(c);
				String currentcharacter = String.valueOf(c);
				if (currentKeyboard.equals("UPPERCASE")) {
					upperCaseCount = upperCaseCount + 1;
				}
				if (upperCaseCount > 1) {
					currentKeyboard = keyboardlayoutName();
				}
				if (currentKeyboard.contains(keyboardNeedtoChange)) {
					isKeyboardChanged = true;
				} else {
					currentKeyboard = keyboardlayoutName();
					System.out.println(currentKeyboard);
					if (keyboardNeedtoChange.contains("UPPERCASE")) {
						isKeyboardChanged = changeKeyboardToUpperCase(currentKeyboard);
					} else if (keyboardNeedtoChange.contains("LOWERCASE")) {
						isKeyboardChanged = changeKeyboardToLowerCase(currentKeyboard);
					} else if (keyboardNeedtoChange.contains("DIGIT")) {
						isKeyboardChanged = changeKeyboardToDigit(currentKeyboard);
					} else if (keyboardNeedtoChange.contains("SPECIAL CHARACTER")) {
						isKeyboardChanged = changeKeyboardToSpecialCharacter(currentKeyboard);
					} else {
						isKeyboardChanged = false;
					}
				}
				if (isKeyboardChanged) {
					currentKeyboard = keyboardNeedtoChange;
				}
				if (isKeyboardChanged && sendKey(currentcharacter)) {
					Keyword.ReportStep_Pass(testCase, "Character entered :: " + currentcharacter);
					flag = true;
				} else {
					flag = false;
				}
			}
		} catch (Exception e) {
			System.out.println("Null Exception for designKeyboardLayout");
		}
		return flag;
	}

	public static boolean changeKeyboardToUpperCase(String current_Keyboard) {
		boolean isKeyboardChanged = false;
		String currentKeyboard = current_Keyboard;
		String keyboardlayoutName = null;
		for (int i = 0; i < 5; i++) {
			if (keyboardlayoutName != null && keyboardlayoutName.contains("UPPERCASE")) {
				isKeyboardChanged = true;
				break;
			} else {
				if (currentKeyboard.contains("LOWERCASE")) {
					sendKey("SHIFT");
					keyboardlayoutName = keyboardlayoutName();
				} else if (currentKeyboard.contains("SPECIAL CHARACTER")) {
					sendKey("CHANGE_LAYOUT");
					keyboardlayoutName = keyboardlayoutName();
				} else if (currentKeyboard.contains("DIGIT")) {
					sendKey("CHANGE_LAYOUT");
					keyboardlayoutName = keyboardlayoutName();
				}
			}
		}
		return isKeyboardChanged;
	}

	public static boolean changeKeyboardToLowerCase(String current_Keyboard) {
		boolean isKeyboardChanged = false;
		String currentKeyboard = current_Keyboard;
		String keyboardlayoutName = null;
		for (int i = 0; i < 5; i++) {
			if (keyboardlayoutName != null && keyboardlayoutName.contains("LOWERCASE")) {
				isKeyboardChanged = true;
				break;
			} else {
				if (currentKeyboard.contains("LOWERCASE")) {
					isKeyboardChanged = true;
					break;
				} else if (currentKeyboard.contains("UPPERCASE")) {
					sendKey("SHIFT");
					keyboardlayoutName = keyboardlayoutName();
				} else if (currentKeyboard.contains("SPECIAL CHARACTER")) {
					sendKey("CHANGE_LAYOUT");
					keyboardlayoutName = keyboardlayoutName();
				} else if (currentKeyboard.contains("DIGIT")) {
					sendKey("CHANGE_LAYOUT");
					keyboardlayoutName = keyboardlayoutName();
				}
			}
		}
		return isKeyboardChanged;
	}

	public static boolean changeKeyboardToDigit(String current_Keyboard) {
		boolean isKeyboardChanged = false;
		String currentKeyboard = current_Keyboard;
		String keyboardlayoutName = null;
		for (int i = 0; i < 5; i++) {
			if (keyboardlayoutName != null && keyboardlayoutName.contains("DIGIT")) {
				isKeyboardChanged = true;
				break;
			} else {
				if (currentKeyboard.contains("UPPERCASE") || currentKeyboard.contains("LOWERCASE")) {
					sendKey("CHANGE_LAYOUT");
					keyboardlayoutName = keyboardlayoutName();
				} else if (currentKeyboard.contains("SPECIAL CHARACTER")) {
					sendKey("SHIFT");
					keyboardlayoutName = keyboardlayoutName();
				}
			}
		}
		return isKeyboardChanged;
	}

	public static boolean changeKeyboardToSpecialCharacter(String current_Keyboard) {
		boolean isKeyboardChanged = false;
		String currentKeyboard = current_Keyboard;
		String keyboardlayoutName = null;
		for (int i = 0; i < 5; i++) {
			if (keyboardlayoutName != null && keyboardlayoutName.contains("SPECIAL CHARACTER")) {
				isKeyboardChanged = true;
				break;
			} else {
				if (currentKeyboard.contains("UPPERCASE") || currentKeyboard.contains("LOWERCASE")) {
					sendKey("CHANGE_LAYOUT");
					currentKeyboard = keyboardlayoutName = keyboardlayoutName();
				} else if (currentKeyboard.contains("DIGIT")) {
					sendKey("SHIFT");
					current_Keyboard = keyboardlayoutName = keyboardlayoutName();
				}
			}
		}
		return isKeyboardChanged;
	}

	@SuppressWarnings("deprecation")
	public static String characterAnalysis(char c) {
		String specialCharactersString = "!@#$%&*()'+,-./:;<=>?[]^_`{|}";
		String Charstr = String.valueOf(c);
		String commonspecialCharacter = "$&@.,?!'";
		String common_specialChar = String.valueOf(c);

		if (Character.isUpperCase(c) || Character.isSpace(c)) {
			return "UPPERCASE";
		} else if (Character.isLowerCase(c) || Character.isSpace(c)) {
			return "LOWERCASE";
		} else if (Character.isDigit(c) || commonspecialCharacter.contains(common_specialChar)
				|| Character.isSpace(c)) {
			return "DIGIT";
		} else if (specialCharactersString.contains(Charstr) || Character.isSpace(c)) {
			return "SPECIAL CHARACTER";
		} else if (Character.isSpace(c)) {
			return "SPACE";
		} else {
			new Throwable("Invalid character");
			return null;
		}

	}

//	public static String keyboardlayoutName() {
////		String txt = StatCommands.getInstance().cattCommandsStub
////				.getTextsFromScreenParticualrArea(
////						screenshotData.newBuilder().setCapturePath("ArmConstants.stat_UI_Tmp_Asset").setXStartCordinate(2)
////								.setYStartCoordinate(219).setXEndCordinate(319).setYEndCoordinate(361).build())
////				.getStrVal();
//		String txt = StatCommands.getInstance().cattCommandsStub
//				.getTextsFromScreenParticualrArea(
//						screenshotData.newBuilder().setCapturePath("ArmConstants.stat_UI_Tmp_Asset").setXStartCordinate(2)
//								.setYStartCoordinate(242).setXEndCordinate(319).setYEndCoordinate(358).build())
//				.getStrVal();
//
////		System.out.println(txt);
//		if (txt.contains("Q") && txt.contains("W") && txt.contains("E") && txt.contains("R") && txt.contains("T")
//				&& txt.contains("Y")) {
//			return "UPPERCASE";
//		} else if (txt.contains("q") && txt.contains("w") && txt.contains("e") && txt.contains("r") && txt.contains("t")
//				&& txt.contains("y")) {
//			return "LOWERCASE";
//		} else if (txt.contains("(") && txt.contains(")") && txt.contains("&") && txt.contains("@")
//				&& txt.contains("7")) {
//			return "DIGIT";
//		} else if (txt.contains("}") && txt.contains("—")) {
//			return "SPECIAL CHARACTER";
//		} else {
//			return null;
//		}
//	}

	public static String keyboardlayoutName() {
		try {
			String txt = StatCommands.getInstance().cattCommandsStub.getTextsFromScreenParticualrArea(
					screenshotData.newBuilder().setCapturePath("ArmConstants.stat_UI_Tmp_Asset").setXStartCordinate(2)
							.setYStartCoordinate(242).setXEndCordinate(319).setYEndCoordinate(358).build())
					.getStrVal();
			String device = SuiteConstants.getConstantValue(SuiteConstantTypes.PROJECT_SPECIFIC, "DEVICE_UNDER_TEST")
					.trim().toUpperCase();
			if (!device.contains("FLYCATCHER")) {
				if (txt.contains("A") && txt.contains("S") && txt.contains("D") && txt.contains("E")
						&& txt.contains("C") && txt.contains("T")) {
					return "UPPERCASE";
				} else if (txt.contains("q") && txt.contains("w") && txt.contains("e") && txt.contains("r")
						&& txt.contains("o") && txt.contains("p")) {
					return "LOWERCASE";
				} else if (txt.contains("1") && txt.contains("2") && txt.contains("3") && txt.contains("4")
						&& txt.contains("5")&& txt.contains("6")) {
					return "DIGIT";
				} else if (txt.contains("}") && txt.contains("#")&& txt.contains("+")&& txt.contains("<")) {
					return "SPECIAL CHARACTER";
				} else {
					return null;
				}
			} else {
				if (txt.contains("A") && txt.contains("S") && txt.contains("D") && txt.contains("E")
						&& txt.contains("C") && txt.contains("T")) {
					return "UPPERCASE";
				} else if (txt.contains("q") && txt.contains("w") && txt.contains("e") && txt.contains("r")
						&& txt.contains("o") && txt.contains("p")) {
					return "LOWERCASE";
				} else if (txt.contains("1") && txt.contains("2") && txt.contains("3") && txt.contains("4")
						&& txt.contains("5")&& txt.contains("6")) {
					return "DIGIT";
				} else if (txt.contains("}") && txt.contains("#")&& txt.contains("+")&& txt.contains("<")) {
					return "SPECIAL CHARACTER";
				} else {
					return null;
				}
			}
		} catch (Exception e) {
			return null;
		}
	}

//	public static String elementName() {
////		String txt = StatCommands.getInstance().cattCommandsStub
////				.getTextsFromScreenParticualrArea(
////						screenshotData.newBuilder().setCapturePath("ArmConstants.stat_UI_Tmp_Asset").setXStartCordinate(2)
////								.setYStartCoordinate(219).setXEndCordinate(319).setYEndCoordinate(361).build())
////				.getStrVal();
//		String txt = StatCommands.getInstance().cattCommandsStub
//				.getTextsFromScreenParticualrArea(
//						screenshotData.newBuilder().setCapturePath("ArmConstants.stat_UI_Tmp_Asset").setXStartCordinate(2)
//								.setYStartCoordinate(242).setXEndCordinate(319).setYEndCoordinate(358).build())
//				.getStrVal();
//	
//		if()
//	
//	
//	}

	public static String screenName(String screen) {

		if (screen.contains("SSID_NAME")) {
			return "UPPERCASE";
		} else if (screen.contains("SSID_PASSWORD")) {
			return "LOWERCASE";
		} else {
			return null;
		}

	}

//	public static boolean isWifiScreen(TestCases testCase) {
//		boolean flag = false;
//		ArrayList<String> dataList = RoboUtils.GetData_TakeScreenShot(testCase);
////		dataList.contains("")
//		System.out.println(dataList);
//		for (String string : dataList) {
//			if (string.toLowerCase().contains("gh")) {
//				flag = true;
//				break;
//			} else if (string.toLowerCase().contains("g")) {
//				flag = true;
//				break;
//			} else if (string.toLowerCase().contains("2")) {
//				flag = true;
//				break;
//			} else if (string.toLowerCase().contains("D")) {
//				flag = true;
//				break;
//			} else if (string.toLowerCase().contains("?")) {
//				flag = true;
//				break;
//			}
//		}
//		return flag;
//	}
//
//	public static boolean isConfirmedAfterWifi(TestCases testCase) {
//		boolean flag = false;
//		ArrayList<String> dataList = RoboUtils.GetData_TakeScreenShot(testCase);
////		dataList.contains("")
//		System.out.println(dataList);
//		for (String string : dataList) {
//			if (string.toLowerCase().contains("success")) {
//				flag = true;
//				break;
//			}
//		}
//		return flag;
//	}

	/*
	 * public static void designKeyboardLayout() { String currentKeyboard =
	 * screenName("SSID_NAME"), firstkeyboardName = screenName("SSID_NAME"); String
	 * specialCharactersString = "!@#$%&*()'+,-./:;<=>?[]^_`{|}"; Pattern
	 * Numberpattern = Pattern.compile(".*[^0-9].*"); int incremental = 1; String
	 * sendString = "keyAADG"; char[] charArray = sendString.toCharArray(); for
	 * (char c : charArray) { String keyboardNeedtoChange = characterAnalysis(c);
	 * String currentcharacter = String.valueOf(c);
	 * 
	 * if (currentKeyboard.contains(currentKeyboard)) {
	 * 
	 * } else {
	 * 
	 * if (keyboardNeedtoChange.contains("UPPER CASE")) { if
	 * (currentKeyboard.contains("LOWER CASE")) { sendKey("SHIFT"); currentKeyboard
	 * = "UPPER CASE"; } else if (currentKeyboard.contains("SPECIAL CHARACTER")) {
	 * if (incremental == 1) { sendKey("CHANGE_LAYOUT"); currentKeyboard =
	 * "UPPER CASE"; } else { sendKey("CHANGE_LAYOUT"); sendKey("SHIFT");
	 * currentKeyboard = "UPPER CASE"; } } else if
	 * (currentKeyboard.contains("DIGIT")) { if (incremental == 1) {
	 * sendKey("CHANGE_LAYOUT"); currentKeyboard = "UPPER CASE"; } else {
	 * sendKey("CHANGE_LAYOUT"); sendKey("SHIFT"); currentKeyboard = "UPPER CASE"; }
	 * } else { new Throwable("invalid keyboard style"); }
	 * 
	 * } else if (keyboardNeedtoChange.contains("LOWER CASE")) { if
	 * (currentKeyboard.contains("UPPER CASE")) { sendKey("SHIFT"); currentKeyboard
	 * = "LOWER CASE"; } else if (currentKeyboard.contains("SPECIAL CHARACTER")) {
	 * 
	 * 
	 * 
	 * } else if (currentKeyboard.contains("DIGIT")) {
	 * 
	 * 
	 * } else { new Throwable("invalid keyboard style"); }
	 * 
	 * }
	 * 
	 * }
	 * 
	 * incremental = incremental + 1; }
	 * 
	 * }
	 */

}
