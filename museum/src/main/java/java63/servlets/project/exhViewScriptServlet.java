package java63.servlets.project;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.GenericServlet;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebServlet;

/*	Include에 사용할 t 서블릿
 *  =>HTML 페이지의 권리 안내문 메시지 출력을 맡는다.
 *  
*/
@WebServlet("/exhview/script")
public class exhViewScriptServlet extends GenericServlet{

	private static final long serialVersionUID = 1L;

	@Override
	public void service(ServletRequest request, ServletResponse response)
			throws ServletException, IOException {
		
		String webAppPath = this.getServletContext().getContextPath();
		PrintWriter out = response.getWriter();
		
		
		out.println("			<script src='" + webAppPath +
				"/js/exhView/modernizr.custom.79639.js'></script>");
		
		out.println("<script src='http://ajax.googleapis.com/ajax/libs/jquery/1.8.3/jquery.min.js'></script>");
		out.println("		<script src='" + webAppPath +
				"/js/exhView/jquery.mousewheel.js'></script>");
		out.println("		<script src='" + webAppPath +
				"/js/exhView/jquery.jscrollpane.min.js'></script>");
		out.println("		<script src='" + webAppPath +
				"/js/exhView/jquerypp.custom.js'></script>");
		out.println("		<script src='" + webAppPath +
				"/js/exhView/jquery.bookblock.js'></script>");
		out.println("		<script src='" + webAppPath +
				"/js/exhView/page.js'></script>");
		
		out.println("		<script>");
		out.println("			$(function() {");
		out.println("				Page.init();");
		out.println("			});");
		out.println("		</script>");
				
		
		
		
		
	}

}
