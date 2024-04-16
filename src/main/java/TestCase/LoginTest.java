package TestCase;

import Utility.BaseTest;
import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;

public class LoginTest extends BaseTest {

    @Test
    public void verifyLoginFunctionality() {
        driver.get("https://www.saucedemo.com/");

        // enter username
        driver.findElement(By.id("user-name")).sendKeys("standard_user");
        // enter pw
        driver.findElement(By.id("password")).sendKeys("secret_sauce");
        // Click on Login button
        driver.findElement(By.id("login-button")).click();

        // Verify Text 'Products'
        //Assert.assertTrue(driver.findElement(By.xpath("//span[text()='Products']")).isDisplayed());


        //span[@class='title' and text()='Products']
        Assert.assertTrue(driver.findElement(By.xpath("//span[@class='title' and text()='Products']")).isDisplayed());

    }

}
