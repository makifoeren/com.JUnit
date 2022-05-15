package day05_JUnit;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class C02_MavenTest {

    public static void main(String[] args) throws InterruptedException {

        WebDriverManager.chromedriver().setup();

        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));


        //1. http://zero.webappsecurity.com sayfasina gidin
        driver.get("http://zero.webappsecurity.com");

        //2. Signin buttonuna tiklayin
        WebElement singInButonu = driver.findElement(By.xpath("//button[@id='signin_button']"));
        singInButonu.click();

        //3. Login alanine  “username” yazdirin
        //   WebElement login= driver.findElement(By.className("icon-question-sign"));
        // login.sendKeys("username"+ Keys.ENTER);
        //WebElement login = driver.findElement(By.xpath("//input[@id='user_login']"));
        //login.sendKeys("username" + Keys.ENTER);
        driver.findElement(By.xpath("//input[@id='user_login']")).sendKeys("username");
        //4. Password alanine “password” yazdirin
        driver.findElement(By.xpath("//input[@id='user_password']")).sendKeys("password");


        //5. Sign in buttonuna tiklayin
        driver.findElement(By.xpath("//input[@name='submit']")).click();
        driver.navigate().back();

        //6.Online Banking manusunden Pay Bills sayfasina gidin
        driver.findElement(By.xpath("(//*[text()='Online Banking'])[1]")).click();

        driver.findElement(By.xpath("(//*[text()='Pay Bills'])")).click();


        //7. amount kismina yatirmak istediginiz herhangi bir miktari yazin
driver.findElement(By.xpath("//input[@id='sp_amount']")).sendKeys("750");

        //8. tarih kismina “2020-09-10” yazdirin
        driver.findElement(By.xpath("//input[@id='sp_date']")).sendKeys("2020-09-10");


        //9. Pay buttonuna tiklayinpay
driver.findElement(By.xpath("//input[@value='Pay']")).click();

        //10. “The payment was successfully submitted.” mesajinin ciktigini control edin
        WebElement mesaj=driver.findElement(By.xpath("(//*[text()='The payment was successfully submitted.'])"));




        if (mesaj.isDisplayed()){

            System.out.println("Test PASSEND");
        }else {
            System.out.println("Test FAIELD");
        }

        driver.close();
    }
}
