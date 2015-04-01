package java63.servlets.project;

import java.io.InputStream;
import java63.servlets.project.dao.BoardDao;
import java63.servlets.project.dao.ExhibitionDao;
import java63.servlets.project.dao.UserDao;

import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

/* 공통으로 사용하는 자본은 보통 ServletContext에 보관한다.
 * 
 * ServletContext => 웹 애플리케이션 시작 시 생성됨. 
 * 종료하면 제거됨
 * HttpSession => 최초 요청 시 생성. 타입아웃 또는 무효화 명령 시 제거됨.
 * HeepServletRequest => 요청 때마다 생성. 응답 후 제거
 * PageContext => JSP에서 사용.각 JSP 실행할 때마다 생성되고, 
 * 실행 완료되면 제거됨.
 */
/*@WebListener*/
public class ContextLoaderListener implements ServletContextListener {
  @Override
  public void contextInitialized(ServletContextEvent sce) {
    try {
      ServletContext ctx = sce.getServletContext();
      InputStream inputStream = Resources.getResourceAsStream(
          ctx.getInitParameter("mybatisConfig"));
      SqlSessionFactory sqlSessionFactory = 
          new SqlSessionFactoryBuilder().build(inputStream);
      
      BoardDao boardDao = new BoardDao();
      boardDao.setSqlSessionFactory(sqlSessionFactory);      
      
      // ServletContext 보관소에 객체 저장!
      ctx.setAttribute("boardDao", boardDao);
      
    //!!!주의!!!
      ExhibitionDao exhibitionDao = new ExhibitionDao();
      exhibitionDao.setSqlSessionFactory(sqlSessionFactory);
      
      ctx.setAttribute("exhibitionDao", exhibitionDao);
      
      
      UserDao exhibitionDao2 = new UserDao();
      exhibitionDao2.setSqlSessionFactory(sqlSessionFactory);
      ctx.setAttribute("userDao", exhibitionDao2);

      
      
    } catch (Exception e) {
      e.printStackTrace();
    }
  }
  /* 웹 애플리케이션이 종료될 때 호출됨
   * => 서블릿이 사용한 자원을 해제할 때
   */
  @Override
  public void contextDestroyed(ServletContextEvent sce) {
    
  }

}
