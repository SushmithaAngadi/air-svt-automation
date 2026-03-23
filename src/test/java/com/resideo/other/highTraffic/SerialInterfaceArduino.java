package com.resideo.system.utils;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.time.Duration;
import java.util.ArrayList;
import java.util.Base64;
import java.util.Scanner;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.support.ui.FluentWait;

import com.fazecast.jSerialComm.*;
import com.resideo.commons.coreframework.Keyword;
import com.resideo.commons.coreframework.TestCases;
import com.resideo.commons.report.FailType;

public class SerialInterfaceArduino {
	
	private static SerialPort activeArduinoPort;
	
	public static SerialPort getActiveArduinoPort() {
	    return activeArduinoPort;
	}
	
    public static SerialPort comDiscoverDevice(String deviceName){
        SerialPort[] comPorts = SerialPort.getCommPorts();
        SerialPort devicePort = null;
        for (SerialPort port: comPorts) {
//            System.out.println(port.getSystemPortName());
//            System.out.println(port.getManufacturer());
//            System.out.println(port.getDescriptivePortName());
            if(port.getManufacturer().toUpperCase().contains(deviceName.toUpperCase())){
                System.out.println(deviceName + " detected on " + port.getSystemPortName());
                devicePort = port;
            }
        }
        return devicePort;
    }

    public static boolean comInitCheck(SerialPort port, String expInitMessage) throws InterruptedException{
        
        boolean isMatching = false;

        if(port != null){
            port.openPort(200);
            if (port.isOpen()) {
                System.out.println(port.getSystemPortName() + " port opened successfully");
                Thread.sleep(1000);
//                SerialInterfaceArduino.sendCommand(port, "IS OPEN", "");
                
              

                try {
                	port.getOutputStream().write(("IS OPEN\n").getBytes());
    				port.getOutputStream().flush();
    				TimeUnit.SECONDS.sleep(2);
    				Scanner comScanner = new Scanner(port.getInputStream());
                    while(comScanner.hasNextLine()){
                        String rxString = comScanner.nextLine();
                        System.out.println("Received String: " + rxString);
                        if(rxString.contains(expInitMessage)){
                            System.out.println("Device ready..!");
                            isMatching = true;
                        }
                        
                        else{
                            System.out.println("Arduino init string not matched");
                            isMatching = false;
                        }
                    }
                }catch (Exception e) {
                    System.err.println("Error reading from serial port: " + e.getMessage());
                }
            }
        }
    return isMatching;
    }

	public static boolean commandTest(SerialPort port, String command, String expResponse) throws InterruptedException {
		boolean isSensorPaired = false;
		if (port != null) {
			PrintWriter out = new PrintWriter(port.getOutputStream(), true);
			Thread.sleep(1000);
			try {
				port.getOutputStream().write((command + "\n").getBytes());
				port.getOutputStream().flush();

				System.out.println("Relay1_ON command sent");
				FluentWait<Boolean> wait = new FluentWait<>(true).withTimeout(Duration.ofMinutes(3))
						.pollingEvery(Duration.ofSeconds(3)).ignoring(Exception.class);
				isSensorPaired = wait.until(flag -> {
					try {
						Scanner comScanner = new Scanner(port.getInputStream());
						while (comScanner.hasNextLine()) {
							String rxString = comScanner.nextLine();
							System.out.println("Received String: " + rxString);
							if (rxString.contains(expResponse)) {
								System.out.println("Command Response validated");
								return true;
							} else {
								System.out.println("Command Response not matching");
								return false;
							}
						}
						System.out.println("Did not receive a message from Arduino port");
						return false;

					} catch (Exception e) {
						System.err.println("Error reading from serial port: " + e.getMessage());
					}
					return false;
				});
			} catch (IOException e1) {
				e1.printStackTrace();
			}
		}
		return isSensorPaired;

	}
    
    public static SerialPort arduinoInterfaceInit() throws InterruptedException{
    //SERIAL DEVICE DISCOVERY FUNCTION CALL
        String deviceName = "Arduino";
        SerialPort port = comDiscoverDevice(deviceName);

        if(port != null){
            System.out.println(deviceName + " found");
        }
        else if(port == null){
            System.out.println(deviceName + " not found");
        }
        return port;
    }
    
