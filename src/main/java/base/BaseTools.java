package base;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.time.Duration;


public class BaseTools {

    public static final Logger LOGGER = LoggerFactory.getLogger(BaseTools.class);
    protected final String BASE_URL = GlobalProperties.getInstance().getBaseUrl();

    public WebDriver driver;

    public BaseTools() {

    }

    public BaseTools(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public void navigateTo(String url) {
        driver.navigate().to(url);
    }

    protected WebElement waitForElementVisibility(WebElement elementToBeVisible) {
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(0));
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(25));

        WebElement foundElementAfterWait = wait.until(ExpectedConditions.visibilityOf(elementToBeVisible));

        // You can set it back to 10 seconds if needed
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

        return foundElementAfterWait;
    }

    public void typeText(WebElement element, String text) {
        waitForElementVisibility(element);
        element.clear();
        element.sendKeys(text);
    }

    public void selectText(WebElement element, String text) {
        waitForElementVisibility(element);
        element.sendKeys(text);
    }

    protected void mouseOver(WebElement element) {
        LOGGER.info("Scrolling...");
        Actions action = new Actions(driver);
        //This will perform mouseover function
        action.moveToElement(element);
    }


}