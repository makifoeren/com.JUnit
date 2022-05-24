package practice;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import utilities.TestBase;

public class Q09_Alert extends TestBase {
    @Test
    public void test01() throws InterruptedException {

        // go to url :http://demo.automationtesting.in/Alerts.html
        driver.get("http://demo.automationtesting.in/Alerts.html");


        //    click  "Alert with OK" and click 'click the button to display an alert box:'
        driver.findElement(By.xpath("(//a[@class='analystic'])[1]")).click();
        driver.findElement(By.xpath("//button[@class='btn btn-danger']")).click();

        //    accept Alert(I am an alert box!) and print alert on console
        System.out.println("driver.switchTo().alert().getText() = " + driver.switchTo().alert().getText());
        driver.switchTo().alert().accept();


        //    click "Alert with OK & Cancel" and click 'click the button to display a confirm box'
        //    cancel Alert  (Press a Button !)
        driver.findElement(By.xpath("(//a[@class='analystic'])[2]")).click();
        driver.findElement(By.xpath("//button[@onclick='confirmbox()']")).click();
        System.out.println("driver.switchTo().alert().getText() = " + driver.switchTo().alert().getText());
        driver.switchTo().alert().dismiss();


        //    click "Alert with Textbox" and click 'click the button to demonstrate the prompt box'
        driver.findElement(By.xpath("(//a[@class='analystic'])[3]")).click();
        driver.findElement(By.xpath("//button[@class='btn btn-info']")).click();

        Thread.sleep(2000);
        //    and then sendKeys 'TechProEducation' (Please enter your name)
        driver.switchTo().alert().sendKeys("TechProEducation");
        driver.switchTo().alert().accept();


        Thread.sleep(2000);
        //    finally print on console this message "Hello TechproEducation How are you today"

        String expectedMsj = "Hello TechProEducation How are you today";
        String actualMsj = driver.findElement(By.xpath("//p[@id='demo1']")).getText();

        Assert.assertEquals(expectedMsj, actualMsj);


    }
}