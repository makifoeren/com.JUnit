package day8_alerts;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class C03_BasicAuthentication {

    /*
    BasicAuthentication Normal olarak web sitelerinde login fonksiyonu icin kullanici adi ve sifre webelemntlerini
    girip login butonuna basariz.Ancak bazi web sitelerinde  ozellikle API haberlesmesinde kullanici
    adi ve sifreyi manuel olarak tektek girrmek yerine servis saglayicinin bize verecegi bilgiler dogrultusunda
    kullanici adi ve sifreyi URL e ekleyebiliriz.
    Boylece sayfya gitme ve login fonksiyonu birlikte halledilmis olur.

     */

    static WebDriver driver;

    @BeforeClass
    public static void setUp() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
    }

    @AfterClass
    public static void tearDown() {
        driver.quit();
    }

    @Test
    public void test01() {
        driver.get("https://admin:admin@the-internet.herokuapp.com/basic_auth");
    }
}
