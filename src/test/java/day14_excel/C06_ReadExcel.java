package day14_excel;

import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.junit.Test;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class C06_ReadExcel {

    @Test
    public void test() throws IOException {

        // excel dosyasindaki tum verileri clasimiza alip
        // bir java obj store edelim
        //boylece her seferinde excel e ulasip satir stun vs ugrasmayalim

        // database yapisi olan excel i koyabilecegimiz en uygun Java objesi Map tir

        Map<String, String> ulkelerMap = new HashMap<>();

        //7. Dosya yolunu bir String degiskene atayalim
        String dosyaYolu = "src/resources/ulkeler.xlsx";

        //8. FileInputStream objesi olusturup,parametre olarak dosya yolunu girelim
        FileInputStream fis = new FileInputStream(dosyaYolu);

        //9. Workbook objesi olusturalim,parameter olarak fileInputStream objesini girelim
        //10. WorkbookFactory.create(fileInputStream)
        Workbook workbook = WorkbookFactory.create(fis);

        int sonSatirIndex = workbook.getSheet("Sayfa1").getLastRowNum();

        for (int i = 0; i <= sonSatirIndex; i++) {

            // key i. satirdaki 0 index indeki data dir

            String key = workbook.getSheet("Sayfa1").getRow(i).getCell(0).toString();

            //value ise i. satirdaki 1,2, ve 3. satirdaki indexdeki datalari birlesimi olacak
            // 0 daki key sonrakilaer value

            String value = workbook.getSheet("Sayfa1").getRow(i).getCell(1).toString()
                    + ", "
                    + workbook.getSheet("Sayfa1").getRow(i).getCell(2).toString()
                    + ", "
                    + workbook.getSheet("Sayfa1").getRow(i).getCell(3).toString();

            ulkelerMap.put(key, value);
            System.out.println(key + " " + value);

        }


        System.out.println(ulkelerMap);
    }
}

