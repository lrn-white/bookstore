package com.liu.bookserver.dao;

import com.liu.bookserver.model.BookShelf;
import org.apache.ibatis.annotations.Mapper;

/**
 * @author lrn
 * @createTime : 2018/10/30 10:27
 */
@Mapper
public interface BookShelfDao {

    /**
     * 添加书籍收藏信息
     * @author : lrn
     * @createTime : 2018/10/30 10:26
     * @param bookShelf userid 用户id
     * @param bookShelf id id
     * @param bookShelf bookid 书籍id
     * @param bookShelf uname 用户账号
     * @return
     */
    int addCollection(BookShelf bookShelf);

    /**
     * 移除书籍收藏
     *
     * @param bookShelf userid 用户id
     * @param bookShelf bookid 书籍id
     * @return
     * @author : lrn
     * @createTime : 2018/10/30 14:14
     */
    int delCollection(BookShelf bookShelf);
}
