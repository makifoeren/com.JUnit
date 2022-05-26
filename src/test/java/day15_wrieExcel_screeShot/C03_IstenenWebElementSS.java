package day15_wrieExcel_screeShot;

import org.apache.commons.io.FileUtils;
import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import utilities.TestBase;

import java.io.File;
import java.io.IOException;

public class C03_IstenenWebElementSS extends TestBase {



    @Test
    public void test() throws InterruptedException, IOException {

        //2- https://www.amazon.com sayfasina gidelim
        driver.get("https://www.amazon.com");


        //3- Arama kutusuna actions method’larine kullanarak
        //samsung A71 yazdirin ve Enter’a basarak arama
        //yaptirin
        WebElement aramaKutusu = driver.findElement(By.id("twotabsearchtextbox"));
        Actions actions = new Actions(driver);
        actions.click(aramaKutusu).sendKeys("samsung").
                sendKeys(Keys.SPACE).
                keyDown(Keys.SHIFT).
                sendKeys("a").
                keyUp(Keys.SHIFT).
                sendKeys("71").
                sendKeys(Keys.ENTER).
                perform();

        Thread.sleep(1000);

        //4- aramanin gerceklestigini test edin


        WebElement aramaKontrol = driver.findElement(By.xpath("(//div[@class='a-section a-spacing-small a-spacing-top-small'])[1]"));
        String expectedYazi = "samsung A71";
        String actualYazi = aramaKontrol.getText();

        Assert.assertTrue(actualYazi.contains(expectedYazi));

        //ISTENEN ELEMENTIN FOTOSUNU CEKELIM
        WebElement sonucYaziElementi = driver.findElement
                (By.xpath("(//div[@class='a-section a-spacing-small a-spacing-top-small'])[1]"));
            //kaydedecegimiz yer kalici dosyanin kayit yeri
        File sonucYaziElemetSS = new File("target/ekrangoruntuleri/sonucYazisiSS.jpeg");
        // gecici dosyamiz
        File temp = sonucYaziElementi.getScreenshotAs(OutputType.FILE);

        //gecici dosyayi ana dosyaya kopyalayacagiz
        FileUtils.copyFile(temp, sonucYaziElemetSS);


    }
}
