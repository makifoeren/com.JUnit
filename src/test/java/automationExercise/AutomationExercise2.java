package automationExercise;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import utilities.TestBase;

public class AutomationExercise2 extends TestBase {

    @Test
    public void test1() {
        //2. Navigate to url 'http://automationexercise.com'
        driver.get("http://automationexercise.com");

        //3. Verify that home page is visible successfully
        WebElement anaSayfaDogrulama = driver.findElement(By.xpath("//html[@lang='en']"));
        Assert.assertTrue(anaSayfaDogrulama.isDisplayed());

        //4. Click on 'Signup / Login' button
        driver.findElement(By.xpath("//*[text()=' Signup / Login']")).click();


        //5. Verify 'Login to your account' is visible
        //'Hesabınıza giriş yapın' ifadesinin görünür olduğunu doğrulayın
        WebElement yourAccont = driver.findElement(By.xpath("(//h2)[1]"));
        if (yourAccont.isDisplayed()) {
            System.out.println("Test Passend");
        } else System.out.println("Test Failed");


        //6. Enter correct email address and password
        //Doğru e-posta adresini ve şifreyi girin
        driver.findElement(By.xpath("(//input[@name='email'])[1]")).sendKeys("1234asdf@gmail.com");
        driver.findElement(By.xpath("//input[@name='password']")).sendKeys("mail123");


        //7. Click 'login' button
        driver.findElement(By.xpath("(//button[@type='submit'])[1]")).click();


        //8. Verify that 'Logged in as username' is visible
        //'Kullanıcı adı olarak oturum açıldı' ifadesinin görünür olduğunu doğrulayın
        WebElement oturumAcildiMi = driver.findElement(By.xpath("//*[text()=' Logged in as ']"));
        Assert.assertTrue(oturumAcildiMi.isDisplayed());

        //9. Click 'Delete Account' button


        //10. Verify that 'ACCOUNT DELETED!' is visible

    }

}
