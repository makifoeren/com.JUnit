package fragen;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class Mail {


       /*
    1. Bir Class olusturalim YanlisEmailTesti
    2. http://automationpractice.com/index.php sayfasina gidelim
    3. Sign in butonuna basalim
    4. Email kutusuna @isareti olmayan bir mail yazip enter’a
       bastigimizda “Invalid email address” uyarisi ciktigini test edelim
     */

    WebDriver driver;

    @Before
    public void setUp(){

        WebDriverManager.chromedriver().setup();
        driver=new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));

    }

    @After
    public void tearDown() {
     //   driver.close();
    }

    //  2. http://automationpractice.com/index.php sayfasina gidelim
    @Test
    public void yanlisMails() throws InterruptedException {
        driver.get("http://automationpractice.com/index.php");

        //3. Sign in butonuna basalim
        WebElement singInButonu=driver.findElement(By.xpath("//a[@class='login']"));
        singInButonu.click();
Thread.sleep(2000);

        //  4. Email kutusuna @isareti olmayan bir mail yazip enter’a

        WebElement eMailKutusu=driver.findElement(By.xpath("//input[@value='Enter your e-mail']"));
        eMailKutusu.sendKeys("gelenler.gidenler"+ Keys.ENTER);

        Thread.sleep(3000);
        //5. bastigimizda “Invalid email address” uyarisi ciktigini test edelim

        WebElement expected=driver.findElement(By.xpath(" //p[@class='alert alert-danger']"));

        Assert.assertTrue(expected.isDisplayed());








    }

}
