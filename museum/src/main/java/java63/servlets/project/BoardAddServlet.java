package java63.servlets.project;

import java.io.IOException;
import java63.servlets.project.dao.BoardDao;
import java63.servlets.project.domain.Board;

import javax.servlet.GenericServlet;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/board/add")
public class BoardAddServlet extends GenericServlet {
  private static final long serialVersionUID = 1L;

  @Override
  public void service(ServletRequest request, ServletResponse response)
      throws ServletException, IOException {
    // 다음 코드는 필터로 대체함.
    // request.setCharacterEncoding("UTF-8");
    //Date date = new Date();
    
    Board board = new Board();
    
    
    
    HttpServletRequest hsrquest = (HttpServletRequest)request;
    Cookie[] cokie =  hsrquest.getCookies();
    String uuser ="";
    if( cokie != null )
    {
      //System.out.println(    " bbblost" + cokie.length );
      for( Cookie  ccc : cokie  )
      {
         //System.out.println(    "얏 호 " + ccc.getName() + "  "  + ccc.getValue()  );
         if(  ccc.getName().equals("id") ) 
           uuser =  ccc.getValue() ;
      }
    }
    else
      System.out.println(    " bbblost : 2" );
    

    
    
    board.setUserid( uuser );
     
    board.setTitle(request.getParameter("title"));
    board.setSection(request.getParameter("section"));
    board.setContext(request.getParameter("context"));
    //board.setDate(date);
    
    // AppInitServlet.boardDao.insert(board);
    // ContextLoaderListener.boardDao.insert(board);
    
    // boardDao를 ServletContext 보관소에서 꺼내는 방식을 사용
    // => 단점 => 위의 방식보다 코드가 늘었다.
    // => 장점 : 특정 클래스에 종속되지 않는다.=> 유지보수에서 더 중요
    BoardDao boardDao = 
        (BoardDao)this.getServletContext().getAttribute("boardDao");
    
    try {
    boardDao.insert(board);
    } catch (Exception e) {
      RequestDispatcher rd = 
          request.getRequestDispatcher("/common/loginerror");
      request.setAttribute("error", e);
      rd.forward(request, response);
      
    }
    
    HttpServletResponse orginResponse = (HttpServletResponse)response;
    orginResponse.sendRedirect("../exhibition/index");
    
    
  }
  
}

