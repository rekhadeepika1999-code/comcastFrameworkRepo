package PracticeTest;

import java.io.FileReader;

import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.testng.annotations.Test;

public class DemoJson {
	
		@Test
		public void readDatafromJson()throws Throwable{
			JSONParser js=new JSONParser();
			JSONObject obj =(JSONObject)js.parse(new FileReader("./configAppData/commondata.json"));
			System.out.println("Browser:"+obj.get("browser"));
			System.out.println("Url:"+obj.get("url"));
			
		}

}

