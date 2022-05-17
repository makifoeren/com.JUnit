package day07_assertions;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class C02_BestBuy {


    static WebDriver driver;

    @BeforeClass
    public static void setUp() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
        driver.get("https://www.bestbuy.com/");

    }

    @AfterClass
    public static void tearDown() {
   driver.close();
    }

    @Test
    public void test01() {
        // 2) https://www.bestbuy.com/ Adresine gidin
        //    farkli test method’lari olusturarak asagidaki testleri yapin
        //      ○ Sayfa URL’inin https://www.bestbuy.com/‘a esit oldugunu test edin

        String expectedUrl = "https://www.bestbuy.com/";
        String acualUrl = driver.getCurrentUrl();

        Assert.assertEquals(expectedUrl, acualUrl);
    }

    @Test
    public void test02() {
        //      ○ titleTest => Sayfa başlığının “Rest” içermediğini(contains) test edin
        String istenmeyenKelme = "Rest";
        String actualTitle = driver.getTitle();

        Assert.assertFalse(actualTitle.contains("Rest"));

    }

    @Test
    public void test03() {
        //      ○ logoTest => BestBuy logosunun görüntülendigini test edin

        WebElement logoTest = driver.findElement(By.xpath("(//img[@class='logo'])[1]"));

        Assert.assertTrue(logoTest.isDisplayed());


    }

    @Test
    public void test04() {
        //      ○ FrancaisLinkTest => Fransizca Linkin görüntülendiğini test edin

        WebElement fransizLink=driver.findElement(By.xpath("//button[@lang='fr']"));
        Assert.assertTrue(fransizLink.isDisplayed());


    }


}