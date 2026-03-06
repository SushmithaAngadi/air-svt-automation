package com.resideo.utils.stat;

import java.awt.Point;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

//import org.python.bouncycastle.pqc.jcajce.provider.qtesla.SignatureSpi.HeuristicIIISpeed;

import com.resideo.utils.stat.cattgrpccommands.screenshotData;
import com.spire.xls.core.spreadsheet.ISparkline;

public class UI_Stat_Data {

	private static String readerHeader = "0_0_319_50";

	public static double[] getCoordinates(String CoordinateName) {
		double coordinates[] = new double[4];
		String target = null;

		if (CoordinateName.contains("Header")) {
			target = readerHeader;

		} else {

		}

		String[] coordinate = target.split("_");
		for (int i = 0; i < coordinate.length; i++) {
			coordinates[i] = Double.parseDouble(coordinate[i]);
		}
//		System.out.println(coordinate.toString());
		return coordinates;
	}

	public static double[] getCoordinates_Keyboard(String charac) {
		double coordinates[] = new double[2];
		Point pt = getKeyboard_Coordinate(charac);
		coordinates[0] = pt.x;
		coordinates[1] = pt.y;
		return coordinates;
	}

	public static boolean clickOnElement_byCoordinate(double x, double y) {
		return StatCommands.getInstance().cattCommandsStub
				.clickOnExactButton(screenshotData.newBuilder().setXEndCordinate(x).setYEndCoordinate(y).build())
				.getBoolVal();
	}

