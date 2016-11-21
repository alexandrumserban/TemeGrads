import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by amserban on 11/21/2016.
 */
public class ProductsPage {

    private WebDriver driver;

    public ProductsPage(WebDriver webDriver){this.driver = webDriver;}

    @FindBy(xpath = "//div[@id='page_content']/div[1]/div/div[1]/ul/li[5]/span")
    private WebElement totalNumberOfResults;

    @FindBy(xpath = "//div[@id='main_products_container']/ul/li//a[@class = 'price-offer']")
    private List<WebElement> productPrices;

    @FindBy(xpath = "//div[@id='main_products_container']/ul/li//div[@class ='div-offer']/div[1]/a")
    private List<WebElement> shopNames;

    @FindBy(xpath = "//div[@id='main_products_container']//p[@class='text-xl']/a")
    private List<WebElement> productNames;

    @FindBy (xpath = "//ul[@class = 'nav-tab']/li[2]")
    private WebElement sortButton;


    public Integer numberOfResults(){
        String totalResults = totalNumberOfResults.getText();
        System.out.println("Number of results: " + totalResults);
        return Integer.parseInt(totalResults);
    }

    public void sortProductsAscending(){
        sortButton.click();

        String shopName = shopNames.get(0).getAttribute("title");
        String productName = productNames.get(0).getText();
        String productPrice = productPrices.get(0).getText();

        System.out.println("Product: " + productName + " ;Shop: " + shopName + " ;Price: " + productPrice);

    }

    public void sortProductsDescending(){
        sortButton.click();

        String shopName = shopNames.get(0).getAttribute("title");
        String productName = productNames.get(0).getText();
        String productPrice = productPrices.get(0).getText();

        System.out.println("Product: " + productName + " ;Shop: " + shopName + " ;Price: " + productPrice);

    }

 /*   public String lowestPrice(){
        Float minim = Float.parseFloat(productPrices.get(0).getText());
        for(WebElement price : productPrices){
            Float priceFloat = Float.parseFloat(price.getText());
            if(priceFloat <= minim){
                minim = priceFloat;
            }
        }
        System.out.println("lowest price = " + minim.toString());
        return minim.toString();
    }*/

    public void assertPrice(String price, String title, String shop){
        List<Integer> index = new ArrayList<Integer>();

        for(WebElement productPrice : productPrices){
            if(productPrice.getText().equals(price)){
                index.add(productPrices.indexOf(productPrice));
            }
        }

        if((productNames.get(index.get(0)).getText().equals(title))&&(shopNames.get(index.get(0)).getAttribute("title").equals(shop))){
            System.out.println("Yeeey");
        }else {
            System.out.println("Noooooooooooo");
        }



    }

}
