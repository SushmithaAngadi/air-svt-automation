package com.resideo.utils.relay;

public class RelayUtils extends SerialCommunication {
	static boolean flagship;

	public RelayUtils() {
		flagship = new SerialCommunication().intialSerialCommunication();
	}

	public static boolean G_Relay(String RelayPosition) {
		boolean flag = true;
		if (flagship) {

			if (RelayPosition.equals("ON")) {
				String message = sendDataAfterDATA(port, G_Relay_ON);
				if (message.equals("PIN :22 ON"))
					flag = true;
				else
					flag = false;
			} else if (RelayPosition.equals("OFF")) {
				String message = sendDataAfterDATA(port, G_Relay_OFF);
				if (message.equals("PIN :22 OFF"))
					flag = true;
				else
					flag = false;
			}
		} else {
			System.out.println("initaSerialCommunication not able to intilize");
			flag = false;
		}
		return flag;
	}

	public static boolean Y_Relay(String RelayPosition) {
		boolean flag = true;
		if (flagship) {
			if (RelayPosition.equals("ON")) {
				String message = sendDataAfterDATA(port, Y_Relay_ON);
				if (message.equals("PIN :23 ON"))
					flag = true;
				else
					flag = false;
			} else if (RelayPosition.equals("OFF")) {
				String message = sendDataAfterDATA(port, Y_Relay_OFF);
				if (message.equals("PIN :23 OFF"))
					flag = true;
				else
					flag = false;
			}

		} else {
			System.out.println("initaSerialCommunication not able to intilize");
			flag = false;
		}
		return flag;
	}

	public static boolean K_Relay(String RelayPosition) {
		boolean flag = true;
		if (flagship) {
			if (RelayPosition.equals("ON")) {
				String message = sendDataAfterDATA(port, K_Relay_ON);
				if (message.equals("PIN :24 ON"))
					flag = true;
				else
					flag = false;
			} else if (RelayPosition.equals("OFF")) {
				String message = sendDataAfterDATA(port, K_Relay_OFF);
				if (message.equals("PIN :24 OFF"))
					flag = true;
				else
					flag = false;
			}

		} else {
			System.out.println("initaSerialCommunication not able to intilize");
			flag = false;
		}
		return flag;
	}

	public static boolean W_AUX_Relay(String RelayPosition) {
		boolean flag = true;
		if (flagship) {
			if (RelayPosition.equals("ON")) {
				String message = sendDataAfterDATA(port, W_AUX_Relay_ON);
				if (message.equals("PIN :25 ON"))
					flag = true;
				else
					flag = false;
			} else if (RelayPosition.equals("OFF")) {
				String message = sendDataAfterDATA(port, W_AUX_Relay_OFF);
				if (message.equals("PIN :25 OFF"))
					flag = true;
				else
					flag = false;
			}

		} else {
			System.out.println("initaSerialCommunication not able to intilize");
			flag = false;
		}
		return flag;
	}

	public static boolean Y2_Relay(String RelayPosition) {
		boolean flag = true;
		if (flagship) {
			if (RelayPosition.equals("ON")) {
				String message = sendDataAfterDATA(port, Y2_Relay_ON);
				if (message.equals("PIN :26 ON"))
					flag = true;
				else
					flag = false;
			} else if (RelayPosition.equals("OFF")) {
				String message = sendDataAfterDATA(port, Y2_Relay_OFF);
				if (message.equals("PIN :26 OFF"))
					flag = true;
				else
					flag = false;
			}

		} else {
			System.out.println("initaSerialCommunication not able to intilize");
			flag = false;
		}
		return flag;
	}

	public static boolean W_Relay(String RelayPosition) {
		boolean flag = true;
		if (flagship) {
			if (RelayPosition.equals("ON")) {
				String message = sendDataAfterDATA(port, W_Relay_ON);
				if (message.equals("PIN :27 ON"))
					flag = true;
				else
					flag = false;
			} else if (RelayPosition.equals("OFF")) {
				String message = sendDataAfterDATA(port, W_Relay_OFF);
				if (message.equals("PIN :27 OFF"))
					flag = true;
				else
					flag = false;
			}

		} else {
			System.out.println("initaSerialCommunication not able to intilize");
			flag = false;
		}
		return flag;
	}

	public static boolean O_B_Relay(String RelayPosition) {
		boolean flag = true;
		if (flagship) {
			if (RelayPosition.equals("ON")) {
				String message = sendDataAfterDATA(port, O_B_Relay_ON);
				if (message.equals("PIN :28 ON"))
					flag = true;
				else
					flag = false;
			} else if (RelayPosition.equals("OFF")) {
				String message = sendDataAfterDATA(port, O_B_Relay_OFF);
				if (message.equals("PIN :28 OFF"))
					flag = true;
				else
					flag = false;
			}

		} else {
			System.out.println("initaSerialCommunication not able to intilize");
			flag = false;
		}
		return flag;
	}

