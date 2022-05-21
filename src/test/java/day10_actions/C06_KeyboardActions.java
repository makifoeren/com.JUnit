package day10_actions;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import utilities.TestBase;

public class C06_KeyboardActions extends TestBase {
    @Test
    public void name() throws InterruptedException {

        // facebook ana sayfaya gidip
        driver.get("https://www.facebook.com/");
        driver.findElement(By.xpath("//*[text()='Erforderliche und optionale Cookies erlauben']")).click();
        // yeni kayit olustur butonuna basin
        driver.findElement(By.xpath("//a[@class='_42ft _4jy0 _6lti _4jy6 _4jy2 selected _51sy']")).click();

        // isim kutusunu locate edip,
        WebElement isimKutusu = driver.findElement(By.xpath("(//input[@class='inputtext _58mg _5dba _2ph-'])[1]"));

        // geriye kalan alanlari TAB ile dolasarak
        // formu doldurun

        Actions actions = new Actions(driver);
        actions.click(isimKutusu)
                .sendKeys("Taha")
                .sendKeys(Keys.TAB)
                .sendKeys("Ustaoglu")
                .sendKeys(Keys.TAB)
                .sendKeys("ghfdf@gmail.com")
                .sendKeys(Keys.TAB)
                .sendKeys("ghfdf@gmail.com")
                .sendKeys(Keys.TAB)
                .sendKeys("12345buKl.")
                .sendKeys(Keys.TAB)
                .sendKeys(Keys.TAB)
                .sendKeys("15")
                .sendKeys(Keys.TAB)
                .sendKeys("Jan")
                .sendKeys(Keys.TAB)
                .sendKeys("2000")
                .sendKeys(Keys.TAB)
                .sendKeys(Keys.TAB)
                .sendKeys(Keys.ARROW_DOWN)
                .sendKeys(Keys.TAB)
                .sendKeys(Keys.TAB)
                .sendKeys(Keys.TAB)
                .sendKeys(Keys.TAB)
                .sendKeys(Keys.ENTER)
                .perform();
        Thread.sleep(5000);


    }

}