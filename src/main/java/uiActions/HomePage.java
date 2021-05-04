package uiActions;
import baseMethods.BasesMethods;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import wrappers.CreatePropertiesFile;

import java.io.IOException;

public class HomePage {
    //String homeUrl = "https://www.levelset.com/";
    WebDriver driver;
    String createDocu = "//a[text()='Create a Document ']";
    //String homeTitle = "//h1[text()=\"Get paid faster.\"]";

    CreatePropertiesFile getFile = new CreatePropertiesFile();


    public HomePage(WebDriver driver)
    {
        this.driver = driver;
    }


    public void navigateToHome(String homeUrl , String homeTitle) throws IOException
    {
        new BasesMethods(driver).navigateToAnyPage(getFile.readPropertiesFile(homeUrl), By.xpath(getFile.readPropertiesFile(homeTitle)) );
    }

    public void selectCreateDoc()
    {
        new BasesMethods(driver).clickOnElement(By.xpath(createDocu), "elementToBeClickable");

        new CreateDocument(driver).validateCreateDocument();
    }


}
