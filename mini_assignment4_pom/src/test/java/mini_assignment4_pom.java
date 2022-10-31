import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import java.util.concurrent.TimeUnit;
public class Main {
    public static WebDriver driver;
    @BeforeTest
    public void openSauceDemo() {
        System.setProperty("webdriver.chrome.driver", "C:\\Users\\ankitkumar83\\chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
    }
    @AfterTest
    public void closeSauceDemo()
    {
        driver.close();
    }





}