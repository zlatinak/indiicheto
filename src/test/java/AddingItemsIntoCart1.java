import java.util.Arrays;

import java.util.List;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;

import org.openqa.selenium.WebDriver;

import org.openqa.selenium.WebElement;

import org.openqa.selenium.chrome.ChromeDriver;

import org.openqa.selenium.support.ui.ExpectedConditions;

import org.openqa.selenium.support.ui.WebDriverWait;


import java.util.List;

public class AddingItemsIntoCart1 {

    public static void main(String[] args) {

        System.setProperty("webdriver.chrome.driver", "C:\\Users\\Zlatina\\Desktop\\Selenium_Drivers\\chromedriver.exe");
        ChromeDriver driver = new ChromeDriver();
        String[] itemsNeeded = {"Cucumber", "Brokoli","Beetroot"};//array in JAVA

        driver.get("https://rahulshettyacademy.com/seleniumPractise/#/");

        List<WebElement> products = driver.findElements(By.cssSelector("h4.product-name"));// all products with common cssSelector are stored

        for (int i = 0; i < products.size(); i++) {

            String name = products.get(i).getText(); // Store text of the current Element

            //convert array into array list for easy search
            //check whether name your extract is present in array or not
            List itemsNeededList = Arrays.asList(itemsNeeded);
            System.out.println(name);
            if (itemsNeededList.contains(name)) {   //check whether this text contains Cucumber
                driver.findElements(By.xpath("//button[text()='ADD TO CART']")).get(i).click();

            }
        }

    }
}
