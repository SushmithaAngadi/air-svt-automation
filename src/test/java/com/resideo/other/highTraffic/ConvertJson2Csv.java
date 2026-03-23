package com.resideo.system.utils;

import java.io.FileWriter;
import java.io.IOException;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVPrinter;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

public class ConvertJson2Csv {

	public static void main(String[] args) {
		// Step 1: Read JSON File to List Objects
		String jsonStr = "[{\"Trail_No\":\"1\",\"Start_value\":\"Jack Smith\",\"Start_value\":\"Massachusetts\",\"End_Value\":23},{\"Trail_No\":\"2\",\"Start_value\":\"Adam Johnson\",\"Start_value\":\"New York\",\"End_Value\":27},{\"Trail_No\":\"3\",\"Start_value\":\"Katherin Carter\",\"Start_value\":\"Washington DC\",\"End_Value\":26},{\"Trail_No\":\"4\",\"Start_value\":\"Jack London\",\"Start_value\":\"Nevada\",\"End_Value\":33},{\"Trail_No\":\"5\",\"Start_value\":\"Jason Bourne\",\"Start_value\":\"California\",\"End_Value\":36}]";

		List<TrailData> trailData = convertJsonString2Objects(jsonStr);

		// Step 2: Write List Objects to CSV File
		writeListObjects2CsvFile(trailData, "customers.csv");
	}

	/**
	 * 
	 * Convert JSON String to List Java Objects
	 * 
	 * @param pathFile
	 * @return
	 */
	private static List<TrailData> convertJsonString2Objects(String jsonString) {

		Type listType = new TypeToken<ArrayList<TrailData>>() {
		}.getType();
		return new Gson().fromJson(jsonString, listType);
	}

	/**
	 * Write List Objects to CSV File
	 * 
	 * @param customers
	 */
	@SuppressWarnings("deprecation")
	private static void writeListObjects2CsvFile(List<TrailData> trailData, String pathFile) {
		final String[] CSV_HEADER = { "Trail_No", "isExecuteOnTraffic", "Changes_in_APP_STAT",
				"Changes_in_Setpoint_SystemMode", "Before_Trail_Start_Value", "Start_value", "End_Value",
				"Traffic_StartTime", "Traffic_EndTIme", "Trail_StartTime", "Change_Time", "Verify_Time",
				"Total_TimeTaken", "AfterTrailWaitTime", "isTrailSuccess" };

		FileWriter fileWriter = null;
		CSVPrinter csvPrinter = null;

		try {
			fileWriter = new FileWriter(pathFile);
			csvPrinter = new CSVPrinter(fileWriter, CSVFormat.DEFAULT.withHeader(CSV_HEADER));

			for (TrailData traildatas : trailData) {
				List<?> data = Arrays.asList(traildatas.trailNo(), traildatas.executeOnTraffic_nonTraffic(),
						traildatas.changesApp_stat(), traildatas.setpointMode_change(), traildatas.beforeTrailStart(),
						traildatas.ChangefromValue(), traildatas.changeToValue(), traildatas.trafficStartTime(),
						traildatas.trailEndTime(), traildatas.trailStartTime(), traildatas.changeTime(),
						traildatas.verifyTime(), traildatas.TotalTimeTaken(), traildatas.AfterTrailWaitTime(),
						traildatas.isTrailSuccess());
				System.out.println(data);
				csvPrinter.printRecord(data);
			}
		} catch (Exception e) {
			System.out.println("Writing CSV error!");
			e.printStackTrace();
		} finally {
			try {
				fileWriter.flush();
				fileWriter.close();
				csvPrinter.close();
			} catch (IOException e) {
				System.out.println("Flushing/closing error!");
				e.printStackTrace();
			}
		}
	}
}