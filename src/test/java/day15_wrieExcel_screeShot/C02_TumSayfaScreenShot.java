package day15_wrieExcel_screeShot;

import org.apache.commons.io.FileUtils;
import org.junit.Test;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import utilities.TestBase;

import java.io.File;
import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class C02_TumSayfaScreenShot extends TestBase {


    @Test
    public void tumSayfa() throws IOException {
        // amazon sayfasina gidip tum sayfanin fotografini cekelim


        driver.get("https://www.amazon.com");

        // 1- adim driver i TakesScreenshot cast yapacagiz
        TakesScreenshot ts = (TakesScreenshot) driver;

        //2- kayderttigimiz ekran goruntusunu projede istedigmiz yere
        // kaydedebilmek icin path ile yeni bir file olusturalim

        LocalDateTime date = LocalDateTime.now();
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("YYMMDDHHmmss");
        String tarih=date.format(dtf);


        File tumSayfaResim = new File("target/ekrangoruntuleri/tumSayfa" + tarih + ".jpg");

        //3- Ts obj kullanarak getScreenshotAs methodu  calistiralim

        File geciciDosya = ts.getScreenshotAs(OutputType.FILE);

        // 4. adim kaydettigmizi sakla

        FileUtils.copyFile(geciciDosya, tumSayfaResim);


    }
}
