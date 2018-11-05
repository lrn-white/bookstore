package com.liu.bookserver.dao;

import com.liu.bookserver.model.Book;
import com.liu.bookserver.model.BookShelf;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * @author lrn
 * @createTime : 2018/10/29 16:48
 */
@Mapper
public interface BookDao {

    /**
     * 新增书籍信息
     *
     * @param book id id
     * @param book bname 书籍名
     * @param book author 作者名
     * @return
     * @author : lrn
     * @createTime : 2018/10/29 16:57
     */
    int addBook(Book book);

    /**
     * 编辑书籍信息
     *
     * @param book id id
     * @param book bname 书籍名
     * @param book author 作者名
     * @return
     * @author : lrn
     * @createTime : 2018/10/29 17:21
     */
    int editBook(Book book);

    /**
     * 获取单一书籍信息
     *
     * @param book id id
     * @param book bname 书籍名
     * @param book author 作者名
     * @return
     * @author : lrn
     * @createTime : 2018/10/30 8:51
     */
    List<Book> getBook(Book book);
}
