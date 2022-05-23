package practice;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.time.Duration;

public class Q05_Title_UrlTest {
       /*
       ...Exercise5...
      @BeforeClass ın icerisinde driver i kuralim
      maximize edip tum web elementler yuklenene kadar 10 sn bekletelim
      Google 'a gidelim ve sayfa basliginin Google icerdigini dogrulayalim
      Amazon'a gidelim ve url in www.amazon.com icerip icermedigini dogrulayalim
      @AfterClass ta driver ı kapatalim
       */

   static WebDriver driver;

    @BeforeClass
    public static void setUp() {
        WebDriverManager.chromedriver().setup();
        driver=new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        ChromeOptions options = new ChromeOptions();
        options.addArguments("disable-popup-blocking");
    }

    @AfterClass
    public static void tearDown() {
    driver.close();
    }

    @Test
    public void google() {
        // Google 'a gidelim ve sayfa basliginin Google icerdigini dogrulayalim
        driver.get("https://www.google.com");
        driver.findElement(By.xpath("//*[text()='Ich stimme zu']")).click();


       WebElement logoGorunur=driver.findElement(By.xpath("//img[@alt='Google'][1]"));
       String actuelIcerik=logoGorunur.getText();
       String expectedIcerik="Google";

       Assert.assertTrue(expectedIcerik.contains(actuelIcerik));


    }

    @Test
    public void amazon() {

        // Amazon'a gidelim ve url in www.amazon.com icerip icermedigini dogrulayalim
        driver.get("https://www.amazon.com");
        String actualUrl=driver.getCurrentUrl();
        String expectedUrl="www.amazon.com";

      // Assert.assertEquals(expectedUrl,actualUrl);
       //Expected :www.amazon.com
        //Actual   :https://www.amazon.com/
        //<Click to see difference>

       Assert.assertFalse(expectedUrl.contains(actualUrl));


    }
}
