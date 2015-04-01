package java63.servlets.project;

import java.io.IOException;
import java.io.PrintWriter;

import java63.servlets.project.dao.ExhibitionDao;
import java63.servlets.project.domain.Exhibition;

import javax.servlet.GenericServlet; 
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebServlet;

@WebServlet("/exhibition/list")
public class ExhibitionListServlet extends GenericServlet {
  private static final long serialVersionUID = 1L;

  static final int PAGE_DEFAULT_SIZE = 3;
  
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
    out.println("<html>");
    out.println("<head>");

    /*
    // 다른 서블릿을 실행 => 실행 후 제어권이 되돌아 온다.
    RequestDispatcher rd = request.getRequestDispatcher("/common/header");
    rd.include(request, response);
    */
    
    out.println("</head>");
    out.println("<body>");
    out.println("<div class='container'>");
    out.println("<h1>전시 목록</h1>");
    out.println("<table class='table table-hover'>");
    out.println("<tr>");
    out.println("  <th>#</th><th>제목</th><th>마지막일</th><th>조회수</th>");
    out.println("</tr>");
    
    
    ExhibitionDao exhibitionDao = (ExhibitionDao)this.getServletContext()
                                         .getAttribute("exhibitionDao");
    
    for (Exhibition exhibition : exhibitionDao.selectList(pageNo, pageSize)) {
      out.println("<tr>");
      out.println("  <td>" + exhibition.getNo() + "</td>");
      out.println("  <td><a href='view?no=" + exhibition.getNo() + "'>" 
            + exhibition.getTitle() + "</a></td>");
      out.println("  <td>" + exhibition.getLastDate() + "</td>");
      out.println("  <td>" + exhibition.getCount() + "</td>");
      out.println("</tr>");

    }
    out.println("</table>");
    
    /*
    rd = request.getRequestDispatcher("/common/footer");
    rd.include(request, response);
    */
    
    out.println("</div>");
    
    out.println("<script src='../../js/jquery-1.11.1.js'></script>");
    
    
    out.println("</body>");
    out.println("</html>");
    System.out.println("service() 실행 완료");
  }
  
}












