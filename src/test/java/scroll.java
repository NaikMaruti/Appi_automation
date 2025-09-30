import io.appium.java_client.AppiumBy;
import org.testng.annotations.Test;

public class scroll extends BaseTest{

    @Test
    public void scrollGesture() {
        driver.findElement(AppiumBy.accessibilityId("Views")).click();

        scrollToText("WebView");
       // scrollToEndAction();

    }
}
