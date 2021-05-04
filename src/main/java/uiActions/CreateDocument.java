package uiActions;

import baseMethods.BasesMethods;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class CreateDocument {
    WebDriver driver;
    String free1 = "//div[text()=\"20-Day Preliminary Notice\"]/..//span[text()=\"Free\"]";
    // String free2 = "//div[text()=\"Notice of Intent to Lien\"]/..//span[text()=\"Free\"]";
    //String free3 = "//div[text()=\"Lien / Bond Claim\"]/..//span[text()=\"$349\"]";
    //String firstField = "//div[contains(@class,\"product-title-container card-header\")]//div[text()=\"20-Day Preliminary Notice\"]";
    //String secondField = "//div[contains(@class,\"product-title-container card-header\")]//div[text()=\"Notice of Intent to Lien\"]";
    // String thirdField = "//div[contains(@class,\"product-title-container card-header\")]//div[text()=\"Lien / Bond Claim\"]";
    //String titleFields = "//div[@class=\"document-general-type-info\"]//div[@class=\"title\"]";
    public CreateDocument(WebDriver driver)
    {
        this.driver = driver;
    }

    public void validateCreateDocument()
    {
        new BasesMethods(driver).clickOnElement(By.xpath(free1), "presenceOfElementLocated");

    }
    ///////////////////////////////////////////////////////////////////

    public String validateFieldFree(String elementPath)
    {
        return new BasesMethods(driver).getText(By.xpath(elementPath));
    }

    public void validateFieldClick(String firstField)
    {
        new BasesMethods(driver).clickOnElement(By.xpath(firstField), "elementToBeClickable");

    }

    public String validateFieldTitle(String titleFields)
    {
        return new BasesMethods(driver).getText(By.xpath(titleFields));

    }
    ////////////////////////////////////////////////////////////////////


   /* public String validate_SecondField_Free()
    {
    	return new BaseFun(driver).getText(By.xpath(free2));
    }

    public void validate_SecondField_Click()
    {
    	new BaseFun(driver).clickOnElement(By.xpath(secondField), "elementToBeClickable");

    }

    public String validate_SecondField_Title()
    {
    	validate_SecondField_Click();
    	return new BaseFun(driver).getText(By.xpath(titleFields));
    }
    ///////////////////////////////////////////////////////////////////
    public String validate_ThirdField_Free()
    {
    	return new BaseFun(driver).getText(By.xpath(free3));
    }

    public void validate_ThirdField_Click()
    {
    	new BaseFun(driver).clickOnElement(By.xpath(secondField), "elementToBeClickable");

    }

    public String validate_ThirdField_Title()
    {
    	return new BaseFun(driver).getText(By.xpath(titleFields));

    }    */
}
