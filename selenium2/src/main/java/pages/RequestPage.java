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

}
