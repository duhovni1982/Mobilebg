package pages;

import base.BaseTools;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

import java.util.List;

public class ResultPage extends BaseTools {

    public ResultPage(WebDriver driver) {

        super(driver);
    }

    //WebElements-------------------------

    @FindBy(how = How.XPATH, using = "/html/body/form[3]/div[1]")
    public WebElement result;

    @FindBy(how = How.XPATH, using = "//div[contains(@class, 'item') and contains(@class, 'TOP')]")
    List<WebElement> promotedTopAds;

    @FindBy(how = How.XPATH, using = "//div[contains(@class, 'item') or contains(@class, 'VIP')]") // VIP or TOP ads
    List<WebElement> promotedVipAds;


    //Methods--------------------------------
    public String getTotalNmber(){
        waitForElementVisibility(result);

        String resulttext = result.getText();
        String regex = "общо\\s(\\d+)";

        java.util.regex.Pattern pattern = java.util.regex.Pattern.compile(regex);
        java.util.regex.Matcher matcher = pattern.matcher(resulttext);

        String resultNumber = null;

        // Ensure there is a match before calling group()
        if (matcher.find()) {
            resultNumber = matcher.group(1);  // Get the number after "общо"
            LOGGER.info("Total number of searched cars is: " + resultNumber);
        } else {
            LOGGER.warn("No number found after 'общо' in the result text.");
        }

        return resulttext;

    }

    public int countVipAdons(){
        int size = promotedVipAds.size();
        LOGGER.info("Total number of searched VIP adons is: " + size);
        return size;
    }

    public int countTopAdons(){
        int size = promotedTopAds.size();
        LOGGER.info("Total number of searched TOP adons is: " + size);
        return size;
    }


}


