package diPages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class generalPage {
	
	WebDriver driver;

	public generalPage(WebDriver driver) {
		this.driver = driver;
	}
	
  public void masterpageSetting() {
	  //Click on actions list
	  driver.findElement(By.cssSelector("[name='fInboxControl$fCbxUpAction']")).click();
	  //Chooses Master Page Setting
	  driver.findElement(By.xpath(".//*[@value='btnImportFromCloudImportInvoice|cloud/BYD/Syn.aspx?type=SET']")).click();
	  //Click Ok
	  driver.findElement(By.id("fInboxControl_btnUpGo")).click();
	  
	  //Handle new opened browser windows
	  String winHandleBefore = driver.getWindowHandle();
		for(String winHandle : driver.getWindowHandles()){
		    driver.switchTo().window(winHandle);
		}
	
	  //Setting general
	  driver.findElement(By.id("generalSetting")).click();
	  //click on list trading partner
	  driver.findElement(By.id("tradingPartners")).click();
	  //choose Trading partner theo value
	  driver.findElement(By.xpath(".//*[@value='628']")).click();
	  
	  //Star check checkbox
	  System.out.println("Checking Invoice Settings (810)");
	  //Check first Invoice Settings (810) checkbox
	  WebElement Consolidate_Invoices = driver.findElement(By.xpath(".//*[@class='checkbox']//*[@id='Consolidate810']"));
	  WebElement Send_manual_Invoices = driver.findElement(By.xpath(".//*[@class='checkbox']//*[@id='EDIProcessMode810']"));
	  
	  if(Consolidate_Invoices.isSelected()) {
		  System.out.println("Consolidate Invoices 810 is : Checked " );
	  }else{
		  System.out.println("Consolidate Invoices 810 is : unChecked " );
	  }
	  if(Send_manual_Invoices.isSelected()) {
		  System.out.println("Send manual Invoices 810 is : Checked " );
	  }else {
		  System.out.println("Send manual Invoices 810 is : unChecked " );
	  }
	  
	  // Close the new window, if that window no more required
	  driver.close();
	  // Switch back to original browser (first window)
	  driver.switchTo().window(winHandleBefore);
	  //Close first window
	  driver.close();
	  
	  
  }
}
