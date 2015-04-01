package java63.servlets.project;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.GenericServlet;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebServlet;

@WebServlet("/table/header")
public class TableHeaderServlet extends GenericServlet {
  private static final long serialVersionUID = 1L;

  @Override
  public void service(ServletRequest request, ServletResponse response)
      throws ServletException, IOException {

    String webAppPath = 
        this.getServletContext().getContextPath();
    PrintWriter out = response.getWriter();
    
	out.println("<link rel='stylesheet' type='text/css' href='" + webAppPath + 	"/css/table_normalize.css' />");
	//out.println("<link rel='stylesheet' type='text/css' href='" + webAppPath +	"/css/table_demo.css' />");
	out.println("<link rel='stylesheet' type='text/css' href='" + webAppPath +	"/css/table_component.css' />");
	out.println("<script src='" + webAppPath + "/js/modernizr.custom.js'></script>");
	
	

	
	
	
    
  }

}
