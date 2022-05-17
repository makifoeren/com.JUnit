package day07_assertions;

public class Tanim {

    /*
                 ASSERTIONS ; Selenium da tst edilen drumlari Selenium Assert Class inda hazir methodlarla yapariz
            Java dan kalan if-else ilede test yapilabilir ama Junit ve TestNG frameworkleri Assert gore dizay edilmistir
            Assertions methodlari
            assertTrue,assertFalse de sonucu bilmemiz gerekiyor onmli olan  bekledigimiz sonucun olmamais.
            Assertion basarisiz olursa ASSERTIONEXCEPTION hatasi olur.ne istioyrsak ona gore secip yazmaliyz

            ---eger bizeden istenen iki degerin esitligi test edilmedi assertEquals
            ---eger sonucun olumlu true bekleniyorsa asserttrue
            ---eger sonucun olumsuz false bekleniyorsa assertFalse

           Assert te test FAILED olunce Selenium da kalan kisim calismaz
           if-else de test istenen sonucu yazdirir testin calismasi durmaz ve testin sonunda olumsuz bile olsa
           kodlar normal calisip bittigi icin test PASSED der


            String exceptedName"Ali Can";
            String actualName"Ali Can";
            actualName.equals(exceptedName)---> false
            actualName.equalsIgnoreCase(exceptedName)-->true

            int yas1=63;
            int yas2=68;
            emekliOlabilirmi(yas1);-->false
            emekliOlabilirmi(yas2);-->true

           Assert.assertEquqls(actualName,exceptedName) --false---TEST FAILED
           Assert.assertTrue(yas2>65)--true---PASSED
           Assert.assertTrue(yas2<65)--false---FAILED
           Assert.assertFalse(yas1>65)--false---PASSED
           Assert.assertFalse(yas1<65)--true---FAILED

                DROPDOWN MENU; acilir menu
           dropdoen bir webelemnt den birden fazla option kullanabilmemizi saglar
           dropdown ile select tag i birbirinden ayrilmaz parcsidir.
           Bir HTML uyesi selec tag i kullaniyorsa cok buyuk bir ihtimalle dropdown dir.
           Dropdown da asil amac webelemnti locate etmek degil,istenen option i secebilmektir.
           Secme islemi 3 adimda yapilir
           1-Dropdown webelementini locate ederiz.
           2-Select class indan bir obje olusturup,parametre olarak dropdown webelementi yazariz.
           3-Dropdown dan option secmek icin 3 secenekten birini kullaniriz
               1-selectByIndex
               2-selectByVisibleText
               3-selectByValue

               Handle Dropdown

               1--- WebElement ddm=driver.finElement(By.id("value of id"));
               2--- Select options=new Select(ddm);
               3--- options.selecetByIndex(1);
                            selectByVisibleText
                            selectByValue





             */
}
