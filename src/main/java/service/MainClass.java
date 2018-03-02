package service;

import dao.BookMapper;
import entity.BookDO;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import utils.MySqlSessionFactory;

import java.io.InputStream;
import java.util.List;

public class MainClass {
    public static void main(String[] args){
        SqlSession session=null;
        try{
        MySqlSessionFactory mySqlSessionFactory=new MySqlSessionFactory();
        session=mySqlSessionFactory.getSession();
        BookMapper mapper = session.getMapper(BookMapper.class);

//       insert(mapper);
//       session.commit();

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
