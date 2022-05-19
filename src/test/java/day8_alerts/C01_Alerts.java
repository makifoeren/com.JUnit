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


public class C01_Alerts {


WebDriver driver;


    @Before
    public void setUp(){
        WebDriverManager.chromedriver().setup();
        driver=new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
    }

    @After
    public void tearDown(){
   driver.close();
    }

    /* herhangi bir web sitesine gidince veya
          bir websitesinde herhangi bir islem yaptigimizda ortaya cikan uyarilara alert diyoruz.

          Eger bir alert inspect yapilabiliyorsa, o alert otomasyon ile kullanilanilabilir,
          bu tur alert'lere HTML alert denir ve bunlar icin ekstra bir islme yapmaya gerek yoktur
          tum webelementler gibi locate edip istedigimiz islemleri yapabiliriz
          driver.get("https://www.facebook.com"); da cikan alert vb..

          Ancak web uygulamalarinda HTML alert sag click ypip incelebnebilir,dolayisiyla web elementler gibidir.
           yaninda java script alert de bulunabilir
          js alert'ler locate edilemez webelemntlerden farklidir
          driver.swictchTo.alert methodu ile alerte gecip , omdan sonra
          accept,dismiss,sendKeys veta getText methodlari kullanilabilir
          Art arda bileolsa alert yapmak istedigimiz her seferde swichto kullanmaliyiz

          Selenium'da JS alert'ler icin ozel bir yontem gelistirmistir

          ---Click for JS Alert 1.Simple Alert : Bu basit alert ekranda bazi bilgiler veya uyarilar görüntüler.
                                        Ok denilerek kapatilir
          ---Click for JS Confirm 2.Confirmation Alert : Bu onay uyarisi bir tür islem yapma izni ister.
                                        Alert onaylaniyorsa OK, onaylanmiyorsa Cansel butonuna basilir.
                                        Iki farkli fonksiyon saglar

          ---Click for JS Prompt 3.Prompt Alert : Bu prompt Uyarisi kullanicidan bazi girdilerin girilmesini
                                        ister ve selenium webdriver metni sendkeys("input...") kullanarak girebilir.
        */

    @Test
    public void test(){
        driver.get("https://the-internet.herokuapp.com/javascript_alerts ");

        driver.findElement(By.xpath("//*[text()='Click for JS Alert']")).click();

        // alert'te OK tusuna basin switchTo degistir alert e gecip geleb method lar kullanilabilir
        driver.switchTo().alert().accept();


        // result kisminda "You successfully clicked an alert" yazdigini test edin
       String acttual= driver.findElement(By.xpath("//*[text()='You successfully clicked an alert']")).getText();

        String expected="You successfully clicked an alert";

        Assert.assertEquals(expected,acttual);




    }
}
