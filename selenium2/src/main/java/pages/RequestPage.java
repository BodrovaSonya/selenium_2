package pages;

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
    WebElement execbButton;

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


    public RequestPage (WebDriver driver) {
        PageFactory.initElements(driver,this);
        this.driver = driver;
    }

    public void chooseSum (String sum) { // Минимальная
        sumSection.findElement(By.xpath(".//*[contains(text(),'" + sum + "')]")).click();
    }

    public void execute () {
        execbButton.click();
    }


    public void fillField(String fieldName, String value) {
        switch (fieldName){
            case "фамилия застрахованного":

        }
    }
}
