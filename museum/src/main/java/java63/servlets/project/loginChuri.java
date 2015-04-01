package java63.servlets.project;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import javax.servlet.*;

import java.io.*;
import java.net.URLEncoder;
import java.util.Date;

import java63.servlets.project.dao.BoardDao;
import java63.servlets.project.dao.ExhibitionDao;
import java63.servlets.project.dao.UserDao;
import java63.servlets.project.domain.Board;
import java63.servlets.project.domain.Exhibition;
import java63.servlets.project.domain.User;

@SuppressWarnings("serial")
@WebServlet("/login/loginChuri")   
public class loginChuri extends GenericServlet 
{ 
  
  @Override
  public void service(ServletRequest request, ServletResponse response)
      throws ServletException, IOException {
   
    request.setCharacterEncoding("UTF-8");
  
    String id = request.getParameter("id").trim();
    String password = request.getParameter("password").trim();
  
    //if( id.equals("") )
   //   System.out.println( "로그인 널임" ); 
          
    System.out.println( "로그인 처리중  " + id + "  " + password );
   
 
    response.setContentType("text/html;charset=UTF-8");
    PrintWriter out =  response.getWriter(); 
    out.println("<html>");
    
    out.println("<head>");
    out.println("<link rel='stylesheet'"); 
    out.println("      href='../../css/bootstrap.min.css'>");
    out.println("<link rel='stylesheet'"); 
    out.println("      href='../../css/bootstrap-theme.min.css'>");
    out.println("<link rel='stylesheet' href='../../css/common.css'>");
    out.println("</head>");
    
    out.println("<body>"); 
      
    UserDao userDao = (UserDao)this.getServletContext()
        .getAttribute("userDao");
 
    boolean loginSuccess = false;
    String tName = new String();
    for (User u : userDao.selectList( 0, 0)) 
    {
      if( u.getUserid().equals( id )  && u.getPassword().equals(password ))
      {
        loginSuccess = true;
        tName = u.getUsername();
        
        System.out.println( " 야호 " +  tName );
      }
    }
  
    if( loginSuccess )
    {
      System.out.println( "로그인 성공 하였습니ㅏ. ");
      
      HttpServletResponse orginReq = (HttpServletResponse)response ;
     
       
      Cookie ccokie1 = new Cookie( "name", URLEncoder.encode(tName, "euc-kr") ) ;
      ccokie1.setPath("/museum");
      orginReq.addCookie( ccokie1 );
      
      System.out.println( "로그인 성공 하였습니ㅏ.  1 ");
      
      Cookie ccokie2 = new Cookie( "id", id  ) ;
      ccokie2.setPath("/museum");
      orginReq.addCookie( ccokie2 );
       
      System.out.println( "로그인 성공 하였습니ㅏ. :  2 ");
      
      Cookie ccokie3 = new Cookie( "password",  password  ) ;
      ccokie3.setPath("/museum");
      orginReq.addCookie(  ccokie3   );
      
      Cookie ccokie4 = new Cookie( "isLogin",  "true"  ) ;
      ccokie4.setPath("/museum");
      orginReq.addCookie( ccokie4  ); 
  
      orginReq.sendRedirect("../exhibition/index");
    }
    else
    {
      System.out.println( "로그인 실패 하였습니ㅏ. ");
      
      out.println("<script>");
       
      if( id.equals("") || password.equals(""))
      {
        out.println("alert( ' 아이디와 비밀번호를 전부 입력해주세요'); ");
      }
      else
      { 
        out.println("alert( '아이디와 비밀번호가 일치하지 않습니다'); ");
      }
      
      // out.println("window.setTimeout(function(){"); 
      out.println("  window.location.href = '../board/login.html';");
      //out.println("}, 3000);");
      out.println("</script>");
      
    }
     
    
    out.println("</body>");
    out.println("</html>");
      
  }
}
