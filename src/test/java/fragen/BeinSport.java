package fragen;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class BeinSport {

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
    public void test01() {
        // 1) Bir class oluşturun: BeinSportAssertions
        // 2) https://https://beinsports.com.tr/adresine gidin
        driver.get("https://beinsports.com");

        //Turkey ekranini secin
        driver.findElement(By.xpath("//a[@href='https://tr.beinsports.com']")).click();

        // Ekranda cikan uyariyi "daha sonra "onaylayin ve "cerezleri reddedin"

        driver.findElement(By.xpath("//*[text()='Reklam Çerezlerini Reddet']")).click();
        //   driver.findElement(By.xpath("//*[text()='Daha Sonra']")).click();

    }
    // 3) Aşağıdaki adları kullanarak 3 test metodu oluşturun ve gerekli testleri yapin
    @Test
    public void test02() throws InterruptedException {

        // titleTest => Sayfa başlığının “BeinSport” olmadigini test edin
        System.out.println("actual Titel : " + driver.getTitle());
        String actualTitle = driver.getTitle();
        String expecteTitel = "BeinSport";
        Assert.assertNotEquals("Bu kod hata oldugunda calisir", expecteTitel, actualTitle);

        Thread.sleep(3000);

    }

    @Test
    public void test03() throws InterruptedException {
        // imageTest =>BeinSport resminin görüntülendiğini (isDisplayed()) test edin
        WebElement imageTest = driver.findElement(By.xpath("//img[@style='position:absolute;top:0;left:0;" +
                "bottom:0;right:0;box-sizing:border-box;padding:0;border:none;margin:auto;display:block;" +
                "width:0;height:0;min-width:100%;" +
                "max-width:100%;min-height:100%;max-height:100%'][1]"));
        Assert.assertTrue(imageTest.isDisplayed());


        Thread.sleep(3000);

    }

    @Test
    public void test04() throws InterruptedException {

        // Search Box 'in erisilebilir oldugunu test edin (isEnabled())
        WebElement searchBoxTest = driver.findElement(By.xpath("//i[@class='icon icon-search text-white']"));
        Assert.assertTrue(searchBoxTest.isEnabled());


        Thread.sleep(3000);
    }


}
