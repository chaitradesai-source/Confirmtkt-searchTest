package tests;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.*;
import java.time.Duration;

public class SearchTest {

    WebDriver driver;
    WebDriverWait wait;

    @BeforeClass
    public void setUp() {
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        wait = new WebDriverWait(driver, Duration.ofSeconds(20));
        driver.get("https://www.confirmtkt.com/rbooking/");
        System.out.println("browser opened hehe"); // junior-style message
    }

    @Test
    public void testBookingSearch() {
        try {
            // typing from station
            WebElement fromInput = wait.until(ExpectedConditions.elementToBeClickable(
                    By.cssSelector("input[placeholder='Enter From']")));
            fromInput.sendKeys("NDLS");

            WebElement fromSuggestion = wait.until(ExpectedConditions.elementToBeClickable(
                    By.xpath("//li[contains(@class,'autocomplete') and contains(text(),'NDLS')]")));
            fromSuggestion.click();
            System.out.println("from station done lol"); // naive message

            // typing to station
            WebElement toInput = wait.until(ExpectedConditions.elementToBeClickable(
                    By.cssSelector("input[placeholder='Enter To']")));
            toInput.sendKeys("MMCT");

            WebElement toSuggestion = wait.until(ExpectedConditions.elementToBeClickable(
                    By.xpath("//li[contains(@class,'autocomplete') and contains(text(),'MMCT')]")));
            toSuggestion.click();
            System.out.println("to station"); // casual message

            // pick date
            WebElement firstDate = wait.until(ExpectedConditions.elementToBeClickable(
                    By.cssSelector("td.available")));
            firstDate.click();
            System.out.println("date picked"); // very junior-style

            // click search
            WebElement searchBtn = wait.until(ExpectedConditions.elementToBeClickable(
                    By.xpath("//button[contains(text(),'Search')]")));
            searchBtn.click();
            System.out.println("clicked search"); // naive message

            System.out.println("test finished!"); // casual end message

        } catch (Exception e) {
            System.out.println("oops !!, something went wrong: " + e.getMessage()); // casual failure message
            e.printStackTrace();
        }
    }

    @AfterClass
    public void tearDown() {
        driver.quit();
        System.out.println("browser closed"); // closing message
    }
}
