package fragen;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import utilities.TestBase;

public class Iframe extends TestBase {


    @Test
    public void test() throws InterruptedException {
        //1. “http://webdriveruniversity.com/IFrame/index.html” sayfasina gidin
        driver.get("http://webdriveruniversity.com/IFrame/index.html");

        //2. “Our Products” butonuna basin
        driver.switchTo().frame(driver.findElement(By.xpath("//iframe[@src='../Page-Object-Model/index.html']")));
        driver.findElement(By.xpath("//*[text()='Our Products']")).click();
        Thread.sleep(2000);

        //3. “Cameras product”i tiklayin
        driver.findElement(By.xpath("//*[text()='Cameras']")).click();
        Thread.sleep(2000);

        //4. Popup mesajini yazdirin
        WebElement popunMsj=driver.findElement(By.xpath("//div[@class='modal-body']"));
        String popunMsjYazi=popunMsj.getText();
        System.out.println("popunMsjYazi = " + popunMsjYazi);

        //5. “close” butonuna basin
        driver.findElement(By.xpath("//*[text()='Close']")).click();


        //6. "WebdriverUniversity.com (IFrame)" linkini tiklayin

        //driver.switchTo( ).parentFrame( ); 1 ust seviyedeki frame’e cikartir
        driver.switchTo().defaultContent(); //En ustteki frame’e cikmak icin kullanilir

        driver.findElement(By.xpath("(//a[@id='nav-title'])[1]")).click();


        //7. "http://webdriveruniversity.com/index.html" adresine gittigini test edin

        String expectedUrl="http://webdriveruniversity.com/index.html";
        String actualUrl=driver.getCurrentUrl();

        Assert.assertEquals(expectedUrl,actualUrl);


    }

}
