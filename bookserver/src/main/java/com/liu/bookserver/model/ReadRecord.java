package com.liu.bookserver.model;

import lombok.Data;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

/**
 * @author lrn
 * @createTime : 2018/11/1 8:59
 */
@Data
public class ReadRecord {
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
    @NotBlank(message = "用户id不能为空",groups = {add.class})
    private String userid;
    /**
     * 书籍id
     */
    @NotBlank(message = "书籍id不能为空",groups = {add.class})
    private String bookid;
    /**
     * 章节id
     */
    @NotBlank(message = "章节id不能为空",groups = {add.class})
    private String chapterid;
    /**
     * 页数
     */
    @NotNull(message = "页数不能为空",groups = {add.class})
    private Integer pageNum;
}
