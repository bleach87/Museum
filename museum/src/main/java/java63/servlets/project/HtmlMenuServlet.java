package java63.servlets.project;

import java.io.IOException;
import java.io.PrintWriter;
import java.net.URLDecoder;
import java.net.URLEncoder;

import javax.servlet.GenericServlet;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;

/*	Include에 사용할 t 서블릿
 *  =>HTML 페이지의 권리 안내문 메시지 출력을 맡는다.
 *  
*/
@WebServlet("/exhibition/index")
public class HtmlMenuServlet extends GenericServlet{

	private static final long serialVersionUID = 1L;

	@Override
	public void service(ServletRequest request, ServletResponse response)
			throws ServletException, IOException {
		
		String webAppPath = this.getServletContext().getContextPath();
		response.setContentType("text/html;charset=UTF-8");
		PrintWriter out = response.getWriter();
		
		   /*------------------------------------------------------------------------------*/
		
		
		
		HttpServletRequest hsrquest = (HttpServletRequest)request;

		 Cookie[] cokie =  hsrquest.getCookies();

		    String name ="";
		    String isLogin ="";
		    if( cokie != null )
		    {

		      System.out.println(    " bbblost" + cokie.length );
		      for( Cookie  ccc : cokie  )
		      {
		         System.out.println(    "얏 호 " + ccc.getName() + "  "  + ccc.getValue()  );
		         if(  ccc.getName().equals("name") ) 
		        	 name =  URLDecoder.decode( 	ccc.getValue() , "euc-kr" );
		         else   if(  ccc.getName().equals("isLogin") ) 
		        	 isLogin =  ccc.getValue() ;
		      }
		    }
		    else
		      System.out.println(    " bbblost : 2" );
		
		    /*------------------------------------------------------------------------------*/
		
		
		
		
		out.println("<html>");
		out.println("<head>");
		
		//다른 서블릿을 실행 => 실행 후 제어권이 되돌아 온다.
		RequestDispatcher rd = request.getRequestDispatcher("/exhibition/header");
		rd.include(request, response);
		
		out.println("</head>");

		out.println("<body>");
		
		out.println("		<div class='container'>");
		
		out.println("			<header class='clearfix'>");
		out.println("				<a href = ''>");
		out.println("					<img src = '" + webAppPath + "/images/logo.png' />");
		out.println("				</a>");
		out.println("				<nav>");
		
		
		if( isLogin.equals("true")){
			out.println("						<p>Welcome To Our Art Hall Mr(s)." + name +	" </p>");
		}
		else {
			out.println("					<a href ='" + webAppPath + 	"/board/login.html'>");
			out.println("						<p>Sign In / Registe</p>");
			out.println("					</a>");
		}
		
		
		out.println("				</nav>");
		out.println("			</header>	 ");
					
		out.println("			<div class='main'>");
		out.println("				<nav class='cbp-hsmenu-wrapper' id='cbp-hsmenu-wrapper'>");
		out.println("					<div class='cbp-hsinner'>");
		out.println("						<ul class='cbp-hsmenu'>");
								
		out.println("							<li>");
		out.println("								<a href='#'>Louvre Museum</a>");
		out.println("							<ul class='cbp-hssubmenu'>");
		out.println("									<li><a href='view?no=1'><img src='" + webAppPath +	
				"/img/img01_02.jpg' alt='img01'/><span>Horaires et tarifs</span></a></li>");
		
		out.println("									<li><a href='view?no=3'><img src='" + webAppPath +
				"/img/img03_02.jpg' alt='img02'/><span>Préparer sa visite</span></a></li>");
		
		out.println("									<li><a href='view?no=7'><img src='" + webAppPath +
				"/img/img07_02.jpg' alt='img03'/><span>Louvre, mode demploi</span></a></li>");
		out.println("								</ul>");
		out.println("							</li>");
		
		out.println("							<li>");
		out.println("								<a href='#'>MoMA Museum</a>");
		out.println("								<ul class='cbp-hssubmenu cbp-hssub-rows'>");
		out.println("									<li><a href='view?no=9'><img src='" + webAppPath +
				"/img/img09_02.jpg' alt='img03'/><span>Untitled Leg</span></a></li>");
		
		out.println("									<li><a href='view?no=11'><img src='" + webAppPath +
				"/img/img011_02.jpg' alt='img03'/><span>The Persistence of Memory</span></a></li>");
		
		out.println("									<li><a href='view?no=13'><img src='" + webAppPath + 
				"/img/img013_02.jpg' alt='img03'/><span>Untitled</span></a></li>");
		out.println("								</ul>");
		out.println("							</li>");
		
									
		out.println("							<li>");
		out.println("								<a href='#'>Community</a>");
		out.println("							<ul class='cbp-hssubmenu'>");
									
		rd = request.getRequestDispatcher("/board/list");
		rd.include(request, response);
									
		out.println("							</ul>");
		out.println("							</li>");
								
		out.println("					</div>");
		out.println("				</nav>");
		out.println("			</div>");
		out.println("		</div>");
				
		
		out.println("		 <div class='container'>");

		out.println("           <div class='wrapper'>");
		out.println("                <div id='ei-slider' class='ei-slider'>");
		out.println("                   <ul class='ei-slider-large'>");
		out.println("						<li>");
		out.println("                          	<img src='" +webAppPath +
				"/images/img_m/img01_01.jpg' alt='image01'/>");
		
		out.println("                          		<div class='ei-title' >");
		out.println("                             		 	<h2 class = 'aa'>Louvre </h2>");
		out.println("                              		<h3>mode d’emploi</h3>");
		out.println("                          		</div>");
		out.println("                     </li>");
		                        
		out.println("                      <li>");
		out.println("                         <img src='" +webAppPath +
				"/images/img_m/img02_01.jpg' alt='image02_01' />");
		
		out.println("                          <div class='ei-title'>");
		out.println("                              <h2>Creative</h2>");
		out.println("                              <h3>Duet</h3>");
		out.println("                         </div>");
		out.println("                       </li>");
		out.println("                      <li>");
		out.println("                            <img src='" + webAppPath +
				"/images/img_m/img04_01.jpg' alt='image04_01' />");
		
		out.println("                            <div class='ei-title'>");
		out.println("                                <h2>Friendly</h2>");
		out.println("                               <h3>Devil</h3>");
		out.println("                           </div>");
		out.println("                       </li>");
		out.println("                      <li>");
		out.println("                         <img src='" + webAppPath +
				"/images/img_m/img05_01.jpg' alt='image05_01'/>");
		
		out.println("                          <div class='ei-title'>");
		out.println("                             <h2>Vincent van Gogh</h2>");
		out.println("                             <h3>The Starry Night</h3>");
		                           
		out.println("              </div>");
		out.println("                </li>");
		out.println("                 <li>");
		out.println("                <img src='" + webAppPath +
				"/images/img_m/img07_01.jpg' alt='image07_01'/>");
		
		out.println("                <div class='ei-title'>");
		out.println("                   <h2>Insecure</h2>");
		out.println("                    <h3>Hussler</h3>");
		out.println("                  </div>");
		out.println("              </li>");
		out.println("              <li>");
		out.println("                  <img src='" +webAppPath +
				"/images/img_m/img08_01.jpg' alt='image08_01'/>");
		
		out.println("                 <div class='ei-title'>");
		out.println("                  <h2>Loving</h2>");
		out.println("                  <h3>Rebel</h3>");
		out.println("                   </div>");
		out.println("               </li>");
		out.println("              <li>");
		out.println("                <img src='" + webAppPath +
				"/images/img_m/img09_01.jpg' alt='image09_01'/>");
		
		out.println("                <div class='ei-title'>");
		out.println("                    <h2>Crazy</h2>");
		out.println("                    <h3>Friend</h3>");
		out.println("                 </div>");
		out.println("            </li>");
		out.println("           </ul>");
		out.println("            <ul class='ei-slider-thumbs'>");
		out.println("               <li class='ei-slider-element'>Current</li>");
		
		
		out.println("				<li><a href='#'>Slide 1</a><img src='" +webAppPath +
				"/images/img_m/img01_01.jpg' alt='thumb06' /></li>");
		
		out.println("              <li><a href='#'>Slide 2</a><img src='" +webAppPath +
				"/images/img_m/img02_01.jpg' alt='thumb01' /></li>");
		
		out.println("               <li><a href='#'>Slide 4</a><img src='" + webAppPath +
				"/images/img_m/img04_01.jpg' alt='thumb02' /></li>");
		
		out.println("               <li><a href='#'>Slide 5</a><img src='" + webAppPath +
				"/images/img_m/img05_01.jpg' alt='thumb03' /></li>");
		
		out.println("               <li><a href='#'>Slide 7</a><img src='" + webAppPath +
				"/images/img_m/img07_01.jpg' alt='thumb04' /></li>");
		
		out.println("           <li><a href='#'>Slide 8</a><img src='" + webAppPath +
				"/images/img_m/img08_01.jpg' alt='thumb05' /></li>");
		
		out.println("             <li><a href='#'>Slide 9</a><img src='" + webAppPath +
				"/images/img_m/img09_01.jpg' alt='thumb07' /></li>");
		out.println("          </ul>");
		
		out.println("          </div>");
		             
		out.println("        </div>");
		out.println("     </div>");
		
		out.println("</body>");
		
		rd = request.getRequestDispatcher("/common/script");
		rd.include(request, response);
		
	    rd = request.getRequestDispatcher("/common/footer");
		rd.include(request, response);

	
	
		out.println("</html>");
		
	}

}
