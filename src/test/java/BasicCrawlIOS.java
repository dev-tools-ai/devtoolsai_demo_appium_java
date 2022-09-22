import ai.devtools.appium.SmartDriver;

import io.appium.java_client.MobileElement;
import io.appium.java_client.ios.IOSDriver;
import io.appium.java_client.remote.MobileCapabilityType;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Point;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.io.File;
import java.net.URL;

public class BasicCrawlIOS {

    @Test public void test() {
        try {
            DesiredCapabilities capabilities = new DesiredCapabilities();
            capabilities.setCapability(MobileCapabilityType.APP, new File("/Users/etienne/sdk/sample_projects/devtoolsai_demo_appium_java/iosSampleApp.app").getAbsolutePath());
            capabilities.setCapability("allowTestPackages", true);
            capabilities.setCapability("appWaitForLaunch", false);
            capabilities.setCapability("newCommandTimeout", 0);
            capabilities.setCapability("automationName", "XCUITest");
            capabilities.setCapability("platformName", "iOS");
            capabilities.setCapability("platformVersion", "14.4");
            capabilities.setCapability("deviceName", "iPhone 12 Pro Max");

            System.out.println("Starting test");
            IOSDriver<MobileElement> androidDriver = new IOSDriver<MobileElement>(new URL("http://localhost:4723/wd/hub"), capabilities);
            SmartDriver<MobileElement> smartDriver = new SmartDriver<MobileElement>(androidDriver, "<<get your api key at dev-tools.ai>>");


            MobileElement textField = smartDriver.findElement(By.xpath("//XCUIElementTypeApplication[@name=\"iosSampleApp\"]/XCUIElementTypeWindow[1]/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeTextField"));
            textField.sendKeys("my_username");

            MobileElement popUp = smartDriver.findByAI("ios_popup_java");
            popUp.click();

            Thread.sleep(5000);

            smartDriver.quit();
        } catch(Exception e) {
            e.printStackTrace();
        }
    }
}
