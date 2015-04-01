package java63.servlets.project.domain;

import java.io.Serializable;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class Board implements Serializable, Cloneable {
  private static final long serialVersionUID = 1L;
  
  protected int       no;
  protected String    title;
  protected String    section;
  protected String    context;
  protected Date      date;
  protected String    pic;
  protected String    userid;
  
  
  public Board() {
	   this.date =new Date();
  }
  
  

  public Board(int no, String title, String section, String context,
       String pic, String userid) {
    super();
    this.no = no;
    this.title = title;
    this.section = section;
    this.context = context;
    this.date =new Date();
    this.pic = pic;
    this.userid = userid;
  }



  @Override
  public Board clone() throws CloneNotSupportedException {
    return (Board) super.clone();
  }
  
  

  @Override
  public String toString() {
    return "Museum [no=" + no + ", title=" + title + ", section=" + section
        + ", context=" + context + ", date=" + date + ", pic=" + pic
        + ", userid=" + userid + "]";
  }



 

  @Override
  public int hashCode() {
    final int prime = 31;
    int result = 1;
    result = prime * result + ((context == null) ? 0 : context.hashCode());
    result = prime * result + ((date == null) ? 0 : date.hashCode());
    result = prime * result + no;
    result = prime * result + ((pic == null) ? 0 : pic.hashCode());
    result = prime * result + ((section == null) ? 0 : section.hashCode());
    result = prime * result + ((title == null) ? 0 : title.hashCode());
    result = prime * result + ((userid == null) ? 0 : userid.hashCode());
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
    Board other = (Board) obj;
    if (context == null) {
      if (other.context != null)
        return false;
    } else if (!context.equals(other.context))
      return false;
    if (date == null) {
      if (other.date != null)
        return false;
    } else if (!date.equals(other.date))
      return false;
    if (no != other.no)
      return false;
    if (pic == null) {
      if (other.pic != null)
        return false;
    } else if (!pic.equals(other.pic))
      return false;
    if (section == null) {
      if (other.section != null)
        return false;
    } else if (!section.equals(other.section))
      return false;
    if (title == null) {
      if (other.title != null)
        return false;
    } else if (!title.equals(other.title))
      return false;
    if (userid == null) {
      if (other.userid != null)
        return false;
    } else if (!userid.equals(other.userid))
      return false;
    return true;
  }



  public int getNo() {
    return no;
  }



  public void setNo(int no) {
    this.no = no;
  }



  public String getTitle() {
    return title;
  }



  public void setTitle(String title) {
    this.title = title;
  }



  public String getSection() {
    return section;
  }



  public void setSection(String section) {
    this.section = section;
  }



  public String getContext() {
    return context;
  }



  public void setContext(String context) {
    this.context = context;
  }



  public String getDate() {
    SimpleDateFormat simpleDate = new SimpleDateFormat("yyyy-MM-dd");
    return simpleDate.format(date);
  }

/*
  public void setDate(Date date) {
    this.date = date;
  }

  public void getAddDate(Date date) {
    Calendar calendar = Calendar.getInstance ();
    calendar.setTime (date);
  }*/



  public String getPic() {
    return pic;
  }



  public void setPic(String pic) {
    this.pic = pic;
  }



  public String getUserid() {
    return userid;
  }



  public void setUserid(String userid) {
    this.userid = userid;
  }


  
}


