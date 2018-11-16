import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class MyFirstTest {

    WebDriver driver;
    @BeforeMethod
    public void beforeTest(){
        System.setProperty("webdriver.chrome.driver", "C:/drivers/chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.navigate().to("http://przyklady.javastart.pl/jpetstore/actions/Catalog.action");
    }

    @Test
    public void myFirstTest(){
        WebElement signInLink =  driver.findElement(By.cssSelector("#MenuContent a[href*='signonForm']"));
        signInLink.click();
        WebElement userName = driver.findElement(By.name("username"));
        userName.sendKeys("asda");
        WebElement password = driver.findElement(By.name("password"));
        password.clear();
        password.sendKeys("123asd");
        WebElement loginButton = driver.findElement(By.name("signon"));
        loginButton.click();
        String invalidUserNameorPass = "Invalid username or password";
        Assert.assertTrue(driver.findElement(By.cssSelector("#Content ul[class='messages'] li")).getText().contains(invalidUserNameorPass));

    }

    @AfterMethod
    public void afterTest (){
        driver.close();
        driver.quit();
    }
}
