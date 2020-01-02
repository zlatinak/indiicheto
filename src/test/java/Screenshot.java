import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.io.File;
import java.io.IOException;


public class Screenshot {

    public static void main(String[] args) throws IOException {
        System.setProperty("webdriver.chrome.driver", "C:\\Users\\Zlatina\\Desktop\\Selenium_Drivers\\chromedriver.exe");
        ChromeDriver driver = new ChromeDriver();

        driver.get("https://www.facebook.com/");
        driver.findElement(By.xpath("id('email')")).sendKeys("test");
        driver.manage().deleteAllCookies();
        driver.manage().window().maximize();

        getScreenshot(driver);


    }

    private static void getScreenshot(WebDriver driver) throws IOException {

        driver.get("https://www.google.com/");
        File src = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
        FileUtils.copyFile(src, new File("C:\\Users\\Zlatina\\Desktop\\Automation\\test.png"));
    }
}


