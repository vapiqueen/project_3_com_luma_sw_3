package testsuite;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import utilities.Utility;

import java.util.List;

public class WomenTest extends Utility {

    String baseUrl = "https://magento.softwaretestingboard.com/";

    @Before
    public void setUp() {
        openBrowser(baseUrl);
    }

    @Test
    public void verifyTheSortByProductNameFilter() {
        //Mouse Hover on Women Menu
        mouseHoverOnElement(By.xpath("//a[@id='ui-id-4']//span[@class='ui-menu-icon ui-icon ui-icon-carat-1-e']"));
        //hoovering on Tops
        mouseHoverOnElement(By.xpath("//a[@id='ui-id-9']"));
        //Hoovering and clicking on Jackets
        clickOnElement(By.xpath("//a[@id='ui-id-11']//span[contains(text(),'Jackets')]"));

        //Select sort By filter "Product Name"
        WebElement dropDowm = driver.findElement(By.id("sorter"));
        Select select = new Select(dropDowm);
        select.selectByValue("name");

        //verify the product name display in alphabetical order
        List<WebElement> element = driver.findElements(By.xpath("//strong[@class = 'product name product-item-name']"));
        for (WebElement result : element) {
            System.out.println(result.getText());
        }
    }
    @Test

       public void verifyTheSortByPriceFilter(){
        //Mouse Hover on Women Menu
        mouseHoverOnElement(By.xpath("//a[@id='ui-id-4']//span[@class='ui-menu-icon ui-icon ui-icon-carat-1-e']"));
        //hoovering on Tops
        mouseHoverOnElement(By.xpath("//a[@id='ui-id-9']"));
        //Hoovering and clicking on Jackets
        clickOnElement(By.xpath("//a[@id='ui-id-11']//span[contains(text(),'Jackets')]"));

        //Select sort By filter "Price"
        WebElement dropDowm = driver.findElement(By.id("sorter"));
        Select select = new Select(dropDowm);
        select.selectByVisibleText("Position");
        selectFromDropDownMenu(By.id("sorter"), "price ");
        select.selectByValue("price");

        //verify the product price display in Low to High
        List<WebElement> List2 = driver.findElements(By.xpath("//div[@class = 'price-box price-final_price']"));
        for (int i = 0; i < List2.size(); i++) {
            System.out.println(List2.get(i).getText());
            String expectedText = List2.get(i).getText();
            String actualText = List2.get(i).getText();
            Assert.assertEquals("Price not ordered : Low to High  ", expectedText, actualText);
      }

    }
    @After
    public void teardown(){
        closeBrowser();
    }

}



