import config.DriverManager;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.GoogleSearchPage;
import resources.DataProviderClass;


public class GoogleSearchTest {
    public WebDriver driver;
    public GoogleSearchPage googleSearch;


    @BeforeMethod
    public void openConnection() throws Exception {
        driver = new DriverManager("https://www.google.com").getDriver();
        googleSearch = new GoogleSearchPage(driver);
    }

    @Test(dataProvider = "dp", dataProviderClass = DataProviderClass.class)
    public void testSimple(String searchText){
        googleSearch.searchFor(searchText);
        googleSearch.validateResults(searchText);
    }

    @AfterMethod
    public void tearDown() throws Exception {
        driver.quit();
    }


}
