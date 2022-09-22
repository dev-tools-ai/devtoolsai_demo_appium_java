import ai.devtools.appium.SmartDriver;
import io.appium.java_client.MobileBy;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.remote.MobileCapabilityType;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.io.File;
import java.net.URL;

public class BasicCrawlAndroid {

    @Test public void test() {
        try {
            DesiredCapabilities capabilities = new DesiredCapabilities();
            capabilities.setCapability(MobileCapabilityType.APP, new File("/Users/etienne/apks/todoist.apk").getAbsolutePath());
            capabilities.setCapability("allowTestPackages", true);
            capabilities.setCapability("appWaitForLaunch", false);
            capabilities.setCapability("newCommandTimeout", 0);

            System.out.println("Starting test");

            AndroidDriver<MobileElement> androidDriver = new AndroidDriver<MobileElement>(new URL("http://localhost:4723/wd/hub"), capabilities);
            SmartDriver<MobileElement> smartDriver = new SmartDriver<MobileElement>(androidDriver, "<<get your api key at dev-tools.ai>>");
            Thread.sleep(5000);
            MobileElement button = smartDriver.findElement(MobileBy.id("com.todoist:id/btn_welcome_email"));
            button.click();
            Thread.sleep(4000);

            MobileElement element = smartDriver.findByAI("appium_java_todoist_username");
            element.click();
            element.sendKeys("my_username");

            smartDriver.quit();
        } catch(Exception e) {
            e.printStackTrace();
        }
    }
}
