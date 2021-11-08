
package models;

import java.io.Serializable;

public class User implements Serializable{
    String email;
    int active;
    String fname;
    String lname;
    String password;
    int role;
    
 public User(){
     
 }
 
 public User(String email, int active, String fname, String lname, String password, int role){
     this.email = email;
     this.active = active;
     this.fname = fname;
     this.lname = lname;
     this.password = password;
     this.role = role;
 }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public int getActive() {
        return active;
    }

    public void setActive(int active) {
        this.active = active;
    }

    public String getFname() {
        return fname;
    }

    public void setFname(String fname) {
        this.fname = fname;
    }

    public String getLname() {
        return lname;
    }

    public void setLname(String lname) {
        this.lname = lname;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public int getRole() {
        return role;
    }

    public void setRole(int role) {
        this.role = role;
    }
 
}