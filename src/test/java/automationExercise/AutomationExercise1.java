package automationExercise;

import com.github.javafaker.Faker;
import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import utilities.TestBase;

public class AutomationExercise1 extends TestBase {
    @Test
    public void name() throws InterruptedException {

        //    1. Launch browser
//2. Navigate to url 'http://automationexercise.com'
        driver.get("http://automationexercise.com");

//3. Verify that home page is visible successfully
        WebElement anaSayfaDogrulama = driver.findElement(By.xpath("//html[@lang='en']"));
        Assert.assertTrue(anaSayfaDogrulama.isDisplayed());

//4. Click on 'Signup / Login' button
        driver.findElement(By.xpath("//*[text()=' Signup / Login']")).click();


//5. Verify 'New User Signup!' is visible
        WebElement userSignupDogrulama = driver.findElement(By.xpath("(//h2)[3]"));
        Assert.assertTrue(userSignupDogrulama.isDisplayed());

//6. Enter name and email addres
//7. Click 'Signup' button

        WebElement name = driver.findElement(By.xpath("//input[@type='text']"));
        Faker faker = new Faker();
        Actions actions = new Actions(driver);
        actions.click(name).sendKeys(faker.name().name()).sendKeys(Keys.PAGE_DOWN).
                sendKeys(Keys.TAB).
                sendKeys(faker.internet().emailAddress()).
                sendKeys(Keys.TAB).
                sendKeys(Keys.ENTER).
                perform();


//8. Verify that 'ENTER ACCOUNT INFORMATION' is visible
        WebElement enterAccountDogrulama = driver.findElement(By.xpath("(//h2[@class='title text-center'])[1]"));
        Assert.assertTrue(enterAccountDogrulama.isDisplayed());


//9. Fill details: Title, Name, Email, Password, Date of birth

        WebElement titel=driver.findElement(By.xpath("//input[@id='id_gender1']"));
        actions.click(titel).sendKeys(Keys.PAGE_DOWN)
                .sendKeys(Keys.TAB)
                .sendKeys(Keys.TAB)
                .sendKeys(faker.internet().password()).perform();

        WebElement dateButonu = driver.findElement(By.xpath("//select[@id='days']"));
        Select select = new Select(dateButonu);
        select.selectByIndex(5);

        WebElement monthsButonu = driver.findElement(By.xpath("//select[@id='months']"));
        Select select2 = new Select(monthsButonu);
        select2.selectByIndex(4);

        WebElement yearsButonu = driver.findElement(By.xpath("//select[@name='years']"));
        Select select3 = new Select(yearsButonu);
        select3.selectByValue("1999");


        Thread.sleep(3000);

//10. Select checkbox 'Sign up for our newsletter!'
        driver.findElement(By.xpath("//input[@id='newsletter']")).click();


//11. Select checkbox 'Receive special offers from our partners!'
        driver.findElement(By.xpath("//input[@id='optin']")).click();


//12. Fill details: First name, Last name, Company, Address, Address2, Country, State, City, Zipcode, Mobile Number
        //13. Click 'Create Account button'
        WebElement firstName= driver.findElement(By.xpath("//input[@id='first_name']"));
        actions.click(firstName).
                sendKeys(faker.name().firstName()).
                sendKeys(Keys.TAB).
                sendKeys(faker.name().lastName()).
                sendKeys(Keys.TAB).
                sendKeys("Caglayan A.S").
                sendKeys(Keys.TAB).
                sendKeys(faker.address().fullAddress()).
                sendKeys(Keys.TAB).
                sendKeys(faker.address().secondaryAddress()).
                sendKeys(Keys.TAB).
                sendKeys("c").
                sendKeys(faker.address().state()).
                sendKeys(Keys.TAB).
                sendKeys(faker.address().cityName()).
                sendKeys(Keys.TAB).
                sendKeys(faker.address().zipCode()).
                sendKeys(Keys.TAB).
                sendKeys("093768279292").
                sendKeys(Keys.TAB).
                sendKeys(Keys.ENTER).
                perform();


//14. Verify that 'ACCOUNT CREATED!' is visible

        WebElement AccountCreatedDogrulama = driver.findElement(By.xpath("(//h2[@class='title text-center'])[1]"));
        Assert.assertTrue(AccountCreatedDogrulama.isDisplayed());


//15. Click 'Continue' button
        driver.findElement(By.xpath("//a[@data-qa='continue-button']")).click();


        //16. Verify that 'Logged in as username' is visible
        WebElement isimIleKayit=driver.findElement(By.xpath("//*[text()=' Logged in as '] "));
        Assert.assertTrue(isimIleKayit.isDisplayed());

//17. Click 'Delete Account' button
        driver.findElement(By.xpath("(//a[@style='color:brown;'])[1]")).click();

//18. Verify that 'ACCOUNT DELETED!' is visible and click 'Continue' button

       WebElement accountDelete =driver.findElement(By.xpath("//div[@class='page-header']"));
        Assert.assertTrue(accountDelete.isDisplayed());



    }
}