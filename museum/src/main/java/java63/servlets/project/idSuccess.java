package java63.servlets.project;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import javax.servlet.*;

import java.io.*;
import java.net.URLDecoder;


@WebServlet("/login/idSuccess")
public class idSuccess extends GenericServlet 
{  
  private static final long serialVersionUID = 1L;

  @Override
  public void service(ServletRequest req, ServletResponse res)
      throws ServletException, IOException {
 
    req.setCharacterEncoding("UTF-8");
    HttpServletResponse hsr =  (HttpServletResponse)res;
    HttpServletRequest hsrquest = (HttpServletRequest)req;
    Cookie []cokie =  hsrquest.getCookies();
    String name ="";
    
    for( Cookie  ccc : cokie  )
    {
       System.out.println(    "얏 호 " + ccc.getName() + "  "  + ccc.getValue()  );
       if(  ccc.getName().equals("name") ) 
         name = URLDecoder.decode( ccc.getValue(), "euc-kr");
    }
      
    System.out.println( "service  "  + name ); 
    
    res.setContentType("text/html;charset=UTF-8");
    PrintWriter out =  res.getWriter();
    out.println("<HTML>");
    out.println("<HEAD><TITLE> sdfasdf</TITLE></HEAD>");
    out.println("<BODY>");
    out.println("  지금은 메인 화면이에요  "   );
    out.println("  현재 "  +   name + " 님♥  이 로그인 중이여요. "   );
  
    out.println("</BODY>");
    out.println("</HTML>"); 
     
    //System.out.println( "service  "  + name );
     
   
  }
}
