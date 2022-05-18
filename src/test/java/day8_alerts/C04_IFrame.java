package day8_alerts;

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

import static io.netty.util.ResourceLeakDetector.isEnabled;

public class C04_IFrame {

    /*
    Bir web sitesinde baska bir web sitesi yerlestirlmis.
    Bir sayfada ifarme varsa Selenium elementleri dogrudan gormez
    switchTo method u ile ifarme gecmenin 3 yolu vardir
    1--- indexs ile
    driver.switchto().frame(index of iframe); // index 0 dan baslar

    2-- id veya name ile calue
    driver.switchto().frame("id of the ifarme");

    3--WebElement ile
     driver.switchto().frame(WebElement of the ifarme);

     */


    WebDriver driver;

    @Before
    public void setUp() {
        WebDriverManager.chromiumdriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
    }

    @After
    public void tearDown() {
        driver.close();

    }

    @Test
    public void test01() throws InterruptedException {
        //https://the-internet.herokuapp.com/iframe adresine gidin.

        driver.get("https://the-internet.herokuapp.com/iframe");

        //“An IFrame containing….” textinin erisilebilir
        // oldugunu test edin ve  konsolda    yazdirin.
        WebElement baslikElementi = driver.findElement(By.xpath("//h3"));
        Assert.assertTrue(baslikElementi.isEnabled());
        // isDisplayed  gorunebilir
        // isEnabled()  erisilebilir
        // isSelected   secilmis
        System.out.println(baslikElementi.getText());

        //Text Box’a “Merhaba Dunya!” yazin. Bunu once yazinca
        // testbox i dogru olarak locate etmemmize ragmen driver
        // bulamadi bunun uzerine HTML kodlari inceleyince textbox in aslinda
        //bir ifream icinde oldugu gorduk
        // bu durumda once ifram i locate edip swicto ile gecmeliyiz



        WebElement iFrameElement = driver.findElement(By.id("mce_0_ifr"));
        driver.switchTo().frame(iFrameElement);

        //Text Box’a “Merhaba Dunya!” yazin.
        WebElement testKutusu = driver.findElement(By.xpath("//body[@id='tinymce']"));
        testKutusu.clear();

        testKutusu.sendKeys("Merhaba Dunya");

        //TextBox’in altinda bulunan “Elemental Selenium” linkini textinin gorunur oldugunu
        //dogrulayin ve  konsolda yazdirin.

        // linkElement i dogru locate etmemize ragmen yazdirmadi cunku yukarida iFrame gecis yapmistik
        //once oradan cikmamiz lazim

        driver.switchTo().defaultContent();
        WebElement linkElement = driver.findElement(By.linkText("Elemental Selenium"));

        Assert.assertTrue(linkElement.isDisplayed());
        System.out.println(linkElement);

        Thread.sleep(5000);

    }
}
