import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

/**
 * Created by amserban on 11/21/2016.
 */
public class HomePage {

    private WebDriver driver;

    public  HomePage(WebDriver driver) {
        this.driver = driver;
        this.driver.get("http://www.shopmania.ro/");
    }

    @FindBy(id = "autocomplete_prod")
    private WebElement searchField;
    @FindBy(className = "icon-search")
    private WebElement searchButton;


    public ResultsPage searchProduct (String productTitle){

        searchField.sendKeys(productTitle);
        searchButton.click();

        ResultsPage resultsPage = PageFactory.initElements(driver, ResultsPage.class);
        return resultsPage;

    }


}
