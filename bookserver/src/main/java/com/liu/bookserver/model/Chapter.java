package com.liu.bookserver.model;

import lombok.Data;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

/**
 * @author lrn
 * @createTime : 2018/10/31 13:54
 */
@Data
public class Chapter {
    /**
     * id
     */
    @NotBlank(message = "id不能为空",groups = {edit.class})
    private String id;
    /**
     * 自增id
     */
    private Integer rowid;
    /**
     * 书籍id
     */
    @NotBlank(message = "书籍id不能为空",groups = {add.class})
    private String bookid;
    /**
     * 章节名
     */
    @NotBlank(message = "章节名不能为空",groups = {add.class})
    private String cname;
    /**
     * 章节单价
     */
    @NotNull(message = "章节单价不能为空",groups = {add.class})
    private Double cprice;
}
