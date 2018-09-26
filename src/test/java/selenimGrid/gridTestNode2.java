package selenimGrid;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.WebDriver;

import ElementActions.phpTravelActions;
import commonUtilities.PropertyManager;
import commonUtilities.RunCommandsInCmd;
import commonUtilities.commonUtilities;

public class gridTestNode2 {
	private static WebDriver driver = null;
	private static commonUtilities commObj = null;
	
	@BeforeClass
	public static void init() throws Throwable {
		int nodeNumber = 2;
		commObj = new commonUtilities();
		RunCommandsInCmd.startHubServer(PropertyManager.getPropertyVal("starthubserver"));
		RunCommandsInCmd.startNodeServer(PropertyManager.getPropertyVal("startnodeserver"), nodeNumber);
		driver = commObj.getDriver(nodeNumber);
		commObj.openURL(PropertyManager.getPropertyVal("phptravelurl"));
	}

	@Test
	public void appValidate() throws Throwable {
		phpTravelActions phpObj = new phpTravelActions(driver);
		phpObj.searchHotel();
	}

	@AfterClass
	public static void terminate() {
		RunCommandsInCmd.endHubServer();
		commObj.quitDriver();
	}

}
