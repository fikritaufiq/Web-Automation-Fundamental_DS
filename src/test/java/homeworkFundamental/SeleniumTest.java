package homeworkFundamental;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;
import java.time.Duration;

public class SeleniumTest {

    WebDriver driver;
    @Test
    public void searchEmail(){

        WebDriverManager.edgedriver();
        driver = new EdgeDriver();
        driver.manage().window().maximize();
        driver.get("https://yopmail.com/");
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("login")));
        driver.findElement(By.id("login")).sendKeys("automationtest");
        driver.findElement(By.xpath("//i[@class='material-icons-outlined f36']")).click();

        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//iframe[@id='ifmail']")));
        driver.switchTo().frame(driver.findElement(By.id("ifmail")));

        String actualSuccessSwith = driver.findElement(By.xpath("//strong[.='Thanks for connecting!']")).getText();
        String expectedSuccessSwith = "Thanks for connecting!";
        Assert.assertEquals(actualSuccessSwith, expectedSuccessSwith);
        driver.quit();
    }

}
