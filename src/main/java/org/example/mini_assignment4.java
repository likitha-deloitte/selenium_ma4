
package org.example;

import org.junit.Assert;
import org.junit.Before;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.Callable;
import java.util.concurrent.TimeUnit;

public class mini_assignment4 {

    private static WebDriver driver;

    public static void main(String[] args) throws InterruptedException {
        System.setProperty("webdriver.chrome.driver","C:\\Users\\mulikitha\\Documents\\chromedriver (2).exe");
        ChromeDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().deleteAllCookies();
        driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
        driver.get("https://www.saucedemo.com/");

        WebElement username = driver.findElement(By.xpath("//input[@id='user-name']"));
        username.sendKeys("standard_user");
        Thread.sleep(2000);

        WebElement password = driver.findElement(By.xpath("//input[@id='password']"));
        password.sendKeys("secret_sauce");
        Thread.sleep(2000);

        WebElement loginbutton = driver.findElement(By.xpath("//input[@id='login-button']"));
        loginbutton.click();
        Thread.sleep(2000);

        WebElement filter = driver.findElement(By.xpath("//select[@class='product_sort_container']"));
        filter.click();
        Thread.sleep(2000);

        WebElement pricesort = driver.findElement(By.xpath("(//select[@class='product_sort_container']/option)[4]"));
        pricesort.click();
        Thread.sleep(2000);

        WebElement highestproduct = driver.findElement(By.xpath("(//div[@class='inventory_list']/div[@class='inventory_item'])[1]"));
        try {
            Assert.assertTrue(highestproduct.isDisplayed()&&highestproduct.isEnabled());
            System.out.println("Highest product is displayed");
        } catch (Exception e) {
            System.out.println("Highest product is not displayed");
        }
        Thread.sleep(2000);

        WebElement addtoCartEnable = driver.findElement(By.xpath("//button[@id='add-to-cart-sauce-labs-fleece-jacket']"));
        try {
            Assert.assertTrue(addtoCartEnable.isDisplayed()&&addtoCartEnable.isEnabled());
            System.out.println("add to cart button is enabled and displayed");
        } catch (Exception e) {
            System.out.println("add to cart button is not enabled & not displayed");
        }
        Thread.sleep(2000);

        String ProductPriceVerify = driver.findElement(By.xpath("(//div[@class='inventory_item_price'])[1]")).getText();
        int limit = 100;
        ProductPriceVerify =ProductPriceVerify.replace("$","");
        int priceValue = Integer.parseInt(ProductPriceVerify.substring(0,ProductPriceVerify.indexOf(".")));
        if( limit > priceValue)
            System.out.println("It is less than 100");
        else
            System.out.println("It i greater tahn 100");
        Thread.sleep(2000);

        WebElement addtocart = driver.findElement(By.xpath("//button[@id='add-to-cart-sauce-labs-fleece-jacket']"));
        addtocart.click();
        Thread.sleep(2000);

        WebElement Remove = driver.findElement(By.xpath("//*[@id='remove-sauce-labs-fleece-jacket']"));
        try {
            Assert.assertTrue(Remove.isDisplayed() && Remove.isEnabled());
            System.out.println("Remove Button is enabled & displayed");
        } catch (Exception e) {
            System.out.println("Remove Button is not enabled & displayed");
        }
        Thread.sleep(2000);

        Remove.click();

        WebElement addToCartEnable1 = driver.findElement(By.xpath("//button[@id='add-to-cart-sauce-labs-fleece-jacket']"));
        try {
            Assert.assertTrue(addToCartEnable1.isDisplayed() && addToCartEnable1.isEnabled());
            System.out.println("Addtocart Button is enabled & displayed");
        } catch (Exception e) {
            System.out.println("Add to cart button is not enabled & displayed");
        }
        Thread.sleep(2000);

        addToCartEnable1.click();

        WebElement CartIcon = driver.findElement(By.xpath("//a[@class='shopping_cart_link']"));
        CartIcon.click();
        Thread.sleep(2000);

        WebElement ContinueShop = driver.findElement(By.xpath("//button[@id='continue-shopping']"));
        ContinueShop.click();
        Thread.sleep(2000);

        WebElement pricesortt = driver.findElement(By.xpath("(//select[@class='product_sort_container']/option)[3]"));
        pricesortt.click();
        Thread.sleep(2000);

        WebElement leastproduct = driver.findElement(By.xpath("(//div[@class='inventory_list']/div[@class='inventory_item'])[1]"));
        try {
            Assert.assertTrue(leastproduct.isDisplayed()&&leastproduct.isEnabled());
            System.out.println("least product is displayed");
        } catch (Exception e) {
            System.out.println("least product is not displayed");
        }
        Thread.sleep(2000);

        WebElement addtoCart = driver.findElement(By.xpath("//button[@id='add-to-cart-sauce-labs-onesie']"));
        try {
            Assert.assertTrue(addtoCart.isDisplayed()&&addtoCart.isEnabled());
            System.out.println("add to cart button is enabled and displayed");
        } catch (Exception e) {
            System.out.println("add to cart button is not enabled & not displayed");
        }
        Thread.sleep(2000);

        WebElement addtocartt = driver.findElement(By.xpath("//button[@id='add-to-cart-sauce-labs-onesie']"));
        addtocartt.click();
        Thread.sleep(2000);

        WebElement CartIcon1 = driver.findElement(By.xpath("//a[@class='shopping_cart_link']"));
        CartIcon1.click();
        Thread.sleep(2000);

        WebElement Checkout = driver.findElement(By.xpath("//button[@id='checkout']"));
        Checkout.click();
        Thread.sleep(2000);

        WebElement firstname = driver.findElement(By.xpath("//*[@id='first-name']"));
        firstname.sendKeys("likitha");
        Thread.sleep(2000);

        WebElement lastname = driver.findElement(By.xpath("//*[@id='last-name']"));
        lastname.sendKeys("munjampally");
        Thread.sleep(2000);

        WebElement postalcode = driver.findElement(By.xpath("//*[@id='postal-code']"));
        postalcode.sendKeys("504296");
        Thread.sleep(2000);

        WebElement Continue = driver.findElement(By.xpath("//*[@id='continue']"));
        Continue.click();
        Thread.sleep(2000);

        WebElement Finish = driver.findElement(By.xpath("//button[@id='finish']"));
        Finish.click();
        Thread.sleep(2000);


    }
}
