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

    public static void main(String[] args) throws InterruptedException {

        System.setProperty("webdriver.chrome.driver", "C:\\Users\\zlatinap\\Desktop\\Selenium_Drivers\\chromedriver.exe");
        ChromeDriver driver = new ChromeDriver();
   //     driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        WebDriverWait w = new WebDriverWait(driver,5);
        String[] itemsNeeded = {"Cucumber", "Brocolli", "Beetroot"};//array in JAVA

        driver.get("https://rahulshettyacademy.com/seleniumPractise/#/");
        driver.manage().window().maximize();
        addItems(driver, itemsNeeded);
        driver.findElement(By.cssSelector("img[alt=\"Cart\"]")).click();
        driver.findElement(By.xpath("//button[text()='PROCEED TO CHECKOUT']")).click();
        w.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("input.promoCode")));
        driver.findElement(By.cssSelector("input.promoCode")).sendKeys("rahulshettyacademy");
        driver.findElement(By.cssSelector("button.promoBtn")).click();
        //explicit wait

        w.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("span.promoInfo")));
        System.out.println(driver.findElement(By.cssSelector("span.promoInfo")).getText());
    }

    public static void addItems(WebDriver driver, String[] itemsNeeded) {
        int j = 0;//counter how many veggi were found from the itemsNeeded
        List<WebElement> products = driver.findElements(By.cssSelector("h4.product-name"));// all products with common cssSelector are stored

        for (int i = 0; i < products.size(); i++) {

//            String name = products.get(i).getText(); // Store text of the current Element
            String[] name = products.get(i).getText().split("-");//it will be split on two elements - before and after the "-"
            name[0].trim();//will trim empty spaces
            String formattedName = name[0].trim();
            //convert array into array list for easy search
            //check whether name your extract is present in array or not
            List itemsNeededList = Arrays.asList(itemsNeeded);
            System.out.println(formattedName);

            if (itemsNeededList.contains(formattedName)) {   //check whether this text contains Cucumber
                j++;
                //click on Add to cart
                driver.findElements(By.cssSelector(".product-action")).get(i).click();
                System.out.println("click");
                if (j == itemsNeeded.length) {
                    break;
                }
            }

        }


    }

}
