package java63.servlets.project;

import java.io.IOException;
import java.io.PrintWriter;

import java63.servlets.project.dao.ExhibitionDao;
import java63.servlets.project.domain.Exhibition;

import javax.servlet.GenericServlet;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebServlet;

@WebServlet("/exhibition/view")
public class ExhibitionViewServlet extends GenericServlet {
  private static final long serialVersionUID = 1L;
  static final int PAGE_DEFAULT_SIZE = 3;

  
  @Override
  public void service(ServletRequest request, ServletResponse response)
      throws ServletException, IOException {
    int no = Integer.parseInt(request.getParameter("no"));
    // exhibition exhibition = AppInitServlet.exhibitionDao.selectOne(no);
    ExhibitionDao exhibitionDao = (ExhibitionDao) this.getServletContext()
        .getAttribute("exhibitionDao");
    Exhibition exhibition = exhibitionDao.selectOne(no);
    Exhibition exhibition2 = exhibitionDao.selectOne(no+1);
    Exhibition exhibition3 = exhibitionDao.selectOne(no+2);

    response.setContentType("text/html;charset=UTF-8");
    PrintWriter out = response.getWriter();
    out.println("<html>");
    out.println("<head>");

    // 다른 서블릿을 실행 => 실행 후 제어권이 되돌아 온다.
    RequestDispatcher rd = request.getRequestDispatcher("/exhview/header");
    rd.include(request, response);

    out.println("</head>");
    out.println("<body>");
    out.println("<div class='main_container'>");
    
    /* --------------------------------------------------------------------------   */

	



    
/* --------------------------------------------------------------------------   */
out.println("			<div class='bb-custom-wrapper'>");
out.println("				<div id='bb-bookblock' class='bb-bookblock'>");

/* ----item1----------------------------------------------------------------   */
out.println("					<div class='bb-item' id='item1'>");
out.println("						<div class='content'>");
out.println("							<div class='scroller'>");
 
    out.println("<h2>" + exhibition.getTitle() + "</h2>");
    
    out.println("<div >");
    out.println("<img  id ='aa' src='../img/img0" + exhibition.getNo()
            + "_02.jpg' class='exhibition'/>");
    out.println("</div>");
    
    out.println("<p>" + exhibition.getStartDate() + " ~ "
        + exhibition.getLastDate() + "</p>");
    out.println("<p>" + exhibition.getIntroduction() + "</p>");
    
    out.println("</div>");
    out.println("</div>");
    out.println("</div>");
    /* ------item1----------------------------------------------------------------   */
    
    
    /* ----item2----------------------------------------------------------------   */
    out.println("					<div class='bb-item' id='item2'>");
    out.println("						<div class='content'>");
    out.println("							<div class='scroller'>");
     
        out.println("<h2>" + exhibition2.getTitle() + "</h2>");
        System.out.println(exhibition2.getNo());
        out.println("<img src='../img/img0" + exhibition2.getNo()
                + "_02.jpg' class='exhibition'/>");
        
        out.println("<p>" + exhibition2.getStartDate() + " ~ "
            + exhibition2.getLastDate() + "</p>");
        out.println("<p>" + exhibition2.getIntroduction() + "</p>");
        
        out.println("</div>");
        out.println("</div>");
        out.println("</div>");
        /* ------item2----------------------------------------------------------------   */
        
        
        /* ----item3----------------------------------------------------------------   */
        out.println("					<div class='bb-item' id='item3'>");
        out.println("						<div class='content'>");
        out.println("							<div class='scroller'>");
         
            out.println("<h2>" + exhibition3.getTitle() + "</h2>");
            
            out.println("<img src='../img/img0" + exhibition3.getNo()
                    + "_02.jpg' class='exhibition'/>");
            
            out.println("<p>" + exhibition3.getStartDate() + " ~ "
                + exhibition3.getLastDate() + "</p>");
            out.println("<p>" + exhibition3.getIntroduction() + "</p>");
            
            out.println("</div>");
            out.println("</div>");
            out.println("</div>");
            /* ------item3----------------------------------------------------------------   */
            
    
    out.println("				</div>");
	
    out.println("				<nav>");
    out.println("					<span id='bb-nav-prev'>&larr;</span>");
    out.println("					<span id='bb-nav-next'>&rarr;</span>");
    out.println("				</nav>");

    
    out.println("				<a href ='index'><span class='menu-button'></span></a>");

    out.println("			</div>");
    out.println("</div>");

    out.println("<script src='../js/jquery-1.11.1.js'></script>");

    out.println("</script>");

    out.println("</body>");
    
    rd = request.getRequestDispatcher("/exhview/script");
	rd.include(request, response);
	
    rd = request.getRequestDispatcher("/common/footer");
	rd.include(request, response);

    
    
    out.println("</html>");
  }

}
