import io.appium.java_client.AppiumBy;
import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.By;
import org.testng.annotations.Test;

import java.net.MalformedURLException;
import java.net.URISyntaxException;

public class appiumBasic_dreaftTests {
    AndroidDriver driver;
    @Test
    public void appiumTest() throws MalformedURLException, URISyntaxException{

        BaseTest baseTest= new BaseTest();
        driver = baseTest.configureAppium();

        driver.findElement(AppiumBy.accessibilityId("Preference")).click();
        driver.findElement(By.xpath("//android.widget.TextView[@content-desc='3. Preference dependencies']")).click();
        driver.findElement(By.id("android:id/checkbox")).click();
        driver.findElement(By.xpath("(//android.widget.RelativeLayout)[2]")).click();
        driver.findElement(By.id("android:id/edit")).sendKeys("Rahul Wifi");
        driver.findElements(AppiumBy.className("android.widget.Button")).get(1).click();


       baseTest.tearDown(driver);    }
}

