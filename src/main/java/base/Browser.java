package base;

import lombok.Data;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.time.Duration;

@Data
public class Browser {
    private String CHROME_DRIVER_PATH;
    private String FIREFOX_DRIVER_PATH;
    private BaseTools baseTools = new BaseTools();

    public Browser() {
        // Determine the OS type
        String os = System.getProperty("os.name").toLowerCase();

        if (os.contains("win")) {
            // Windows
            CHROME_DRIVER_PATH = "src/main/resources/win/chromedriver.exe";
            FIREFOX_DRIVER_PATH = "src/main/resources/win/geckodriver.exe";

        } else if (os.contains("nux")){
            // Linux or macOS
            CHROME_DRIVER_PATH = "src/main/resources/linux/chromedriver";

        } else if (os.contains("mac")) {
            // Linux or macOS
            CHROME_DRIVER_PATH = "src/main/resources/mac/chromedriver";

        } else {
            // Unsupported OS
            throw new IllegalStateException("Unsupported operating system: " + os);
        }
    }

    public void initChrome(){
        System.setProperty("webdriver.chrome.driver", CHROME_DRIVER_PATH);

        // Disable the "Choose your search engine" prompt
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--disable-search-engine-choice-screen");

        baseTools.driver = new ChromeDriver(options);
        baseTools.driver.manage().window().maximize();
        baseTools.driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
    }

    public void initFirefox() {
        baseTools.driver = new FirefoxDriver();
        baseTools.driver.manage().window().maximize();
        baseTools.driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
    }

    public void tearDown() {
        baseTools.driver.quit();
    }

}
