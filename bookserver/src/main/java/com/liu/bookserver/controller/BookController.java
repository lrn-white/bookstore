package com.liu.bookserver.controller;

import com.liu.bookserver.httpformat.HttpResult;
import com.liu.bookserver.httpformat.MsgEnum;
import com.liu.bookserver.model.*;
import com.liu.bookserver.service.BookService;
import com.liu.bookserver.utils.UUIDTool;
import com.netflix.ribbon.proxy.annotation.Http;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.ObjectUtils;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.ws.rs.POST;
import java.io.IOException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.LinkedBlockingDeque;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/**
 * @author lrn
 * @createTime : 2018/10/29 16:28
 */
@RestController
@RequestMapping("/book")
public class BookController {
    @Autowired
    private BookService bookService;

    /**
     * 新增书籍信息
     *
     * @param book bname 书籍名
     * @param book author 作者名
     * @return
     * @author : lrn
     * @createTime : 2018/10/29 16:57
     */
    @PostMapping("/addBook")
    private HttpResult addBook(@Validated(add.class) Book book, BindingResult result) {
        if (result.hasErrors()) {
            return HttpResult.fail(result.getFieldError().getDefaultMessage());
        }
        return bookService.addBook(book);
    }

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
    @PostMapping("/editBook")
    private HttpResult editBook(@Validated({edit.class}) Book book, BindingResult result) {
        if (result.hasErrors()) {
            return HttpResult.fail(result.getFieldError().getDefaultMessage());
        }
        if (ObjectUtils.isEmpty(book.getBname()) && ObjectUtils.isEmpty(book.getAuthor())) {
            return HttpResult.fail(MsgEnum.PARAM_FAILURE);
        }
        return bookService.editBook(book);
    }

    /**
     * 获取书籍信息
     *
     * @param book id id
     * @param book bname 书籍名
     * @param book author 作者名
     * @return
     * @author : lrn
     * @createTime : 2018/10/30 8:51
     */
    @GetMapping("/getBook")
    private HttpResult getBook(Book book) {
        return bookService.getBook(book);
    }

    /**
     * 添加书籍收藏
     *
     * @param userid 用户id
     * @param bookid 书籍id
     * @return
     * @author : lrn
     * @createTime : 2018/10/30 10:04
     */
    @PostMapping("/addCollection")
    private HttpResult addCollection(@NotBlank(message = "userid不能为空") String userid,
                                     @NotBlank(message = "bookid不能为空") String bookid) throws IOException {
        return bookService.addCollection(userid, bookid);
    }

    /**
     * 移除书籍收藏
     *
     * @param id 收藏id
     * @return
     * @author : lrn
     * @createTime : 2018/10/30 14:14
     */

    @PostMapping("/delCollection")
    private HttpResult delCollection(@NotBlank(message = "userid不能为空") String id) {
        return bookService.delCollection(id);
    }

    /**
     * 添加章节信息
     *
     * @param chapter bookid 书籍id
     * @param chapter cname 章节名
     * @param chapter cprice 章节单价
     * @return
     * @author : lrn
     * @createTime : 2018/10/31 17:19
     */
    @PostMapping("/addChapter")
    private HttpResult addChapter(@Validated({add.class}) Chapter chapter, BindingResult result) {
        if (result.hasErrors()) {
            return HttpResult.fail(result.getFieldError().getDefaultMessage());
        }
        return bookService.addChapter(chapter);
    }

    /**
     * 修改章节信息
     *
     * @param chapter id 章节id
     * @param chapter cname 章节名
     * @param chapter cprice 单价
     * @return
     * @author : lrn
     * @createTime : 2018/10/31 17:29
     */
    @PostMapping("/editChapter")
    private HttpResult editChapter(@Validated({edit.class}) Chapter chapter, BindingResult result) {
        if (result.hasErrors()) {
            return HttpResult.fail(result.getFieldError().getDefaultMessage());
        }
        return bookService.editChapter(chapter);
    }

    /**
     * 删除章节信息
     *
     * @param id 章节id
     * @return
     * @author : lrn
     * @createTime : 2018/10/31 19:33
     */
    @GetMapping("/delChapter")
    private HttpResult delChapter(@NotBlank(message = "id不能为空") String id) {
        return bookService.delChapter(id);
    }

    /**
     * 添加阅读记录（如果没有前置记录就新增，有就修改)
     *
     * @param readRecord userid 用户id
     * @param readRecord bookid 书籍id
     * @param readRecord chapterid 章节id
     * @param readRecord pageNum 页数
     * @return
     * @author : lrn
     * @createTime : 2018/11/1 9:06
     */
    @PostMapping("/addReadRecord")
    private HttpResult addReadRecord(@Validated(add.class) ReadRecord readRecord, BindingResult result) {
        if (result.hasErrors()) {
            return HttpResult.fail(result.getFieldError().getDefaultMessage());
        }
        return bookService.addReadRecord(readRecord);
    }

    /**
     * 查询阅读记录
     *
     * @param userid 用户id
     * @param bookid 书籍id
     * @return
     * @author : lrn
     * @createTime : 2018/11/1 15:00
     */
    @GetMapping("/getReadRecord")
    private HttpResult getReadRecord(@NotBlank(message = "用户id不能为空") String userid,
                                     @NotBlank(message = "书籍id不能为空") String bookid) {
        return bookService.getReadRecord(userid, bookid);
    }

}
