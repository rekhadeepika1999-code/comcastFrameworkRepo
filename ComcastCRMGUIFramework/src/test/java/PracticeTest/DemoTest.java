package PracticeTest;

import org.testng.annotations.Test;

import com.aventstack.extentreports.Status;
import com.comcast.crm.basetest.BaseClass;
import com.comcast.crm.generic.webdriverutility.UtilityClassObject;

public class DemoTest  {
@Test
public void demo1() {
	System.out.println("Demo run");
	//UtilityClassObject.getTest().log(Status.PASS, "passed");
}
}
