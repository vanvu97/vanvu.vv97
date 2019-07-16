package firstDayAtWork;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
 
public class sapByDesignHomePage {
    private WebDriver driver;
    private By byUserNavigation = By.id("userNavigationLabel");
     
    public sapByDesignHomePage(WebDriver driver) {
        this.driver = driver;
    }
     
    public boolean isDisplayed() {
        if (Untils.waitForElementDisplay(driver, byUserNavigation, 10)) {
            return true;
        } else {
            return false;
        }
    }
}