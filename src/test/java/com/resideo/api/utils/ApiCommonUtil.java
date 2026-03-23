package com.resideo.utils.api.common;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

import org.apache.http.ParseException;
import org.json.JSONObject;
import org.json.simple.parser.JSONParser;

import com.resideo.commons.coreframework.Keyword;
import com.resideo.commons.coreframework.SuiteConstants;
import com.resideo.commons.coreframework.TestCases;
import com.resideo.commons.coreframework.SuiteConstants.SuiteConstantTypes;
import com.resideo.commons.report.FailType;
import com.jayway.jsonpath.Configuration;
import com.jayway.jsonpath.DocumentContext;
import com.jayway.jsonpath.JsonPath;
import com.jayway.jsonpath.spi.json.JacksonJsonNodeJsonProvider;
import com.jayway.jsonpath.spi.mapper.JacksonMappingProvider;

public class ApiCommonUtil {

	public static String getValueByJsonPath(String responseBody, String xpath) {
		try {
			return JsonPath.read(responseBody, xpath).toString();
		} catch (Exception e) {
			return null;
		}
	}

	public static String updateJsonValues(String jsonString, String jPath, String updateObject) {
		Configuration configuration = Configuration.builder().jsonProvider(new JacksonJsonNodeJsonProvider())
				.mappingProvider(new JacksonMappingProvider()).build();
		DocumentContext json = JsonPath.using(configuration).parse(jsonString);
		return json.set(jPath, updateObject).jsonString();
	}

	public static String deleteJsonPath(String jsonString, String jPath) {
		Configuration configuration = Configuration.builder().jsonProvider(new JacksonJsonNodeJsonProvider())
				.mappingProvider(new JacksonMappingProvider()).build();
		DocumentContext json = JsonPath.using(configuration).parse(jsonString);
		return json.delete(jPath).jsonString();
//		return json.set(jPath, updateObject).jsonString();
	}

	public static String updateJsonValues(Object jsonString, String jPath, Object updateObject) {
		Configuration configuration = Configuration.builder().jsonProvider(new JacksonJsonNodeJsonProvider())
				.mappingProvider(new JacksonMappingProvider()).build();
		DocumentContext json = JsonPath.using(configuration).parse(jsonString);
		return json.set(jPath, updateObject).jsonString();
	}

	public static String AddTimeinGivenTime(String inputDateFormat, String outputDateFormat, String date,
			String dayOfTime, int time) {
		try {
			Date dateFormat = new SimpleDateFormat(inputDateFormat).parse(date);
			Calendar cal = Calendar.getInstance();
			cal.setTime(dateFormat);
			if (dayOfTime.contains("HOUR")) {
				cal.add(Calendar.HOUR, time);
			} else if (dayOfTime.contains("WEEK")) {
				cal.add(Calendar.WEEK_OF_MONTH, time);
			} else if (dayOfTime.contains("DAY")) {
				cal.add(Calendar.DAY_OF_WEEK, time);
			} else if (dayOfTime.contains("MONTH")) {
				cal.add(Calendar.MONTH, time);
			} else if (dayOfTime.contains("MINUTE")) {
				cal.add(Calendar.MINUTE, time);
			} else if (dayOfTime.contains("SECOND")) {
				cal.add(Calendar.SECOND, time);
			}
			date = new SimpleDateFormat(outputDateFormat).format(cal.getTime());
		} catch (ParseException | java.text.ParseException e) {
			e.printStackTrace();
		}
		return date;
	}

	public static String roundOffTimeToUpcomingNearest15minutes(TestCases testCase, String format, String time) {
		String roundOffTime = " ";
		try {
			SimpleDateFormat dateFormat = new SimpleDateFormat(format);
			Calendar c = Calendar.getInstance();
			c.setTime(dateFormat.parse(time));
			int minutes = c.get(Calendar.MINUTE);
			int mod = minutes % 15;
			c.add(Calendar.MINUTE, 15 - mod);
			c.set(Calendar.SECOND, 0);
			roundOffTime = dateFormat.format(c.getTime());
		} catch (Exception e) {
			roundOffTime = " ";
			Keyword.ReportStep_Fail_WithOut_ScreenShot(testCase, FailType.FUNCTIONAL_FAILURE,
					"Add days to date : Error Occured : " + e.getMessage());
		}
		return roundOffTime;
	}

