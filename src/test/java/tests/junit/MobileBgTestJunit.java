package tests.junit;

import core.MobileBgWebApplication;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class MobileBgTestJunit {
    public MobileBgWebApplication mobileBgWebApplication = new MobileBgWebApplication();

    @BeforeEach
    public void init(){
        mobileBgWebApplication.browser().initChrome();
    }

    @Test
    public void mobilebgTestOne() throws InterruptedException {
        //Open Main page
        mobileBgWebApplication.mainPage().openMainPage();

        mobileBgWebApplication.mainPage().acceptCookies();
        mobileBgWebApplication.mainPage().clickTursene();
        mobileBgWebApplication.mainPage().chooseMarka("VW");
        mobileBgWebApplication.mainPage().chooseModel("Golf");
        mobileBgWebApplication.mainPage().selectFourByFour();
        mobileBgWebApplication.mainPage().clicksearchButton();

        mobileBgWebApplication.resultPage().getTotalNmber();
        mobileBgWebApplication.resultPage().countTopAdons();
        mobileBgWebApplication.resultPage().countVipAdons();

    }

    @AfterEach
    public void tearDown(){
        mobileBgWebApplication.browser().tearDown();
    }

}