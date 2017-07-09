package AutoRegFacebook;
 
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import com.google.common.base.Function;

/**
 * Created by Administrator on 06/12/2016.
 */
public class FacebookSetup {
    String linkRegFace;
   public WebDriver mWebDriver;
   String srcFileChrome;
    public FacebookSetup() {
        linkRegFace="https://mobile.facebook.com/reg/";
        System.setProperty("webdriver.chrome.driver","D:/chromedriver.exe");
        this.mWebDriver = new ChromeDriver();
    }
    public FacebookSetup(String linkRegFace) {
        this.linkRegFace=linkRegFace;
        System.setProperty("webdriver.chrome.driver","D:/chromedriver.exe");
        this.mWebDriver = new ChromeDriver();
    }
    public FacebookSetup(String linkRegFace,String srcFileChorome) {
        this.srcFileChrome=srcFileChorome;
        this.linkRegFace=linkRegFace;
        System.setProperty("webdriver.chrome.driver",this.srcFileChrome);
        this.mWebDriver = new ChromeDriver();
    }
    public void init(){
        startLinkRegFace(linkRegFace);
        setInfoFace();
    }
    public void setInfoFace(){
        setInputByName("firstname",randomFirtName());
        setInputByName("lastname",randomLastName());
//        setInputByName("reg_email__",RandomNumberPhone());
        setInputByName("reg_email__","hhhhh@polyfaust.com");
        setInputByName("reg_passwd__","Bi01627601492");
        setSex(Util.randInt(1,2));
        setRandomDateBirthday();
        setClickButtonByName("submit");
        setClickByClass("_uf0");
        setClickByClass("_54k8 _56bs _56b_ _qyx _56bx _56bt");
    }

    public void setClickButtonByName(String nameButton){
        WebElement e=mWebDriver.findElement(By.name(nameButton));
        e.click();
    }

    public void setClickByClass(String className){
        WebElement e=mWebDriver.findElement(By.className(className));
        e.click();
    }

    public String RandomNumberPhone(){
        String num="+84";
        int temp=Util.randInt(1,2);
        if(temp==1) num+="1"+Util.randInt(0,9);
        else num+="9";
        for (int i=3;i<=10;i++){
            num=num+Util.randInt(0,9);
        }
        return num;
    }

    public void setSex(int sex){
        if(sex==1){
            WebElement oCheckBox = mWebDriver.findElement(By.cssSelector("input[value='1'"));
            oCheckBox.click();
            return;
        }
        WebElement oCheckBox = mWebDriver.findElement(By.cssSelector("input[value='2'"));
        oCheckBox.click();
    }

    public void clickByValue(String value){
        WebElement bt = mWebDriver.findElement(By.cssSelector("input[value='"+value+"'"));
        bt.click();
    }

    public void setRandomDateBirthday(){
        setInputByName("birthday_day",Util.randInt(1,28)+"");
        setInputByName("birthday_year",Util.randInt(1980,2005)+"");
        setInputByName("birthday_month",Util.randInt(1,12)+"");
    }


    public void setInputByName(String nameElement,String value1){
        WebElement e=mWebDriver.findElement(By.name(nameElement));
        e.sendKeys(value1);
    }
    public void intUrl(){
        mWebDriver.get(linkRegFace);
    }
    public void startLinkRegFace(String url){
        mWebDriver.get(url);
    }

    public  String randomFirtName(){
        int ran=Util.randInt(0,Util.List_First_Name.length-1);
        return Util.List_First_Name[ran];
    }
    public  String randomLastName(){
        int ran=Util.randInt(0,Util.List_Last_Name.length-1);
        return Util.List_Last_Name[ran];
    }

    public void openTab(String tab){
        mWebDriver.navigate().to(tab);

    }

    public void intNative(){
        mWebDriver.navigate().to(linkRegFace);
    }
}
