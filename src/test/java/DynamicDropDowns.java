import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class DynamicDropDowns {

    public static void main(String[] args) throws InterruptedException {

        System.setProperty("webdriver.chrome.driver", "C:\\Users\\zlatinap\\Desktop\\Selenium_Drivers\\chromedriver.exe"); //driver location
        WebDriver driver = new ChromeDriver();//initialize driver

        driver.get("https://www.spicejet.com/"); //URL in the browser
        driver.manage().window().maximize();
        driver.findElement(By.id("ctl00_mainContent_ddl_originStation1_CTXT")).click();//open "From" dropdown
        //a[@value='MAA']  - Xpath for chennai
        //a[@value='BLR']
        driver.findElement(By.xpath("//a[@value='BLR']")).click();// select BLR - Bengaluru

        Thread.sleep(2000);

   //driver.findElement(By.xpath("(//a[@value='MAA'])[2]")).click();

        driver.findElement(By.xpath("//div[@id='glsctl00_mainContent_ddl_destinationStation1_CTNR'] //a[@value='MAA']")).click(); // "To" dropdown is automatically opened and Chennai is selected
//the above is example of parent child xpath
        driver.findElement(By.cssSelector(".ui-state-default.ui-state-highlight.ui-state-active")).click(); //Depart date calendar is automatically opened and current date is selected
//the above is example of css classname selector - if there are a empty spaces within the classname should be replaced with dots
        Thread.sleep(6000);


        driver.close();



    }
}
