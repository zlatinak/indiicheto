package Windows;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import java.util.Iterator;
import java.util.Set;


    public class LimitingWebDriverScope {
        public static void main (String[] args) throws InterruptedException {
            // Give me the count on the links on the page
            System.setProperty("webdriver.chrome.driver", "C:\\Users\\zlatinap\\Desktop\\Selenium_Drivers\\chromedriver.exe");
            ChromeDriver driver = new ChromeDriver();

            driver.get("http://qaclickacademy.com/practice.php");
            // Give me the count on the links on the page
            System.out.println(driver.findElements(By.tagName("a")).size());
            //Give me the links present on the footer
            WebElement footerDriver = driver.findElement(By.id("gf-BIG")); //Limiting webdriver score by creating Webelement of footer
            System.out.println(footerDriver.findElements(By.tagName("a")).size());
            //Give me the count on the first column on the footer
            WebElement columnDriver =footerDriver.findElement(By.xpath("//table/tbody/tr/td[1]/ul"));

            System.out.println(columnDriver.findElements(By.tagName("a")).size());

            //click on each link in the column
            for(int i=1;i<columnDriver.findElements(By.tagName("a")).size();i++)
            {
                //open it in new tab
                String clickLinkTab=Keys.chord(Keys.CONTROL,Keys.ENTER);
//                columnDriver.findElements(By.tagName("a")).get(i).click();
                columnDriver.findElements(By.tagName("a")).get(i).sendKeys(clickLinkTab);
                Thread.sleep(5000);

            }//opens all the tabs
            Set<String> abc =driver.getWindowHandles();
            Iterator<String> it=abc.iterator();//storing all pages, start from 0 which will be the main page
            while(it.hasNext())//it tells whether the next index is present
            {
                driver.switchTo().window(it.next());
                System.out.println(driver.getTitle());
            }

        }

}
