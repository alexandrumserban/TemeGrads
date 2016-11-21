import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

/**
 * Created by amserban on 11/21/2016.
 */
public class ResultsPage {

    private WebDriver webDriver;

    public ResultsPage (WebDriver driver) {this.webDriver = driver;}

    @FindBy(xpath = "//div[@id='main_col']/div/ul[1]/li[4]/a")
    private WebElement telefoaneMobile;

    public ProductsPage searchCategory(){
        telefoaneMobile.click();

        ProductsPage productsPage = PageFactory.initElements(webDriver, ProductsPage.class);
        return productsPage;
    }
}
