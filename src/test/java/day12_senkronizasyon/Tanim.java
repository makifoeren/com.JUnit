package day12_senkronizasyon;

public class Tanim {

    /*
    1-- Selinium waits,(senkronizasyon) :Kodlarimizla bilgisayri calismasini uyumlu hale
    getimek icin bazen kodlarimizi bekletmemiz gerekir.
    2-- Selenium da kullandigimiz 3 cesit wait vardir
         1- Thread.sleep(): Javadan gelir ve kodlari durdurur.Kendisine verilen surenin tamamini bekler
         2- implicitlyWait: Seleniumdan gelir sayfanin yuklenmesi ve herbir web elemntin locate edilmesi
         icin beklenecek max. sureyi belirler.Esnektir esas olan beklemek degil esas olan kodun calismasini saglamaktir.
         Kod calisirsa beklemden devam eder, kod calismazsa max.sure doluncaya kadar bekler ve sonra hata msj iverir(Exception)
        3- ExplicitlyWait: Seleniumdan gelir ,spesifik bir islem icin beklenecek max sureyi belirler.
        ExplicitlyWait i kullanabilmek icin wait objsi olusturmk gerekir. Genellikle wait obje si ile birlikte kullanacagimiz
        wait.until(ExpectedConditions.---istedigimiz fonk---elementToBeClickable(enabledKutusu))
        Genellkle locate ile birlikte kullanilir
     */
}
