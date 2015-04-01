package java63.servlets.project.domain;

import java.io.Serializable;
import java.io.UnsupportedEncodingException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class User implements Serializable, Cloneable {
  private static final long serialVersionUID = 1L;
   
  protected String    userid;
  protected String    username;
  protected String    password; 
  protected String    email;
  
  
  public User( )
  {
    
  }
  public User(String userid, String username, String password, String email) {
    
    this.userid = userid;
    this.username = username;
    this.password = password;
    this.email = email;
  }
  @Override
  public int hashCode() {
    final int prime = 31;
    int result = 1;
    result = prime * result + ((email == null) ? 0 : email.hashCode());
    result = prime * result + ((password == null) ? 0 : password.hashCode());
    result = prime * result + ((userid == null) ? 0 : userid.hashCode());
    result = prime * result + ((username == null) ? 0 : username.hashCode());
    return result;
  }
  @Override
  public boolean equals(Object obj) {
    if (this == obj)
      return true;
    if (obj == null)
      return false;
    if (getClass() != obj.getClass())
      return false;
    User other = (User) obj;
    if (email == null) {
      if (other.email != null)
        return false;
    } else if (!email.equals(other.email))
      return false;
    if (password == null) {
      if (other.password != null)
        return false;
    } else if (!password.equals(other.password))
      return false;
    if (userid == null) {
      if (other.userid != null)
        return false;
    } else if (!userid.equals(other.userid))
      return false;
    if (username == null) {
      if (other.username != null)
        return false;
    } else if (!username.equals(other.username))
      return false;
    return true;
  }
  @Override
  protected Object clone() throws CloneNotSupportedException {
    // TODO Auto-generated method stub
    return super.clone();
  }
  @Override
  public String toString() {
    return "User [userid=" + userid + ", username=" + username + ", password="
        + password + ", email=" + email + "]";
  }
  
  
  public String getUserid() {
    return userid;
  }
  public void setUserid(String userid) {
    this.userid = userid;
  }
  public String getUsername() {
    return username;
  }
  public void setUsername(String username) {
    this.username = username;
  }
  public String getPassword() {
    return password;
  }
  public void setPassword(String password) {
    this.password = password;
  }
  public String getEmail() {
    return email;
  }
  public void setEmail(String email) {
    this.email = email;
  } 
   
   
  
  
}


