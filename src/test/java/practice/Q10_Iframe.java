package practice;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import utilities.TestBase;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Q10_Iframe extends TestBase {
    @Test
    public void test() throws InterruptedException {


        // https://www.jqueryscript.net/demo/Easy-iFrame-based-Twitter-Emoji-Picker-Plugin-jQuery-Emoojis/ sitesine gidin
        // web sitesini maximize yapin
        driver.get("https://www.jqueryscript.net/demo/Easy-iFrame-based-Twitter-Emoji-Picker-Plugin-jQuery-Emoojis/");
        WebElement iframe=driver.findElement(By.xpath("//iframe[@id='emoojis']"));
        driver.switchTo().frame(iframe);

        // ikinci emojiye tıklayın
        WebElement ikinciEmoji = driver.findElement(By.xpath("(//span[@data-upgraded=',MaterialRipple'])[2]"));
        ikinciEmoji.click();

        // tüm ikinci emoji öğelerini tıklayın
        List<WebElement> emojiOgeler=driver.findElements(By.xpath("/div[@id='nature']"));

       // emojiOgeler.stream().forEach(t-> t.click());

        for (WebElement each:emojiOgeler
             ) {
            each.click();
        }
        Thread.sleep(3000);

        // parent iframe e geri donun
        driver.switchTo().parentFrame();

        // formu doldurun,(Formu istediğiniz metinlerle doldurun)

        List<WebElement> textList=driver.findElements(By.xpath("//input[@class='mdl-textfield__input']"));

        List<String> text=new ArrayList<>(Arrays.asList("Bir","iframe","sorusu","bu","kadar","olabbilir",

                "olabbilir","olabbilir","olabbilir","",""));

        for (int i = 0; i < textList.size(); i++) {
            textList.get(i).sendKeys(text.get(i));
        }


        //  apply button a basin

        driver.findElement(By.xpath("//*[text()='Apply']")).click();
    }
}