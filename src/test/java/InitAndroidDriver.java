public class InitAndroidDriver extends BaseApi {

    public void click(String uiSelect){
        driver.findElementByAndroidUIAutomator(uiSelect).click();
    }

    public void clickById(String id){
        driver.findElementById(id).click();
    }

    public void clearByClassName(String className){
        driver.findElementByClassName(className).clear();
    }

    public void entry(String className ,String msg){
        driver.findElementByClassName(className).sendKeys(msg);
    }

    public void entryById(String id,String msg){
        driver.findElementById(id).sendKeys(msg);
    }

    public void quit(){
        driver.quit();
    }
}
