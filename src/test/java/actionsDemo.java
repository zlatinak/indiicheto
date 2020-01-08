import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;



public class actionsDemo {

    public static void main (String[] args){

        System.setProperty("webdriver.chrome.driver", "C:\\Users\\zlatinap\\Desktop\\Selenium_Drivers\\chromedriver.exe");
        ChromeDriver driver = new ChromeDriver();
        driver.manage().window().maximize();

        driver.get("https://www.amazon.com/");
        WebElement move =driver.findElement(By.id("nav-link-accountList"));
        Actions a= new Actions(driver);
        a.moveToElement(driver.findElement(By.id("twotabsearchtextbox"))).click().keyDown(Keys.SHIFT).sendKeys("hello").doubleClick().build().perform();//enter text with capital letters, additionally added double click
        a.moveToElement(move).contextClick().build().perform();//without build and perform methods , the action will not be executed
        //contextClick() -> right click



    }
}
