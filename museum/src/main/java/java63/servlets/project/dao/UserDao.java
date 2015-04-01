/* 페이징 처리
 * => DBMS마다 처리하는 방법이 다르다.    
 */
package java63.servlets.project.dao;

import java.util.HashMap;
import java.util.List;
 
import java63.servlets.project.domain.User;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class UserDao {
  @Autowired
  SqlSessionFactory sqlSessionFactory;
  
  public void setSqlSessionFactory(SqlSessionFactory sqlSessionFactory) {
    this.sqlSessionFactory = sqlSessionFactory;
  }

  public UserDao() {}

  public User selectOne(int no) {
    SqlSession sqlSession = sqlSessionFactory.openSession();
    
    try {
      return sqlSession.selectOne(
        "java02.test19.server.UserDao.selectOne", 
        no /* new Integer(no) */);
    } finally {
      sqlSession.close();
    }
  }
  
  public void update(User  ppp ) {
    SqlSession sqlSession = sqlSessionFactory.openSession();
    try {
      sqlSession.update(
        "java02.test19.server.UserDao.update", ppp);
      sqlSession.commit();
    } finally {
      sqlSession.close();
    }
  }
  
  public void delete(int no) {
    SqlSession sqlSession = sqlSessionFactory.openSession();
    try {
      sqlSession.delete(
        "java02.test19.server.UserDao.delete", no);
      sqlSession.commit();
    } finally {
      sqlSession.close();
    }
  }
  
  public List<User> selectList(int pageNo, int pageSize) {
    SqlSession sqlSession = sqlSessionFactory.openSession();
    
    HashMap<String,Object> paramMap = new HashMap<>();
    paramMap.put("startIndex", ((pageNo - 1) * pageSize));
    paramMap.put("pageSize", pageSize);
    
    try {
      return sqlSession.selectList(
        // 네임스페이스 + SQL문 아이디
        "java02.test19.server.UserDao.selectList", 
        paramMap  /*SQL문을 실행할 때 필요한 값 전달*/ );
    } finally {
      sqlSession.close();
    }
  }
  
  public void insert(User user) {
    SqlSession sqlSession = sqlSessionFactory.openSession();
    try {
      sqlSession.insert(
        "java02.test19.server.UserDao.insert", user);
      sqlSession.commit();
    } finally {
      sqlSession.close();
    }
  }
}

