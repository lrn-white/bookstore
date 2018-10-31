package com.liu.bookserver.model;

import lombok.Data;

import java.io.Serializable;

/**
 * @author lrn
 * @createTime : 2018/10/30 10:13
 */
@Data
public class BookShelf {
    /**
     * id
     */
    private String id;
    /**
     * 自增id
     */
    private Integer rowid;
    /**
     * 用户id
     */
    private String userid;
    /**
     * 书籍id
     */
    private String bookid;
    /**
     * 用户名
     */
    private String uname;
}
