package com.liu.bookserver.model;

import lombok.Data;

import javax.validation.constraints.NotBlank;

/**
 * @author lrn
 * @createTime : 2018/10/29 15:45
 */
@Data
public class Book {
    /**
     * id
     */
    @NotBlank(groups = {edit.class}, message = "id不能为空")
    private String id;
    /**
     * 自增id
     */
    private Integer rowid;
    /**
     * 书籍名
     */
    @NotBlank(message = "书籍名不能为空", groups = {add.class})
    private String bname;
    /**
     * 作者名
     */
    @NotBlank(message = "作者名不能为空", groups = {add.class})
    private String author;
}
