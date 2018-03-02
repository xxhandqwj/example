package service;

import dao.BookMapper;
import entity.BookDO;
import org.apache.ibatis.session.SqlSession;
import utils.MySqlSessionFactory;

import java.util.List;
/**
 * 演示mybatis
 * @author xuxiaohang
 * @date 2018/3/2 下午3:42
 */
public class MainClass {
    public static void main(String[] args){
        SqlSession session=null;
        try{
            MySqlSessionFactory mySqlSessionFactory=new MySqlSessionFactory();
            session=mySqlSessionFactory.getSession();
            BookMapper mapper = session.getMapper(BookMapper.class);
            BookDO book =new BookDO();
            book.setBookId("8");
            book.setBookName("Thinking in JavaScript");
            book.setPrice(68.0);

//            insert(mapper,session,book);

            selectAll(mapper);

            selectById(mapper,8);

            selectByName(mapper,"Thinking in Java");

            selectByFuzzyName(mapper,"Java");

//            updateById(book,mapper,session);
            selectAll(mapper);

        }catch(Exception e){
            e.printStackTrace();

        }finally {
            if(session != null) {
                session.close();
            }
        }
    }

    public  static void insert(BookMapper mapper,SqlSession session,BookDO book){
        mapper.saveBook(book);
        session.commit();

    }
    public static void updateById(BookDO book,BookMapper mapper,SqlSession session){
        mapper.updateById(book);
        session.commit();
    }

    public static void selectAll(BookMapper mapper){
        List<BookDO> books=mapper.selectAll();
        System.out.println(books);
    }

    public static void selectById(BookMapper mapper,Integer id){
        BookDO bookDO=mapper.selectById(id);
        System.out.println("selectById:"+bookDO);

    }

    public static void selectByName(BookMapper mapper,String bookName){
        BookDO bookDO=mapper.selectByName(bookName);
        System.out.println(bookDO);
    }
    public static void selectByFuzzyName(BookMapper mapper,String fuzzyBookName){
        List<BookDO> books=mapper.selectByNameFuzzy("%"+fuzzyBookName+"%");
        System.out.println(books);
    }
}
