import io.appium.java_client.AppiumBy;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.options.UiAutomator2Options;
import io.appium.java_client.service.local.AppiumDriverLocalService;
import io.appium.java_client.service.local.AppiumServiceBuilder;
import io.appium.java_client.service.local.flags.GeneralServerFlag;
import org.openqa.selenium.By;
import org.testng.annotations.Test;

import java.io.File;
import java.net.MalformedURLException;
import java.net.URI;
import java.net.URISyntaxException;
import java.time.Duration;

public class appiumBasics {

    @Test
    public void appiumTest() throws MalformedURLException, URISyntaxException{

        AppiumDriverLocalService service= new AppiumServiceBuilder().withAppiumJS(new File("C://Users//marut//AppData//Roaming//npm//node_modules//appium//build//lib//main.js"))
                .withArgument(GeneralServerFlag.SESSION_OVERRIDE).withIPAddress("127.0.0.1").usingPort(4723).build();
        service.start();


        UiAutomator2Options options = new UiAutomator2Options();
        options.setDeviceName("Pixel 3a Maruti");
        options.setApp("C://Users//marut//IdeaProjects//Appi_auto_1//src//test//resources//ApiDemos-debug.apk");
        //options.setCapability("max-duration", 50000);
        options.setCapability("newCommandTimeout", 50000);


        AndroidDriver driver =new AndroidDriver(new URI("http://127.0.0.1:4723").toURL(), options);
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));

        driver.findElement(AppiumBy.accessibilityId("Preference")).click();
        driver.findElement(By.xpath("//android.widget.TextView[@content-desc='3. Preference dependencies']")).click();
        driver.findElement(By.id("android:id/checkbox")).click();
        driver.findElement(By.xpath("(//android.widget.RelativeLayout)[2]")).click();
        driver.findElement(By.id("android:id/edit")).sendKeys("Rahul Wifi");
        driver.findElements(AppiumBy.className("android.widget.Button")).get(1).click();


        driver.quit();

        service.stop();

    }
}

