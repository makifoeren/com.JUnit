package day14_excel;

import org.apache.poi.ss.usermodel.*;
import org.junit.Assert;
import org.junit.Test;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

public class C01_ReadExcel {

    @Test
    public void readExcelTest() throws IOException {

        /*
        dataya ulasmak icin 4 adim excel de yazdigi gibi
        dosya/sayfa/satir/sutun

        Woorkbook -- excel dosxasi
        Sheet -- her acik excel sekmesi icin (Sheet1, Sheet2, etc...)
        Row (satir) -- Java yanlizca iceride veri varsa satrilari sayr.
                    Default olarak Java perspektifinden satir sayisi 0 dir.
       Cell (hucre) -- Java her satira bakar ve yanlizca hucrede veri varsa sayisini sayar
         */


        //7. Dosya yolunu bir String degiskene atayalim
        String dosyaYolu="src/resources/ulkeler.xlsx";

        //8. FileInputStream objesi olusturup,parametre olarak dosya yolunu girelim
        FileInputStream fis= new FileInputStream(new File(dosyaYolu));
                    // input excel i alip okumasini yapiyor

        //9. Workbook objesi olusturalim,parameter olarak fileInputStream objesini girelim
        Workbook workbook= WorkbookFactory.create(fis);
        // Selenium da java ile olusan workbook obj kaydettik
        // calisma kitabi kopyasi olusturuldu,fis araciligi ile excel yuklendi
        // excel in fabrikasi

        //10. WorkbookFactory.create(fileInputStream)
        //11. Worksheet objesi olusturun workbook.getSheetAt(index)
        Sheet sheet=workbook.getSheet("Sayfa1");
        // fis uzerinden workbook tan var olanin bilgisini okuyacaz

        //12. Row objesi olusturun sheet.getRow(index)
        Row row=sheet.getRow(3);
        // sayfadan satira ulasmak icinyukaridaki sheet obj sindan index 0 dan basliyor

        //13. Cell objesi olusturun row.getCell(index)
        Cell cell=row.getCell(3);
        //row uzerinden 3. huceyi getirsin

        System.out.println("cell = " + cell);

        // 3. index teki satirin 3. index in deki datanin Cezayir oldugunu test edin

        String expectedData="Cezayir";
        String actualData=cell.toString();


        Assert.assertEquals(expectedData,actualData);




    }

}
