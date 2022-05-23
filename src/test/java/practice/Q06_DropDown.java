package practice;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import org.openqa.selenium.support.ui.Select;

import java.time.Duration;

public class Q06_DropDown {


    WebDriver driver;

    @Before
    public void setup(){
        WebDriverManager.chromedriver().setup();
        driver=new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));

        ChromeOptions options = new ChromeOptions();
        options.addArguments("disable-popup-blocking");
        //bu kod bloğu, sayfa başlangıcında cookies'leri hızlıca disable etmesi için
    }

    @After
    public void tearDown() {
       driver.close();
    }

    @Test
    public void test() {

        // 1. Amazon.com'a gidelim.
        driver.get("https://www.amazon.com");


        // 2. DropDown üzerinde Books secelim.(All yazan yerde)
        //    kategorilerin hepsini konsola yazdiralim
        WebElement dropDown=driver.findElement(By.xpath("//select[@id='searchDropdownBox']"));
        Select select = new Select(dropDown);
        select.selectByIndex(3);
        System.out.println("select.getFirstSelectedOption().getText() = " + select.getFirstSelectedOption().getText());

        //for (WebElement each:select.getOptions()
        //) {

          //  System.out.println(each.getText());
        //}


       select.getOptions().stream().forEach(t-> System.out.println(t.getText()));


        // 3. Arama kutusuna Les Miserables yazalım ve arama yapalim.
        driver.findElement(By.id("twotabsearchtextbox")).sendKeys("Les Miserables"+ Keys.ENTER);

        // 4. Sonuc sayisini ekrana yazdiralim.
        String sonucYazisi= driver.findElement(By.xpath("//div[@class='a-section a-spacing-small a-spacing-top-small']")).getText();
        System.out.println("sonucYazisi = " + sonucYazisi);

        // 5. Sonucların Les Miserables i icerdigini assert edelim
        Assert.assertTrue(sonucYazisi.contains("Les Miserables"));

    }

}
