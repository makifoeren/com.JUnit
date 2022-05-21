package day11_faker_file;

public class Tanim {
    /*
    1-File :Selenium Webdriver uzerinden calitigi icin bizim bilgisayarimizdaki dosyalar ile ilgili test
    yapamaz.Ancak bazi testler calisirken bilgisayarimzda bir dosyanin var olupolmadigini control etmemiz,
    bir dosyayi okumamiz veya indirdigimiz bir dosyanin indirilip indirilmedigini control etmemiz gerekir.
                Bu durumda Java imdadimiza yetisir.
                Ancak bilgisayarimzdaki dosyalara erismek icin dosya yoluna path ihtiyaci vardir.
                Her bilgisayarin ismi ve user ismi birbirinden farkli olacagindan eger sabit bir dosya yolu
                yazarsak,bir bilgisyarda calisan test otekinde calismaz. Bunun icin dosya yolu dinamik
                olmasi tercih edilir.
                dosya yolu dinamik yapmak icin herkesin bilgisayarunda farkli olan kisim
                ve herkesin bilg ayni olan kisimlari concate etmemiz gerekir-
                farkliKisim= System.getProperty("user.home");
           ortakKisim = "\\Downloads\\dosyaAdi.dosyaUzantisi";

    2-Dosyanin bilgisayrimizda oldugunu test etmek icin
    Files.exists(Paths.get(dosyaYolu)) --->true veya false doner

    3- dosya upload: bilgisayarimizdaki klasorleri mause ile acamayacagimiz icin dosya sec butonunu locate edip
    button.sendKeys(dosyaYolu) diyerek dosyayi secip sonra file upload butonuna basiyoruz

                ,

     */

}

