package pages;

import java.util.List;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

public class GoogleSearchPage {
    private static WebDriver driver = null;
    private static By SEARCH_FIELD = By.cssSelector("input[name='q']");
    private static By SEARCH_FIELD_RESULT_PAGE = By.cssSelector("input[title='Search']");
    private static By RESULT_HEADERS = By.xpath("//div[@class='r']//h3");

  public GoogleSearchPage(WebDriver driver){
        this.driver=driver;
    }

    public void searchFor(String text){
        driver.findElement(SEARCH_FIELD).sendKeys(text);
        driver.findElement(SEARCH_FIELD).submit();
    }

    public void validateResults(String text){
      String searchedText = driver.findElement(SEARCH_FIELD_RESULT_PAGE).getAttribute("value");
      Assert.assertEquals(searchedText, text);

      List<WebElement> results= driver.findElements(RESULT_HEADERS);
      Assert.assertTrue(results.get(0).getText().toLowerCase().contains(text.toLowerCase()));
    }

}
