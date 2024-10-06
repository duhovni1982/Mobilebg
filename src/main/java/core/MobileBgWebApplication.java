package core;

import base.Browser;
import pages.MainPage;
import pages.ResultPage;

public class MobileBgWebApplication {

    private Browser browser;
    private ResultPage resultPage;
    private MainPage mainPage;

    public MobileBgWebApplication() {
    }

    //lazy instantiating methods

    public Browser browser() {
        if (browser == null) {
            browser=new Browser();
            return browser;
        } else {
            return browser;
        }
    }

    public ResultPage resultPage() {
        if (resultPage == null) {
            resultPage =new ResultPage(browser.getBaseTools().driver);
            return resultPage;
        } else {
            return resultPage;
        }
    }

    public MainPage mainPage() {
        if (mainPage == null) {
            mainPage=new MainPage(browser.getBaseTools().driver);
            return mainPage;
        } else {
            return mainPage;
        }
    }


}
