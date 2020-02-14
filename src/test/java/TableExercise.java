import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class TableExercise {


    public static void main(String[] args) {
// TODO Auto-generated method stub
        int sum = 0;
        System.setProperty("webdriver.chrome.driver", "C:\\Users\\zlatinap\\Desktop\\Selenium_Drivers\\chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.get("https://www.cricbuzz.com/live-cricket-scorecard/22780/nz-vs-ind-3rd-odi-india-tour-of-new-zealand-2020");

        WebElement table = driver.findElement(By.cssSelector("div[class='cb-col cb-col-100 cb-ltst-wgt-hdr']"));
        int rowcount = table.findElements(By.cssSelector("cb-col cb-col-100 cb-scrd-itms")).size();
        int count = table.findElements(By.cssSelector("div[class='cb-col cb-col-100 cb-scrd-itms'] div:nth-child(3)")).size();

        for (int i = 0; i < count - 2; i++) {
            String value = table.findElements(By.cssSelector("div[class='cb-col cb-col-100 cb-scrd-itms'] div:nth-child(3)")).get(i).getText();
            int valueinteger = Integer.parseInt(value);
            sum = sum + valueinteger;//103
        }
//System.out.println(sum);

        String Extras = driver.findElement(By.xpath("//div[text()='Extras']/following-sibling::div")).getText();
        int extrasValue = Integer.parseInt(Extras);
        int TotalSumValue = sum + extrasValue;
        System.out.println(TotalSumValue);


        String ActualTotal = driver.findElement(By.xpath("//div[text()='Total']/following-sibling::div")).getText();
        int ActualTotalVAlue = Integer.parseInt(ActualTotal);
        if (ActualTotalVAlue == TotalSumValue) {
            System.out.println("Count Matches");
        } else {
            System.out.println("count fails");
        }
    }
}