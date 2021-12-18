import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class AuthenticationThenSearchingAndBookingProductTest {
    public static void main(String[] args) throws InterruptedException {
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();

        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(100));
        driver.manage().timeouts().scriptTimeout(Duration.ofSeconds(2));
        driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(30));

        driver.get("https://www.tunisianet.com.tn/");
        driver.manage().window().setSize(new Dimension(1552, 840));
        Thread.sleep(2000);
        driver.findElement(By.cssSelector("#_desktop_user_info > div > div > svg")).click();
        driver.findElement(By.cssSelector(".user-down span")).click();
        driver.findElement(By.name("email")).click();
        driver.findElement(By.name("email")).sendKeys("mehdi.benchikha@insat.u-carthage.tn");
        driver.findElement(By.name("password")).click();
        driver.findElement(By.name("password")).sendKeys("123456789");
        driver.findElement(By.id("submit-login")).click();
        driver.findElement(By.id("search_query_top")).click();
        driver.findElement(By.id("search_query_top")).sendKeys("MacBook M1 13.3");
        Thread.sleep(20000);
        driver.findElement(By.linkText("PC PORTABLE APPLE MACBOOK PRO M1 13.3\" / 256 GO SSD / GRIS SIDÉRAL")).click();
        driver.findElement(By.cssSelector(".add-to-cart")).click();
        driver.findElement(By.cssSelector(".btn-block:nth-child(1)")).click();
        Thread.sleep(10000);
        driver.close();
    }
}
