import org.testng.annotations.Test;

import java.sql.SQLException;

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
