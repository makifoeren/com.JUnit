package day06_radioButton_checkBox;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class C03_RadioButton {

//1. Bir class oluşturun : RadioButtonTest
    //2. Gerekli yapiyi olusturun ve aşağıdaki görevi tamamlayın.

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
    public void radioButontest() throws InterruptedException {

        //https://www.facebook.com adresine gidin
        driver.get("https://www.facebook.com");

        //Cookies’i kabul edin
        driver.findElement(By.xpath("//*[text()='Erforderliche und optionale Cookies erlauben']")).click();

        //“Create an Account” button’una basin
        driver.findElement(By.xpath("//*[text()='Neues Konto erstellen']")).click();


        //“radio buttons” elementlerini locate edin
        WebElement weiblichButonu = driver.findElement(By.xpath("//input[@value='1']"));
        WebElement männlichButonu = driver.findElement(By.xpath("//input[@value='2']"));
        WebElement diversButonu = driver.findElement(By.xpath("//input[@value='-1']"));


        //Secili degilse cinsiyet butonundan size uygun olani secin


        if (!männlichButonu.isSelected())
            männlichButonu.click();


        Thread.sleep(3000);
        weiblichButonu.click();
        Thread.sleep(3000);
        diversButonu.click();
        Thread.sleep(3000);
// radiobutton ozelligi biri isaretnenince digeri kalkar
    }

}
