public class AndroidDriver extends BaseApi{

    protected InitAndroidDriver driver =new InitAndroidDriver();

    public void click(String uiSelect){
        this.driver.click(uiSelect);
    }

    public void clickById(String id){
        this.driver.clickById(id);
    }

    public void clearByClassName(String className){
        this.driver.clearByClassName(className);
    }

    public void entry(String className,String msg){
        this.driver.entry(className,msg);
    }

    public void entryById(String id,String msg){
        this.driver.entryById(id,msg);
    }

    public void quit(){
        this.driver.quit();
    }

    public static AndroidDriver getInstance(){
        return new AndroidDriver();
    }

}

