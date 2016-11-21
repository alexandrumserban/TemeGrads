import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.PageFactory;

import java.util.concurrent.TimeUnit;

import static org.junit.Assert.assertTrue;

/**
 * Created by amserban on 11/21/2016.
 */
public class ShopmaniaTest {

    private WebDriver driver;
    private HomePage homePage;

    @Before
    public void before(){
        driver = new FirefoxDriver();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        homePage = PageFactory.initElements(driver, HomePage.class);
        driver.manage().window().maximize();
    }

    @After
    public void after() throws InterruptedException {
        Thread.sleep(5000);
        driver.close();

    }

    @Test
    public void test(){

        ResultsPage resultsPage = homePage.searchProduct("Samsung S7");
        ProductsPage productsPage = resultsPage.searchCategory();

        Integer totalResults = productsPage.numberOfResults();
        assertTrue(totalResults > 0);

        productsPage.sortProductsAscending();
        productsPage.assertPrice("3.299,99 RON","Telefon mobil Samsung Galaxy S7 G930F 32GB, Android","Rombiz");
        productsPage.sortProductsDescending();
        productsPage.assertPrice("3.620 RON","Smartphone Samsung Galaxy S7 edge 32GB (Android), black","Extreme Digital");


    }


}
