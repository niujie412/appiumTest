# appiumTest
windows环境下进行Android appium测试<br>

环境搭建：<br>
1.node.js安装:官网下载node windows版安装，添加到path中<br>
cmd窗口验证npm -v 验证node是否安装成功<br>
2.java安装和环境变量配置<br>
3.使用node下载appium 可用cnpm下载,npm --registry http://registry.cnpmjs.org install -g appium<br>
4.安卓sdk下载安装和环境变量配置<br>

appium -doctor 检测<br>
<br>
adb devices<br>
获取deviceName <br>
启动：appium -a 127.0.0.1 -p 4723 -U deviceName <br>

UIAutomatorViewer 在Android  tools目录下<br>
测试用例:<br>

```
public class LoginTest extends BaseCase {

    @Test
    public void loginTest() throws InterruptedException, SQLException, ClassNotFoundException {
        androidDriver.click("new UiSelector().text(\"我的\")");
        androidDriver.clickById("com.manyi.lovehouse:id/tvLogin");
        androidDriver.clickById("com.manyi.lovehouse:id/phone_login_btn");
        androidDriver.clearByClassName("android.widget.EditText");
        androidDriver.entry("android.widget.EditText","15021960281");
        androidDriver.clickById("com.manyi.lovehouse:id/login_next_btn");
        SendCode sendCode = new SendCode();
        Thread.sleep(3000);
        String smsCode = sendCode.getSmsCode("15021960281");
        System.out.println("123:"+smsCode);
        Thread.sleep(8000);
        androidDriver.entryById("com.manyi.lovehouse:id/psd_edit",smsCode);
    }
}
```
