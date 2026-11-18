package PracticeTest;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.SearchContext;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class NestedShadowroot {

	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		WebDriver driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
		driver.get("https://demoapps.qspiders.com/ui/shadow/nested?sublist=2");
		SearchContext p=driver.findElement(By.xpath("//div[@class='shadowOuter']")).getShadowRoot();
		Actions Act=new Actions(driver);
		//open->close
		Act.sendKeys(p.findElement(By.cssSelector("label[for='email']")),Keys.TAB,"sdaef").perform();
		Thread.sleep(5000);
		
		//close->open
		Act.sendKeys(driver.findElement(By.xpath("//h1[text()='Login']")),Keys.TAB,Keys.TAB,"desert").perform();

	}

}
