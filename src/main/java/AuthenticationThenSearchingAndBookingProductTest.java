import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class AuthenticationThenSearchingAndBookingProductTest {

    private static final String EMAIL_ADDRESS = "mehdi.benchikha@insat.u-carthage.tn";
    private static final String PASSWORD = "123456789";
    private static final String URL = "https://www.tunisianet.com.tn/";
    private static final String SEARCH_KEYWORD = "MacBook M1 13.3";
    private static final String PRODUCT_REFERENCE = "PC Portable Apple MacBook Pro M1 13.3\" / 256 Go SSD / Gris Sidéral";


    public static void main(String[] args) throws InterruptedException {
        WebDriver driver = createDriver();

        configureDriver(driver);

        navigateTo(driver, URL);

        Thread.sleep(2000);

        authenticate(driver, EMAIL_ADDRESS, PASSWORD);

        search(driver, SEARCH_KEYWORD);

        bookProduct(driver, PRODUCT_REFERENCE);

        driver.quit();
    }

    public static WebDriver createDriver() {
        WebDriverManager.chromedriver().setup();
        return new ChromeDriver();
    }

    public static void configureDriver(WebDriver driver) {
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(10));
        driver.manage().window().maximize();
    }

    public static void navigateTo(WebDriver driver, String url) {
        driver.navigate().to(url);
    }

    public static void authenticate(WebDriver driver, String email, String password){
        // Click on connection trigger
        driver.findElement(By.cssSelector("#_desktop_user_info > div > div > svg")).click();
        driver.findElement(By.cssSelector(".user-down span")).click();

        // Enter credentials
        WebElement emailInput = driver.findElement(By.name("email"));
        emailInput.click();
        emailInput.sendKeys(email);
        WebElement passwordInput = driver.findElement(By.name("password"));
        passwordInput.click();
        passwordInput.sendKeys(password);

        driver.findElement(By.id("submit-login")).click();
    }

    public static void search(WebDriver driver, String keyword){
        WebElement searchInput = driver.findElement(By.id("search_query_top"));
        searchInput.click();
        searchInput.sendKeys(keyword);
        driver.findElement(By.cssSelector(".button-search > .nav-link")).click();
    }

    public static void bookProduct(WebDriver driver, String productReference) throws InterruptedException {
        driver.findElement(By.linkText(productReference)).click();
        driver.findElement(By.cssSelector(".add-to-cart")).click();
        Thread.sleep(2000);
        driver.findElement(By.linkText("Commander")).click();
        Thread.sleep(2000);
        driver.findElement(By.linkText("Commanderchevron_right")).click();
        Thread.sleep(2000);
    }
}