	public static void coordinates(String keyboardType, String str) {
		int count = 0;
		String currentKeyboard = null;
		String currentchar;
		if (keyboardType.toUpperCase().contains("WIFINAME")||keyboardType.toUpperCase().contains("ROOMNAME")) {
			currentKeyboard = "UPPERCASE";
		} else if (keyboardType.toUpperCase().contains("WIFIPASSWORD")) {
			currentKeyboard = "LOWERCASE";
		} else {

		}

		char[] charArray = str.toCharArray();
		for (char c : charArray) {
			boolean isSpecialcharacter = isSpecialCharacter(c);
			currentchar = String.valueOf(c);
			count = count + 1;
			if (Character.isUpperCase(c)) {
				if (currentKeyboard.toUpperCase().contains("LOWERCASE")) {
					double[] coord = getCoordinates_Keyboard("SHIFT");
					clickOnElement_byCoordinate(coord[0], coord[1]);
					System.out.println("changed lowercase to uppercase");
					currentKeyboard = "LOWERCASE";
				} else if (currentKeyboard.toUpperCase().contains("DIGIT")
						|| currentKeyboard.toUpperCase().contains("SPECIALCHARACTER")) {
					double[] coord = getCoordinates_Keyboard("CHANGE_LAYOUT");
					clickOnElement_byCoordinate(coord[0], coord[1]);
					if(count>1) {
						coord = getCoordinates_Keyboard("SHIFT");
						clickOnElement_byCoordinate(coord[0], coord[1]);
						System.out.println("changed lowercase to uppercase");
					}
					System.out.println("changed digit to uppercase");
					currentKeyboard = "UPPERCASE";
				} else if (currentKeyboard.toUpperCase().contains("UPPERCASE")) {
					System.out.println("Layout no changes");
					currentKeyboard = "LOWERCASE";
				} else if (isSpecialcharacter) {
					double[] coord = getCoordinates_Keyboard("CHANGE_LAYOUT");
					clickOnElement_byCoordinate(coord[0], coord[1]);
					System.out.println("changed 123 to uppercase");
					currentKeyboard = "UPPERCASE";
				}
			} else if (Character.isLowerCase(c)) {
				if (currentKeyboard.toUpperCase().contains("UPPERCASE")) {
					double[] coord = getCoordinates_Keyboard("SHIFT");
					clickOnElement_byCoordinate(coord[0], coord[1]);
					System.out.println("changed to shift to lower case");
					currentKeyboard = "LOWERCASE";
				} else if (currentKeyboard.toUpperCase().contains("DIGIT")
						|| currentKeyboard.toUpperCase().contains("SPECIALCHARACTER")) {
					double[] coord = getCoordinates_Keyboard("CHANGE_LAYOUT");
					clickOnElement_byCoordinate(coord[0], coord[1]);
					System.out.println("changed digit to uppercase");
					coord = getCoordinates_Keyboard("SHIFT");
					clickOnElement_byCoordinate(coord[0], coord[1]);
					System.out.println("changed uppercase to lowercase");
					currentKeyboard = "LOWERCASE";
				} else if (currentKeyboard.toUpperCase().contains("LOWERCASE")) {
					System.out.println("Layout no changes");
				} else if (isSpecialcharacter) {
					double[] coord = getCoordinates_Keyboard("CHANGE_LAYOUT");
					clickOnElement_byCoordinate(coord[0], coord[1]);
					System.out.println("changed digit to uppercase");
					coord = getCoordinates_Keyboard("SHIFT");
					clickOnElement_byCoordinate(coord[0], coord[1]);
					System.out.println("changed uppercase to lowercase");
					currentKeyboard = "LOWERCASE";
				}
			} else if (Character.isDigit(c) || isSpecialcharacter) {
				if (currentKeyboard.toUpperCase().contains("UPPERCASE")) {
					double[] coord = getCoordinates_Keyboard("CHANGE_LAYOUT");
					clickOnElement_byCoordinate(coord[0], coord[1]);
					System.out.println("changed uppercase to digit");
					currentKeyboard = "DIGIT";
					if (isSpecialcharacter
							&& (currentchar.contains("_") || currentchar.contains("[") || currentchar.contains("]"))) {
						coord = getCoordinates_Keyboard("SHIFT");
						clickOnElement_byCoordinate(coord[0], coord[1]);
						currentKeyboard = "SPECIALCHARACTER";
					}
				} else if (currentKeyboard.toUpperCase().contains("LOWERCASE")) {
					double[] coord = getCoordinates_Keyboard("SHIFT");
					clickOnElement_byCoordinate(coord[0], coord[1]);
					System.out.println("changed uppercase to lowercase");
					coord = getCoordinates_Keyboard("CHANGE_LAYOUT");
					clickOnElement_byCoordinate(coord[0], coord[1]);
					System.out.println("changed uppercase to digit");
					currentKeyboard = "DIGIT";
					if (isSpecialcharacter
							&& (currentchar.contains("_") || currentchar.contains("[") || currentchar.contains("]"))) {
						coord = getCoordinates_Keyboard("SHIFT");
						clickOnElement_byCoordinate(coord[0], coord[1]);
						currentKeyboard = "SPECIALCHARACTER";
					}
				} else if (currentKeyboard.toUpperCase().contains("DIGIT")) {
					if (isSpecialcharacter) {
						if (currentchar.contains("_") || currentchar.contains("[") || currentchar.contains("]")) {
							double[] coord = getCoordinates_Keyboard("SHIFT");
							clickOnElement_byCoordinate(coord[0], coord[1]);
							currentKeyboard = "SPECIALCHARACTER";
						}
					}
				} else if (currentKeyboard.toUpperCase().contains("SPECIALCHARACTER")) {
					if (Character.isDigit(c)) {
						double[] coord = getCoordinates_Keyboard("SHIFT");
						clickOnElement_byCoordinate(coord[0], coord[1]);
						currentKeyboard = "DIGIT";
					}
				}
//			} else if (currentchar.contains(".") || currentchar.contains("-") || currentchar.contains("_")
//					|| currentchar.contains(",") || currentchar.contains("&") || currentchar.contains("!")
//					|| currentchar.contains("'") || currentchar.contains("(") || currentchar.contains(")")) {
//				if (!currentKeyboard.toUpperCase().contains("UPPERCASE")) {
//
//				} else {
//					new Throwable("CHARACTER invalid");
//				}
			} else {
				new Throwable("CHARACTER invalid");
			}
			double[] coord = getCoordinates_Keyboard(currentchar);
			clickOnElement_byCoordinate(coord[0], coord[1]);
		}

	}

