package pages;

import base.BaseTools;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

public class MainPage extends BaseTools {

    public MainPage(WebDriver driver) {

        super(driver);
    }


    @FindBy(how = How.ID, using = "cookiescript_accept")
    public WebElement cookiescriptAccept;

    @FindBy(how = How.LINK_TEXT, using = "Търсене")
    public WebElement tursene;

    @FindBy(how = How.XPATH, using = "//*[@id=\"mainholder\"]/form/table/tbody/tr/td/table[2]/tbody/tr[3]/td[1]/select")
    public WebElement marka;

    @FindBy(how = How.XPATH, using = "//*[@id=\"mainholder\"]/form/table/tbody/tr/td/table[2]/tbody/tr[3]/td[3]/select")
    public WebElement model;

    @FindBy(how = How.ID, using = "eimg88")
    public WebElement fourbyfour;

    @FindBy(how = How.XPATH, using = "//*[@id=\"mainholder\"]/form/table/tbody/tr/td/table[2]/tbody/tr[1]/td[7]/input")
    public WebElement searchButton;


    //Methods--------------------------------
    public void openMainPage() {
        LOGGER.info("Navigate to: " + BASE_URL);
        navigateTo(BASE_URL);
    }

    public void clickTursene(){
        LOGGER.info("Click Търсене");
        mouseOver(tursene);
        tursene.click();
    }

    public void acceptCookies(){
        boolean enabled = cookiescriptAccept.isEnabled();
        if (enabled) {
            cookiescriptAccept.click();
            LOGGER.info("Accept cookies clicked");
        } else {
            LOGGER.info("Cookies did NOT appear");
        }
    }

    public void chooseMarka(String text){
        LOGGER.info("Select marka");
        selectText(marka, text);
    }

    public void chooseModel(String text){
        LOGGER.info("Select model");
        selectText(model, text);
    }

    public void selectFourByFour(){
        LOGGER.info("Select 4x4");
        fourbyfour.click();
    }

    public void clicksearchButton(){
        LOGGER.info("Click the Search button");
        mouseOver(searchButton);
        searchButton.click();
    }

}
