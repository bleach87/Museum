package java63.servlets.project.dao;

import java.util.HashMap;
import java.util.List;
import java63.servlets.project.domain.Exhibition;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class ExhibitionDao {
  @Autowired
  SqlSessionFactory sqlSessionFactory;
  
  public void setSqlSessionFactory(SqlSessionFactory sqlSessionFactory) {
    this.sqlSessionFactory = sqlSessionFactory;
  }

  public ExhibitionDao() {}

  public Exhibition selectOne(int no) {
    SqlSession sqlSession = sqlSessionFactory.openSession();
    
    try {
      return sqlSession.selectOne(
        "java02.test19.server.ExhibitionDao.selectOne", 
        no /* new Integer(no) */);
    } finally {
      sqlSession.close();
    }
  }  
  
  
  public List<Exhibition> selectList(int pageNo, int pageSize) {
    SqlSession sqlSession = sqlSessionFactory.openSession();
    
    HashMap<String,Object> paramMap = new HashMap<>();
    paramMap.put("startIndex", ((pageNo - 1) * pageSize));
    paramMap.put("pageSize", pageSize);
    
    try {
      return sqlSession.selectList(
        // 네임스페이스 + SQL문 아이디
        "java02.test19.server.ExhibitionDao.selectList", 
        paramMap /* SQL문을 실행할 때 필요한 값 전달 */);
    } finally {
      sqlSession.close();
    }
  }  
  
}


















