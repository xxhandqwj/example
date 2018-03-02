package utils;

import dao.BookMapper;
import entity.BookDO;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;


import java.io.InputStream;
import java.util.List;

/**
 * 通过输入流创建SqlSessionFactory
 * @author xuxiaohang
 * @date 2018/2/9 上午11:45
 */
public class MySqlSessionFactory {
    private static final String RESOURCE="context/mybatis-config.xml";
    SqlSessionFactory sqlSessionFactory=null;
    SqlSession session=null;

    public MySqlSessionFactory(){
       try{
//         从 XML 中构建 SqlSessionFactory
           InputStream inputStream = Resources.getResourceAsStream(RESOURCE);
           sqlSessionFactory=new SqlSessionFactoryBuilder().build(inputStream);

       }catch (Exception e) {
           e.printStackTrace();
       }
    }

    public SqlSession getSession() {
        session=sqlSessionFactory.openSession();
        return session;
    }


}
