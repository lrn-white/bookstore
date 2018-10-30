package com.liu.bookserver.service.serviceimpl;

import com.liu.bookserver.dao.BookDao;
import com.liu.bookserver.httpformat.HttpResult;
import com.liu.bookserver.httpformat.MsgEnum;
import com.liu.bookserver.model.Book;
import com.liu.bookserver.service.BookService;
import com.liu.bookserver.utils.UUIDTool;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.ObjectUtils;

/**
 * @author lrn
 * @createTime : 2018/10/29 16:49
 */
@Service
public class BookServiceImpl implements BookService{

    @Autowired
    private BookDao bookDao;
    @Override
    public HttpResult addBook(Book book) {
        book.setId(UUIDTool.getUUID());
        int flag = bookDao.addBook(book);
        if (flag == 0){
            return HttpResult.fail(MsgEnum.DATA_ADD_FAILURE);
        }
        return HttpResult.success(MsgEnum.DATA_ADD_SUCCESS);
    }

    @Override
    public HttpResult editBook(Book book) {
        int flag = bookDao.editBook(book);
        if (flag == 0){
            return HttpResult.fail(MsgEnum.DATA_UPDATE_FAILURE);
        }
        return HttpResult.success(MsgEnum.DATA_UPDATE_SUCCESS);
    }

    @Override
    public HttpResult getBook(Book book) {
        return HttpResult.success(MsgEnum.DATA_SELECT_SUCCESS,bookDao.getBook(book));
    }
}
