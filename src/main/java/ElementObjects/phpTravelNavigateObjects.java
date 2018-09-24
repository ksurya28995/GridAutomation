package ElementObjects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

public class phpTravelNavigateObjects {

	@FindBy(how=How.XPATH, using = "//span[contains(text(),'Homepage')]//parent::div//parent::div//parent::div/div[2]//a/small")
	public WebElement homePageLink;
	
	@FindBy(how=How.XPATH, using = "//span[contains(text(),'Administrator')]//parent::div//parent::div//parent::div/div[2]//a/small")
	public WebElement adminPageLink;
	
	@FindBy(how=How.XPATH, using = "//span[contains(text(),'Supplier')]//parent::div//parent::div//parent::div/div[2]//a/small")
	public WebElement supplierPageLink;
	
	@FindBy(how=How.XPATH, using = "//div[@id='collapse']//ul[2]/ul[1]/li[1]/a[@data-toggle='dropdown']")
	public WebElement myAccountBtn;
	
	@FindBy(how=How.XPATH, using = "//span[@class='ink animate']//parent::a//parent::li//a[contains(text(),'  Sign Up')]")
	public WebElement signUpBtn;
	
	@FindBy(how=How.XPATH, using = "//span[@class='ink animate']//parent::a//parent::li//a[contains(text(),' Login')]")
	public WebElement loginBtn;
	
	
}
