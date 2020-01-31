import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;
import java.util.Iterator;
import java.util.Set;

public class multipleWindowsAssigment {


    public static void main(String[] args){

        System.setProperty("webdriver.chrome.driver", "C:\\Users\\zlatinap\\Desktop\\Selenium_Drivers\\chromedriver.exe");
        ChromeDriver driver = new ChromeDriver();

        driver.get("http://the-internet.herokuapp.com/windows");
        driver.findElement(By.xpath("//*[@id=\"content\"]/div/a")).click();//click on the link

        Set<String> ids=driver.getWindowHandles(); // getWindowHandle() will get the handle of the page the webDriver is currently controlling.

        Iterator<String> it = ids.iterator();
        String parentId= it.next();
        String childId=it.next();
        driver.switchTo().window(childId);
        System.out.println(driver.findElementByXPath("/html/body/div/h3").getText());
        driver.switchTo().window(parentId);
        System.out.println(driver.findElementByXPath("//*[@id=\"content\"]/div/h3").getText());
    }
}
