package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

/**
 * Created by sonya on 26.01.2018.
 */
public class MainPage extends BasePage{

    @FindBy(xpath = "//div[contains(@class,'bp-area header-container')]")
    WebElement menu;

    public MainPage (WebDriver driver) {
        PageFactory.initElements(driver, this);
        this.driver = driver;
    }

    public void selectSection (String name) {
        menu.findElement(By.xpath(".//a[@aria-label='Раздел " + name +"']")).click(); // Застраховать себя  и имущество
    }

    public void travelInsurance (String name) {
        menu.findElement(By.xpath(".//a[contains(text(),'" + name + "')]")).click(); // Страхование путешественников
    }

    public WebElement getTravelInsuranceElement (String name) {
        return menu.findElement(By.xpath(".//a[contains(text(),'" + name + "')]"));
    }
}
