package config;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class DriverManager {
    private WebDriver driver;

    public DriverManager(String url){
        System.setProperty("webdriver.chrome.driver", "driver/chromedriver");
        this.driver = new ChromeDriver();
        driver.get("https://www.google.com");
    }

    public WebDriver getDriver(){
        return this.driver;
    }

}
