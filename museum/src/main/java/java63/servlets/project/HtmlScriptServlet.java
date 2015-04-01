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
@WebServlet("/common/script")
public class HtmlScriptServlet extends GenericServlet{

	private static final long serialVersionUID = 1L;

	@Override
	public void service(ServletRequest request, ServletResponse response)
			throws ServletException, IOException {
		
		String webAppPath = this.getServletContext().getContextPath();
		PrintWriter out = response.getWriter();
		
		
		
		out.println("<script src='" + webAppPath+ "/js/cbpHorizontalSlideOutMenu.min.js'></script>");
		out.println("<script>");
		out.println("			var menu = new cbpHorizontalSlideOutMenu( document.getElementById( 'cbp-hsmenu-wrapper' ) ); ");
		out.println("		</script>	");
		        	
		
		out.println("<script src='" + webAppPath + 	"/js/jquery.stickyheader.js'></script>");
		
		out.println("        <script type='text/javascript' src='http://ajax.googleapis.com/ajax/libs/jquery/1.7.0/jquery.min.js'></script>");
		out.println("        <script type='text/javascript' src='" + webAppPath + 	"/js/jquery.eislideshow.js'></script>");
		out.println("        <script type='text/javascript' src='" + webAppPath + 	"/js/jquery.easing.1.3.js'></script>");
		        

		
		out.println("<script type='text/javascript'>");
		out.println(" $(function() {");
		out.println("      $('#ei-slider').eislideshow({");
		out.println("			animation			: 'center',");
		out.println("			autoplay			: true,");
		out.println("			slideshow_interval	: 3000,");
		out.println("			titlesFactor		: 0");
		out.println("      });");
		out.println("   });");
		out.println("  </script>");

		
		
		
		
	}

}
