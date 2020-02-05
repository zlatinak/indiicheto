import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.List;

public class Calendar {

    public static void main(String[] args) {

        System.setProperty("webdriver.chrome.driver", "C:\\Users\\zlatinap\\Desktop\\Selenium_Drivers\\chromedriver.exe");
        ChromeDriver driver = new ChromeDriver();

        driver.get("https://www.path2usa.com/travel-companions");
        driver.findElement(By.id("travel_date")).click();//open Calendar
        //select 21 of August

//        driver.findElement(By.cssSelector("[class='datepicker-days'] [class='datepicker-switch']")).getText().contains("August");
        //grabing the text and check whether contain August
        while(!driver.findElement(By.cssSelector("[class='datepicker-days'] [class='datepicker-switch']")).getText().contains("August")){
            driver.findElement(By.cssSelector("[class='datepicker-days'] [class='next']")).click();
        }
        List<WebElement> dates = driver.findElements(By.className("day"));
        //Grab common attribute //Put it in a list and iterr
        int count = driver.findElements(By.className("day")).size();
        for (int i = 0; i < count; i++) {
            String currentDate = driver.findElements(By.className("day")).get(i).getText();

            if (currentDate.equalsIgnoreCase("21")) {

                driver.findElements(By.className("day")).get(i).click();
                break;
            }


        }

    }
}
