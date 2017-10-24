import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.CapabilityType;

import java.net.MalformedURLException;
import java.net.URL;
import org.junit.*;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.sql.SQLException;
import java.util.List;

public class apptest {
    private AndroidDriver driver;


    @Test
    public void plus() throws MalformedURLException, InterruptedException, SQLException, ClassNotFoundException {
        //获取1
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
        Thread.sleep(8000);
        List<WebElement> elements = driver.findElementsById("com.manyi.lovehouse:id/finance_details");
        if (elements.size()!=0){
            driver.findElementById("com.manyi.lovehouse:id/finance_cancel").click();
        }
        Thread.sleep(3000);
//        driver.findElementByAndroidUIAutomator("new UiSelector().text(\"二手房\")").click();
//        driver.findElementById("com.manyi.lovehouse:id/text_switch_list").click();
//        driver.findElementByAndroidUIAutomator("new UiSelector().text(\"牡丹小区\")").click();
//        String estateName =driver.findElementById("com.manyi.lovehouse:id/house_title_info").getText();
//        System.out.println("estateName"+estateName);
//        String housePrice = driver.findElementById("com.manyi.lovehouse:id/sale_house_total_price").getText();
//        System.out.println("housePrice:"+housePrice);
//        String room = driver.findElementById("com.manyi.lovehouse:id/house_room").getText();
//        System.out.println("room"+room);
        driver.findElementByAndroidUIAutomator("new UiSelector().text(\"我的\")").click();
        driver.findElementById("com.manyi.lovehouse:id/tvLogin").click();
        driver.findElementById("com.manyi.lovehouse:id/phone_login_btn").click();
        driver.findElementByClassName("android.widget.EditText").clear();
        driver.findElementByClassName("android.widget.EditText").sendKeys("15021960281");
        driver.findElementById("com.manyi.lovehouse:id/login_next_btn").click();
        SendCode sendCode = new SendCode();
        Thread.sleep(3000);
        String smsCode = sendCode.getSmsCode("15021960281");
        System.out.println("123:"+smsCode);
        Thread.sleep(8000);
        driver.findElementById("com.manyi.lovehouse:id/psd_edit").sendKeys(smsCode);
        Thread.sleep(8000);
        driver.quit();
    }


}
