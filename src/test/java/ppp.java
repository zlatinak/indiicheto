import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.util.concurrent.TimeUnit;

public class ppp  {
    static WebDriver driver;
    private static String userTokenId;
    static String url;
    static String urlM;

//    String components  = "2DEen_USmerchuniqueidMadridcashmoney4263399918594539351Lorem0987654321EURautoFnametest%40mymail.com1234562019-11-26.13%3A31%3A4332507Sancho+el+fuerte+15Lnamehttp%3A%2F%2Fnotify.me4.0.0Test11335"


    @BeforeClass
    public void preconditions() throws UnsupportedEncodingException {
        https://srv-bsf-devppptag.gw-4u.com/ppp/purchase.do?checksum=d00cd442da42e86d0b942421ec2b0f4c&country=DE&merchantLocale=en_US&city=Madrid&item_name_1=money&merchant_id=3641284379854225520&currency=EUR&user_token=auto&first_name=Fname&email=test%40mymail.com&merchant_site_id=36731&address1=Sancho%20el%20fuerte%2015&last_name=Lname&version=4.0.0&total_amount=15&item_quantity_1=1&item_amount_1=15&time_stamp=2019-11-26.13%3A31%3A43&user_token_id=IntJ3fe4ab6ce58a17c4
        driver = WebDriverFactory.getDriver("chrome");
        driver.manage().timeouts().implicitlyWait(6, TimeUnit.SECONDS);
        userTokenId = "user_token_id=IntJ" + Long.toHexString(Double.doubleToLongBits(Math.random()));
        urlM = "https://srv-bsf-devppptag.gw-4u.com/ppp/purchase.do?checksum=123&country=DE&merchantLocale=en_US&city=Madrid&item_name_1=money&merchant_id=3641284379854225520&currency=EUR&user_token=auto&first_name=Fname&email=test%40mymail.com&merchant_site_id=36731&address1=Sancho%20el%20fuerte%2015&last_name=Lname&version=4.0.0&total_amount=15&item_quantity_1=1&item_amount_1=15&time_stamp=2019-11-26.13%3A31%3A43&" + userTokenId;
        String decodedUrl = URLDecoder.decode(urlM, "UTF-8");
        url = decodedUrl.replaceAll("http.*.?do\\?", "").replaceAll("checksum.*?(?=&)", "");
        String chkString = url;
        String checksum = Checksum.calculateChecksum("1KRdecbEiD9HGTlM93lAq79ygRopevJD5hz0KoGjjIhERwYB9g8T3KJr5i0PRh83", chkString.replaceAll("&.*?=", ""));
        url = urlM.replaceAll("checksum.*?(?=&)", String.format("checksum=%s", checksum));
    }


    @Test(priority = 1)
    private static void newUserDeposit() throws InterruptedException {
        driver.navigate().to(url);
        driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
        driver.manage().window().maximize();

        driver.findElement(By.cssSelector("li[data-value='apmgw_PaySafeCard']")).click();     //Select CC from Other Payment Methods
        driver.findElement(By.id("continueButton")).click(); //click on Deposit button
        String cashierPage = driver.getWindowHandle();

        // Switch to Paysafecard window
        for (String winHandle : driver.getWindowHandles()) {
            driver.switchTo().window(winHandle);
        }

        WebElement accountId = driver.findElement(By.id("classicPin-addPinField"));
        accountId.click(); //
        accountId.clear(); //
        accountId.sendKeys("0000000009903207");
        driver.findElement(By.cssSelector("label[for='acceptTerms']")).click(); //accept Terms
        Thread.sleep(2000);
        driver.findElement(By.id("payBtn")).click(); // click on Pay button

        driver.findElement(By.cssSelector("a.button.button-functional.processing.deactivated"));
        //switch back to Cashier
        Thread.sleep(2000);
        driver.switchTo().window(cashierPage);


        WebDriverWait w = new WebDriverWait(driver,10);
        w.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(".success"))); //success message is displayed

//        w.until(ExpectedConditions.elementToBeClickable(By.cssSelector("button.modal_close.btn.on_confirm")));
//        w.until(ExpectedConditions.elementToBeClickable(By.cssSelector("button.modal_close.btn.on_confirm")));
        WebElement el =   w.until(ExpectedConditions.elementToBeClickable(By.cssSelector("button.modal_close.btn.on_confirm")));
        el.click();
    }

    //    @Test(dependsOnMethods = "newUserDeposit")
    public void submitWithUpo() throws InterruptedException {
        driver.navigate().to(url);
        driver.manage().window().maximize();
//        Thread.sleep(1000);
        driver.findElement(By.id("continueButton")).click(); //click on Deposit button
//        Thread.sleep(5000);
        String cashierPage = driver.getWindowHandle();

        // Switch to Paysafecard window
        for (String winHandle : driver.getWindowHandles()) {
            driver.switchTo().window(winHandle);
        } //
        WebElement accountId = driver.findElement(By.id("classicPin-addPinField"));
        accountId.click(); //
        accountId.clear(); //
        accountId.sendKeys("0000 0000 0990 3207");
        driver.findElement(By.cssSelector("label[for='acceptTerms']")).click(); //accept Terms
//        Thread.sleep(2000);
        driver.findElement(By.id("payBtn")).click(); // click on Pay button
//        Thread.sleep(8000);
        driver.switchTo().window(cashierPage);

//        driver.findElement(By.cssSelector(".success")).isDisplayed(); //success message is displayed

        driver.findElement(By.cssSelector(".modal_close.btn.on_confirm")).click();

    }

}
