package pages;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

/**
 * Created by sonya on 26.01.2018.
 */
public class RequestPage extends BasePage {
    @FindBy(xpath = "//section[@class='b-form-section']//div[contains(@class,'b-form-box-block')]")
    WebElement sumSection;

    @FindBy(xpath = "//span[@class=\"b-button-block-center\"]//*[contains(text(),\"Оформить\")]")
    WebElement execButton;

    @FindBy(name = "insured0_surname")
    WebElement surname1;

    @FindBy(name = "insured0_name")
    WebElement name1;

    @FindBy(name = "insured0_birthDate")
    WebElement birthday1;

    @FindBy(name = "surname")
    WebElement surname;

    @FindBy(name = "name")
    WebElement name;

    @FindBy(xpath = "//fieldset[@class='b-form-fieldset-splash b-form-margtop-fieldset']")
    WebElement gender;

    @FindBy(name = "birthDate")
    WebElement birthDate;

    @FindBy(name = "middlename")
    WebElement middlename;

    @FindBy(name = "passport_series")
    WebElement passport_series;

    @FindBy(name = "passport_number")
    WebElement passport_number;

    @FindBy(name = "issueDate")
    WebElement issueDate;

    @FindBy(name = "issuePlace")
    WebElement issuePlace;

    @FindBy (xpath = "//*[contains(text(),\"Продолжить\")]")
    WebElement continueButton;

    @FindBy (xpath = "//*[@class=\"b-form-center-pos b-form-error-message\"][1]/div")
    WebElement errorMessage;

    public RequestPage (WebDriver driver) {
        PageFactory.initElements(driver,this);
        this.driver = driver;
    }

    public void chooseSum (String sum) { // Минимальная
        sumSection.findElement(By.xpath(".//*[contains(text(),'" + sum + "')]")).click();
    }

    public void execute () {
        execButton.click();
    }


    public void fillField(String fieldName, String value) {
        switch (fieldName){
            case "фамилия застрахованного":
                fillField(surname1, value);
                break;
            case "имя застрахованного":
                fillField(name1, value);
                break;
            case "дата рождения застрахованного":
                fillField(birthday1, value);
                break;
            case "фамилия":
                fillField(surname, value);
                break;
            case "имя":
                fillField(name, value);
                break;
            case "день рождения":
                fillField(birthDate, value);
                break;
            case "отчество":
                fillField(middlename, value);
                break;
            case "серия паспорта":
                fillField(passport_series, value);
                break;
            case "номер паспорта":
                fillField(passport_number, value);
                break;
            case "дата выдачи":
                fillField(issueDate, value);
                break;
            case "место выдачи":
                fillField(issuePlace, value);
                break;
            default:
                throw new AssertionError("Поле '"+fieldName+"' не объявлено на странице");
        }
    }

    public void chooseGender (String sex){
        switch (sex){
            case "мужской":
                gender.findElement(By.xpath(".//input[@name='male']"));
                break;
            case "женский":
                gender.findElement(By.xpath(".//input[@name='female']"));
                break;
            default:
                throw new AssertionError("Поле '"+ sex + "' не объявлено на странице");
}

    }

      public void checkErrorMessage(String error){
        String actualValue = errorMessage.getText();
        Assert.assertTrue(String.format("Получено значение [%s]. Ожидалось [%s]", actualValue, error),
                actualValue.contains(error));
    }

    public void checkFields (String field){
        switch (field){
            case "фамилия застрахованного":
                Assert.assertEquals("Ivanov", surname1.getAttribute("value"));
                break;
            case "имя застрахованного":
                Assert.assertEquals("Ivan", name1.getAttribute("value"));
                break;
            case "дата рождения застрахованного":
                Assert.assertEquals("01.01.1999", birthday1.getAttribute("value"));
                break;
            case "фамилия":
                Assert.assertEquals("Петров", surname.getAttribute("value"));
                break;
            case "имя":
                Assert.assertEquals("Петр", name.getAttribute("value"));
                break;
            case "день рождения":
                Assert.assertEquals("", birthDate.getAttribute("value"));
                break;
            case "отчество":
                Assert.assertEquals("Петрович", middlename.getAttribute("value"));
                break;
            case "серия паспорта":
                Assert.assertEquals("1234", passport_series.getAttribute("value"));
                break;
            case "номер паспорта":
                Assert.assertEquals("222222", passport_number.getAttribute("value"));
                break;
            case "дата выдачи":
                Assert.assertEquals("14.03.2009", issueDate.getAttribute("value"));
                break;
            case "место выдачи":
                Assert.assertEquals("Трололо", issuePlace.getAttribute("value"));
                break;
            default:
                throw new AssertionError("Поле '"+field+"' не объявлено на странице");
}

    }

    public void clickContinue (){
        continueButton.click();
    }
}
