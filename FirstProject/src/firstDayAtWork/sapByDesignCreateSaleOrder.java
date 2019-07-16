package firstDayAtWork;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class sapByDesignCreateSaleOrder {
		private WebDriver driver;
	    private By byUserNavigation = By.id("userNavigationLabel");
	    
	    JavascriptExecutor js = (JavascriptExecutor) driver;
	 
	    private By byShellMenu = By.id("__button0");
	     
	    public sapByDesignCreateSaleOrder(WebDriver driver) {
	        this.driver = driver;
	    }
	     
	    public sapByDesignHomePage createSaleOrder () {

	        driver.findElement(byShellMenu).click();
	        
	        // return home page
	        return new sapByDesignHomePage(driver);
	    }

		
	}