package AutoRegFacebook;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.List;

/**
 * Created by Admin on 1/8/2017.
 */
public class AtuoSendLike {
    FacebookSetup facebookSetup;
    public AtuoSendLike(){
        // chú chú ý phải đúng src chromedriver.exe
         facebookSetup =new FacebookSetup("https://m.facebook.com/","D:/chromedriver.exe");
    }
    public void startSendLikePage(String userName,String pass,String idPage) {
        if(facebookSetup==null) return;
        System.out.println("start");
        facebookSetup.intNative();
        facebookSetup.setInputByName("email",userName);
        facebookSetup.setInputByName("pass",pass);
        facebookSetup.setClickButtonByName("login");
        try {
            Thread.sleep(3000l);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        facebookSetup.openTab("https://m.facebook.com/send_page_invite/?pageid="+idPage+"&reference=context_row");
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        By mySelector = By.xpath("//div[@id='m_invitee_list']/div[@id='m_invitee_list']/div[*]");
        List<WebElement> myElements = facebookSetup.mWebDriver.findElements(By.id("m_invitee_list"));

        int n=2;
        while (n>1) {
            List<WebElement> amyElements = facebookSetup.mWebDriver.findElements(mySelector);
            n=myElements.size();
            if(n>1){
                System.out.println("het");
                break;
            }
//        List<WebElement> myElements1=myElements.get(0).findElements(By.id("m_invitee_list"));
//        System.out.println("siz1:"+myElements1.size());
            for (WebElement e : amyElements) {
                //  System.out.println(e.getText());
                WebElement w = e.findElement(By.xpath(".//div/div/div/button"));
                w.click();
//            System.out.println(e.getText()+"size:"+w.size());
            }
        }

        try {
            Thread.sleep(1000);
            facebookSetup.openTab("https://m.facebook.com/send_page_invite/?pageid="+idPage+"&reference=context_row");

        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("het");
        facebookSetup.mWebDriver.quit();
    }

}
