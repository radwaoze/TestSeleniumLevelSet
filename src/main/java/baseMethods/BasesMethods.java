package baseMethods;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class BasesMethods {

    WebDriver driver;

    public BasesMethods(WebDriver driver)
    {
        this.driver = driver;
    }

    ////////////////////

    public WebElement waitExpectedCondition(By elementPath , String waitCond)
    {
        WebElement element = null;
        try
        {
            switch(waitCond)
            {
                case "presenceOfElementLocated":
                    element = (new WebDriverWait(driver, 15)).until(ExpectedConditions.presenceOfElementLocated(elementPath));
                    return element;

                case "elementToBeClickable":
                    element = (new WebDriverWait(driver, 15)).until(ExpectedConditions.elementToBeClickable(elementPath));
                    return element;

                case "visibilityOfElementLocated":
                    element = (new WebDriverWait(driver, 15)).until(ExpectedConditions.visibilityOfElementLocated(elementPath));
                    return element;
                default:

            }
        }
        catch (Exception e)
        {
            System.out.println(e.getMessage());
        }
        return element;
    }

    ////////////////////

    public Boolean waitExpectedCondition(String waitCond , String expectText)
    {
        Boolean element = null;
        try
        {
            switch(waitCond)
            {

                case "titleContains":
                    element = (new WebDriverWait(driver, 6)).until(ExpectedConditions.titleContains(expectText));
                    return element;

            }
        }
        catch (Exception e)
        {
            System.out.println(e.getMessage());
        }
        return element;
    }

    ///////////////////

    public void navigateToAnyPage(String homeUrl , By elementPath )
    {
        WebElement element;

        try {
            driver.get(homeUrl);
            element = waitExpectedCondition( elementPath, "presenceOfElementLocated");
        }
        catch(Exception e)
        {
            driver.navigate().to(homeUrl);
            driver.navigate().refresh();
            element = waitExpectedCondition( elementPath, "presenceOfElementLocated");
        }

    }

    ////////////////////

    public void clickOnElement(By elementPath , String waitCond)
    {
        WebElement element = null;

        try {

            element = waitExpectedCondition(elementPath , "elementToBeClickable");

            element.click();
            //try gowa try
            //javasrcipt

        }
        catch(Exception e)
        {
            element = waitExpectedCondition(elementPath , "elementToBeClickable");
            element.submit();
        }
    }

    ///////////////////

    public void hoverOnElement(By elementPath , String cssValue)
    {
        WebElement element = driver.findElement(elementPath);
        Actions builder = new Actions(driver);
        builder.clickAndHold().moveToElement(element).build().perform();
        String colorElement = getColor(elementPath, cssValue);
        // #013E68 //(1,62,104)
    }

    ///////////////////

    public void scrollUpDownPage()
    {
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("window.scrollBy(0,1000)");
    }

    ///////////////////

    public String getText(By path)
    {

        return driver.findElement(path).getText();
    }

    /////////////////

    public String getColor(By path , String cssValue)
    {

        return driver.findElement(path).getCssValue(cssValue);
    }

    ////////////////

    public void takeScreenShot()
    {

    }

}