	public static boolean U_Relay(String RelayPosition) {
		boolean flag = true;
		if (flagship) {
			if (RelayPosition.equals("ON")) {
				String message = sendDataAfterDATA(port, U_Relay_ON);
				if (message.equals("PIN :29 ON"))
					flag = true;
				else
					flag = false;
			} else if (RelayPosition.equals("OFF")) {
				String message = sendDataAfterDATA(port, U_Relay_OFF);
				if (message.equals("PIN :29 OFF"))
					flag = true;
				else
					flag = false;
			}
		} else {
			System.out.println("initaSerialCommunication not able to intilize");
			flag = false;
		}
		return flag;
	}

	public static boolean L_Relay(String RelayPosition) {
		boolean flag = true;
		if (flagship) {
			if (RelayPosition.equals("ON")) {
				String message = sendDataAfterDATA(port, L_Relay_ON);
				if (message.equals("PIN :30 ON"))
					flag = true;
				else
					flag = false;
			} else if (RelayPosition.equals("OFF")) {
				String message = sendDataAfterDATA(port, L_Relay_OFF);
				if (message.equals("PIN :30 OFF"))
					flag = true;
				else
					flag = false;
			}
		} else {
			System.out.println("initaSerialCommunication not able to intilize");
			flag = false;
		}
		return flag;
	}

	public static boolean Thermostat_Relay(String RelayPosition) {
		boolean flag = true;
		if (flagship) {
			if (RelayPosition.equals("ON")) {
				String message = sendDataAfterDATA(port, Thermostat_Relay_ON);
				if (message.equals("PIN :31 ON"))
					flag = true;
				else
					flag = false;
			} else if (RelayPosition.equals("OFF")) {
				String message = sendDataAfterDATA(port, Thermostat_Relay_OFF);
				if (message.equals("PIN :31 OFF"))
					flag = true;
				else
					flag = false;
			}
		} else {
			System.out.println("initaSerialCommunication not able to intilize");
			flag = false;
		}
		return flag;
	}

	public static boolean Sensor1_Relay(String RelayPosition) {
		boolean flag = true;
		if (flagship) {
			if (RelayPosition.equals("ON")) {
				String message = sendDataAfterDATA(port, Sensor1_Relay_ON);
				if (message.equals("PIN :32 ON"))
					flag = true;
				else
					flag = false;
			} else if (RelayPosition.equals("OFF")) {
				String message = sendDataAfterDATA(port, Sensor1_Relay_OFF);
				if (message.equals("PIN :32 OFF"))
					flag = true;
				else
					flag = false;
			}
		} else {
			System.out.println("initaSerialCommunication not able to intilize");
			flag = false;
		}
		return flag;
	}

	public static boolean Sensor2_Relay(String RelayPosition) {
		boolean flag = true;
		if (flagship) {
			if (RelayPosition.equals("ON")) {
				String message = sendDataAfterDATA(port, Sensor2_Relay_ON);
				if (message.equals("PIN :33 ON"))
					flag = true;
				else
					flag = false;
			} else if (RelayPosition.equals("OFF")) {
				String message = sendDataAfterDATA(port, Sensor2_Relay_OFF);
				if (message.equals("PIN :33 OFF"))
					flag = true;
				else
					flag = false;
			}
		} else {
			System.out.println("initaSerialCommunication not able to intilize");
			flag = false;
		}
		return flag;
	}

	public static boolean Sensor3_Relay(String RelayPosition) {
		boolean flag = true;
		if (flagship) {
			if (RelayPosition.equals("ON")) {
				String message = sendDataAfterDATA(port, Sensor3_Relay_ON);
				if (message.equals("PIN :34 ON"))
					flag = true;
				else
					flag = false;
			} else if (RelayPosition.equals("OFF")) {
				String message = sendDataAfterDATA(port, Sensor3_Relay_OFF);
				if (message.equals("PIN :34 OFF"))
					flag = true;
				else
					flag = false;
			}
		} else {
			System.out.println("initaSerialCommunication not able to intilize");
			flag = false;
		}
		return flag;
	}

	public static boolean Sensor4_Relay(String RelayPosition) {
		boolean flag = true;
		if (flagship) {
			if (RelayPosition.equals("ON")) {
				String message = sendDataAfterDATA(port, Sensor4_Relay_ON);
				if (message.equals("PIN :35 ON"))
					flag = true;
				else
					flag = false;
			} else if (RelayPosition.equals("OFF")) {
				String message = sendDataAfterDATA(port, Sensor4_Relay_OFF);
				if (message.equals("PIN :35 OFF"))
					flag = true;
				else
					flag = false;
			}
		} else {
			System.out.println("initaSerialCommunication not able to intilize");
			flag = false;
		}
		return flag;
	}

	public static boolean Sensor5_Relay(String RelayPosition) {
		boolean flag = true;
		if (flagship) {
			if (RelayPosition.equals("ON")) {
				String message = sendDataAfterDATA(port, Sensor5_Relay_ON);
				if (message.equals("PIN :36 ON"))
					flag = true;
				else
					flag = false;
			} else if (RelayPosition.equals("OFF")) {
				String message = sendDataAfterDATA(port, Sensor5_Relay_OFF);
				if (message.equals("PIN :36 OFF"))
					flag = true;
				else
					flag = false;
			}
		} else {
			System.out.println("initaSerialCommunication not able to intilize");
			flag = false;
		}
		return flag;
	}

