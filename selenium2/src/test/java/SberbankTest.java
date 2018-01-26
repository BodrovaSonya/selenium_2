import org.junit.Test;
import org.openqa.selenium.By;
import pages.MainPage;
import pages.TravelInsurancePage;

import java.util.Set;

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

        String parentWindow = driver.getWindowHandle();
        Set<String> handles =  driver.getWindowHandles();
        for(String windowHandle  : handles) {
            if (!windowHandle.equals(parentWindow)) {
                driver.switchTo().window(windowHandle);
            }
        }
        /**
         * старая версия
         */
/*
        String parentWindow = driver.getWindowHandle();
        Set<String> handles =  driver.getWindowHandles();
        for(String windowHandle  : handles) {
            if (!windowHandle.equals(parentWindow)) {
                driver.switchTo().window(windowHandle);
            }
        }
       // wait.until(ExpectedConditions.elementToBeClickable(driver.findElement(By.xpath("//*[contains(text(),\"Минимальная\")]"))));

        driver.findElement(By.xpath("//*[contains(text(),\"Минимальная\")]")).click();
        driver.findElement(By.xpath("//span[@class=\"b-button-block-center\"]//*[contains(text(),\"Оформить\")]")).click();

        //застрахованный
        fillField(By.name("insured0_surname"),"Ivanov");
        fillField(By.name("insured0_name"),"Ivan");
        fillField(By.name("insured0_birthDate"),"01.01.1999");

        //страхователь
        fillField(By.name("surname"),"Петров");
        fillField(By.name("name"),"Петр");
        fillField(By.name("middlename"),"Петрович");
        fillField(By.name("birthDate"),"01.01.1989");
        driver.findElement(By.xpath("//*[@class=\"b-radio-field-entity ng-pristine ng-untouched ng-valid\"][@name=\"male\"]")).click();
        fillField(By.name("passport_series"),"1234");
        fillField(By.name("passport_number"),"222222");
        fillField(By.name("issueDate"),"14.03.2009");
        fillField(By.name("issuePlace"),"Трололо");

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
