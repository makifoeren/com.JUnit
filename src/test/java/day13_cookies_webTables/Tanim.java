package day13_cookies_webTables;

public class Tanim {
    /*
    Selenium ile cookies otomasyonu yapabiliriz.

- listeleyebilir
Driver.manage( ). method’u ile cookie’leri

- Isim ile cagirabilir
- Yeni cookie ekleyebilir
- Var olanlari ismi silebilir
- Var olan tum cookie’leri silebiliriz

tr - row (satir)
th - horizontal (satir)
td- data (hucre

1-- Web Tables: HTML de bazi webelementleri organize bir sekilde kullanmak tercih edilebilir
2-- Genel HTML kodlari acdisindan tablo elementleri tag lerle belirlenmistir
  --<tbale>
  --<header> tablonun baslik kismini belirler
      <tr> veya <th> satirlari
      <td> satirdaki cell numarasini verir(bunu sutun diye adlandirabiliriz ama kodlarda sutun yoktur )
     -- <tbody> tablo bodys
      <tr>  satirlari
      <td> satirdaki cell numarasini verir(bunu sutun diye adlandirabiliriz ama kodlarda sutun yoktur )

3-- Web elementleri absolute xpath e benzer sekilde locate edebiliriz ancak yaptihimiz tam olarak xpath degildir.
Biz tablodaki webelementlerin tag larina odaklaniriz

4-- Mesela --tabloda body sinin 3. satirinin 5. cell ine ulasmak istersek  //tbody//tr[3]//td[5]
            --basliktaki ilk satirdaki tum datalar  //thead//tr[1]
            --tablo bady sinde 4. sutundaki tum datalar her satiri istiyor inemli degil onun icin tr atlayip //tbody//td[5]

5-- Eger verilen satir ve sutun numarasina gore dinamik yapmak istersek
        "//tbody//tr["+satir+"]//["+sutun+"]"

     */
}
