package newPOM;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class LoginPage{
	
	WebDriver driver;
	
	public LoginPage(WebDriver driver) {
		this.driver = driver;
	}
	public void login(String userName, String password) {
		driver.findElement(By.cssSelector("input[name='fTbxUserName']")).sendKeys(userName);
		driver.findElement(By.cssSelector("[name='fTbxPassword']")).sendKeys(password);
		
		WebElement ele = driver.findElement(By.cssSelector("#fBtnLogin"));
		JavascriptExecutor executor = (JavascriptExecutor)driver;
		executor.executeScript("arguments[0].click();", ele);
		
	}
	public void login2 (String userName2, String password2) {
		//Switch to frame
		driver.switchTo().frame("frameUserSelection");
		driver.findElement(By.id("fCbpUserSelection_ASPxPanel1_fPnlEmpIdentification_fTbxEmpUserId_I")).sendKeys(userName2);
		driver.findElement(By.id("fCbpUserSelection_ASPxPanel1_fPnlEmpIdentification_fTbxEmpSecPassword_I")).sendKeys(password2);
		driver.findElement(By.id("fCbpUserSelection_ASPxPanel1_fPnlEmpIdentification_fBtnLogin_B")).click();
		//Switch back to default page
		driver.switchTo().defaultContent();
	}	
		
	public void chooseCustomer(String customersName) {
		//Switch to frame
		driver.switchTo().frame("frameUserSelection");
		//Wait for element is display
		WebDriverWait waitTitle = new WebDriverWait(driver, 15);
		waitTitle.until(ExpectedConditions.visibilityOfElementLocated(By.id("fCbpUserSelection_ASPxPanel2_fPnlUserSelection_fTbxSearchName_I")));
		driver.findElement(By.id("fCbpUserSelection_ASPxPanel2_fPnlUserSelection_fTbxSearchName_I")).sendKeys(customersName);
		driver.findElement(By.id("fCbpUserSelection_ASPxPanel2_fPnlUserSelection_fBtnSearch_B")).click();
		//Choose Customer value (Customer's name)
		driver.findElement(By.xpath(".//*[@value='27228']")).click();
		driver.findElement(By.id("fCbpUserSelection_ASPxPanel2_fPnlUserSelection_fBtnOK_B")).click();
		//Switch back to default page
		driver.switchTo().defaultContent();
	}
		
}