/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package AutoRegFacebook;

/**
 *
 * @author Administrator
 */
public class RegFaceNew extends FacebookSetup{
    
    public RegFaceNew() {
    }

    public RegFaceNew(String linkRegFace) {
        super(linkRegFace);
    }

    public RegFaceNew(String linkRegFace, String srcFileChorome) {
        super(linkRegFace, srcFileChorome);
    }
    
    public void setValueALl(){
        setInputByName("lastname", randomLastName());
        setInputByName("firstname", randomFirtName());
    }
}
