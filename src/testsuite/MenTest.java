package testsuite;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import utilities.Utility;

public class MenTest extends Utility {
    String baseUrl = "https://magento.softwaretestingboard.com/";

    @Before
    public void setUp() {
        openBrowser(baseUrl);
    }

    @Test
    public void userShouldAddProductSuccessFullyToShoppinCart() {
        //Mouse Hover on Men Menu
        mouseHoverOnElement(By.xpath("//a[@id='ui-id-5']//span[@class='ui-menu-icon ui-icon ui-icon-carat-1-e']"));
        //Mouse Hover on Bottoms
        mouseHoverOnElement(By.xpath("//a[@id='ui-id-18']"));
        //Click on Pants
        clickOnElement(By.xpath("//a[@id='ui-id-23']//span[contains(text(),'Pants')]"));

        //Mouse Hover on product name ‘Cronus Yoga Pant’ and click on size 32.
        clickOnElement(By.xpath("//a[normalize-space()='Cronus Yoga Pant']"));
               clickOnElement(By.xpath("//div[@id='option-label-size-143-item-175']"));

       //Mouse Hover on product name'Cronus yoga pant' and click on colour Black
        clickOnElement(By.id("option-label-color-93-item-49"));

        //Mouse Hover on product name'Cronus Yoga Pant' and click on 'Add To Cart' Button.
        clickOnElement(By.xpath("//button[@title='Add to Cart']"));

        //Verify the text'‘You added Cronus Yoga Pant to your shopping cart.’
        String expectedText ="You added Cronus Yoga Pant to your shopping cart.";
      String actualText = driver.findElement(By.xpath("//div[@class='page messages']")).getText();
        //Assert.assertEquals("Your shopping cart is empty",expectedText,actualText);

        //Click on 'Shopping cart' link into message
        clickOnElement(By.xpath("//a[normalize-space()='shopping cart']"));

        //Verify the text 'Shopping Cart'
        String expectedmessage ="Shopping Cart";
        String actualmessage = driver.findElement(By.xpath("//span[@class='base']")).getText();
        Assert.assertEquals("Error in the text",expectedmessage,actualmessage);

        //Verify the product name'‘Cronus Yoga Pant’
        expectedText = "Cronus Yoga Pant";
        actualText = driver.findElement(By.xpath("//td[@class='col item']//a[normalize-space()='Cronus Yoga Pant']")).getText();
        Assert.assertEquals("Error in the text",expectedText,actualText);

        //Verify the product size'32'
        expectedText ="32";
        actualText=driver.findElement(By.xpath("//dd[contains(text(),'32')]")).getText();
        Assert.assertEquals("Product size is not correct",expectedText,actualText);

        //Verify the product colour'Black'
        expectedText="Black";
        actualText=driver.findElement(By.xpath("//dd[contains(text(),'Black')]")).getText();
        Assert.assertEquals("Black colour is not selected",expectedText,actualText);
    }
    @After
    public void teardown(){
        closeBrowser();
    }
}
