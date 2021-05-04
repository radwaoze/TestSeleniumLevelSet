package levelsetTests;

import baseMethods.BrowserSetup;
import io.github.bonigarcia.wdm.WebDriverManager;
import io.qameta.allure.Description;
import io.qameta.allure.Link;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import org.apache.commons.io.FileUtils;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.ITestResult;
import org.testng.annotations.*;
import uiActions.CreateDocument;
import uiActions.HomePage;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;

public class TestLevelset {
    WebDriver driver;
    CreateDocument createDoc;
    HomePage homePage ;
    baseMethods.BrowserSetup BrowserSetup;

    @DataProvider(name = "dataReader")
    public Object[] readJsonData() throws IOException, ParseException
    {
        JSONParser jsonParser = new JSONParser();
        FileReader reader = new FileReader("G:\\ITI\\Automation\\Automtion Practices\\src\\test\\java\\levelsetTests\\TestData.json");

        Object obj = jsonParser.parse(reader);

        JSONObject dataReaderObj = (JSONObject)obj;
        JSONArray dataReaderArray = (JSONArray)dataReaderObj.get("DataReader");

        String dataArray[] = new String[dataReaderArray.size()] ;
        for(int i=0 ; i<dataReaderArray.size(); i++)
        {
            JSONObject dataTest = (JSONObject)dataReaderArray.get(i);

            String fPath = (String)dataTest.get("freePath");
            String expectFree = (String)dataTest.get("expectResult");
            String clickPath = (String)dataTest.get("fClickPath");
            String titlePath = (String)dataTest.get("titlePath");
            String expectTitle = (String)dataTest.get("titleExpected");

            dataArray[i] = fPath + " , " + expectFree + " , "  + titlePath + " , "  + clickPath + " , "  + expectTitle;
            System.out.println("Result : " + dataArray[i]);
        }


        return dataArray;

    }

    @Parameters("browser")
    @BeforeMethod
    public void setup(String browser) {
        //WebDriverManager.chromedriver().setup();

        BrowserSetup = new BrowserSetup();
        driver = BrowserSetup.BrowserName(browser);
        BrowserSetup.maximizeScreen();

        createDoc = new CreateDocument(driver);
        homePage = new HomePage(driver);

    }

    @Test(dataProvider = "dataReader")
    @Severity(SeverityLevel.NORMAL)
    @Description("Select Document Test Case")
    @Link(name = "Levelset Website Select Document Page", url = "https://app.levelset.com/wizard/SelectDocument")
    public void TestDocuments(String data) throws IOException {

        String dataTest[] = data.split(" , ");

        homePage.navigateToHome("homeUrl" , "homeTitle");
        homePage.selectCreateDoc();

        String actual = createDoc.validateFieldFree(dataTest[0]);
        Assert.assertEquals(actual, dataTest[1]);

        createDoc.validateFieldClick(dataTest[2]);


        String title1 = createDoc.validateFieldTitle(dataTest[3]);
        Assert.assertEquals(title1, dataTest[4]);
    }

  /*@Test
  public void test3() {
	     homePage.navigateToHome();
	     homePage.selectCreateDoc();

	  String actual = createDoc.validate_ThirdField_Free();
	  Assert.assertEquals(actual, "Free");

	  createDoc.validate_ThirdField_Click();


	  String title2 = createDoc.validate_ThirdField_Title();
	  Assert.assertEquals(title2, "Lien / Bond Claim");
  }*/
  /*@Test
  public void open_browzer() throws IOException {
	  homePage.navigateToHome("https://www.levelset.com/" , "//h1[text()='Get paid faster.']");
	  homePage.selectCreateDoc();
  }*/
  @AfterMethod
  public void afterMethod(ITestResult result) throws IOException {
      if(ITestResult.FAILURE == result.getStatus())
      {
          TakesScreenshot ts = (TakesScreenshot) driver;
          File source = ts.getScreenshotAs(OutputType.FILE);
          FileUtils.copyFile(source, new File("./screenshot/" + result.getName()+".png"));
      }
        BrowserSetup.closeBrowser();
    }

}
