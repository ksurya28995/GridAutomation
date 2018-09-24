package ElementObjects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

public class googleObjects {

	@FindBy(how=How.XPATH, using="//div[@id='gs_lc0']/input[1]")
	public WebElement searchBox;
	
	@FindBy(how=How.XPATH, using="//input[@value='Google Search']")
	public WebElement searchBtn;
	
	@FindBy(how=How.XPATH, using="//input[@value='Google Search']")
	public WebElement resultStats;
	
}
