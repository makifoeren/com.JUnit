package day8_alerts;

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

public class C02_Alerts {

    //● Bir class olusturun: Alerts
    //● https://the-internet.herokuapp.com/javascript_alerts adresine gidin.

    static WebDriver driver;

    @BeforeClass
    public static void setUp() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
        // https://the-internet.herokuapp.com/javascript_alerts adresine gidin.
        driver.get("https://the-internet.herokuapp.com/javascript_alerts");
    }

    @AfterClass
    public static void tearDown() {
        // driver.quit();
    }

    @Test
    public void acceptAlert() {
        //● Bir metod olusturun: acceptAlert
        //      ○ 1. butona tıklayın, uyarıdaki OK butonuna tıklayın ve result mesajının
        //      “You successfully clicked an alert” oldugunu test edin.

        driver.findElement(By.xpath("//button[@onclick='jsAlert()']")).click();
        driver.switchTo().alert().accept();
        WebElement actualYazi = driver.findElement(By.xpath("//p[@id='result']"));
        String actualGorunen = actualYazi.getText();
        String expected = "You successfully clicked an alert";
        Assert.assertEquals(expected, actualGorunen);

    }

    @Test
    public void dismissAlert() {
        //● Bir metod olusturun: dismissAlert
        //      ○ 2. butona tıklayın, uyarıdaki Cancel butonuna tıklayın ve result mesajının
        //      “successfuly” icermedigini test edin.
        driver.findElement(By.xpath("//*[text()='Click for JS Confirm']")).click();
        driver.switchTo().alert().dismiss();
        String actuelYazi = driver.findElement(By.xpath("//p[@style='color:green']")).getText();
        String istenmeyenYazi = "successfuly";

        Assert.assertNotEquals(istenmeyenYazi, actuelYazi);
        //Assert.assertFalse(actuelYazi.contains(istenmeyenYazi));

    }

    @Test
    public void sendKeysAlert() {
        //● Bir metod olusturun: sendKeysAlert
        //      ○ 3. butona tıklayın, uyarıdaki metin kutusuna isminizi yazin,
        //      OK butonuna tıklayın ve result mesajında isminizin görüntülendiğini doğrulayın.
        driver.findElement(By.xpath("//button[@onclick='jsPrompt()']")).click();
        driver.switchTo().alert().sendKeys("ali can");
        driver.switchTo().alert().accept();
        WebElement gozukenYazi = driver.findElement(By.xpath("//p[@id='result']"));
        String gorunenYaziStr = gozukenYazi.getText();
        String beklenenYazi = "ali can";

        Assert.assertTrue(gorunenYaziStr.contains(beklenenYazi));


    }

}
