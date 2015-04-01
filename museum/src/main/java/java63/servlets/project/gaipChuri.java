package java63.servlets.project;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import javax.servlet.*;

import java.io.*;
import java.util.Date;

import java63.servlets.project.dao.BoardDao;
import java63.servlets.project.dao.UserDao;
import java63.servlets.project.domain.Board;
import java63.servlets.project.domain.User;

@WebServlet("/login/gaipChuri")
public class gaipChuri extends GenericServlet 
{ 

  @Override
  public void service(ServletRequest request, ServletResponse response)
      throws ServletException, IOException {

    request.setCharacterEncoding("UTF-8");

    String name = request.getParameter("name").trim();
    String id = request.getParameter("id").trim();
    String password = request.getParameter("password").trim();
    String email = request.getParameter("email").trim();
 
    HttpServletResponse orginResponse = (HttpServletResponse)response ;
  
    User user = new User();
    user.setUserid(   id  );
    user.setUsername(   name );
    user.setPassword(  password  );
    user.setEmail(  email  );

    UserDao userDao = 
        (UserDao)this.getServletContext().getAttribute("userDao");


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

  
    try 
    {
      if( name.equals("") || id.equals("") || password.equals("") || email.equals("") )
      { 
        System.out.println( "가입 처리중 0 " ); 
        out.println("<script>");
        out.println(" alert('네 항목 모두 입력해주세요'); "); 
        out.println("</script>");
      }
      else
      { 
        System.out.println( "가입 처리중 1 " ); 
        
        boolean zungbokUpda = true;
        for (User u : userDao.selectList( 0, 0)) 
        {
          System.out.println( " 중복 검사  " + u.getUserid() + "  " + id ); 
          
          if( u.getUserid().equals( id )  )
          { 
            zungbokUpda = false;
          }
        }

        if( zungbokUpda    )
        {
          System.out.println( "가입 처리중 2" ); 
          
          userDao.insert(user); 
          out.println("<h1> 가입 성공했습니다.  </h1>"); 
          
          out.println("<script>"); 
          //out.println("window.setTimeout(function(){");
          out.println("  window.location.href = '../exhibition/index';");
         // out.println("}, 2000);");
          out.println("</script>"); 
        }
        else
        {
          System.out.println( "가입 처리중 3 " ); 
         // out.println("<html>");
         // out.println("<body>"); 
          //out.println("<script>");
          
         // out.println("<h1> 아이디가 중복됩니다.  </h1>");
          //out.println(" alert('아이디가 중복됩니다.'); "); 
          
          out.println("<script>"); 
          out.println(" alert('아이디가 중복됩니다.'); "); 
          //out.println("window.setTimeout(function(){");
          out.println("  window.location.href = '../board/login.html';");
         // out.println("}, 2000);");
          out.println("</script>"); 
        }
        
       
        
      } 
    } catch (Exception e) {
      RequestDispatcher rd = 
          request.getRequestDispatcher("/common/error");
      request.setAttribute("error", e);
      rd.forward(request, response);  
    }  
    
    out.println("</body>");
    out.println("</html>");

    //orginResponse.sendRedirect("loginZun");

  }
}