	public static boolean closePort() {
		return port.closePort();
	}

	public static boolean ResetAllRelay_OFF() {
		boolean flag = true;
		if (flagship) {

			String message = sendDataAfterDATA(port, "ResetAll");
			if (message.equals("ResetAll"))
				flag = true;
			else
				flag = false;
		} else {
			System.out.println("initaSerialCommunication not able to intilize");
			flag = false;
		}
		return flag;
	}

	public static boolean ResetAllRelay_ON() {
		boolean flag = true;
		if (flagship) {

			String message = sendDataAfterDATA(port, "AllRelayON");
			if (message.equals("AllRelayON"))
				flag = true;
			else
				flag = false;
		} else {
			System.out.println("initaSerialCommunication not able to intilize");
			flag = false;
		}
		return flag;
	}

	public boolean relayStatusUpdate(String RelayName, String RelayConditoion) {
		boolean flag = true;

		// String formation= "G_K_Y_Y2_W_W2_O:B_U_L_STAT_SEN1_SEN2_SEN3_SEN4_SEN5"
		flag = flag && ResetAllRelay_OFF();
		String[] split = RelayName.split("_");
		for (int i = 0; i < split.length; i++) {
			System.out.println(split[i]);
			switch (split[i]) {
			case "G": {
				flag = flag && G_Relay(RelayConditoion);
				break;
			}
			case "K": {
				flag = flag && K_Relay(RelayConditoion);
				break;
			}
			case "Y": {
				flag = flag && Y_Relay(RelayConditoion);
				break;
			}
			case "Y2": {
				flag = flag && Y2_Relay(RelayConditoion);
				break;
			}
			case "W": {
				flag = flag && W_Relay(RelayConditoion);
				break;
			}
			case "W2": {
				flag = flag && W_AUX_Relay(RelayConditoion);
				break;
			}
			case "O:B": {
				flag = flag && O_B_Relay(RelayConditoion);
				break;
			}
			case "U": {
				flag = flag && U_Relay(RelayConditoion);
				break;
			}
			case "L": {
				flag = flag && L_Relay(RelayConditoion);
				break;
			}
			case "STAT": {
				flag = flag && Thermostat_Relay(RelayConditoion);
				break;
			}

			case "ResetOFF": {
				flag = flag && ResetAllRelay_OFF();
				break;
			}
			case "ResetON": {
				flag = flag && ResetAllRelay_ON();
				break;
			}
			default: {
				flag = false;
				break;
			}

			}
		}
		return flag;
	}

	public boolean sensorEnroll_SensorUnPair(String SensorDetails, String Mode) {
		boolean flag = true;
		switch (SensorDetails) {

		case "Enroll": {
			switch (Mode) {

			case "SEN1": {
				flag = flag && Sensor1_Relay("ON");
				Sleep(200);
				flag = flag && Sensor1_Relay("OFF");
				break;
			}
			case "SEN2": {
				flag = flag && Sensor2_Relay("ON");
				Sleep(200);
				flag = flag && Sensor2_Relay("OFF");
				break;
			}
			case "SEN3": {
				flag = flag && Sensor3_Relay("ON");
				Sleep(200);
				flag = flag && Sensor3_Relay("OFF");
				break;
			}
			case "SEN4": {
				flag = flag && Sensor4_Relay("ON");
				Sleep(200);
				flag = flag && Sensor4_Relay("OFF");
				break;
			}
			case "SEN5": {
				flag = flag && Sensor5_Relay("ON");
				Sleep(200);
				flag = flag && Sensor5_Relay("OFF");
				break;
			}
			default: {
				flag = false;
				break;
			}
			}
			break;
		}
		case "UnPair": {
			switch (Mode) {

			case "SEN1": {
				flag = flag && Sensor1_Relay("ON");
				Sleep(14000);
				flag = flag && Sensor1_Relay("OFF");
				break;
			}
			case "SEN2": {
				flag = flag && Sensor2_Relay("ON");
				Sleep(14000);
				flag = flag && Sensor2_Relay("OFF");
				break;
			}
			case "SEN3": {
				flag = flag && Sensor3_Relay("ON");
				Sleep(14000);
				flag = flag && Sensor3_Relay("OFF");
				break;
			}
			case "SEN4": {
				flag = flag && Sensor4_Relay("ON");
				Sleep(14000);
				flag = flag && Sensor4_Relay("OFF");
				break;
			}
			case "SEN5": {
				flag = flag && Sensor5_Relay("ON");
				Sleep(14000);
				flag = flag && Sensor5_Relay("OFF");
				break;
			}
			default: {
				flag = false;
				break;
			}
			}
			break;
		}

		}

		return flag;
	}

	public void Sleep(int X) {
		try {
			Thread.sleep(X);
		} catch (InterruptedException e) {
		}
	}

}
