package day10_actions;

public class Tanim {

    /*
    1--TastBase Class: Her test classindaki tekrar tekrar yatdigmiz setup ve teardown methodlari
    tekrar yazmak kurtulmak icin Java OOp konsept i killanarak olusturdugmuz bir class dir
     -- TesBase parent olarak kabul eden class lar hazirlik icin olusturdugumuz driver,setuo, ve teardown
      olusturmak zorunda kalamzalr,kendileri olmasa bile parent class dan kullanilmis olur
      --- TestBase genelde teslerden farkli bir package de oldugundan driver kullanabilmek icin
      public ve protected yapmamiz gerekir.Biz hep child kullabacagimizicin protected yapmayi tercih ettik
      --Bu class sadece child class lardan inheritance oyellikleri ile kullanilsin istedigimizden
      bu class in obje olusturularak kullanilmasina engel olmak ici class abstract yapabilirz

    2--Actions Class:Selenium daki Actions class i mause ve klavye ile yapabildigimz eylemleri driver
    ile yapabilmemize imkan tanir
            1--Mause Base Actions:
               -- click(), contextClick(),WebElemente e sag tiklama yapar
               doubleClick(), WebElemente cift tikllar
               click()AndHold(),WebElemente uzerinde click yapili olarak komut bekler
               dragAndDrop(),WebElemente bir noktadan digerine surukler ve birakir
               moveToElement() mause u istedigimiz WebElement  in uzeruine tasir
            2--Keyboard Base Actions :
                --keyDown() klavyede tusa basma islemei
                ,keyUp(),klavyede tusu serbest birakma islmei
                sendKeys() ogeye bir anahtar gonderir

                Actions class ini kullanabilmek iv´cin actions obj olusturup parametre olarak driver ekleyip
                en sondada perform() demeyi unutmayalim
     */
}
