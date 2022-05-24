package fragen;

import com.github.javafaker.Faker;
import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import utilities.TestBase;

import java.util.Set;

public class Handl extends TestBase {



    @Test
    public void test() throws InterruptedException {

        //    Window Handle HomeWork
        //1."http://webdriveruniversity.com/" adresine gidin

        driver.get("http://webdriveruniversity.com/");

        String ilkSayfaUrl=driver.getCurrentUrl();
        System.out.println("ilkSayfaUrl = " + ilkSayfaUrl);

        String ilkSayfaHandleDegeri = driver.getWindowHandle();
        System.out.println("ilkSayfaHandleDegeri = " + ilkSayfaHandleDegeri);


        //2."Login Portal" a kadar asagi inin
        //3."Login Portal" a tiklayin

        Actions actions = new Actions(driver);
        actions.sendKeys(Keys.PAGE_DOWN).perform();

        Thread.sleep(2000);

        driver.findElement(By.xpath("//*[text()='LOGIN PORTAL']")).click();


        //String sonSayfaHandleDegeri = driver.getWindowHandle();
        //System.out.println("sonSayfaHandleDegeri = " + sonSayfaHandleDegeri);

        //4.Diger window'a gecin

        Set<String> tumHandles = driver.getWindowHandles();
        System.out.println("tumHandles = " + tumHandles);

        String ikinciSayfaHand = "";
        for (String each : tumHandles
        ) {
            if (!each.equals(ilkSayfaHandleDegeri));
            ikinciSayfaHand=each;

        }

        System.out.println("ikinciSayfaHand = " + ikinciSayfaHand);

        //ikinci sayfaya gidelim
        driver.switchTo().window(ikinciSayfaHand);


        //5."username" ve "password" kutularina deger yazdirin
        //6."login" butonuna basin

        Faker faker=new Faker();
        WebElement username=driver.findElement(By.xpath("//input[@placeholder='Username']"));

        actions.click(username).
                sendKeys(faker.name().username()).
                sendKeys(Keys.TAB).
                sendKeys(faker.internet().password()).
                sendKeys(Keys.TAB).
               sendKeys(Keys.ENTER).perform();

        //7.Popup'ta cikan yazinin "validation failed" oldugunu test edin

        String expectedPopup="validation failed";
        String actualPopup=driver.switchTo().alert().getText();

        Assert.assertEquals(expectedPopup,actualPopup);


        //8.Ok diyerek Popup'i kapatin
        driver.switchTo().alert().accept();

        //9.Ilk sayfaya geri donun
        driver.switchTo().window(ilkSayfaHandleDegeri);
        Thread.sleep(2000);

        //10.Ilk sayfaya donuldugunu test edin
       String sonsayfaUrl= driver.getCurrentUrl();

       Assert.assertEquals(ilkSayfaUrl,sonsayfaUrl);



    }
}
