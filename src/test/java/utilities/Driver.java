package utilities;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;

import java.time.Duration;

public class Driver {

    public Driver() {
    }

    static WebDriver driver;

    public static WebDriver getDriver() {

        if (driver == null) {
            switch (Configreader.properties.getProperty("browser")) {
                case "chrome":
                    WebDriverManager.chromedriver().setup();
                    break;
                case "firefox":
                    WebDriverManager.firefoxdriver().setup();
                    break;
                default:
                    WebDriverManager.chromedriver().setup();
            }

            driver.manage().window().maximize();
            driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));


        }

        return driver;


    }
    public static void closeDriver(){
        if (driver!=null){
            driver.close();
            driver=null;
        }
    }
}
