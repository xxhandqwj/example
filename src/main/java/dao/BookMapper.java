package dao;

import entity.BookDO;
import org.apache.ibatis.annotations.*;

import java.util.List;

/**
 *  操作数据库映射器
 * @author xuxiaohang  
 * @date 2018/2/9 上午10:56    
 */
public interface BookMapper {
    /**    
     *  插入数据库信息
     * @author xuxiaohang  
     * @date 2018/2/9 上午10:56  
     * @param  book 数据库信息实体
     * @return int    插入条数
     */  
    int saveBook(BookDO book);
    /**
     *  查询所有记录
     * @author xuxiaohang
     * @date 2018/2/9 下午2:25
     * @return java.util.List<entity.BookDO>
     */
    List<BookDO> selectAll();
    /**    
     * 删除所有记录
     * @author xuxiaohang
     * @date 2018/2/9 下午4:28
     * @return void  
     */  
    void deleteAll();
    /**
     * 根据id查询
     * @author xuxiaohang
     * @date 2018/2/9 下午4:58
     * @param bookId
     * @return entity.BookDO
     */
    BookDO selectById(@Param("bookId") Integer bookId);

    /**    
     * 通过名字查找
     * @author xuxiaohang  
     * @date 2018/2/28 下午5:09  
     * @param bookName
     * @return entity.BookDO  
     */  
    @Results(id="result",value = {
            @Result(property = "bookId",column = "book_id",id=true),
            @Result(property = "bookName",column = "book_name"),
            @Result(property = "price",column = "price")
    })

    @Select("SELECT * FROM book WHERE book_name = #{bookName}")
    BookDO selectByName(String bookName);

    /**    
     * 通过id删除
     * @author xuxiaohang  
     * @date 2018/2/28 下午5:09  
     * @param book
     * @return void  
     */  
    void updateById(BookDO book);
}