	public static boolean isSpecialCharacter(char c) {
//		String str;
		Pattern checkPattern;
		Matcher match;
		boolean check;
		// Declare pattern of special characters
		checkPattern = Pattern.compile("[^a-zA-Z0-9]");
		// Declare matcher to match with String
		match = checkPattern.matcher(String.valueOf(c));
		// Use find( ) function to check
		check = match.find();
		// Check whether String contains any special characters or not and display
		// accordingly
		if (check) {
			System.out.println("Given String contains special character!");
			return true;
		} else {
			System.out.println("Given String doesn't contain any special characters");
			return false;
		}
	}

	public static Point getKeyboard_Coordinate(String atChar) {
		Point point = new Point();
		switch (atChar) {
		case "A":
		case "a":
		case "-":
		case "_": {
			point.setLocation(31, 332);
		}

			break;
		case "B":
		case "b":
		case "'": {
			point.setLocation(180, 390);
		}

			break;
		case "C":
		case "c":
		case "?": {
			point.setLocation(115, 390);
		}

			break;
		case "D":
		case "d":
		case ":":
		case "|": {
			point.setLocation(95, 331);
		}

			break;
		case "E":
		case "e":
		case "3":
		case "{": {
			point.setLocation(81, 272);
		}

			break;
		case "F":
		case "f":
		case ";":
		case "`": {
			point.setLocation(129, 331);
		}

			break;
		case "G":
		case "g":
		case "(":
		case "<": {
			point.setLocation(161, 332);
		}

			break;
		case "H":
		case "h":
		case ")":
		case ">": {
			point.setLocation(191, 332);
		}

			break;
		case "I":
		case "i":
		case "8":
		case "*": {
			point.setLocation(239, 273);
		}
			break;
		case "J":
		case "j":
		case "$": {
			point.setLocation(224, 329);
		}

			break;
		case "K":
		case "k":
		case "&": {
			point.setLocation(256, 330);
		}

			break;
		case "L":
		case "l":
		case "@": {
			point.setLocation(287, 330);
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
			point.setLocation(213, 386);
		}
			break;
		case "O":
		case "o":
		case "9":
		case "+": {
			point.setLocation(270, 272);
		}

			break;
		case "P":
		case "p":
		case "0":
		case "=": {
			point.setLocation(304, 270);
		}

			break;
		case "Q":
		case "q":
		case "1":
		case "[": {
			point.setLocation(14, 273);
		}

			break;
		case "R":
		case "r":
		case "4":
		case "}": {
			point.setLocation(112, 271);
		}
			break;
		case "S":
		case "s":
		case "/": {
			point.setLocation(63, 330);
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
			point.setLocation(208, 270);
		}
			break;
		case "V":
		case "v":
		case "!": {
			point.setLocation(149, 390);
		}

			break;
		case "W":
		case "w":
		case "2":
		case "]": {
			point.setLocation(48, 271);
		}
			break;
		case "X":
		case "x":
		case ",": {
			point.setLocation(85, 389);
		}

			break;
		case "Y":
		case "y":
		case "6":
		case "%": {
			point.setLocation(176, 273);
		}

			break;
		case "Z":
		case "z":
		case ".": {
			point.setLocation(54, 389);
		}

			break;
		case "SHIFT": {
			point.setLocation(18, 390);
		}

			break;
		case "BACKSPACE": {
			point.setLocation(294, 388);
		}

			break;
		case "SPACE": {
			point.setLocation(157, 448);
		}
			break;
		case "CHANGE_LAYOUT": {
			point.setLocation(33, 446);
		}
			break;
		case "NEXT": {
			point.setLocation(284, 446);
		}
			break;
		default:
			break;
		}
		return point;
	}

}
