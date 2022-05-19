package day_9;

public class Tanim {

    /*
    1-- Windoe handling: Bazen bir otomasyonda icinde

    2--Eger kontrollu olarak yeni sayfaya geciyorssak
    Driver.switchTo().newWindow(Window type) diyerek yeni bir sekme veya yeni bir pencere acrsak.
    driver otomatik olarak yeni sayfada gececektir.

    Eger test case de yeniden ilk sayfaya donme gorevi varsa,ikinci sayfaya gecmeden
    once ilk sayfanin window handle degerini alip bir String variable ye assing edebiliriz.
    Boylece istedigimiyz anda bu handle degerini kullanaraak ilk sayfaya donebiliriz

    Eger yeni sayfa acilmasi tikladigimiz bir link ile oluyorsa driver yeni sayfaya GECMEZ bu durmda ilk sayfa ve
    ikici sayfanin window handle degerlerini bulup bu handle degerini ile sayfalari arasinda gecis ypmamiz gerekir

    ---Ilk olarak ilk sayfada iken window handle degeri alip String bir variable a assing ederiz.
    --linki tikladiktan sonra iknic sayfa acilacaktir ikinci sayfanin window handle degeri alip
    bir set e koyariz
    --set icindeki iki window handle degerineden biri ilk sayfanin window handle degeridir
    ,ilk sayfanin window handle degerine esit olmayan ise ikinci sayfanin window handle degeridir.
    Bu sekilde iki sayfanin window handle degerini belirleyip,istedigimiz gibi gecis yapabiliriz.
     */

}
