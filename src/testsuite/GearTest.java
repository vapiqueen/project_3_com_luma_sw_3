package testsuite;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import utilities.Utility;

public class GearTest extends Utility {
    String baseUrl = "https://magento.softwaretestingboard.com/";

    @Before
    public void setUp() {

        openBrowser(baseUrl);
    }
    @Test
    public void userShouldAddProductSuccessFullyToShoppingCart(){

        //Mouse Hover on Gear Menu
        mouseHoverOnElement(By.xpath("//span[contains(text(),'Gear')"));

        //Click on Bags
        clickOnElement(By.xpath("//a[@id='ui-id-25'])//span[contain(text(),'Bags')]"));

        //Click on Product Name 'Overnight Duffle'
        clickOnElement(By.xpath("//a[normalize-space()='Overnight Duffle']"));

        //Verify the text 'Overnight Duffle'
      String expectedText = "Overnight Duffle";
      String actualText = driver.findElement(By.xpath("//a[contains(text(),'Overnight Duffle')]")).getText();
        Assert.assertEquals("Error in the text display",expectedText,actualText);

        //Change Qty 3
        clickOnElement(By.xpath("//button[@title='Add to Cart']"));

        //Click on 'Add to Cart' Button.

        //Verify the text ‘You added Overnight Duffle to your shopping cart.’
        String expectedMessage = "You added Overnight Duffle to your shopping cart";
        String actualMessage= driver.findElement(By.xpath("//div[@class='page messages']")).getText();
        Assert.assertEquals("Error message displayed",expectedMessage,actualMessage);

        //Click on ‘shopping cart’ Link into message
        String expectedmessage ="Shopping Cart";
        String actualmessage = driver.findElement(By.xpath("//span[@class='base']")).getText();
        Assert.assertEquals("Error in the text",expectedmessage,actualmessage);

        //Verify the product name ‘Cronus Yoga Pant’
        expectedText = "Cronus Yoga Pant";
        actualText = driver.findElement(By.xpath("//td[@class='col item']//a[normalize-space()='Cronus Yoga Pant']")).getText();
        Assert.assertEquals("Error in the text",expectedText,actualText);

        //Verify the Qty is ‘3’
        expectedText = "3";
        actualText =driver.findElement(By.xpath("//input[@id='cart-236643-qty']")).getText();
        Assert.assertEquals("Wrong quantity displaced",expectedText,actualText);

        // Verify the product price ‘$135.00’
        expectedmessage= "$135.00";
       actualmessage =driver.findElement(By.xpath("//td[class='col subtotal']\")//span[@class='price']")).getText();
        Assert.assertEquals("Total amount vary",expectedmessage,actualmessage);
        //Change Qty to ‘5’
        expectedText ="5";
        actualText=driver.findElement(By.xpath("//input[@id='cart-236643-qty']")).getText();
        Assert.assertEquals("Enable to change the quantity",expectedText,actualText);

        //Click on ‘Update Shopping Cart’ button
        clickOnElement(By.xpath("//span[text()='Update Shopping Cart']"));

        //Verify the product price ‘$225.00’
        expectedmessage="$225.00";
        actualmessage = driver.findElement(By.xpath("//span[@class='cart-price']//span[@class='price'][text()='$225.00']")).getText();
        Assert.assertEquals("Error in the total price",expectedmessage,actualmessage);

    }
    @After
    public void teardown(){
        closeBrowser();
    }

}
