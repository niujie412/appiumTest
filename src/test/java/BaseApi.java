import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.net.MalformedURLException;
import java.net.URL;

public class BaseApi {
    protected static AndroidDriver driver;

    public static void setDriver(AndroidDriver driver) {
        BaseApi.driver = driver;
    }

    public static AndroidDriver getAndroidDriver() throws MalformedURLException {
        DesiredCapabilities cap = new DesiredCapabilities();
        cap.setCapability(CapabilityType.BROWSER_NAME, "");
        cap.setCapability("platformName", "Android"); //指定测试平台
        cap.setCapability("deviceName", "PBV7N16719011577"); //指定测试机的ID,通过adb命令`adb devices`获取
        cap.setCapability("platformVersion", "6.0");

        //将上面获取到的包名和Activity名设置为值
        cap.setCapability("appPackage", " com.manyi.lovehouse");
        cap.setCapability("appActivity", "com.manyi.lovehouse.ui.WelcomeActivity");

        //A new session could not be created的解决方法
//        cap.setCapability("appWaitActivity","com.meizu.flyme.calculator.Calculator");
        //每次启动时覆盖session，否则第二次后运行会报错不能新建session
        cap.setCapability("sessionOverride", true);

        driver = new AndroidDriver(new URL("http://127.0.0.1:4723/wd/hub"), cap);
        return driver;
    }
}
