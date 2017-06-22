/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package xtool;

/**
 *
 * @author funkoigame
 */
public class User {
    public String lastName;
    public String firstName;
    public String userName;
    public String passWord;
    public int birthDay;
    public int birthMoth;
    public int birthYear;
    public String Gender;
    public User(String lastName, String firstName) {
        this.lastName = lastName;
        this.firstName = firstName;
    }

    public User() {
    }
    
}
