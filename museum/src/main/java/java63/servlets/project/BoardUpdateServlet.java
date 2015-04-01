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

@WebServlet("/board/update")
public class BoardUpdateServlet extends GenericServlet {
  private static final long serialVersionUID = 1L;

  @Override
  public void service(ServletRequest request, ServletResponse response)
      throws ServletException, IOException {
    // 다음 코드는 필터로 대체함.
    //request.setCharacterEncoding("UTF-8");
	  
	  Board board = new Board();
	   
    board.setNo(Integer.parseInt(request.getParameter("no")));
    board.setTitle(request.getParameter("title"));
    board.setSection(request.getParameter("section"));
    board.setContext(request.getParameter("context"));
    board.setPic(request.getParameter("pic"));
    
    // AppInitServlet.boardDao.update(board);
    BoardDao boardDao = 
        (BoardDao)this.getServletContext().getAttribute("boardDao");
    
    boardDao.update(board);
    
    HttpServletResponse orginResponse = (HttpServletResponse)response;
    orginResponse.sendRedirect("../exhibition/index");
    
  }
  
}

