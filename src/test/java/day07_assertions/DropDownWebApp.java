package day07_assertions;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import java.time.Duration;

public class DropDownWebApp {


    WebDriver driver;

    @Before
    public void setUp() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
    }

    @After
    public void tearDown() {
        driver.close();
    }

    @Test
    public void test() throws InterruptedException {
        //1. http://zero.webappsecurity.com Adresine gidin
        driver.get("http://zero.webappsecurity.com");

        //2. Sign in butonuna basin
        driver.findElement(By.xpath("//button[@id='signin_button']")).click();
        Thread.sleep(1000);

        //3. Login kutusuna “username” yazin
        driver.findElement(By.xpath("//input[@type='text']")).sendKeys("username");
        Thread.sleep(1000);

        //4. Password kutusuna “password” yazin
        driver.findElement(By.xpath("//input[@type='password']")).sendKeys("password");
        Thread.sleep(1000);

        //5. Sign in tusuna basin
        driver.findElement(By.xpath("//input[@type='submit']")).click();
        driver.navigate().back();

        //6. Pay Bills sayfasina gidin
        driver.findElement(By.xpath("//li[@id='onlineBankingMenu']")).click();
        driver.findElement(By.xpath("//span[@id='pay_bills_link']")).click();
        Thread.sleep(1000);

        //7. “Purchase Foreign Currency” tusuna basin
        driver.findElement(By.xpath("//*[text()='Purchase Foreign Currency']")).click();
        Thread.sleep(1000);

        //8. “Currency” drop down menusunden Eurozone’u secin
        WebElement dropDownMenu = driver.findElement(By.xpath("//select[@id='pc_currency']"));
        Select select = new Select(dropDownMenu);
        select.selectByIndex(6);
        Thread.sleep(1000);

        //9. “amount” kutusuna bir sayi girin
        driver.findElement(By.xpath("//input[@id='pc_amount']")).sendKeys("350");
        Thread.sleep(1000);


        //10. “US Dollars” in secilmedigini test edin
        WebElement usDoll = driver.findElement(By.id("pc_inDollars_true"));
        Assert.assertFalse(usDoll.isSelected());
        Thread.sleep(1000);


        //11. “Selected currency” butonunu secin
        driver.findElement(By.xpath("//label[@style='padding-bottom: 8px'][2]")).click();
        Thread.sleep(1000);

        //12. “Calculate Costs” butonuna basin sonra “purchase” butonuna basin
        driver.findElement(By.id("pc_calculate_costs")).click();
        Thread.sleep(1000);

        driver.findElement(By.id("purchase_cash")).click();
        Thread.sleep(1000);

        //13. “Foreign currency cash was successfully purchased.” yazisinin ciktigini kontrol edin.
        String actualYazi = driver.findElement(By.xpath("//div[@id='alert_content']")).getText();
        String expectedYazi = "Foreign currency cash was successfully purchased..";
        Thread.sleep(1000);

        // Assert.assertEquals(expectedYazi,actualYazi);
        Assert.assertTrue(expectedYazi.contains(actualYazi));



    }


}
