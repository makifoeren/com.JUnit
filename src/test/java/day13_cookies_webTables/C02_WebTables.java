
package day13_cookies_webTables;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import utilities.TestBase;

import java.util.List;

public class C02_WebTables extends TestBase {

    @Test
    public void test01() {
        loginGiris();
        tableMetodu();
        printRowsMetodu();
    }
    private void printRowsMetodu() {
//○table body’sinde bulunan toplam satir(row) sayısını bulun.
        List<WebElement> BodySatiSayisi=driver.findElements(By.xpath("//tbody//tr"));
        System.out.println("satir Sayisi " + BodySatiSayisi.size());
//            ○Table body’sinde bulunan satirlari(rows) konsolda yazdırın.
        WebElement tumbadyler=driver.findElement(By.xpath("//tbody"));
        System.out.println(tumbadyler.getText());
//            ○4.satirdaki(row) elementleri konsolda yazdırın.
        WebElement dorduncuSatir=driver.findElement(By.xpath("//tbody//tr[4]"));
        String dorduncuSatirr=dorduncuSatir.getText();
        System.out.println("dorduncuSatir = " + dorduncuSatirr);
        // Email basligindaki tum elementleri(sutun) konsolda yazdırın.
        // once email basliginin kacinci sutunda oldugunu bulalim
        List<WebElement> basliklarListesi=driver.findElements(By.xpath("//thead//tr[1]/th"));
        int emailStunNo=0;
        for (int i = 0; i <basliklarListesi.size(); i++) {
            if (basliklarListesi.get(i).getText().equals("Email")){
                emailStunNo=i;
            }
        }
        System.out.println("email sutun sayusi  "+emailStunNo);
        //List<WebElement> emailStunListesi=driver.findElements(By.xpath("//tbody//tr//td[3]"));
        List<WebElement> emailStunListesi=driver.findElements(By.xpath("//tbody//td["+(emailStunNo+1)+"]"));
        for (WebElement each: emailStunListesi) {
            System.out.println(each.getText());
        }
    }
    private void tableMetodu() {
        //○Tüm table body’sinin boyutunu(s utun sayisi ) bulun. /tbody
        //○Table’daki tum body’I ve başlıkları(headers) konsolda yazdırın.
        List<WebElement> basliktakiSutunSayisi=driver.findElements(By.xpath("//thead//tr[1]//th"));
        System.out.println("basliktakiSutunSayisi sayisi= " + basliktakiSutunSayisi.size());
        WebElement tumbadyler=driver.findElement(By.xpath("//tbody"));
        System.out.println(tumbadyler.getText());
    }
    private void loginGiris() {
        //●login(login() metodun oluşturun ve oturum
        //●https://www.hotelmycamp.com admin/HotelRoomAdmin adresine gidin
        //            ○Username : manager
        //○Password : Manager 1
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
