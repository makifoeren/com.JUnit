package day11_faker_file;

import org.junit.Assert;
import org.junit.Test;

import java.nio.file.Files;
import java.nio.file.Paths;

public class C03_FileExist {
    @Test
    public void name() {
        System.out.println(System.getProperty("user.dir"));
        // bana icinde oldugum projenin dosy yoliunu(path) verir
        // C:\Users\Dell\IdeaProjects\com.JUnitCalismam

        System.out.println(System.getProperty("user.home"));
        // C:\Users\Dell  yani benim bilgisayarimin bana ozel kismini verdi

        //C:\Users\Dell\IdeaProjects\com.JUnitCalismam\src\test\java proje yolu

        // Masa uzerindeki text dosyasinin varligini test edin

        //C:\Users\Dell\Desktop\text.txt

        String dosyaYolu=System.getProperty("user.home") + "\\Deskop\\text.txt";
        System.out.println(dosyaYolu);

        /*
        Bilgisayarimizdaki bir dosyanin varligini test etmek icin
        once o dosyaya ulasmamiz gerekir
        Java'da dosyaya erisim icin dosya yoluna (path) ihtiyac vardir
        Her bilgisayarin kullanici adi farkli olacagindan
        masaustu dosya yolu da birbirinden farkli olacaktir
        Testlerimizin tum bilgisayarlarda calismasi icin dosya yolunu DINAMIK yapmak zorundayiz
        Bunun icin
         her bilgisayarin birbirinden farkli olan yolunu bulmak icin

         */

        String farkliKisim= System.getProperty("user.home");
        // herkesin bilgisayarinda ortak olan kisim ise

        String ortakKisim="\\Desktop\\text.txt";
        // mac icin   "/Desktop/text"

        String masaustuDosyaYolu=farkliKisim+ortakKisim ;
        Assert.assertTrue(Files.exists(Paths.get(masaustuDosyaYolu)));

    }
}