package day13_cookies_webTables;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import utilities.TestBase;

public class C03_Webtables extends TestBase {



    @Test
    public void dinamikYazici() {
        //onceki class taki adrese gidip giris yap methodunu kullanarak sayfaya gitis yapin
        //sonra input olarak verilen satir sayisi ve sutun sayisina sahip
        //cel deki text i yazdirin

        int satir=3;
        int sutun=5;

        girisYap() ;

        // WebElement aranaCell=driver.findElement(By.xpath("//tbody//tr[3]//td[5]"));

        WebElement aranaCell=driver.findElement(By.xpath("//tbody//tr["+satir+"]//td["+sutun+"]"));


        System.out.println(aranaCell.getText());

    }

    public void girisYap() {
        driver.get("https://www.hotelmycamp.com");
        driver.findElement(By.linkText("Log in")).click();
        Actions actions = new Actions(driver);
        WebElement username = driver.findElement(By.id("UserName"));
        actions.click(username).
                sendKeys("manager").
                sendKeys(Keys.TAB).
                sendKeys("Manager1!").
                sendKeys(Keys.ENTER).
                perform();
    }
}
