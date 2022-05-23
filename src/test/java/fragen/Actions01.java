package fragen;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import utilities.TestBase;


public class Actions01 extends TestBase {

    //Yeni Class olusturun ActionsClassHomeWork
    //1- "http://webdriveruniversity.com/Actions" sayfasina gidin
    //2- Hover over Me First" kutusunun ustune gelin
    //3- Link 1" e tiklayin
    //4- Popup mesajini yazdirin
    //5- Popup'i tamam diyerek kapatin
    //6- “Click and hold" kutusuna basili tutun
    //7-“Click and hold" kutusunda cikan yaziyi yazdirin
    //8- “Double click me" butonunu cift tiklayin


    @Test
    public void test01() throws InterruptedException {
        //1- "http://webdriveruniversity.com/Actions" sayfasina gidin
        driver.get("http://webdriveruniversity.com/Actions");

        //2- Hover over Me First" kutusunun ustune gelin
        Actions actions = new Actions(driver);
        WebElement hoverKutus = driver.findElement(By.xpath("(//button[@class='dropbtn'])[1]"));
        actions.click(hoverKutus).perform();

        //3- Link 1" e tiklayin
        Actions actionsLink1 = new Actions(driver);
        WebElement hoverKutusLink1 = driver.findElement(By.xpath("(//*[text()='Link 1'])[1]"));
        actionsLink1.click(hoverKutusLink1).perform();

        //4- Popup mesajini yazdirin
        System.out.println(driver.switchTo().alert().getText());
        Thread.sleep(2000);

        //5- Popup'i tamam diyerek kapatin
        driver.switchTo().alert().accept();
        Thread.sleep(2000);

        //6- “Click and hold" kutusuna basili tutun
        WebElement clickAndHoldButonu=driver.findElement(By.xpath("//div[@id='click-box']"));
        actions.clickAndHold(clickAndHoldButonu).perform();
        Thread.sleep(3000);

        //7-“Click and hold" kutusunda cikan yaziyi yazdirin
        System.out.println(clickAndHoldButonu.getText());
        WebElement yazi=driver.findElement(By.xpath("//div[@id='click-box']"));
        String yaziStr=yazi.getText();
        System.out.println("yaziStr = " + yaziStr);

        //8- “Double click me" butonunu cift tiklayin
        WebElement doubleClicButonu=driver.findElement(By.xpath("//h2"));
        actions.doubleClick(doubleClicButonu).perform();


    }
}
