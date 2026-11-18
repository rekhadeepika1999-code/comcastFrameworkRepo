package CreateNewContactPage;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CreateNewContactPage {

	WebDriver driver;
	public CreateNewContactPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(name="lastname")
	private WebElement lastname;
	
	@FindBy(name="button")
	private WebElement save;
	
	@FindBy(name="support_end_date")
	private WebElement enddate;
	
	public WebElement getLastname() {
		return lastname;
	}
	public WebElement getSave() {
		
		return save;
	}
	
public WebElement getEnddate() {
		
		return enddate;
	}
	

}
