package day14_excel;

import org.apache.poi.ss.usermodel.*;
import org.junit.Assert;
import org.junit.Test;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

public class C03_ReadExcel {

    @Test
    public void readExceltest() throws IOException {

        //input olarak verilen
        //satirNo, sutunNo degerlerini parametre oarak alip
        // o cell deki datayi String olarak bana donduren bir method olusturun

        int satirNo = 12;
        int sutunNo = 2;

        //donen Stringin Cezayir oldugunu test edin

        String expectedData = "Baku";

        String actualData = dataGetir(satirNo - 1, sutunNo - 1); // excel index ile calistigi icin -1 dedik
        Assert.assertEquals(expectedData,actualData);
    }

    public static String dataGetir(int satirIndex, int sutunIndex) throws IOException {

        String istenenData = "";
        String dosyaYolu = "src/resources/ulkeler.xlsx";

        FileInputStream fis = new FileInputStream(dosyaYolu);

        Workbook workbook= WorkbookFactory.create(fis);
        istenenData=workbook.getSheet("Sayfa1").
                getRow(satirIndex).getCell(sutunIndex).toString(); //*****

        //Sheet sheet=workbook.getSheet("Sayfa1");
        //Row row=sheet.getRow(3);
        //Cell cell=row.getCell(3);

        return istenenData;
    }

}
