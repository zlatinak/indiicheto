package Windows;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;

import javax.sound.midi.Sequencer;
import java.util.Iterator;
import java.util.Set;

public class exerciseMultipleWindow {

    public static void main(String[] args) {

        System.setProperty("webdriver.chrome.driver", "C:\\Users\\zlatinap\\Desktop\\Selenium_Drivers\\chromedriver.exe");
        ChromeDriver driver = new ChromeDriver();

        driver.get("https://accounts.google.com/signup");

        driver.findElement(By.xpath("//*[@id=\"initialView\"]/footer/ul/li[3]/a")).click();
        System.out.println("Before switching");
        System.out.println(driver.getTitle());
        Set<String> ids = driver.getWindowHandles();// get ids of all of the opened windows
        Iterator<String> it = ids.iterator();
        String parentId = it.next();
        String childId = it.next();
        driver.switchTo().window(childId);//switch to child window
        System.out.println("After switching");
        System.out.println(driver.getTitle());

        driver.switchTo().window(parentId);
        System.out.println(driver.getTitle());
    }
}
