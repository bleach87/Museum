/* Value Object
 * => Class 문법을 사용하여 사용자 정의 데이터 타입 만들기
 * 
 * 1) Serializable 인터페이스 구현
 *    => SerialVersionUID 스태틱 변수 선언
 * 
 * 2) 인스턴스 변수 선언
 * 
 * 3) setter/getter 생성
 * 
 * 4) 기본 생성자와 파라미터 값을 받는 생성자 선언
 * 
 * 5) equals()/hashCode() 메서드 오버라이딩
 * 
 * 6) toString() 오버라이딩
 */
package java63.servlets.project.domain;

import java.io.Serializable;
 
public class Exhibition implements Serializable, Cloneable {

  private static final long serialVersionUID = 1L;
  
  protected int       no;  // 전시숫자
  protected String    title;  // 제목
  protected String      startDate;  
  protected String      lastDate;  
  protected String    introduction;  // 전시소개
  protected int       count; 
  protected String    image;
  
  public Exhibition() {};
  
  public Exhibition(int no, String title, String startDate, String lastDate,
      String introduction, int count, String image) {
    super();
    this.no = no;
    this.title = title;
    this.startDate = startDate;
    this.lastDate = lastDate;
    this.introduction = introduction;
    this.count = count;
    this.image = image;
     
  
  }
  
  @Override
  public Exhibition clone() throws CloneNotSupportedException {
    return (Exhibition) super.clone();
  }
  
  @Override
  public int hashCode() {
    final int prime = 31;
    int result = 1;
    result = prime * result + count;
    result = prime * result + ((image == null) ? 0 : image.hashCode());
    result = prime * result
        + ((introduction == null) ? 0 : introduction.hashCode());
    result = prime * result + ((lastDate == null) ? 0 : lastDate.hashCode());
    result = prime * result + no;
    result = prime * result + ((startDate == null) ? 0 : startDate.hashCode());
    result = prime * result + ((title == null) ? 0 : title.hashCode());
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
    Exhibition other = (Exhibition) obj;
    if (count != other.count)
      return false;
    if (image == null) {
      if (other.image != null)
        return false;
    } else if (!image.equals(other.image))
      return false;
    if (introduction == null) {
      if (other.introduction != null)
        return false;
    } else if (!introduction.equals(other.introduction))
      return false;
    if (lastDate == null) {
      if (other.lastDate != null)
        return false;
    } else if (!lastDate.equals(other.lastDate))
      return false;
    if (no != other.no)
      return false;
    if (startDate == null) {
      if (other.startDate != null)
        return false;
    } else if (!startDate.equals(other.startDate))
      return false;
    if (title == null) {
      if (other.title != null)
        return false;
    } else if (!title.equals(other.title))
      return false;
    return true;
  }

  @Override
  public String toString() {
    return "Exhibitions [no=" + no + ", title=" + title + ", startDate="
        + startDate + ", lastDate=" + lastDate + ", introduction="
        + introduction + ", count=" + count + ", image=" + image + "]";
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
  public String getStartDate() {
    return startDate;
  }
  public void setStartDate(String startDate) {
    this.startDate = startDate;
  }
  public String getLastDate() {
    return lastDate;
  }
  public void setLastDate(String lastDate) {
    this.lastDate = lastDate;
  }
  public String getIntroduction() {
    return introduction;
  }
  public void setIntroduction(String introduction) {
    this.introduction = introduction;
  }
  public int getCount() {
    return count;
  }
  public void setCount(int count) {
    this.count = count;
  }
  public String getImage() {
    return image;
  }
  public void setImage(String image) {
    this.image = image;
  } 
  
  

  
  
  
}













