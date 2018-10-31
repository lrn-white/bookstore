package com.liu.bookserver.controller;

import com.liu.bookserver.httpformat.HttpResult;
import com.liu.bookserver.httpformat.MsgEnum;
import com.liu.bookserver.model.Book;
import com.liu.bookserver.model.add;
import com.liu.bookserver.model.edit;
import com.liu.bookserver.service.BookService;
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
import java.io.IOException;

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
     * 获取单一书籍信息
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
     * @param userid 用户id
     * @param bookid 书籍id
     * @return
     * @author : lrn
     * @createTime : 2018/10/30 14:14
     */
    @PostMapping("/delCollection")
    private HttpResult delCollection(@NotBlank(message = "userid不能为空") String userid,
                                     @NotBlank(message = "bookid不能为空") String bookid) {
        return bookService.delCollection(userid, bookid);
    }
}
