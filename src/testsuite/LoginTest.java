package testsuite;

import Utilities.Utility;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.json.JsonOutput;

public class LoginTest extends Utility {

    String baseUrl = "https://www.saucedemo.com/";

    @Before
    public void setUp() {
        openBrowser(baseUrl);
    }

    @Test
    public void userShouldLoginSuccessfullyWithValidCredentials() {

        //enter username
        sendTextToElement(By.name("user-name"), "standard_user");
        //enter password
        sendTextToElement(By.name("password"), "secret_sauce");
        //click on Login button
        clickOnElement(By.xpath("//input[@id='login-button']"));

        String expectedMessage = "Products";
        String actualTextMessage = getTextFromElement(By.xpath("//span[contains(text(),'Products')]"));


        //Validate actual and expected message
        Assert.assertEquals("Products", expectedMessage, actualTextMessage);
    }
    @Test
       public void verifyThatSixProductAreDisplayedOnThePage(){

        sendTextToElement(By.name("user-name"), "standard_user");
        //enter password
        sendTextToElement(By.name("password"), "secret_sauce");
        //click on Login button
        clickOnElement(By.xpath("//input[@id='login-button']"));


    boolean isInventoryDisplayed = driver.findElement(By.id("inventory_container")).isDisplayed();
        System.out.println("Six Item Displayed" + isInventoryDisplayed);

    }
    @After
    public void testDown() {
        closeBrowser();

    }
}
