package Assignments;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Assignment2 {

    public static void main(String[] args){


        System.setProperty("webdriver.chrome.driver", "C:\\Users\\zlatinap\\Desktop\\Selenium_Drivers\\chromedriver.exe");
        ChromeDriver driver = new ChromeDriver();

        driver.get("http://www.itgeared.com/demo/1506-ajax-loading.html");
        driver.findElement(By.xpath("//a[text()='Click to load get data via Ajax!']")).click();
        WebDriverWait w = new WebDriverWait(driver,5);

        System.out.println(w.until(ExpectedConditions.visibilityOfElementLocated(By.id("results"))).getText());


    }
}