    public static boolean checkIsArdinoConnected() {
		try {
			SerialPort port = comDiscoverDevice("Arduino");
			if (comInitCheck(port, "Ready to take Input")) {
				activeArduinoPort = port;
				return true;
			}
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		return false;
	}
	
	public static ArrayList<String> getEimOnRelays(TestCases testCase) {
		ArrayList<String> relays_status = new ArrayList<>();
		try {
			if (activeArduinoPort != null) {
				activeArduinoPort.getOutputStream().write(("READ" + "\n").getBytes());
				activeArduinoPort.getOutputStream().flush();
				try {
					TimeUnit.SECONDS.sleep(2);
					Scanner comScanner = new Scanner(activeArduinoPort.getInputStream());
					while (comScanner.hasNextLine()) {
						String rxString = comScanner.nextLine();
						System.out.println("Received String: " + rxString);
						for (String relayStatus : rxString.split(",")) {
							if (relayStatus.split(":")[1].contains("ON")) {
								relays_status.add(relayStatus.split(":")[0].trim());
							}
						}
					}
				} catch (Exception e) {
					System.err.println("Error reading from serial port: " + e.getMessage());
				}

			}else {
				Keyword.ReportStep_Fail_WithOut_ScreenShot(testCase, FailType.COSMETIC_FAILURE,
						"The activeArduinoPort is :"+activeArduinoPort);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return relays_status;
	}
	
	public static boolean sendCommand(SerialPort port, String command, String expResponse)
			throws InterruptedException {
		boolean flag = false;
		for (int j = 0; j < 2; j++) {
			if (port != null) {
				try {
					if (!port.isOpen()) {
		                System.out.println("Opening serial port...");
		                if (!port.openPort(200)) {
		                    System.err.println("Failed to open port.");
		                    return false;
		                }
		            }
					PrintWriter out = new PrintWriter(port.getOutputStream(), true);
					BufferedReader reader = new BufferedReader(new InputStreamReader(port.getInputStream()));
					port.getOutputStream().write((command + "\n").getBytes());
					port.getOutputStream().flush();

					if (command.toUpperCase().contains("RESET")) {
						TimeUnit.SECONDS.sleep(16);
					}
					TimeUnit.SECONDS.sleep(1);
					for (int i = 0; i < 8; i++) {
						try {
							port.getOutputStream().write(("READ STATUS\n").getBytes());
							port.getOutputStream().flush();

							TimeUnit.MILLISECONDS.sleep(300);

							String rxString = null;

							if ((rxString = reader.readLine()) != null) {
								System.out.println("Received String: " + rxString);
								if (rxString.toUpperCase().contains(expResponse.toUpperCase())) {
									return true;
								} else if (rxString.toUpperCase().contains("UNKNOWN")) {
									continue;
								} 
								else {
									System.out.println("LED Status is: " + rxString);
								}
							} else {
								System.out.println("No response received from device");
							}
						} catch (Exception inner) {
							System.err.println(
									"Error reading from serial port (iteration " + i + "): " + inner.getMessage());
							i--;
							// continue to next iteration
						}
					}

				} catch (Exception e) {
					System.err.println("Serial port setup failed: " + e.getMessage());
				}
			}
		}
		return false;
	}
    
    public static boolean readResponseFromAurdino(TestCases testCase, SerialPort port, String command, String expResponse) throws InterruptedException {
    	 PrintWriter out = new PrintWriter(port.getOutputStream(), true);
         BufferedReader reader = new BufferedReader(new InputStreamReader(port.getInputStream()));
    	for (int i = 0; i < 5; i++) {
            try {
                port.getOutputStream().write(("READ STATUS\n").getBytes());
                port.getOutputStream().flush();

                TimeUnit.MILLISECONDS.sleep(300);

                String rxString = null;

                if ((rxString = reader.readLine()) != null) {
                    System.out.println("Received String: " + rxString);
                    if (rxString.toUpperCase().contains(expResponse.toUpperCase())) {
                        return true;
                    } else {
                    	Keyword.ReportStep_Pass(testCase, "LED Status is: " + rxString);
                    }
                } else {
                    Keyword.ReportStep_Pass(testCase, "No response received from device");
                }
            } catch (Exception inner) {
                System.err.println("Error reading from serial port (iteration " + i + "): " + inner.getMessage());
                i--;
                // continue to next iteration
            }
        }
    	return false;
    }
    
    public static void decodeBase64ToPng(String rawData, String outputImagePath) {
        try {
            // 1️⃣ Remove ANSI escape sequences and control characters
            String  cleanedData = rawData.replaceAll("[^A-Za-z0-9+/=]", "");
            
            cleanedData=cleanedData.substring(5,cleanedData.length());
            System.out.println(cleanedData);
            cleanedData=cleanedData.substring(0,cleanedData.length()-5);
            System.out.println(cleanedData);
            
            // Decode Base64
            byte[] imageBytes = Base64.getDecoder().decode(cleanedData);
 
            // Write the decoded image
            Files.write(Paths.get(outputImagePath), imageBytes);
 
            System.out.println(" Image saved successfully: " + outputImagePath);
 
        } catch (IllegalArgumentException e) {
            System.err.println("Invalid Base64 data — possibly corrupted or incomplete.");
            e.printStackTrace();
        } catch (Exception e) {
            System.err.println("Failed to decode or write PNG file.");
            e.printStackTrace();
        }
    }


}
