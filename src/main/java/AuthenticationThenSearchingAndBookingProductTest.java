import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class AuthenticationThenSearchingAndBookingProductTest {


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

    public static void main(String[] args) throws InterruptedException {
        WebDriver driver = createDriver();

        configureDriver(driver);
        // Explicit wait
        WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(2));

        navigateTo(driver, "https://www.tunisianet.com.tn/");

        Thread.sleep(2000);

        driver.findElement(By.cssSelector("#_desktop_user_info > div > div > svg")).click();
        driver.findElement(By.cssSelector(".user-down span")).click();

        WebElement email = driver.findElement(By.name("email"));
        email.click();
        email.sendKeys("mehdi.benchikha@insat.u-carthage.tn");

        WebElement password = driver.findElement(By.name("password"));
        password.click();
        password.sendKeys("123456789");

        driver.findElement(By.id("submit-login")).click();


        WebElement searchInput = driver.findElement(By.id("search_query_top"));
        searchInput.click();
        searchInput.sendKeys("MacBook M1 13.3");

        driver.findElement(By.cssSelector(".button-search > .nav-link")).click();

        driver.findElement(By.linkText("PC Portable Apple MacBook Pro M1 13.3\" / 256 Go SSD / Gris Sidéral")).click();
        driver.findElement(By.cssSelector(".add-to-cart")).click();
        Thread.sleep(2000);
        driver.findElement(By.cssSelector(".btn-block:nth-child(1)")).click();
        Thread.sleep(2000);

        driver.quit();
    }
}
