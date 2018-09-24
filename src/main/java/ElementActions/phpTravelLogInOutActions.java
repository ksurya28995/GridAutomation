package ElementActions;

import java.util.Map;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

import ElementObjects.phpTravelLogInOutObjects;
import commonUtilities.PropertyManager;
import commonUtilities.commonUtilities;

public class phpTravelLogInOutActions extends phpTravelLogInOutObjects {

	WebDriver driver;
	Map<String, String> arrData;
	commonUtilities commObj;
	phpTravelNavigateActions phpTravelNavObj;
	
	public phpTravelLogInOutActions(WebDriver driverObj) throws Exception {
		driver = driverObj;
		commObj = new commonUtilities();
		phpTravelNavObj = new phpTravelNavigateActions(driverObj);
		PageFactory.initElements(driver, this);
	}

	public void loginFlow() throws Throwable {
		phpTravelNavObj.navigateToLoginPage();
		commObj.setTextBox(loUsernameFld, PropertyManager.getPropertyVal("email"));
		commObj.setTextBox(loPasswrdFld, PropertyManager.getPropertyVal("password"));
		commObj.clickElement(loLoginBtn);
		commObj.getFiveSecWait();
		commObj.verify(userNameText);
	}
	
	public void logoutFlow() throws Throwable {
		commObj.waitForElement(myAccountBtn);
		commObj.clickElement(myAccountBtn);
		commObj.clickElement(loLogoutBtn);
		commObj.getThreeSecWait();
		commObj.verify(loUsernameFld);
	}	
	
	public void signUp() throws Throwable {
		arrData = commObj.readCsvData("signUp_Php.csv");
		phpTravelNavObj.navigateToSignUpPage();
		commObj.waitForElement(suSignUpText);
		commObj.setTextBox(suFrstNameFld, arrData.get("Firstname"));
		commObj.setTextBox(suLastNameFld, arrData.get("Lastname"));
		commObj.setTextBox(suMobNumberFld, arrData.get("Mobile Number"));
		String email = arrData.get("Email");
		String randNo = commObj.generateRandomNumber(3);
		email = email.split("@")[0]+randNo+"@"+email.split("@")[1];
		commObj.setTextBox(suEmailFld, email); 
		commObj.setTextBox(suPasswrdFld, arrData.get("Password"));
		commObj.setTextBox(suConfPasswrdFld, arrData.get("Confirm Password"));
		commObj.clickElement(suSignUpBtn);
		commObj.getThreeSecWait();
	}
}
