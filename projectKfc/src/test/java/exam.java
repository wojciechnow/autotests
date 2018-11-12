import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class exam {
    private WebDriver driver;

    @BeforeMethod
    public void beforeTest() {
        System.setProperty("webdriver.chrome.driver", "C:/drivers/chromedriver.exe");
        driver = new ChromeDriver();
        driver.navigate().to("http://przyklady.javastart.pl:8095/hovers");
    }


    @Test
    public void mytest() throws InterruptedException {
        Actions action = new Actions(driver);
        WebElement firstUserAvatar = driver.findElement(By.xpath("//*[@id='content']/div/div[1]"));
        WebElement secUserAvatar = driver.findElement(By.xpath("//*[@id='content']/div/div[2]"));
        WebElement thirdUserAvatar = driver.findElement(By.xpath("//*[@id='content']/div/div[3]"));

        action.moveToElement(firstUserAvatar).perform();
        Thread.sleep(2000);
        WebElement expandedDescFirstAvatar = driver.findElement(By.xpath("//div[1]/div/h5"));
        WebElement expandedDescSecAvatar = driver.findElement(By.xpath("//div[2]/div/h5"));
        WebElement expandedDescThirdAvatar = driver.findElement(By.xpath("//div[3]/div/h5"));
        Thread.sleep(2000);

        Assert.assertEquals(expandedDescFirstAvatar.getText(), "name: user1");
        Thread.sleep(1000);

        Assert.assertEquals(expandedDescSecAvatar.getText(), "");
        Assert.assertEquals(expandedDescThirdAvatar.getText(), "");
        Thread.sleep(1000);
        action.moveToElement(secUserAvatar).perform();
        Thread.sleep(1000);
        action.moveToElement(thirdUserAvatar).perform();
        Thread.sleep(1000);



    }


    @AfterMethod
    public void afterTest() {
        driver.close();
        driver.quit();
    }
}
