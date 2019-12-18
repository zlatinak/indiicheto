import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;

public class Assigment {

    ///Lesson 62
    public static void main(String[] args) throws InterruptedException {

        String text = "Zlatina";

        System.setProperty("webdriver.chrome.driver", "C:\\Users\\zlatinap\\Desktop\\Selenium_Drivers\\chromedriver.exe");
        ChromeDriver driver = new ChromeDriver();

        driver.get("https://rahulshettyacademy.com/AutomationPractice/");
        driver.findElement(By.id("name")).sendKeys(text); //enter text value in name field
        driver.findElement(By.cssSelector("#alertbtn")).click();//click on Alert button
        System.out.println(driver.switchTo().alert().getText());
        driver.switchTo().alert().accept();//switching to alert window and press ok
        driver.findElement(By.cssSelector("#confirmbtn")).click();//click on Confirm button
        System.out.println(driver.switchTo().alert().getText());
        driver.switchTo().alert().dismiss();// switch to alert window and press cancel

        Thread.sleep(2000);
        driver.close();
    }
}
