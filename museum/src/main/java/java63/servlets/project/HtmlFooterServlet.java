package java63.servlets.project;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.GenericServlet;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebServlet;

@WebServlet("/common/footer")
public class HtmlFooterServlet extends GenericServlet {
  private static final long serialVersionUID = 1L;

  @Override
  public void service(ServletRequest request, ServletResponse response)
      throws ServletException, IOException {

    PrintWriter out = response.getWriter();
    
    out.println("<address class = 'copyright'><br><br><br><br><br><br>&copy; 이주형, 박기남, 김해경, 윤종익 Museum of Art . All rights reserved.</address>");
	
  }

}
