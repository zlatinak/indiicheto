import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;

public class SpiceJetEndtoEnd {

    public static void main (String[] args) throws InterruptedException {
        System.setProperty("webdriver.chrome.driver", "C:\\Users\\zlatinap\\Desktop\\Selenium_Drivers\\chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.get("https://www.spicejet.com/");
        driver.manage().window().maximize();

        driver.findElement(By.id("ctl00_mainContent_ddl_originStation1_CTXT")).click();//open "From" dropdown
        driver.findElement(By.xpath("//a[@value='DEL']")).click();// select Del - Delhi
        Thread.sleep(2000);
        driver.findElement(By.xpath("//div[@id='glsctl00_mainContent_ddl_destinationStation1_CTNR'] //a[@value='MAA']")).click();
        // "To" dropdown is automatically opened and Chennai is selected
        //the above is example of parent child xpath

        driver.findElement(By.cssSelector(".ui-state-default.ui-state-highlight.ui-state-active")).click(); //Depart date calendar is automatically opened and current date is selected
        //the above is example of css classname selector - if there are a empty spaces within the classname should be replaced with dots

        System.out.println(driver.findElement(By.id("Div1")).getAttribute("style"));
        driver.findElement(By.id("ctl00_mainContent_rbtnl_Trip_1")).click(); // "Round Trip"  option is selected and "Return Date" calendar is acrive now

        if(driver.findElement(By.id("Div1")).getAttribute("style").contains("1"))
        {
            System.out.println("Its enabled");
            Assert.assertTrue(true);
        }
        else{
            Assert.assertTrue(false);
        } //check that the second calendar looks like disabled

        Assert.assertFalse(driver.findElement(By.cssSelector("input[id*=friendsandfamily")).isSelected());
        //   System.out.println(driver.findElement(By.cssSelector("input[id*=SeniorCitizenDiscount")).isSelected());
        driver.findElement(By.cssSelector("input[id*=friendsandfamily")).click();
        System.out.println(driver.findElement(By.cssSelector("input[id*=friendsandfamily")).isSelected());
        Assert.assertTrue(driver.findElement(By.cssSelector("input[id*=friendsandfamily")).isSelected());


        String passengers = driver.findElement(By.id("divpaxinfo")).getText();
        Assert.assertEquals(passengers,"1 Adult");
        driver.findElement(By.id("divpaxinfo")).click();
        Select s = new Select(driver.findElement(By.id("ctl00_mainContent_ddl_Adult")));
     //   s.getOptions();
        s.selectByValue("6");
        driver.findElement(By.id("divpaxinfo")).click();

        driver.findElement(By.cssSelector("input[id*=FindFlights")).click();


    }
}
