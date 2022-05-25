package fragen;


import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import utilities.TestBase;

public class a1  extends TestBase  {

    @Test
    public void test() {
        ////1. “https://www.saucedemo.com” Adresine gidin
        driver.get("https://www.saucedemo.com");

        //    //2. Username kutusuna “standard_user” yazdirin
        WebElement usernameKutusu=driver.findElement(By.id("user-name"));
        usernameKutusu.sendKeys("standard_user");

        //    //3. Password kutusuna “secret_sauce” yazdirin
        WebElement password= driver.findElement(By.id("password"));
        password.sendKeys("secret_sauce");

        //    //4. Login tusuna basin
        WebElement loginButonu= driver.findElement(By.id("login-button"));
        loginButonu.click();

        //    //5. Ilk urunun ismini kaydedin ve bu urunun sayfasina gidin
        WebElement ilkUrunIsmi= driver.findElement(By.xpath("(//div[@class='inventory_item_name'])[1]"));
        String ilkUrun=ilkUrunIsmi.getText();
        ilkUrunIsmi.click();

        //    //6. Add to Cart butonuna basin
        WebElement addToCartButonu= driver.findElement(By.id("add-to-cart-sauce-labs-backpack"));
        addToCartButonu.click();

        //    //7. Alisveris sepetine tiklayin
        WebElement alisverisSepetiButonu= driver.findElement(By.className("shopping_cart_link"));
        alisverisSepetiButonu.click();

        //    //8. Sectiginiz urunun basarili olarak sepete eklendigini control edin
        WebElement kontrolKismi= driver.findElement(By.className("inventory_item_name"));
        String sepettekiUrunIsmi=kontrolKismi.getText();
        if (sepettekiUrunIsmi.equals(ilkUrun)){
            System.out.println("Urun basarili sekilde sepete eklendi test PASS");
        }else {
            System.out.println("Urun basarili sekilde sepete eklenmedi test FAILED");
        }




    }
}
