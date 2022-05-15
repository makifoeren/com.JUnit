package team;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class CssSelector_JUnit {


    WebDriver driver;

    @Before
    public void setUp() {

        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));

    }

    @After
    public void tearDown() {
        driver.close();
    }

    @Test
    public void cssSelect() throws InterruptedException {

        //1 ) Bir class oluşturun : Locators_css xpath e benzer 3 farkli sekilde alinir
        //2 ) Main method oluşturun ve aşağıdaki görevi tamamlayın.


        //  a. Verilen web sayfasına gidin. http://a.testaddressbook.com/sign_in
        driver.get("http://a.testaddressbook.com/sign_in");

        Thread.sleep(1000);

        //  b. Locate email textbox  1.tagname attribut name value
        WebElement eMailTextBox = driver.findElement(By.cssSelector("input[name='session[email]']"));


        //  c. Locate password textbox 2. yontem id value ile calisir
        WebElement passwordTextBox = driver.findElement(By.cssSelector("input#session_password"));


        //  d. Locate signin button 3. class value ile calisan
        WebElement signInButton = driver.findElement(By.cssSelector("input[name='commit']"));


        //  e. Asagidaki kullanıcı adını ve şifreyi girin ve sign in düğmesini tıklayın
        //
        //      i. Username : testtechproed@gmail.com
        //      ii. Password : Test1234!

        eMailTextBox.sendKeys("testtechproed@gmail.com");
        Thread.sleep(1000);

        passwordTextBox.sendKeys("Test1234!");
        Thread.sleep(1000);

        signInButton.click();
        Thread.sleep(1000);



    }


}
