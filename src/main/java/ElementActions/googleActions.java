package ElementActions;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

import ElementObjects.googleObjects;

public class googleActions extends googleObjects{
	WebDriver _driver;

	public googleActions(WebDriver driverObj) {
		_driver = driverObj;
		PageFactory.initElements(_driver, this);
	}

	public void addSearchTxt() throws Throwable {
		searchBox.sendKeys("Yes");
		Thread.sleep(5000);
		searchBtn.click();
		Thread.sleep(5000);
	}

	public void checkPage() throws Throwable {
		resultStats.isDisplayed();
	}
}
