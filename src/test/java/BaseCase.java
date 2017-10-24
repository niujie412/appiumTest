import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

import java.net.MalformedURLException;

public class BaseCase {
    protected AndroidDriver androidDriver;

    @BeforeClass
    public void setUpClass() throws MalformedURLException {
        BaseApi.getAndroidDriver();
        androidDriver=AndroidDriver.getInstance();
    }

    @AfterClass
    public void finishClass(){
        androidDriver.quit();
    }


}
