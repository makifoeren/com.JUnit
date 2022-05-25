package fragen;

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

public class Keyboard extends TestBase {

    //1- Bir Class olusturalim KeyboardActions1


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

        WebElement sonucYaziElementi=driver.findElement
                (By.xpath("(//div[@class='a-section a-spacing-small a-spacing-top-small'])[1]"));

        File sonucYaziElemetSS=new File("target/ekrangoruntuleri/sonucYazisiSS.jpeg");
        File temp=sonucYaziElementi.getScreenshotAs(OutputType.FILE);
        FileUtils.copyFile(temp,sonucYaziElemetSS);


    }
}
