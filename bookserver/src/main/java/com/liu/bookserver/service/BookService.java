package com.liu.bookserver.service;

import com.liu.bookserver.httpformat.HttpResult;
import com.liu.bookserver.model.Book;
import com.liu.bookserver.model.Chapter;

import java.io.IOException;

/**
 * @author lrn
 * @createTime : 2018/10/29 16:49
 */
public interface BookService {
    /**
     * 新增书籍信息
     *
     * @param book bname 书籍名
     * @param book author 作者名
     * @return
     * @author : lrn
     * @createTime : 2018/10/29 16:57
     */
    HttpResult addBook(Book book);

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

    /**
     * 添加书籍收藏
     *
     * @param userid 用户id
     * @param bookid 书籍id
     * @return
     * @author : lrn
     * @createTime : 2018/10/30 10:04
     */
    HttpResult addCollection(String userid, String bookid) throws IOException;

    /**
     * 移除书籍收藏
     *
     * @param id 收藏id
     * @return
     * @author : lrn
     * @createTime : 2018/10/30 14:14
     */
    HttpResult delCollection(String id);

    /**
     * 添加章节信息
     * @author : lrn
     * @createTime : 2018/10/31 17:19
     * @param chapter bookid 书籍id
     * @param chapter cname 章节名
     * @param chapter cprice 章节单价
     * @return
     */
    HttpResult addChapter(Chapter chapter);

    /**
     * 修改章节信息
     * @author : lrn
     * @createTime : 2018/10/31 17:29
     * @param chapter id 章节id
     * @param chapter cname 章节名
     * @param chapter cprice 单价
     * @return
     */
    HttpResult editChapter(Chapter chapter);

    /**
     * 删除章节信息
     * @author : lrn
     * @createTime : 2018/10/31 19:33
     * @param id 章节id
     * @return
     */
    HttpResult delChapter(String id);
}
