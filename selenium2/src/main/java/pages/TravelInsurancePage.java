package pages;

import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

/**
 * Created by sonya on 26.01.2018.
 */
public class TravelInsurancePage extends BasePage {

    @FindBy(xpath = "//*[@class='sbrf-rich-outer']/h1")
    WebElement title;

    @FindBy(xpath = "//img[@src=\"/portalserver/content/atom/contentRepository/content/person/travel/banner-zashita-traveler.jpg?id=f6c836e1-5c5c-4367-b0d0-bbfb96be9c53\"]")
    WebElement image;

    public TravelInsurancePage (WebDriver driver) {
        PageFactory.initElements(driver,this);
        this.driver = driver;
    }

    public WebElement getTitle(){
        return title;
    }

    public void checkTitleErrorMessage(String errorMessage){
        String actualTitle = this.title.getText();
        Assert.assertTrue(String.format("Получено значение [%s]. Ожидалось [%s]", actualTitle, errorMessage),
                actualTitle.contains(errorMessage));
    }

    public void checkOutOnline (){
        image.click();
    }
}