	public static String AddTimeinGivenTimeWith_15TimeBetween(String inputDateFormat, String outputDateFormat,
			String date, String dayOfTime, int time) {
		try {
			Date dateFormat = new SimpleDateFormat(inputDateFormat).parse(date);
			Calendar cal = Calendar.getInstance();
			cal.setTime(dateFormat);
			if (dayOfTime.contains("HOUR")) {
				cal.add(Calendar.HOUR, time);
			} else if (dayOfTime.contains("WEEK")) {
				cal.add(Calendar.WEEK_OF_MONTH, time);
			} else if (dayOfTime.contains("DAY")) {
				cal.add(Calendar.DAY_OF_WEEK, time);
			} else if (dayOfTime.contains("MONTH")) {
				cal.add(Calendar.MONTH, time);
			} else if (dayOfTime.contains("MINUTE")) {
				cal.add(Calendar.MINUTE, time);
			} else if (dayOfTime.contains("SECOND")) {
				cal.add(Calendar.SECOND, time);
			}
			int minutes = cal.get(Calendar.MINUTE);
			int mod = minutes % 15;
			cal.add(Calendar.MINUTE, 15 - mod);
			cal.set(Calendar.SECOND, 0);
			date = new SimpleDateFormat(outputDateFormat).format(cal.getTime());
		} catch (ParseException | java.text.ParseException e) {
			e.printStackTrace();
		}
		return date;
	}

	public static String getTimeWithAddedHours() {
		DateFormat date_format_obj = new SimpleDateFormat("dd/MM/yy HH:mm:ss");
		Calendar cal_obj = Calendar.getInstance();
		String currentDate = date_format_obj.format(cal_obj.getTime());
		System.out.println("Current date and time: " + currentDate);
		return AddTimeinGivenTimeWith_15TimeBetween("dd/MM/yy HH:mm:ss", "yyyy-MM-dd'T'HH:mm:ss.SS", currentDate,
				"HOUR", 8);
	}

	public static JSONObject get_RouterDetails() {
		JSONParser parser = new JSONParser();
		try {
			File currentDir = new File(".");
			String basePath = currentDir.getCanonicalPath();
			Object obj = parser.parse(new FileReader(basePath + "/src/test/resources/web_data/WifiData.json"));
			JSONObject json = new JSONObject(obj.toString());
			return json;
		} catch (IOException | ParseException | org.json.simple.parser.ParseException e) {
			return null;
		}
	}

	public static boolean set_PropertiesData_Router(JSONObject json, String url) {
		boolean flag = false;
		try {
			System.out.println(SuiteConstants.setConstantValue(SuiteConstantTypes.ROUTER_IOP_AUTOMATION, "USERNAME",
					json.getString("username")));
			System.out.println(SuiteConstants.setConstantValue(SuiteConstantTypes.ROUTER_IOP_AUTOMATION, "PASSWORD",
					json.getString("password")));
			System.out.println(SuiteConstants.setConstantValue(SuiteConstantTypes.ROUTER_IOP_AUTOMATION,
					"ISWEB_AUTHENTICATION_POPUPHANDLE", String.valueOf(json.getBoolean("ispopup")).toUpperCase()));
			System.out.println(SuiteConstants.setConstantValue(SuiteConstantTypes.ROUTER_IOP_AUTOMATION, "WEB_URL", url));
			System.out.println(SuiteConstants.setConstantValue(SuiteConstantTypes.ROUTER_IOP_AUTOMATION, "ROUTER_NAME",
					json.getString("routername").toUpperCase()));
			System.out.println(SuiteConstants.setConstantValue(SuiteConstantTypes.ROUTER_IOP_AUTOMATION, "ROUTER_MODEL",
					json.getString("routermodel").toUpperCase()));
			flag = true;
		} catch (Exception e) {
			new Throwable("xception occured due to " + e.getMessage());
			flag = false;
		}
		return flag;

	}

}
