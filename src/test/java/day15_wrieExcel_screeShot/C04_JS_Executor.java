package day15_wrieExcel_screeShot;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import utilities.TestBase;


public class C04_JS_Executor extends TestBase {

    @Test
    public void JSExecutorTest() throws InterruptedException {


        //amazona gidip asagidaki Sing in butomu gorununceye kadar
        //js ile scroll yapalim ve js ile clic yapalim

        driver.get("https://www.amazon.com");

        JavascriptExecutor jse= (JavascriptExecutor) driver;

        WebElement signInButonu= driver.findElement(By.xpath("(//*[text()='Anmelden'])[3]"));
        Thread.sleep(3000);
        jse.executeScript("arguments[0].scrollIntoView(true);",signInButonu);
        // sign in butonuna js ile click yapalim
        jse.executeScript("arguments[0].click();",signInButonu);
        Thread.sleep(3000);
    }
}
