package java63.servlets.project;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import javax.servlet.*;

import java.io.*;

@WebServlet("/login/loginZun")
public class loginZun extends HttpServlet 
{ 
  @Override
  protected void doGet(HttpServletRequest req, HttpServletResponse response )
      throws ServletException, IOException {
   
    
    response.setContentType("text/html;charset=UTF-8");
    PrintWriter out = response.getWriter();
    out.println("<HTML>");
    out.println("<HEAD><TITLE> sdfasdf</TITLE></HEAD>");
    out.println("<BODY>");
    out.println(" <h1> 로그인 화면입니다.  </h1> "   );
    out.println(" <a href ='login.html'> 로그인 하기 </a>   <p>"   );
    out.println(" <a href ='gaip.html'> 회원 가입하기 </a>   "   );
    out.println("</BODY>");
    out.println("</HTML>");
  }
  
   /*public void doGet(HttpServletRequest request, HttpServletResponse response) 
                             throws IOException, ServletException {
       // int total = 0;
        //for (int cnt = 1; cnt < 101; cnt++)
        //    total += cnt;
       
    } */
}
