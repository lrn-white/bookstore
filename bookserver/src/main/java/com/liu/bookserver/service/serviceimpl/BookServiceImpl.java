package com.liu.bookserver.service.serviceimpl;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.jsonFormatVisitors.JsonArrayFormatVisitor;
import com.liu.bookserver.dao.BookDao;
import com.liu.bookserver.dao.BookShelfDao;
import com.liu.bookserver.httpformat.AbstractHttpResult;
import com.liu.bookserver.httpformat.HttpResult;
import com.liu.bookserver.httpformat.MsgEnum;
import com.liu.bookserver.model.Book;
import com.liu.bookserver.model.BookShelf;
import com.liu.bookserver.model.OrgUser;
import com.liu.bookserver.service.BookService;
import com.liu.bookserver.utils.UUIDTool;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.ObjectUtils;

import java.io.IOException;
import java.util.Map;

/**
 * @author lrn
 * @createTime : 2018/10/29 16:49
 */
@Service
public class BookServiceImpl implements BookService {

    @Autowired
    private BookDao bookDao;
    @Autowired
    private UserServiceServer userServiceServer;
    @Autowired
    private BookShelfDao bookShelfDao;

    @Override
    public HttpResult addBook(Book book) {
        book.setId(UUIDTool.getUUID());
        int flag = bookDao.addBook(book);
        if (flag == 0) {
            return HttpResult.fail(MsgEnum.DATA_ADD_FAILURE);
        }
        return HttpResult.success(MsgEnum.DATA_ADD_SUCCESS);
    }

    @Override
    public HttpResult editBook(Book book) {
        int flag = bookDao.editBook(book);
        if (flag == 0) {
            return HttpResult.fail(MsgEnum.DATA_UPDATE_FAILURE);
        }
        return HttpResult.success(MsgEnum.DATA_UPDATE_SUCCESS);
    }

    @Override
    public HttpResult getBook(Book book) {
        return HttpResult.success(MsgEnum.DATA_SELECT_SUCCESS, bookDao.getBook(book));
    }

    @Override
    public HttpResult addCollection(String userid, String bookid) throws IOException {
        HttpResult httpResult = userServiceServer.getUser(userid);
        Map<String,Object> map  = httpResult.getData();

        BookShelf bookShelf = new BookShelf();
        bookShelf.setBookid(bookid);
        bookShelf.setId(UUIDTool.getUUID());
        bookShelf.setUserid(userid);
        bookShelf.setUname((String) map.get("uname"));
        int flag = bookShelfDao.addCollection(bookShelf);
        if (flag == 0) {
            return HttpResult.fail(MsgEnum.DATA_ADD_FAILURE);
        }
        return HttpResult.success(MsgEnum.DATA_ADD_SUCCESS);
    }

    @Override
    public HttpResult delCollection(String userid, String bookid) {
        BookShelf bookShelf = new BookShelf();
        bookShelf.setBookid(bookid);
        bookShelf.setUserid(userid);
        int flag = bookShelfDao.delCollection(bookShelf);
        if (flag == 0){
            return HttpResult.fail(MsgEnum.DATA_DELETE_FAILURE);
        }
        return HttpResult.success(MsgEnum.DATA_DELETE_SUCCESS);
    }
}
