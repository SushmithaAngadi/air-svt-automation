package com.resideo.fileio.utils;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

import org.json.JSONException;
import org.json.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

public class JsonUtils 
{
	static public JSONObject ReadJosn(String fileNamePath) 
	{
		JSONParser jsonParser = new JSONParser();
		
//		String dir = System.getProperty("user.dir").replace("\\", "\\\\") + "\\\\src\\\\test\\\\resources\\\\testdata\\\\";
		String dir= System.getProperty("user.dir")+"/src/test/resources/testdata/";
		if(!fileNamePath.contains(dir))
			fileNamePath = dir + fileNamePath;
		
        try (FileReader reader = new FileReader(fileNamePath))
        {
            //Read JSON file
        	org.json.simple.JSONObject obj = (org.json.simple.JSONObject)jsonParser.parse(reader);
        	
            return new JSONObject(obj.toJSONString());
                          
        } catch (FileNotFoundException e) {
        	
            e.printStackTrace();
            return null;
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        } catch (ParseException e) {
            e.printStackTrace();
            return null;
        } catch (JSONException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			 return null;
		}
	}
}
