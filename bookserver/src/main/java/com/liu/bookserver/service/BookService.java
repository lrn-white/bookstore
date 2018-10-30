package com.liu.bookserver.service;

import com.liu.bookserver.httpformat.HttpResult;
import com.liu.bookserver.model.Book;

/**
 * @author lrn
 * @createTime : 2018/10/29 16:49
 */
public interface BookService {
    /**
     * 新增书籍信息
     * @author : lrn
     * @createTime : 2018/10/29 16:57
     * @param book bname 书籍名
     * @param book author 作者名
     * @return
     */
    HttpResult addBook(Book book);

    /**
     * 编辑书籍信息
     * @param book id id
     * @param book bname 书籍名
     * @param book author 作者名
     * @return
     * @author : lrn
     * @createTime : 2018/10/29 17:21
     */
    HttpResult editBook(Book book);

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
    HttpResult getBook(Book book);
}
