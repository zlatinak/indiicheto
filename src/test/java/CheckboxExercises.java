import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

public class CheckboxExercises {


    public static void main(String[] args) {


        System.setProperty("webdriver.chrome.driver", "C:\\Users\\zlatinap\\Desktop\\Selenium_Drivers\\chromedriver.exe");
        ChromeDriver driver = new ChromeDriver();

        driver.get("https://rahulshettyacademy.com/AutomationPractice/");
        WebElement checkBox = driver.findElement(By.id("checkBoxOption1"));

        checkBox.click();
        Assert.assertTrue(checkBox.isSelected());
        System.out.println("Checkbox is checked");

        checkBox.click();
        Assert.assertFalse(checkBox.isSelected());
        System.out.println("Checkbox is Unchecked");
        driver.findElement(By.xpath("input[@type='checkbox']")).getSize();


    }
}
