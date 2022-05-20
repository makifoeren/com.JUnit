package day09_handleWindows_testBase;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.*;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class C02_handleWindws {

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
        // 1-amazon ana sayfaya gideli
        driver.get("https://www.amazon.com");
        String ilkSayfaWinHandDeg = driver.getWindowHandle();

        // 2-Url amazon icerdigini test edin
        String actuelUrl = driver.getCurrentUrl();
        String expectedKelime = "amazon";
        Assert.assertTrue(actuelUrl.contains(expectedKelime));

        // 3-yeni bir pencere acip "https://www.bestbuy.com/" anasayfaya gideli
        driver.switchTo().newWindow(WindowType.WINDOW);
        driver.get("https://www.bestbuy.com");
        String ikinciSayfaWinHanddeger = driver.getWindowHandle();


        // 4-titel in Best Buy icerdigini test edelim
        String actualTitel = driver.getTitle();
        String expectedTitel = " Best Buy";
        Assert.assertTrue(actualTitel.contains(expectedTitel));

        // 5-ilk sayfaya donup sayfada Java aratalim
        driver.switchTo().window(ilkSayfaWinHandDeg);
        driver.findElement(By.xpath("//input[@id='twotabsearchtextbox']")).sendKeys("Java" + Keys.ENTER);

        Thread.sleep(1000);

        // 6-arama sonuclarinin Java icerdigini test edelim
        WebElement sonucYazisi = driver.findElement(By.xpath("(//div[@class='sg-col-inner'])[1]"));
        String sonucYazisiStr = sonucYazisi.getText();
        String arananKelime = "Java";
        Assert.assertTrue(sonucYazisiStr.contains(arananKelime));

        Thread.sleep(1000);

        // 7-yeniden bestbuy in acik oldugunu sayfaya gidelim
        driver.switchTo().window(ikinciSayfaWinHanddeger);

        Thread.sleep(1000);
        // 8-logonun gorundugunu test edin

        WebElement logoElenti = driver.findElement(By.xpath("(//img[@class='logo'])[1]"));
        Assert.assertTrue(logoElenti.isDisplayed());

        Thread.sleep(1000);
    }
}