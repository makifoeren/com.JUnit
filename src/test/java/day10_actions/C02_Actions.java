package day10_actions;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import utilities.TestBase;

public class C02_Actions extends TestBase {

    @Test
    public void test() throws InterruptedException {
        // amazon anasayfaya git
        // account manusundan creat a lis linkiine tiklayalim

        driver.get("https://www.amazon.com");

        Actions actions = new Actions(driver);

        WebElement accountlinki= driver.findElement(By.xpath("//*[text()='Konto und Listen']"));
        actions.moveToElement(accountlinki).perform();

        Thread.sleep(2000);
        driver.findElement(By.xpath("//*[text()='Neue Liste anlegen ']")).click();

    }
}
