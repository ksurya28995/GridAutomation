package ElementObjects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

public class phpTravelLogInOutObjects {
	
	@FindBy(how=How.XPATH, using = "//input[@name='username']")
	public WebElement loUsernameFld;
	
	@FindBy(how=How.XPATH, using = "//input[@name='password']")
	public WebElement loPasswrdFld;
	
	@FindBy(how=How.XPATH, using = "//button[contains(text(),'Login')]")
	public WebElement loLoginBtn;
	
	@FindBy(how=How.XPATH, using = "//span[@class='ink animate']//parent::a//parent::li/ul/li[2]/a")
	public WebElement loLogoutBtn;
	
	@FindBy(how=How.XPATH, using = "//div[@id='collapse']//ul[2]/ul[1]/li[1]/a[@data-toggle='dropdown']")
	public WebElement myAccountBtn;
	
	@FindBy(how=How.XPATH, using = "//div[contains(text(),'Sign Up')]")
	public WebElement suSignUpText;
	
	@FindBy(how=How.XPATH, using = "//input[@name='firstname']")
	public WebElement suFrstNameFld;
	
	@FindBy(how=How.XPATH, using = "//input[@name='lastname']")
	public WebElement suLastNameFld;
	
	@FindBy(how=How.XPATH, using = "//input[@name='phone']")
	public WebElement suMobNumberFld;
	
	@FindBy(how=How.XPATH, using = "//input[@name='email']")
	public WebElement suEmailFld;
	
	@FindBy(how=How.XPATH, using = "//input[@name='password']")
	public WebElement suPasswrdFld;
	
	@FindBy(how=How.XPATH, using = "//input[@name='confirmpassword']")
	public WebElement suConfPasswrdFld;
	
	@FindBy(how=How.XPATH, using = "//button[contains(text(),' Sign Up')]")
	public WebElement suSignUpBtn;
	
	@FindBy(how=How.XPATH, using = "//h3[@class='RTL']")
	public WebElement userNameText;
	
	/*@FindBy(how=How.XPATH, using = "")
	public WebElement ;
	
	@FindBy(how=How.XPATH, using = "")
	public WebElement ;
	
	@FindBy(how=How.XPATH, using = "")
	public WebElement ;
	
	@FindBy(how=How.XPATH, using = "")
	public WebElement ;
	
	@FindBy(how=How.XPATH, using = "")
	public WebElement ;
	
	@FindBy(how=How.XPATH, using = "")
	public WebElement ;
	
	@FindBy(how=How.XPATH, using = "")
	public WebElement ;
	
	@FindBy(how=How.XPATH, using = "")
	public WebElement ;
	
	@FindBy(how=How.XPATH, using = "")
	public WebElement ;
	
	@FindBy(how=How.XPATH, using = "")
	public WebElement ;
	
	@FindBy(how=How.XPATH, using = "")
	public WebElement ;
	
	@FindBy(how=How.XPATH, using = "")
	public WebElement ;
	
	@FindBy(how=How.XPATH, using = "")
	public WebElement ;
	
	@FindBy(how=How.XPATH, using = "")
	public WebElement ;
	
	@FindBy(how=How.XPATH, using = "")
	public WebElement ;
	
	@FindBy(how=How.XPATH, using = "")
	public WebElement ;
	
	@FindBy(how=How.XPATH, using = "")
	public WebElement ;
	
	@FindBy(how=How.XPATH, using = "")
	public WebElement ;
	
	@FindBy(how=How.XPATH, using = "")
	public WebElement ;
	
	@FindBy(how=How.XPATH, using = "")
	public WebElement ;
	
	@FindBy(how=How.XPATH, using = "")
	public WebElement ;
	
	@FindBy(how=How.XPATH, using = "")
	public WebElement ;
	
	@FindBy(how=How.XPATH, using = "")
	public WebElement ;
	
	@FindBy(how=How.XPATH, using = "")
	public WebElement ;
	
	@FindBy(how=How.XPATH, using = "")
	public WebElement ;
	
	@FindBy(how=How.XPATH, using = "")
	public WebElement ;
	*/
}
