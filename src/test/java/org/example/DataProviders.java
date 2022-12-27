package org.example;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.DataProvider;
import org.apache.commons.lang3.RandomStringUtils;

public class DataProviders {
    @DataProvider(name="RealPosLoginData")
    public Object[][]RealPosLoginData() {
        return new Object[][]{
               {"ivanof@yandex.ru"},{"ivanof@mail.ru"},{"ivanof@gmail.com"},{"1@yandex.ru"},{"2ivan14of@yandex.ru"},
                {"3IvaNof@gmail.com"},{" 4ivan1of@yandex.ru"},{"5ivanof2@yandex.ru "},{"6iof@y"},{"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@mail.ru"},
               {"8iva#nof@yandex.ru"},{"9iva!nof@yandex.ru"},
               // проверить вручную {""ivan5@yandex.ru""}, {"iiov\an@yandex.ru"},{"'iva8n@yandex.ru'"},  {"iv9a'n@yandex.ru"},  {"i6v"an@yandex.ru"},{"iv78a'n@yandex.ru"}, {"iv3434"an@yandex.ru"},
            {"10iv.anof@yandex.ru"},{"11iva/nof@yandex.ru"}, {"12iv?anof@yandex.ru"},
                {"13iv$anof@yandex.ru"},{"14iva%nof@yandex.ru"}, {"15iv^anof@yandex.ru"}, {"16iv&anof@yandex.ru"},
               {"17iv*anof@yandex.ru"}, {"18iv|anof@yandex.ru"},
               {"19iv#&anof@yandex.ru"},  {"20ivanof@yandex.ru  "},
              {"%&^%$$%^&*^%^&*&^*&^$$nof@yandex.ru"},{"21iv"+"anof@yandex.ru"}, {"22iv_anof@yandex.ru"}, {"23iv-anof@yandex.ru"}, {"iv{anof@yandex.ru"}, {"iv}anof@yandex.ru"}, {"iv{}anof@yandex.ru"},
               {"24iv+anof@yandex.ru"}, {"25iv=anof@yandex.ru"}, {"26iv//anof@yandex.ru"},  {"27iv/*anof@yandex.ru"},  {"%%%%@yandex.ru"},
                {"34vanof@mail"}, {"29ivanof@yandex.ru\r"}, {"31iva\nof@yandex.ru"}, {"52ivaof\r@yandex.ru"},
        };
    }
    @DataProvider(name="RealNegLoginData")
    public Object[][]RealNegLoginData() {
        return new Object[][]{
                {"28ivanof@yandex.ru\n"},{"30ivanof@yandex.ru\r\n"},  {""},{"      "},{"     @mail.ru"}, {"32ivanv@"}, {"33ivanof@ "}, {"@"}, {"@mail.ru"},
                {"35iva,nof@yandex.ru"}, {"36iv)anof@yandex.ru"},{"37iv()anof@yandex.ru"},{"38iv< !--anof@yandex.ru"},{"39iv<div>of@yandex.ru"}, {"40iv<of@yandex.ru"},{"41iv>of@yandex.ru"},
                {"SELECT *%? /*"},   {"42ivanofyandex.ru"}, {"43иванов@yandex.ru"}, {"44ivанof@yandex.ru"},
                {"45iv anof@yandex.ru"}, {"46iva(nof@yandex.ru"}, {"55iva[nof@yandex.ru"},{"56iva[nof@yandex.ru"}, {"57iva[]nof@yandex.ru"},
                {"49iv:anof@yandex.ru"}, {"50iv;anof@yandex.ru"}, {"51iv№anof@yandex.ru"},{"53iva@nov@mail.ru"},
                {"\u2764@yandex.ru"}, {"Null"}
        };
    }
    @DataProvider(name="NameData")
    public Object[][]CreateNameData() {
        return new Object[][]{
                {""},{"Ivan"},{"ivan"},{"      "},{"Null"},{"Ivan12"},{"Iv an"},{" Ivan"},{"Ivan "},{"I"},{"Ivан"},{"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"},
               {"\u2764Ivan"},{"Ivan\n"},{"Ivan\r"},{"Ivan\n\r"},{"Iv\nan"},{"45435"},{"Иван"},{"SELECT *%? /*"},{"Iv<div>an"},{"Iv!an"},{"Iv@an"},{"Iva#n"},
                {"Iv$an"},{"Iv%an"},{"Iv^an"},{"Iv&an"},{"Iv*an"},{"Iv(an"},{"Iv)an"},{"Iv()an"},{"Iv_an"},{"Iv-an"},{"Iv+an"},{"Iv=an"},
               {"Iv[an"},{"Iv]an"},{"I[v]an"},{"I{van"},{"Iv}an"},{"I{v}an"},{"Ivan"},{"Iv|an"},{"I?van"},{"Iv/an"},{"Iv,an"},{"Iv.an"},
                {"Iv;an"},{"Iv:an"},{"Iva'№n"},{"Iva"+"n"},  {"\n"},{"        "}, {"\r"}, {"\r\n"},

        };
    }
    @DataProvider(name="PosPassData")
    public Object[][]CreatePosPassData() {
        String str;
        return new Object[][]{
                {"123"}, {"pass"}, {"psss123"},  {"1"}, {"%^&*(&^%$#$%^&*()(*&$%^&*(+_+_:"}, {"пароль"},{"парword"}, {"pa<ss"},{"pa>ss"},
                {"pa!ss"},{"pa@ss"},{"pa#ss"},{"pa$ss"},{"pa%ss"},{"pa^ss"},{"pa&ss"},{"pa*ss"},{"pa(ss"},{"pa)ss"},{"pa()ss"},
                {"pa_ss"},{"pa+ss"},{"pa-ss"},{"pa+ss"},{"pa№ss"},{"pa?ss"},{"pa.ss"},{"pa|ss"},{"pas?s"},{"pa/ss"},{"pa<ss"},{"pa>ss"},
                {"pa<div>ss"},{"pa{ss"},{"pa}ss"},{"pa{}ss"},{"pa[ss"},{"pa]ss"},{"p[as]s"},{"pa'ss"},{"pa:ss"},{"pa;ss"},{"pa"+"ss"},
                {"pa#&ss"},{"SELECT *%? /*"},{"PaSs"},{" pass"},{"pa ss"},{"pass "},{"< !--"},{"%%%/%%%"},{"pass\u2764"},{"pa//ss"},{"pa/*ss"},
                {"pa\nss"},{"pa\r\nss"},{"pa\r\nss"},
        };
    }
    @DataProvider(name="NegPassData")
    public Object[][]CreateNegPassData() {
        return new Object[][]{
                {""},{"NULL"},  {"\n"},{"        "}, {"\r"}, {"\r\n"},

        };
    }
    @DataProvider(name="PassData")
    public Object[][]CreatePassData() {
        String str;
        return new Object[][]{
                {"123"}, {"pass"}, {"psss123"},  {"1"},
        };
    }
    @DataProvider(name="PosLoginData")
    public Object[][]CreatePosLoginData() {
        return new Object[][]{
                {"ivanof@yandex.ru"},{"ivanof@mail.ru"},{"ivanof@gmail.com"},{"1@yandex.ru"},{"2ivan14of@yandex.ru"},
                {"3IvaNof@gmail.com"},{" 4ivan1of@yandex.ru"},{"5ivanof2@yandex.ru "},{"6@y"},{"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@mail.ru"},
                {"8iva#nof@yandex.ru"},{"9iva!nof@yandex.ru"},{"53iva@nov@mail.ru"},
                // проверить вручную {""ivan5@yandex.ru""}, {"iiov\an@yandex.ru"},{"'iva8n@yandex.ru'"},  {"iv9a'n@yandex.ru"},  {"i6v"an@yandex.ru"},{"iv78a'n@yandex.ru"}, {"iv3434"an@yandex.ru"},
                {"10iv.anof@yandex.ru"},{"11iva/nof@yandex.ru"}, {"12iv?anof@yandex.ru"},{"SELECT *%? /*@mail.ru"}, {"55iva[nof@yandex.ru"}, {"56iva]nof@yandex.ru"}, {"57iva[]nof@yandex.ru"},
                {"13iv$anof@yandex.ru"},{"14iva%nof@yandex.ru"}, {"15iv^anof@yandex.ru"}, {"16iv&anof@yandex.ru"}, {"\u2764@yandex.ru"},
                {"17iv*anof@yandex.ru"}, {"18iv|anof@yandex.ru"},  {"49iv:anof@yandex.ru"}, {"50iv;anof@yandex.ru"}, {"51iv№anof@yandex.ru"},
                {"19iv#&anof@yandex.ru"},  {"20ivanof@yandex.ru  "},  {"45iv anof@yandex.ru"}, {"46iva(nof@yandex.ru"}, {"48iv()anof@yandex.ru"},
                {"%&^%$$%^&*^%^&*&^*&^$$nof@yandex.ru"},{"21iv"+"anof@yandex.ru"}, {"22iv_anof@yandex.ru"}, {"23iv-anof@yandex.ru"}, {"iv{anof@yandex.ru"}, {"iv}anof@yandex.ru"},
                {"24iv+anof@yandex.ru"}, {"25iv=anof@yandex.ru"}, {"26iv//anof@yandex.ru"},  {"27iv/*anof@yandex.ru"},  {"%%%%@yandex.ru"},
                {"35iva,nof@yandex.ru"}, {"36iv)anof@yandex.ru"}, {"38iv< !--anof@yandex.ru"}, {"39iv<div>of@yandex.ru"}, {"40iv<of@yandex.ru"},{"41iv>of@yandex.ru"},
                {"29ivanof@yandex.ru\r"}, {"31iva\nof@yandex.ru"}, {"52ivaof\r@yandex.ru"},  {"28ivanof@yandex.ru\n"},{"30ivanof@yandex.ru\r\n"}, {"60iva«nof@yandex.ru"},
        };
    }
    @DataProvider(name="NegLoginData")
    public Object[][]CreateNegLoginData() {
        return new Object[][]{
                 {""},{"      "},{"     @mail.ru"}, {"32ivanv@"}, {"33ivanof@   "}, {"@"}, {"@mail.ru"}, {"20ivanof@yaex.ru"},
                   {"42ivanofyandex.ru"}, {"43иванов@yandex.ru"}, {"44ivанof@yandex.ru"}, {" @ "},


                 {"Null"}, {"\n\r"},{"\r"},{"\n"}
        };
    }

    @DataProvider(name="EmptyData")
    public Object[][]EmptyData() {
        return new Object[][]{
                {"","",""},{RandomStringUtils.randomNumeric(10) + "@gmail.com","",""},{"","","pass"}, {"","the",""},
        };
    }
    @DataProvider(name="RandomEmailData")
    public Object[][]EmailData() {
        return new Object[][]{
                {RandomStringUtils.randomNumeric(15) + "@gmail.com","the","123"},
        };
    }
}
