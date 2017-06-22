/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package xtool;

import java.util.Calendar;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.scene.web.WebEngine;
import javax.xml.xpath.XPathConstants;
import javax.xml.xpath.XPathExpressionException;
import javax.xml.xpath.XPathFactory;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.html.HTMLFormElement;
import javafx.beans.property.*;
import javafx.beans.value.*;
/**
 *
 * @author funkoigame
 */
public class GoogleReg implements ValueInputGmailReg {

    WebEngine webEngine;
    Document document;
    User newUser;

    public GoogleReg() {
    }

    public GoogleReg(WebEngine webEngine) {
        this.webEngine = webEngine;
        document = this.webEngine.getDocument();
    }

    public Element getElementById(String id) {
        try {
            //  return document.getElementById(id);
            return (Element) XPathFactory.newInstance().newXPath().evaluate(
                    "//*[@id='LastName']//*[@name='LastName']",
                    webEngine.getDocument(),
                    XPathConstants.NODE);
        } catch (XPathExpressionException ex) {
            Logger.getLogger(GoogleReg.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

    public void setValueInputById(String id, String text) throws XPathExpressionException {
        getElementById(id).setAttribute("value", text);
    }

    public void setValueInputByName(String id, String text) {
        String setLastName = "document.getElementsByName('" + id + "')[0].value='" + text + "';";
        webEngine.executeScript(setLastName);
    }

    public void setAllValue() {
        setValueInputByName(LAST_NAME, newUser.lastName);
        setValueInputByName(FIST_NAME, newUser.firstName);
        setValueInputByName(MAIL_NAME, newUser.userName);
        setValueInputByName(PASS_WORD, newUser.passWord);
        setValueInputByName(PASS_WORD2, newUser.passWord);
        if(newUser.birthMoth<=9) setValueInputByName(BIRTH_MOTH, "0"+newUser.birthMoth);
        else setValueInputByName(BIRTH_MOTH, newUser.birthMoth+"");
        setValueInputByName(BIRTH_DAY, newUser.birthDay+"");
        setValueInputByName(BIRTH_YEAR,  newUser.birthYear+"");
        setValueInputByName(GENDER, newUser.Gender);
        setValueInputByName(CountryCode, Util.randomCountry());
    }

    public void createUser() {
        newUser = RandomNewUser();
    }

    public User RandomNewUser() {
        User user = new User();
        user.lastName = Util.List_Last_Name[Util.randInt(0, Util.List_Last_Name.length - 1)];
        user.firstName = Util.List_First_Name[Util.randInt(0, Util.List_First_Name.length - 1)];
        user.userName = Util.removeAccent(user.firstName + user.lastName + Util.randInt(1000, 100000)).toLowerCase();
        user.passWord = Util.removeAccent(user.lastName + user.firstName + Util.randInt(1000, 100000));
        user.birthDay=Util.randInt(1, 28);
        user.birthMoth=Util.randInt(1, 12);
        user.birthYear=Util.randInt(1980, 2006);
        user.Gender=RandomSex();
        return user;
    }
    
    public String RandomSex(){
       int ran=Util.randInt(1, 3);
       if(ran==1) return "FEMALE";
       if(ran==2)return "MALE";
       if(ran==3)return "OTHER";
       return null;
    }
    
    public void Submit(){
        webEngine.executeScript("document.getElementById('submitbutton').click();");
//          final BooleanProperty loginAttempted = new SimpleBooleanProperty(false);
//        HTMLFormElement gaia_loginform = ( HTMLFormElement ) document.getElementById( "createaccount");
//                            if ( gaia_loginform != null ) {
//                                if ( !loginAttempted.get() ) {
//                                    loginAttempted.set( true );
//                                    gaia_loginform.submit();
//                                }
//                            }
    }
}
