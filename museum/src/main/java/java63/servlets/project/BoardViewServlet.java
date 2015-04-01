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
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;

@WebServlet("/board/view")
public class BoardViewServlet extends GenericServlet {
  private static final long serialVersionUID = 1L;

  @Override
  public void service(ServletRequest request, ServletResponse response)
      throws ServletException, IOException {
    int no = Integer.parseInt(request.getParameter("no"));
//    board board = AppInitServlet.boardDao.selectOne(no);
    BoardDao boardDao = 
        (BoardDao)this.getServletContext().getAttribute("boardDao");
    Board board = boardDao.selectOne(no);
    
    
    
	  HttpServletRequest hsrquest = (HttpServletRequest)request;
	    Cookie[] cokie =  hsrquest.getCookies();
	    String uuser ="";
	    if( cokie != null )
	    {
	      //System.out.println(    " bbblost" + cokie.length );
	      for( Cookie  ccc : cokie  )
	      {
	         //System.out.println(    "얏 호 " + ccc.getName() + "  "  + ccc.getValue()  );
	         if(  ccc.getName().equals("id") ) 
	           uuser =  ccc.getValue() ;
	      }
	    }

	
	   
	     System.out.println(uuser+"쿠키");
	    System.out.println(board.getUserid() +"게시물");
	    System.out.println(    " bbblost : 2" );
	    
    
    response.setContentType("text/html;charset=UTF-8");
    PrintWriter out = response.getWriter();
    out.println("<html>");
    out.println("<head>");
    
    // 다른 서블릿을 실행 => 실행 후 제어권이 되돌아 온다.
    RequestDispatcher rd = request.getRequestDispatcher("/common/header");
	rd.include(request, response);
    
    out.println("</head>");
    out.println("<body>");
    out.println("<div class='container'>");
    out.println("<h1>게시물 정보</h1>");
    
    out.println("<form class='form-horizontal' role='form' "
        + "action='update' method='post'>");
    out.println("<div class='form-group'>");
    out.println("  <label for='no' class='col-sm-2 control-label'>번호</label>");
    out.println("  <div class='col-sm-10'>");
    out.println("    <input type='text' class='form-control' readonly ");
    out.println("        id='no' name='no' value='" + board.getNo() + "'>");
    out.println("  </div>");
    out.println("</div>");
  
    out.println("<div class='form-group'>");
    out.println("  <label for='userid' class='col-sm-2 control-label'>ID</label>");
    out.println("  <div class='col-sm-10'>");
    out.println("    <input type='text' class='form-control' readonly");
    out.println("        id='userid' name='userid' value='" + board.getUserid() + "'>");
    out.println("  </div>");
    out.println("</div>");

    out.println("<div class='form-group'>");
    out.println("  <label for='title' class='col-sm-2 control-label'>제목</label>");
    out.println("  <div class='col-sm-10'>");
    out.println("    <input type='text' class='form-control' ");
    out.println("        id='title' name='title' value='" + board.getTitle() + "'>");
    out.println("  </div>");
    out.println("</div>");
    
    out.println("<div class='form-group'>");
    out.println("  <label for='section' class='col-sm-2 control-label'>분류</label>");
    out.println("  <div class='col-sm-10'>");
    out.println("   <input type='text' class='form-control' ");
    out.println("        id='section' name='section' value='" + board.getSection() + "'>");
    out.println("  </div>");
    out.println("</div>");
    
    out.println("<div class='form-group'>");
    out.println("  <label for='context' class='col-sm-2 control-label'>내용</label>");
    out.println("  <div class='col-sm-10'>");
    out.println("   <input type='textarea' class='form-control' ");
    out.println("        id='context' name='context' value='" + board.getContext() + "'>");
    out.println("  </div>");
    out.println("</div>");
 /*   
    out.println("<div class='form-group'>");
    out.println("  <label for='pic' class='col-sm-2 control-label'>사진</label>");
    out.println("  <div class='col-sm-10'>");
    out.println("   <input type='pic' class='form-control' ");
    out.println("        id='pic' name='pic' value='" + board.getPic() + "'>");
    out.println("  </div>");
    out.println("</div>");
    */
    out.println("<div class='form-group'>");
    out.println("  <label for='date' class='col-sm-2 control-label' readonly>날짜</label>");
    out.println("  <div class='col-sm-10'>");
    out.println("   <input type='date' class='form-control' ");
    out.println("        id='date' name='date' value='" + board.getDate() + "'>");
    out.println("  </div>");
    out.println("</div>");
    
    out.println("<div class='form-group'>");
    out.println("  <div class='col-sm-offset-2 col-sm-10'>");
    out.println("    <button id='btnUpdate' type='submit' class='btn btn-primary'>변경</button>");
    out.println("    <button id='btnDelete' type='button' class='btn btn-primary'>삭제</button>");
    out.println("    <button id='btnCancel' type='button' class='btn btn-primary'>취소</button>");
    out.println("  </div>");
    out.println("</div>");
    
    out.println("</form>");
    out.println("</div>");
    
    out.println("<script src='../js/jquery-1.11.1.js'></script>");
    
    out.println("<script>");
    out.println("  $('#btnCancel').click(function(){");
    out.println("    history.back();");
    out.println("  });");
    

    
    
    out.println("  $('#btnDelete').click(function(){");
    
    
/* 
    out.println("    if (board.getUserid() != uuser) {");
    out.println("      alert('ID틀림');");
    out.println("      return false;");
    out.println("    }");*/
    
    out.println("    if (window.confirm('삭제하시겠습니까?')) {");
    out.println("      location.href = 'delete?no=" +  board.getNo() + "'");
    out.println("    }");
    
  
    
    
    out.println("  });");
    
    out.println("  $('#btnUpdate').click(function(){");

    
    out.println("      alert($('#userid').val());");
   
    out.println("    if ( $('#userid').val().length == 0) {");
    out.println("      alert('Please Write YOUR ID');");
    out.println("      return false;");
    out.println("    }");
        
    out.println("    if ( $('#title').val().length == 0) {");
    out.println("      alert('Please Write TITLE');");
    out.println("      return false;");
    out.println("    }");
        
    out.println("    if ( $('#section').val().length == 0) {");
    out.println("      alert('Please Select SECTION');");
    out.println("      return false;");
    out.println("    }");
    
    out.println("    if ( $('#context').val().length == 0) {");
    out.println("      alert('Please Write CONTEXT');");
    out.println("      return false;");
    out.println("    }");
    out.println("  });");
    
    out.println("</script>");
    
    out.println("</body>");
    out.println("</html>");
  }
  
}
