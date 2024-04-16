package TestCase;

import Utility.BaseTest;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.List;

public class ProductVerification extends BaseTest {

    @Test
    public void verifyProducts() {
        driver.get("https://www.saucedemo.com/");

        // enter username
        driver.findElement(By.id("user-name")).sendKeys("standard_user");
        // enter pw
        driver.findElement(By.id("password")).sendKeys("secret_sauce");
        // Click on Login button
        driver.findElement(By.id("login-button")).click();


        List<WebElement> products = driver.findElements(By.xpath("//div[@class='inventory_item']"));

//        Assert.assertEquals(products.size(), 0);

        Assert.assertEquals(products.size(), 6);


    }

}

