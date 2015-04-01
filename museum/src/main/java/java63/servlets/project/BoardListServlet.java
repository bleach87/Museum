package java63.servlets.project;

import java.io.IOException;
import java.io.PrintWriter;
import java63.servlets.project.dao.BoardDao;
import java63.servlets.project.domain.Board;

import javax.servlet.GenericServlet;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebServlet;

@WebServlet("/board/list")
public class BoardListServlet extends GenericServlet {
  private static final long serialVersionUID = 1L;

  static final int PAGE_DEFAULT_SIZE = 20;
  
  @Override
  public void service(ServletRequest request, ServletResponse response)
      throws ServletException, IOException {
    System.out.println("service() 실행 시작");
    int pageNo = 0;
    int pageSize = 0;
    
    if (request.getParameter("pageNo") != null) {
      pageNo = Integer.parseInt(request.getParameter("pageNo"));
      pageSize = PAGE_DEFAULT_SIZE;
    }
    
    if (request.getParameter("pageSize") != null) {
      pageSize = Integer.parseInt(request.getParameter("pageSize"));
    }
    
    response.setContentType("text/html;charset=UTF-8");
    PrintWriter out = response.getWriter();
    
    
	RequestDispatcher rd = request.getRequestDispatcher("/table/header");
	rd.include(request, response);
    
    out.println("<div class='component'>");
    out.println("<button><a href='../board/board-form.html' class='btn btn-primary'>Write</a></button>");
    out.println("<table>");
    out.println("<tr>");
    out.println("  <th>#</th><th>분류</th><th>ID</th><th>제목</th><th>날짜</th>");
    
    out.println("</tr>");
    
    BoardDao boardDao = 
        (BoardDao)this.getServletContext().getAttribute("boardDao");
    
    for (Board board : boardDao.selectList(pageNo, pageSize)) {
      out.println("<tr>");
      out.println("  <td >" + board.getNo() + "</td>");
      out.println("  <td >" + board.getSection() + "</td>");
      out.println("  <td>" + board.getUserid() + "</td>");
      out.println("  <td><a href='../board/view?no=" + board.getNo() + "'>" 
            + board.getTitle() + "</a></td>");
      out.println("  <td >" + board.getDate() + "</td>");
      out.println("</tr>");
    }
    out.println("</table>");
    out.println("</div>");
    
  }
  
}
