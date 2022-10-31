import org.example.Sauce_demo;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import java.io.FileInputStream;
import java.io.IOException;
public class SauceDemoTest extends Sauce_demo {
    @Test(priority = 1)
    public static void login_check() throws Exception {
        driver.get("https://www.saucedemo.com");
        String LoginDetails = "C:\\Users\\mulikitha\\Documents\\ma4_details.xlsx";
        FileInputStream fis = new FileInputStream(LoginDetails);
        XSSFWorkbook workbook = new XSSFWorkbook(fis);
        XSSFSheet sheet = workbook.getSheetAt(0);
        XSSFRow row = null;
        XSSFCell cell = null;
        String username = null;
        String password = null;
        row = sheet.getRow(0);
        for(int j = 0; j< row.getLastCellNum(); j++){
            cell = row.getCell(j);
            if(j==0){
                username = cell.getStringCellValue();
            }
            if(j==1){
                password = cell.getStringCellValue();
            }
        }
        driver.findElement(By.xpath("//input[@id='user-name']")).sendKeys(username);
        Thread.sleep(3000);
        driver.findElement(By.xpath("//input[@id='password']")).sendKeys(password);
        Thread.sleep(3000);
        driver.findElement(By.xpath("//input[@id='login-button']")).click();
        Thread.sleep(5000);
    }
    @Test(priority = 2)
    public static void PriceHighToLow() throws InterruptedException{
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
    }

    @Test(priority = 3)
    public static void addingtocart() throws InterruptedException{
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
    }

    @Test(priority = 4)
    public static void remove_done() throws InterruptedException{
        WebElement Remove = driver.findElement(By.xpath("//*[@id='remove-sauce-labs-fleece-jacket']"));
        try {
            Assert.assertTrue(Remove.isDisplayed() && Remove.isEnabled());
            System.out.println("Remove Button is enabled & displayed");
        } catch (Exception e) {
            System.out.println("Remove Button is not enabled & displayed");
        }
        Thread.sleep(2000);
        Remove.click();
    }
    @Test(priority = 5)
    public static void shopping() throws InterruptedException{
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
    }

    @Test(priority = 6)
    public static void PriceLowToHigh() throws InterruptedException{
        WebElement pricesortt = driver.findElement(By.xpath("(//select[@class='product_sort_container']/option)[3]"));
        pricesortt.click();
        Thread.sleep(2000);
        WebElement leastproduct = driver.findElement(By.xpath("(//div[@class='inventory_list']/div[@class='inventory_item'])[1]"));
        try {
            Assert.assertTrue(leastproduct.isDisplayed() && leastproduct.isEnabled());
            System.out.println("Least product is displayed");
        } catch (Exception e) {
            System.out.println("Least product is not displayed");
        }
        Thread.sleep(2000);
        WebElement addtoCarrt = driver.findElement(By.xpath("//button[@id='add-to-cart-sauce-labs-onesie']"));
        try {
            Assert.assertTrue(addtoCarrt.isDisplayed() && addtoCarrt.isEnabled());
            System.out.println("Add to cart button is enabled and displayed");
        } catch (Exception e) {
            System.out.println("Add to cart button is not enabled & not displayed");
        }
        Thread.sleep(2000);
        WebElement addtocartt = driver.findElement(By.xpath("//button[@id='add-to-cart-sauce-labs-onesie']"));
        addtocartt.click();
        Thread.sleep(2000);
        WebElement CartIcon1 = driver.findElement(By.xpath("//a[@class='shopping_cart_link']"));
        CartIcon1.click();
        Thread.sleep(2000);

    }
    @Test(priority = 7)
    public static void SignoutFromCart() throws InterruptedException, IOException {
        WebElement Checkout = driver.findElement(By.xpath("//button[@id='checkout']"));
        Checkout.click();
        Thread.sleep(2000);
        String LoginDetails = "C:\\Users\\mulikitha\\Documents\\ma4_details.xlsx";
        FileInputStream fis = new FileInputStream(LoginDetails);
        XSSFWorkbook workbook = new XSSFWorkbook(fis);
        XSSFSheet sheet = workbook.getSheetAt(0);
        XSSFRow row = null;
        XSSFCell cell = null;
        String name = "";
        String lastname = "";
        double postalcode = 0;
        row = sheet.getRow(1);
        String postalcode_str = null;
        for (int j = 0; j < row.getLastCellNum(); j++) {

            cell = row.getCell(j);
            if (j == 0) {
                name = cell.getStringCellValue();
                System.out.println(name);
            }
            if (j == 1) {
                lastname = cell.getStringCellValue();
                System.out.println(lastname);
            }
            if (j == 2) {
                postalcode = cell.getNumericCellValue();
                postalcode_str = String.valueOf(postalcode);
                System.out.println(postalcode_str);
            }
        }


        driver.findElement(By.xpath("//*[@id='first-name']")).sendKeys(name);
        Thread.sleep(3000);
        driver.findElement(By.xpath("//*[@id='last-name']")).sendKeys(lastname);
        Thread.sleep(3000);
        driver.findElement(By.xpath("//*[@id='postal-code']")).sendKeys(postalcode_str);
        Thread.sleep(2000);
        WebElement Continue = driver.findElement(By.xpath("//*[@id='continue']"));
        Continue.click();
        Thread.sleep(2000);

    }
    @Test(priority = 8)
    public static void End() throws InterruptedException{
        WebElement Finish = driver.findElement(By.xpath("//button[@id='finish']"));
        Finish.click();
        Thread.sleep(2000);
    }





}