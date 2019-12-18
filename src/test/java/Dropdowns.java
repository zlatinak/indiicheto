import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;

public class Dropdowns {
    public static void main(String[] args) {
        System.setProperty("webdriver.chrome.driver", "C:\\Users\\zlatinap\\Desktop\\Selenium_Drivers\\chromedriver.exe");
        WebDriver driver = new ChromeDriver();

        driver.get("https://www.spicejet.com/");
        driver.manage().window().maximize();


        Assert.assertFalse(driver.findElement(By.cssSelector("input[id*=SeniorCitizenDiscount")).isSelected());
     //   System.out.println(driver.findElement(By.cssSelector("input[id*=SeniorCitizenDiscount")).isSelected());
        driver.findElement(By.cssSelector("input[id*=SeniorCitizenDiscount")).click();
        System.out.println(driver.findElement(By.cssSelector("input[id*=SeniorCitizenDiscount")).isSelected());
        Assert.assertTrue(driver.findElement(By.cssSelector("input[id*=SeniorCitizenDiscount")).isSelected());
        //Count the number of checkboxes
//        System.out.println(driver.findElement(By.name("ctl00$mainContent$view_date2")).isEnabled());//

        System.out.println(driver.findElement(By.id("Div1")).getAttribute("style"));
        driver.findElement(By.id("ctl00_mainContent_rbtnl_Trip_1")).click(); // "Round Trip"  option is selected and "Return Date" calendar is acrive now
//        System.out.println(driver.findElement(By.name("ctl00$mainContent$view_date2")).isEnabled());//

        System.out.println(driver.findElement(By.id("Div1")).getAttribute("style"));
        if(driver.findElement(By.id("Div1")).getAttribute("style").contains("1"))
        {
            System.out.println("Its enabled");
            Assert.assertTrue(true);
        }
        else{
            Assert.assertTrue(false);
        }

        System.out.println("Hello indiiche");

/*

        System.out.println( driver.findElements(By.cssSelector("input[type=checkbox]")).size());
        Assert.assertEquals(driver.findElements(By.cssSelector("input[type=checkbox]")).size(),6);
        String passengers = driver.findElement(By.id("divpaxinfo")).getText();
        Assert.assertEquals(passengers,"1 Adult");
        Select s = new Select(driver.findElement(By.id("ctl00_mainContent_ddl_Adult")));
        s.getOptions();
    //    s.selectByValue("2");
  //      s.selectByIndex(6);
//        s.selectByVisibleText("5");
//        Assert.assertEquals(passengers,"5 Adults");
  */  }
}
