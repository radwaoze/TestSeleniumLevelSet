package baseMethods;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.opera.OperaDriver;

public class BrowserSetup {

    WebDriver driver;

    public WebDriver BrowserName(String browser)
    {
        if(browser.equals("Chrome"))
        {

            WebDriverManager.chromedriver().setup();
            driver = new ChromeDriver();
            return driver;
        }
        else if(browser.equals("Firefox"))
        {
            WebDriverManager.firefoxdriver().setup();
            driver = new FirefoxDriver();
            return driver;
        }
        else if(browser.equals("Edge"))
        {
            WebDriverManager.edgedriver().setup();
            driver = new EdgeDriver();
            return driver;
        }
        else
        {
            WebDriverManager.operadriver().setup();
            driver = new OperaDriver();
            return driver;
        }
    }

    public void maximizeScreen()
    {
        driver.manage().window().maximize();
    }

    public void closeBrowser()
    {
        driver.quit();
    }


}
