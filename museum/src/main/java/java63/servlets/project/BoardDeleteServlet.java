package java63.servlets.project;

import java.io.IOException;
import java.io.PrintWriter;
import java63.servlets.project.dao.BoardDao;

import javax.servlet.GenericServlet;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/board/delete")
public class BoardDeleteServlet extends GenericServlet {
  private static final long serialVersionUID = 1L;

  @Override
  public void service(ServletRequest request, ServletResponse response)
      throws ServletException, IOException {
    int no = Integer.parseInt(request.getParameter("no"));
    // AppInitServlet.boardDao.delete(no);
    // ContextLoaderListener.boardDao.delete(no);

    // BoardDao를 ServletContext 보관소에서 꺼내는 방식을 사용
    // => 단점 => 위의 방식보다 코드가 늘었다.
    // => 장점 : 특정 클래스에 종속되지 않는다.=> 유지보수에서 더 중요
    BoardDao boardDao = (BoardDao) this.getServletContext()
                            .getAttribute("boardDao");
    boardDao.delete(no);
 
    response.setContentType("text/html;charset=UTF-8");
    PrintWriter out = response.getWriter();
    out.println("<html>");
    out.println("<head>");
    out.println("<link rel='stylesheet'");
    out.println("      href='../../css/bootstrap.min.css'>");
    out.println("<link rel='stylesheet'");
    out.println("      href='../../css/bootstrap-theme.min.css'>");
    out.println("<link rel='stylesheet' href='../../css/common.css'>");
    out.println("</head>");
    out.println("<body>");
    out.println("<div class='container'>");
    out.println("<h1>삭제 결과</h1>");
    out.println("<p>    삭제하였습니다.</P>");
    out.println("    </div>");

    out.println("</body>");
    out.println("</html>");
    
    HttpServletResponse orginResponse = (HttpServletResponse)response;
    orginResponse.sendRedirect("../exhibition/index");
    
  }

}
