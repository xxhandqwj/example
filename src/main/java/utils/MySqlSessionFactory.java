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


    public static void main(String[] args){
        SqlSession session=null;
        try {
//      从 XML 中构建 SqlSessionFactory
        InputStream inputStream = Resources.getResourceAsStream(RESOURCE);
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
        session = sqlSessionFactory.openSession();
        BookMapper mapper = session.getMapper(BookMapper.class);
//        insert(mapper);
//        session.commit();

        List<BookDO> books = mapper.selectAll();

        System.out.println(books);

        BookDO bookDO=mapper.selectById(8);

        System.out.println("selectById:"+bookDO);

        bookDO=mapper.selectByName("Thinking in Java");

        System.out.println("selectByName:"+bookDO);

//        updateById("8",mapper);
//        session.commit();
//        books = mapper.selectAll();
//        System.out.println(books);

        }catch(Exception e){
            e.printStackTrace();

        }finally {
            if(session != null) {
                session.close();
            }
        }
    }

    public  static void insert(BookMapper mapper){
        BookDO book =new BookDO();
        book.setBookName("Thinking in JavaScript");
        book.setPrice(68.0);
        mapper.saveBook(book);
        book.setBookName("Thinking in C++");
        book.setPrice(60.0);
        mapper.saveBook(book);

    }
    public static void updateById(String id,BookMapper mapper){
        BookDO book=new BookDO();
        book.setBookId(id);
        book.setBookName("Think in python");
        book.setPrice(49.0);
        mapper.updateById(book);
    }

}
