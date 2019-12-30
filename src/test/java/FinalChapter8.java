import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class FinalChapter8 {


    public static void main(String[] args) {


        System.setProperty("webdriver.chrome.driver", "C:\\Users\\Zlatina\\Desktop\\Selenium_Drivers\\chromedriver.exe");
        WebDriver driver = new ChromeDriver();

        driver.get("https://www.cleartrip.com/");
        driver.manage().window().maximize();


        Select Adults = new Select(driver.findElement(By.id("Adults")));
        Adults.selectByValue("2"); // select 2 as Adults

        Select Children = new Select(driver.findElement(By.id("Childrens")));
        Children.selectByIndex(1);//select 1 as Child

        driver.findElement(By.id("DepartDate")).click();//open the calendar
        driver.findElement(By.cssSelector(".ui-state-default.ui-state-highlight.ui-state-active")).click();//select current date

        driver.findElement(By.id("MoreOptionsLink")).click();//click on the link


        driver.findElement(By.id("AirlineAutocomplete")).sendKeys("indigo");//Enter text in the textbox
        driver.findElement(By.id("SearchBtn")).click();//click on Search button
        String error = driver.findElement(By.id("homeErrorMessage")).getText();
        System.out.println(error);

    }


}
