import org.junit.Test;
import org.openqa.selenium.By;
import pages.MainPage;
import pages.RequestPage;
import pages.TravelInsurancePage;

public class SberbankTest extends BaseTest{
    @Test
    public void testSberbank(){
        MainPage mainPage = new MainPage(driver);
        mainPage.selectSection("Застраховать себя  и имущество");
        mainPage.waitElement(mainPage.getTravelInsuranceElement("Страхование путешественников"));
        mainPage.travelInsurance("Страхование путешественников");

        TravelInsurancePage travelInsurancePage = new TravelInsurancePage(driver);
        travelInsurancePage.waitElement(travelInsurancePage.getTitle());
        travelInsurancePage.checkTitleErrorMessage("Страхование путешественников");
        travelInsurancePage.checkOutOnline();
        travelInsurancePage.switchWindow();

        RequestPage requestPage = new RequestPage(driver);
        requestPage.chooseSum("Минимальная");
        requestPage.execute();

        requestPage.fillField("фамилия застрахованного", "Ivanov");
        requestPage.fillField("имя застрахованного", "Ivan");
        requestPage.fillField("дата рождения застрахованного", "01.01.1999");
        requestPage.fillField("фамилия", "Петров");
        requestPage.fillField("имя", "Петр");
        requestPage.fillField("отчество", "Петрович");
        requestPage.fillField("день рождения", "01.01.1989");
        requestPage.fillField("серия паспорта", "1234");
        requestPage.fillField("номер паспорта", "222222");
        requestPage.fillField("дата выдачи", "14.03.2009");
        requestPage.fillField("место выдачи", "Трололо");
        requestPage.chooseGender("мужской");

        requestPage.checkFields("фамилия застрахованного");
        requestPage.checkFields("имя застрахованного");
        requestPage.checkFields("дата рождения застрахованного");
        requestPage.checkFields("фамилия");
        requestPage.checkFields("имя");
        requestPage.checkFields("отчество");
        requestPage.checkFields("день рождения");
        requestPage.checkFields("серия паспорта");
        requestPage.checkFields("номер паспорта");
        requestPage.checkFields("дата выдачи");
        requestPage.checkFields("место выдачи");

        requestPage.clickContinue();
        requestPage.checkErrorMessage("Заполнены не все обязательные поля");
        /**
         * старая версия
         */
/*

        Assert.assertEquals("Ivanov",
                driver.findElement(By.name("insured0_surname")).getAttribute("value"));
        Assert.assertEquals("Ivan",
                driver.findElement(By.name("insured0_name")).getAttribute("value"));
        Assert.assertEquals("01.01.1999",
                driver.findElement(By.name("insured0_birthDate")).getAttribute("value"));
        Assert.assertEquals("Петров",
                driver.findElement(By.name("surname")).getAttribute("value"));
        Assert.assertEquals("Петр",
                driver.findElement(By.name("name")).getAttribute("value"));
        Assert.assertEquals("Петрович",
                driver.findElement(By.name("middlename")).getAttribute("value"));
        Assert.assertEquals("",
                driver.findElement(By.name("birthDate")).getAttribute("value"));
        Assert.assertEquals("1234",
                driver.findElement(By.name("passport_series")).getAttribute("value"));
        Assert.assertEquals("222222",
                driver.findElement(By.name("passport_number")).getAttribute("value"));
        Assert.assertEquals("14.03.2009",
                driver.findElement(By.name("issueDate")).getAttribute("value"));
        Assert.assertEquals("Трололо",
                driver.findElement(By.name("issuePlace")).getAttribute("value"));

        driver.findElement(By.xpath("//*[contains(text(),\"Продолжить\")]")).click();
        Assert.assertEquals("Заполнены не все обязательные поля",
                driver.findElement(By.xpath("//*[@class=\"b-form-center-pos b-form-error-message\"][1]/div")).getText());
*/
    }

    public void fillField(By locator, String value){
        driver.findElement(locator).clear();
        driver.findElement(locator).sendKeys(value);
    }

}
