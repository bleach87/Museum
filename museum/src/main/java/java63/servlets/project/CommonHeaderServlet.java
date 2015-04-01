package java63.servlets.project;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.GenericServlet;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebServlet;

@WebServlet("/common/header")
public class CommonHeaderServlet extends GenericServlet {
  private static final long serialVersionUID = 1L;

  @Override
  public void service(ServletRequest request, ServletResponse response)
      throws ServletException, IOException {

    String webAppPath = 
        this.getServletContext().getContextPath();
    PrintWriter out = response.getWriter();
    
    out.println("<link rel='stylesheet'"); 
    out.println("      href='" + webAppPath
        + "/css/bootstrap.css'>");
    
    out.println("<link rel='stylesheet'"); 
    out.println("      href='" + webAppPath
        + "/css/bootstrap-theme.min.css'>");
    
    out.println("<link rel='stylesheet' href='" + webAppPath
        + "/css/common.css'>");

	
	
	
    
  }

}
