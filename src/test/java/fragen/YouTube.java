package fragen;


import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;
public class YouTube {

    /*
    1) Bir class oluşturun: YoutubeAssertions
2) https://www.youtube.com adresine gidin
3) Aşağıdaki adları kullanarak 3 test metodu oluşturun ve gerekli testleri yapin
○ titleTest => Sayfa başlığının “YouTube” oldugunu test edin
○ imageTest => YouTube resminin görüntülendiğini (isDisplayed()) test edin
○ Search Box 'in erisilebilir oldugunu test edin (isEnabled())
○ wrongTitleTest => Sayfa basliginin “youtube” olmadigini dogrulayin
     */
    WebDriver driver;
    @Before
    public void SetUp() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
        driver.navigate().to("https://www.youtube.com");
    }
    @After
    public void tearsDown() {driver.close();}
    @Test
    public void test1() {
        //  ○ titleTest => Sayfa başlığının “YouTube” oldugunu test edin
        String baslik=driver.getTitle();
        System.out.println(baslik);
        Assert.assertEquals("YouTube",baslik);
    }
    @Test
    public void test2(){
        //  ○ imageTest => YouTube resminin görüntülendiğini (isDisplayed()) test edin
        Assert.assertTrue(driver.findElement(By.
                xpath("(//*[@id='logo-icon' and @class='style-scope ytd-logo'])[1]")).isDisplayed());
    }
    @Test
    public void test3() {
        //  ○ Search Box 'in erisilebilir oldugunu test edin (isEnabled())
        Assert.assertTrue(driver.findElement(By.
                xpath("(//input[@id='search' and @name='search_query'])")).isEnabled());
    }
    @Test
    public void test4() {
        //○ wrongTitleTest => Sayfa basliginin “youtube” olmadigini dogrulayin
        String baslik=driver.getTitle();
        System.out.println(baslik);
        Assert.assertNotEquals("Youtube",baslik);
    }
}

