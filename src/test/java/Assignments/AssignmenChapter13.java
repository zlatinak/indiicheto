package Assignments;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;

public class AssignmenChapter13 {

    public static void main (String[] args){

        System.setProperty("webdriver.chrome.driver", "C:\\Users\\zlatinap\\Desktop\\Selenium_Drivers\\chromedriver.exe");
        ChromeDriver driver = new ChromeDriver();

        driver.get("http://qaclickacademy.com/practice.php");

        String checkBoxText =driver.findElement(By.xpath("//*[@id='checkbox-example']/fieldset/label[2]")).getText();;

        Select s = new Select(driver.findElement(By.id("dropdown-class-example")));
        s.selectByVisibleText(checkBoxText);

        driver.findElement(By.id("name")).sendKeys(checkBoxText);
        driver.findElement(By.id("alertbtn")).click();

        String alertText = driver.switchTo().alert().getText();
        Assert.assertTrue(alertText.contains(checkBoxText));



    }
}
