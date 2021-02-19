import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

public class BaseTest {
    protected static ThreadLocal<ChromeDriver> driver = new ThreadLocal<>();

    @BeforeMethod
    public void setup()
    {
        System.setProperty("webdriver.chrome.driver", "chromedriver.exe");
        ChromeOptions options = new ChromeOptions();
        options.setHeadless(true);
        driver.set(new ChromeDriver(options));
    }

    public WebDriver getDriver(){
        return driver.get();
    }

    @AfterMethod
    public void tearDown()
    {
        getDriver().quit();
    }

}
