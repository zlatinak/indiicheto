import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class AutoSuggestive {



    public static void main (String[] arg) throws InterruptedException {
      /*  System.setProperty("webdriver.chrome.driver", "C:\\Users\\zlatinap\\Desktop\\Selenium_Drivers\\chromedriver.exe");

        ChromeDriver driver = new ChromeDriver();

        driver.get("https://www.makemytrip.com/");
        WebElement from = driver.findElement(By.id("fromCity"));
        from.sendKeys("MUM");
//        WebElement plHolder = driver.findElement(By.cssSelector("input[placeholder=From"));
//        plHolder.click();
        from.sendKeys(Keys.ARROW_DOWN);
//        from.sendKeys(Keys.ARROW_DOWN);
   //     from.sendKeys(Keys.ENTER);
//        driver.findElement(By.id("react-autowhatever-1-section-0-item-0")).click();
//        WebElement destination = driver.findElement(By.cssSelector("label[for=toCity]"));;
//        destination.sendKeys("test");



//        driver.findElement(By.xpath("//a[@value='BLR']")).click();
*/


        System.setProperty("webdriver.chrome.driver", "C:\\Users\\zlatinap\\Desktop\\Selenium_Drivers\\chromedriver.exe");
        WebDriver driver =new ChromeDriver();
        driver.get("https://www.makemytrip.com/"); //URL in the browser
        WebElement source=driver.findElement(By.id("hp-widget__sfrom"));
        source.clear();
        source.sendKeys("MUM");
        Thread.sleep(2000);
        source.sendKeys(Keys.ENTER);

        WebElement destination=driver.findElement(By.id("hp-widget__sTo"));
        destination.clear();
        destination.sendKeys("DEL");
        Thread.sleep(2000);
        destination.sendKeys(Keys.ARROW_DOWN);
        destination.sendKeys(Keys.ENTER);

    }
}
