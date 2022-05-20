package fragen;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;
import java.util.List;

import static org.openqa.selenium.By.xpath;

public class Amazon {
  /*
    1. C01_TekrarTesti isimli bir class olusturun
    2. https://www.google.com/ adresine gidin
    3. cookies uyarisini kabul ederek kapatin
    4. Sayfa basliginin “Google” ifadesi icerdigini test edin
    5. Arama cubuguna “Nutella” yazip aratin
    6. Bulunan sonuc sayisini yazdirin
    7. sonuc sayisinin 10 milyon’dan fazla oldugunu test edin
    8. Sayfayi kapatin
     */


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
        //driver.close();
    }

    @Test

    public void google() {
        // 2. https://www.google.com/ adresine gidin
        driver.get(" https://www.google.com/");

        //    3. cookies uyarisini kabul ederek kapatin
        driver.findElement(xpath("(//div[@class='QS5gu sy4vM'])[2]")).click();


        // 4. Sayfa basliginin “Google” ifadesi icerdigini test edin
        String actualTitel = driver.getTitle();
        String expecteTitel = "Google";

        if (actualTitel.contains(expecteTitel)) {
            System.out.println("Title testi PASSEND");
        } else System.out.println("Title " + expecteTitel + " yi icermiyor, title testi FAILED");

        //5. Arama cubuguna “Nutella” yazip aratin

        driver.findElement(xpath("//input[@class='gLFyf gsfi']")).sendKeys("nutella" + Keys.ENTER);

        // 6. Bulunan sonuc sayisini yazdirin

        List<WebElement> sonucsayisi = driver.findElements(xpath("//div[@id='result-stats']"));

        WebElement sonucYazsi = sonucsayisi.get(0);

        System.out.println("Cikan sonuc sayisi :" + sonucYazsi.getText());


        List<WebElement> linklerListesi = driver.findElements(By.tagName("a"));
        System.out.println("sayfadaki link sayisi : " + linklerListesi.size());

        for (WebElement each : linklerListesi
        ) {
            System.out.println(each.getText());
        }


        // 7. sonuc sayisinin 10 milyon’dan fazla oldugunu test edin

        String[] sonuc = sonucYazsi.getText().split(" ");
        String sonucSayisi = sonuc[1];

        sonucSayisi=sonucSayisi.replaceAll("\\D","");

        int istenenSayi = 10000000;

        if (Integer.parseInt(sonucSayisi)> istenenSayi) {

            System.out.println("Sonuc testi PASSEND");
        } else System.out.println("Sonuc testi FAIELD");

        //8. kapatma
        //  @After


    }


}