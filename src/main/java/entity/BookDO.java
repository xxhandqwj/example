package entity;
/**
 *
 * @author xuxiaohang
 * @date 2018/2/9 上午11:11
 */
public class BookDO {
    private String bookId;
    private String bookName;
    private Double price;

    public String getBookId() { return bookId; }

    public void setBookId(String bookId) { this.bookId = bookId; }

    public Double getPrice() {
        return price;
    }

    public String getBookName() {
        return bookName;
    }

    public void setBookName(String bookName) {
        this.bookName = bookName;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    @Override
    public String toString() {
        return  "{bookId='"+bookId+"\'"+
                ",bookName='" + bookName + '\'' +
                ", price=" + price +
                '}';
    }
}
