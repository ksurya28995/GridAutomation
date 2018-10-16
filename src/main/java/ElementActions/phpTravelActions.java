package ElementActions;

import static org.junit.Assert.assertTrue;

import java.util.Map;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

import ElementObjects.phpTravelObjects;
import commonUtilities.PropertyManager;
import commonUtilities.commonUtilities;
/**
 * Class is used to do validations on the site
 * 
 * @author surya.k.kumaresan
 */
public class phpTravelActions extends phpTravelObjects {

	WebDriver driver;
	Map<String, String> arrData;
	commonUtilities commObj;
	
	/**
	 * Method is used as a constructor
	 * 
	 * @param webdriver driver of the UI
	 * 
	 * @author surya.k.kumaresan
	 */
	public phpTravelActions(WebDriver driverObj) throws Exception {
		driver = driverObj;
		commObj = new commonUtilities();
		PageFactory.initElements(driver, this);
	}

	/**
	 * Method is used to do the validation 
	 * 
	 * @author surya.k.kumaresan
	 */
	public void searchHotel() throws Throwable {
		arrData = commObj.readCsvData("phpInputs.csv");
		commObj.setTextBox(checkInDateFld, arrData.get("Check In Date"));
		commObj.setTextBox(checkOutDateFld, arrData.get("Check Out Date"));
		commObj.clickElement(noOfPeopleFld);
		commObj.clickElement(addAdultBtn);
		commObj.clickElement(addAdultBtn);
		commObj.clickElement(addChildBtn);
		commObj.clickElement(searchBtn);
		commObj.threadsleep(5000);
		assertTrue("Results Page not found", results.getText().equalsIgnoreCase("No Results Found"));
	}
}
