package fragen;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import utilities.TestBase;

import java.util.List;

public class WebtablesHomework extends TestBase {

    @Test
    public void test1(){
        // 1. “https://demoqa.com/webtables” sayfasina gidin
        driver.get("https://demoqa.com/webtables");
        //  2. Headers da bulunan department isimlerini yazdirin
        List<WebElement> departments=driver.findElements(By.xpath("//div[@class='rt-resizable-header-content']"));
        for (WebElement each: departments) {System.out.println(each.getText());}
        //   3. sutunun basligini yazdirin
        System.out.println(driver.findElement(By.xpath("//button[@id='addNewRecordButton']")).getText());
        // 4. Tablodaki tum datalari yazdirin
        System.out.println(driver.findElement(By.xpath("//div[@class='rt-table']")).getText());
        //  5. Tabloda kac cell (data) oldugunu yazdirin
        System.out.println(driver.findElements(By.xpath("//div[@class='rt-td']")).size());
        //6. Tablodaki satir sayisini yazdirin
        System.out.println(driver.findElements(By.xpath("//div[@role='rowgroup']")).size());
        //7. Tablodaki sutun sayisini yazdirin
        System.out.println(departments.size());
        //8. Tablodaki 3.kolonu yazdirin
        List<WebElement> s3=driver.findElements(By.xpath("//div[@class='rt-td'][3]"));
        for (WebElement each: s3) {System.out.println(each.getText());}
        // 9. Tabloda "First Name" i Kierra olan kisinin Salary'sini yazdirin
        List<WebElement> kierra=driver.findElements(By.xpath("(//div[@class='rt-td'])[1]"));
        for (int i = 0; i <kierra.size() ; i++) {
            if(kierra.get(i).getText().equals("Cierra"))
            {System.out.println(driver.findElement(By.xpath("(//div[@class='rt-td'][5])["+(i+1)+"]")).getText());}
        }


    }
    // 10. Page sayfasinda bir method olusturun, Test sayfasindan satir ve sutun sayisini
    // girdigimde bana datayi yazdirsin
    int row=0;
    int column=0;
    public String rowColumn(int row,int column){
        //div[@class='rt-td'][row][column]

        WebElement a=driver.findElement(By.xpath("//div[@class='rt-td']["+row+"]["+column+"]"));
        return a.getText();}
}
