package com.liu.bookserver;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.liu.bookserver.controller.BookController;
import com.liu.bookserver.model.Book;
import com.liu.bookserver.model.OrgUser;
import com.liu.bookserver.service.BookService;
import com.liu.bookserver.service.serviceimpl.BookServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * @author lrn
 * @createTime : 2018/10/30 13:53
 */
public class test {
    public static void main(String[] args) throws Exception {

            Book book = new Book();
            for (int i = 10; i < 10000; i++) {
                book.setBname("java设计思想" + i);
                book.setAuthor("大神" + i);
//            BookServiceImpl bookService = new BookServiceImpl();
//            bookService.addBook(book);


            }
    }
}
