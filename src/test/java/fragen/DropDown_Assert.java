package fragen;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class DropDown_Assert {
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
        //8-Sayfayi kapatin
       // driver.close();
    }

    @Test
    public void odev2Test1() {
        //1. Launch browser
        //2. Navigate to url 'http://automationexercise.com'
        driver.get("http://automationexercise.com");

        //3. Verify that home page is visible successfully
        //Ana sayfanın başarıyla görünür olduğunu doğrulayın


        //4. Click on 'Signup / Login' button


        //5. Verify 'New User Signup!' is visible
        //'Yeni Kullanıcı Kaydı'nı doğrulayın! görünür

        //6. Enter name and email address

        //7. Click 'Signup' button

        //8. Verify that 'ENTER ACCOUNT INFORMATION' is visible
        //HESAP BİLGİLERİNİ GİRİN' ifadesinin görünür olduğunu doğrulayın

        //9. Fill details: Title, Name, Email, Password, Date of birth


        //10. Select checkbox 'Sign up for our newsletter!'
        //'Bültenimize kaydolun!

        //11. Select checkbox 'Receive special offers from our partners!'
        //Ortaklarımızdan özel teklifler alın!' onay kutusunu seçin.


        //12. Fill details: First name, Last name, Company, Address, Address2, Country, State, City, Zipcode,
        // Mobile Number

        //13. Click 'Create Account button'


        //14. Verify that 'ACCOUNT CREATED!' is visible
        //HESAP OLUŞTURULDU!' görünür

        //15. Click 'Continue' button

        //16. Verify that 'Logged in as username' is visible

        //17. Click 'Delete Account' button


        //18. Verify that 'ACCOUNT DELETED!' is visible and click 'Continue' button --> site hata veriyor...

    }
}
