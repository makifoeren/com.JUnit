package fragen;

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
import org.openqa.selenium.support.ui.Select;

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
    public void test1() throws InterruptedException {
        //1. Launch browser
        //2. Navigate to url 'http://automationexercise.com'
        driver.get("http://automationexercise.com");

        //3. Verify that home page is visible successfully
        //Ana sayfanın başarıyla görünür olduğunu doğrulayın
        WebElement sayfaGorunurMu = driver.findElement(By.xpath("//img[@alt='Website for automation practice']"));
        Assert.assertTrue(sayfaGorunurMu.isDisplayed());

        //4. Click on 'Signup / Login' button
        driver.findElement(By.xpath("//*[text()=' Signup / Login']")).click();


        //5. Verify 'New User Signup!' is visible
        //'Yeni Kullanıcı Kaydı'nı doğrulayın! görünür
        WebElement kullaniciKaydi = driver.findElement(By.xpath("//h2"));
        Assert.assertTrue(kullaniciKaydi.isDisplayed());

        //6. Enter name and email address
        driver.findElement(By.xpath("(//input[@placeholder='Email Address'])[2]")).sendKeys("1234asdf@gmail.com" + Keys.ENTER);
        driver.findElement(By.xpath("//input[@data-qa='signup-name']")).sendKeys("Akif" + Keys.ENTER);
        Thread.sleep(2000);
        //7. Click 'Signup' button
        driver.findElement(By.xpath("(//button[@type='submit'])[2]")).click();


        //8. Verify that 'ENTER ACCOUNT INFORMATION' is visible
        //HESAP BİLGİLERİNİ GİRİN' ifadesinin görünür olduğunu doğrulayın
        WebElement enterAccount = driver.findElement(By.xpath("//*[text()='Enter Account Information']"));
        Assert.assertTrue(enterAccount.isDisplayed());

        //9. Fill details: Title, Name, Email, Password, Date of birth
        driver.findElement(By.xpath("(//input[@type='radio'])[1]")).click();
        driver.findElement(By.xpath("//input[@id='password']")).sendKeys("mail123");

        WebElement dateButonu = driver.findElement(By.xpath("//select[@id='days']"));
        Select select = new Select(dateButonu);
        select.selectByIndex(5);

        WebElement monthsButonu = driver.findElement(By.xpath("//select[@id='months']"));
        Select select2 = new Select(monthsButonu);
        select2.selectByIndex(4);

        WebElement yearsButonu = driver.findElement(By.xpath("//select[@id='years']"));
        Select select3 = new Select(monthsButonu);
        select3.selectByIndex(4);


        //10. Select checkbox 'Sign up for our newsletter!'
        //'Bültenimize kaydolun!

        driver.findElement(By.xpath("//input[@id='newsletter']")).click();

        //11. Select checkbox 'Receive special offers from our partners!'
        //Ortaklarımızdan özel teklifler alın!' onay kutusunu seçin.
       // driver.findElement(By.xpath("(//button[@type='submit'])[2]")).click();


        //12. Fill details: First name, Last name, Company, Address, Address2, Country, State, City, Zipcode,
        // Mobile Number
        driver.findElement(By.xpath("//input[@id='first_name']")).sendKeys("Akif");
        driver.findElement(By.xpath("//input[@id='last_name']")).sendKeys("Yasar");
        driver.findElement(By.xpath("//input[@id='company']")).sendKeys("denememis");
        driver.findElement(By.xpath("//input[@id='address1']")).sendKeys("denememis adres");
        driver.findElement(By.xpath("//input[@id='address2']")).sendKeys("denememis adres");
        WebElement ulkeSecimi = driver.findElement(By.xpath("//select[@id='country']"));
        Select select4 = new Select(ulkeSecimi);
        select4.selectByIndex(4);
        driver.findElement(By.xpath("//input[@id='state']")).sendKeys("denememis");
        driver.findElement(By.xpath("//input[@id='city']")).sendKeys("aydin");
        driver.findElement(By.xpath("//input[@id='zipcode']")).sendKeys("3412453");
        driver.findElement(By.xpath("//input[@id='mobile_number']")).sendKeys("125434567890");

        //13. Click 'Create Account button'
        driver.findElement(By.xpath("//*[text()='Create Account']")).click();



        //14. Verify that 'ACCOUNT CREATED!' is visible
        //HESAP OLUŞTURULDU!' görünür
        WebElement accountDispley=driver.findElement(By.xpath("//h2"));
        Assert.assertTrue(accountDispley.isDisplayed());

        //15. Click 'Continue' button
        driver.findElement(By.xpath("//a[@data-qa='continue-button']")).click();


        //16. Verify that 'Logged in as username' is visible
        WebElement isimIleKayit=driver.findElement(By.xpath("//*[text()=' Logged in as '] "));
        Assert.assertTrue(isimIleKayit.isDisplayed());

        //17. Click 'Delete Account' button
        //driver.findElement(By.xpath("//a[@href='/delete_account']")).click();


        //18. Verify that 'ACCOUNT DELETED!' is visible and click 'Continue' button..

    }
}
