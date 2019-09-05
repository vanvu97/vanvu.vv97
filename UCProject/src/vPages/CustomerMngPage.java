package vPages;

import java.io.FileNotFoundException;
import java.util.List;

import org.apache.commons.lang3.RandomStringUtils;
import org.apache.xpath.operations.Or;
import org.eclipse.jetty.util.log.Log;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class CustomerMngPage {
	
	//Reach to Customer Management section
	@FindBy (css = "li.menu-level-0:nth-child(8) > a:nth-child(1)")
	WebElement btnMonitor;
	@FindBy (css = "li.menu-level-0:nth-child(8) > ul:nth-child(2) > li:nth-child(1)")
	WebElement clickOnCustomerMng;
	@FindBy (css = ".font-black")
	WebElement addCustomer;
	//Create a Account
	@FindBy (css = "#collapse_fieldAccount > div:nth-child(1) > div:nth-child(2) > input:nth-child(1)")
	WebElement inpAccountName;
	@FindBy (css = "input.ng-valid-email")
	WebElement inpEmail;
	@FindBy (css = "select.ng-pristine")
	WebElement accType;
	@FindBy (css = "select.ng-pristine > option:nth-child(2)")
	WebElement types;
	@FindBy (css = "div.mrg10T:nth-child(3) > label:nth-child(1) > span:nth-child(2)")
	WebElement radioSynch;
	@FindBy (css = "div.mrg10T:nth-child(4) > label:nth-child(1) > span:nth-child(2)")
	WebElement radioEnable;
	@FindBy (css = "#collapse_fieldProfile > div:nth-child(1) > div:nth-child(2) > input:nth-child(1)")
	WebElement inpCode;
	@FindBy (css = "input.ng-invalid-required")
	WebElement inpFullName;
	@FindBy (css = "div.form-group:nth-child(3) > div:nth-child(2) > input:nth-child(1)")
	WebElement inpAddress;
	@FindBy (css = "div.form-group:nth-child(4) > div:nth-child(2) > input:nth-child(1)")
	WebElement impCompany;
	@FindBy (css = "div.form-group:nth-child(5) > div:nth-child(2) > input:nth-child(1)")
	WebElement inpCountry;
	@FindBy (css = "div.form-group:nth-child(6) > div:nth-child(2) > input:nth-child(1)")
	WebElement inpCountryCode;
	@FindBy (css = "div.form-group:nth-child(7) > div:nth-child(2) > input:nth-child(1)")
	WebElement inpPhoneNo;
	@FindBy (css = "button.btn")
	WebElement btnSave;
	//Click Next button
	@FindBy (css = ".pagination > li:nth-child(6) > a:nth-child(1)")
	static WebElement btnNext;
	@FindBy (css = ".pagination > li:nth-child(4) > a:nth-child(1)")
	static WebElement btnNext2;
	@FindBy (css = ".pagination > li:nth-child(5) > a")
	static WebElement btnNext3;
	//Get table
	@FindBy (css = ".table")
	WebElement customerTable;
	@FindBy (css = ".table > tbody:nth-child(2)")
	WebElement customerTable2;
	@FindBy (css = "tr.ng-scope:nth-child(n) > td")
	WebElement checkCells;
	//Error Noti
	@FindBy (css = ".lobibox-notify")
	WebElement errorDupEmail;
	@FindBy (css = ".has-error > div:nth-child(2) > p:nth-child(3)")
	WebElement wrongFormatEmail;
	//Delete accoutn
	@FindBy (css = "tr.ng-scope:nth-child(1) > th:nth-child(1) > div:nth-child(1) > a:nth-child(1)")
	WebElement hoverSettingBtn;
	@FindBy (css = ".open > ul:nth-child(2) > li:nth-child(4) > a:nth-child(1)")
	WebElement btnDeleteAccount;
	@FindBy (css = ".swal2-confirm")
	WebElement btnYesDelete;
	
	//Create account Name
	String randomAccountName = RandomStringUtils.randomNumeric(5);
	String accountName = "AccountTest" + randomAccountName;
	//Create a Random Email & Send String
	String createRandomEmail = RandomStringUtils.randomAlphabetic(10);
	String randomEmail = createRandomEmail + "@gmail.com";
	//Create random Code & Send String
	String createRandomCode = RandomStringUtils.randomNumeric(6);
	//Create full-name & Send String
	String createRandomName = RandomStringUtils.randomAlphabetic(6);
	//Create Address & Send String
	String createAddressNumb = RandomStringUtils.randomNumeric(3);
	String createAddressName = RandomStringUtils.randomAlphabetic(9);
	String address = createAddressNumb + " - " + createAddressName;
	//Company
	String[] Company = { "Google", "Facebook", "DI-Central", "Yahoo", "Honda", 
					"Yamaha"};
	//Create Country & Send String
	String[] Country = { "VietNam", "United States", "Japan", "Hong Kong", "India", 
			"Yamaha"};
	//Create Country Code
	String[] CountryCode = { "84", "1", "81", "852", "	91", 
			"Yamaha"};
	//Create random Phone No.
	String createPhoneNo = RandomStringUtils.randomNumeric(7);
	String PhoneNo = "090" + createPhoneNo;



	
	WebDriver driver;
	WebDriverWait wait;
	JavascriptExecutor js = (JavascriptExecutor) driver;
	
	public CustomerMngPage(WebDriver driver) {
		this.driver = driver;
		wait = new WebDriverWait(driver, 20);
		PageFactory.initElements(driver, this);
	}
	
	public void reachToCustomerSection() throws InterruptedException {
		String titleUA = driver.getTitle();
		Assert.assertEquals("Universal Center | DiCentral", titleUA);
		//Hover on MonitorButton
		Actions hover = new Actions(driver);
		hover.moveToElement(btnMonitor).build().perform();
		try {
	        Thread.sleep(5000);
	    } catch (InterruptedException e) {
	        e.printStackTrace();
	    }   
		clickOnCustomerMng.click();
	}
	public void AddCustomer() {
		addCustomer.click();
		//Create account Name
		inpAccountName.sendKeys(accountName);
		//Create a Random Email & Send String
		inpEmail.sendKeys(randomEmail);
		//Choose account Type
		accType.click();
		types.click();
//		if(radioSynch.isSelected()) {
//			System.out.println("Synchronize is Selected");
//		}else if(radioEnable.isSelected()) {
//			System.out.println("Enable is Selected");
//		}else if(!radioEnable.isSelected()) {
//			System.out.println("Enable is Checking");
//			radioEnable.click();
//		}
		//Create random Code & Send String
		inpCode.sendKeys(createRandomCode);
		//Create full-name & Send String
		inpFullName.sendKeys(createRandomName);
		//Create Address & Send String
		inpAddress.sendKeys(address);
		//Company
		impCompany.sendKeys(Company[2]);
		//Create Country & Send String
		inpCountry.sendKeys(Country[1]);
		//Create Country Code
		inpCountryCode.sendKeys(CountryCode[1]);
		//Create random Phone No.
		inpPhoneNo.sendKeys(PhoneNo);
		//Save
		btnSave.click();
		try {
	        Thread.sleep(1500);
	    } catch (InterruptedException e) {
	        e.printStackTrace();
	    }   
		//Assert
		if(errorDupEmail.isDisplayed()) {
			System.out.println("Email is exist. Please use another email");
		}else if(wrongFormatEmail.isDisplayed()) {
			System.out.println("Wrong email format.");
		}
	}
	
	public void PrintInfo() {
		//Summary Information
		System.out.println("Account Name : " + accountName);
		System.out.println("Email : " + randomEmail);
		System.out.println("Code : " + createRandomCode);
		System.out.println("Name : " + createRandomName);
		System.out.println("Address : " + address);
		System.out.println("Country : " + Country[1]);
		System.out.println("Country Code : " + CountryCode[1]);
		System.out.println("PhoneNo : " + PhoneNo);
		System.out.println("=======================================");
	}
	public void setPassword() throws FileNotFoundException, InterruptedException { 

		try {
	        Thread.sleep(1500);
	    } catch (InterruptedException e) {
	        e.printStackTrace();
	    }   
		
		List<WebElement> tableRows = customerTable2.findElements(By.tagName("tr"));
		
		int rowCount = tableRows.size();
		
		System.out.println(rowCount);
		
		for (int row = 0; row < rowCount; row++) {
			
			List<WebElement> columnsRow = customerTable2.findElements(By.tagName("td"));
			
			String getCells = tableRows.get(row).getText().trim();
			
			String firstAccountName = getCells.substring(0, getCells.indexOf(" "));

			 if(firstAccountName == "AccountTest91690") {
				 
				 System.out.println(firstAccountName + " == PASSED ==");
				 
				 break;
				 
			 }else {
				 
				 System.out.println(firstAccountName + " == FAILED ==");
			 }
		}
	}
	public void deleteAccount() {
		
			Actions hoverSetting = new Actions(driver);
			
			hoverSetting.moveToElement(hoverSettingBtn).build().perform();
			
			hoverSettingBtn.click();
			
			btnDeleteAccount.click();
			
			btnYesDelete.click();
			
			try {
				
		        Thread.sleep(1500);
		        
		    } catch (InterruptedException e) {
		        
		    	e.printStackTrace();
		    }  
	}
}

