package com.liu.bookserver.service.serviceimpl;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.jsonFormatVisitors.JsonArrayFormatVisitor;
import com.liu.bookserver.dao.BookDao;
import com.liu.bookserver.dao.BookShelfDao;
import com.liu.bookserver.dao.ChapterDao;
import com.liu.bookserver.dao.ReadRecordDao;
import com.liu.bookserver.httpformat.AbstractHttpResult;
import com.liu.bookserver.httpformat.HttpResult;
import com.liu.bookserver.httpformat.MsgEnum;
import com.liu.bookserver.model.*;
import com.liu.bookserver.service.BookService;
import com.liu.bookserver.utils.UUIDTool;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.ObjectUtils;

import java.io.IOException;
import java.util.List;
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
    @Autowired
    private ChapterDao chapterDao;
    @Autowired
    private ReadRecordDao readRecordDao;

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
        long startTime=System.currentTimeMillis();
        List<Book> books = bookDao.getBook(book);
        long endTime=System.currentTimeMillis();
        float excTime=(float)(endTime-startTime);
        System.out.println(excTime);
        return HttpResult.success(MsgEnum.DATA_SELECT_SUCCESS, books);
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
    public HttpResult delCollection(String id) {
        int flag = bookShelfDao.delCollection(id);
        if (flag == 0){
            return HttpResult.fail(MsgEnum.DATA_DELETE_FAILURE);
        }
        return HttpResult.success(MsgEnum.DATA_DELETE_SUCCESS);
    }

    @Override
    public HttpResult addChapter(Chapter chapter) {
        chapter.setId(UUIDTool.getUUID());
        int flag = chapterDao.addChapter(chapter);
        if (flag == 0){
            return HttpResult.fail(MsgEnum.DATA_ADD_FAILURE);
        }
        return HttpResult.success(MsgEnum.DATA_ADD_SUCCESS);
    }

    @Override
    public HttpResult editChapter(Chapter chapter) {
        int flag = chapterDao.editChapter(chapter);
        if (flag == 0){
            return HttpResult.fail(MsgEnum.DATA_UPDATE_FAILURE);
        }
        return HttpResult.success(MsgEnum.DATA_UPDATE_SUCCESS);
    }

    @Override
    public HttpResult delChapter(String id) {
        int flag = chapterDao.delChapter(id);
        if (flag == 0){
            return HttpResult.fail(MsgEnum.DATA_DELETE_FAILURE);
        }
        return HttpResult.success(MsgEnum.DATA_DELETE_SUCCESS);
    }

    @Override
    public HttpResult addReadRecord(ReadRecord readRecord) {
        ReadRecord readRecord1 = readRecordDao.getReadRecord(readRecord);
        if (ObjectUtils.isEmpty(readRecord1)){
            readRecord.setId(UUIDTool.getUUID());
            int flag = readRecordDao.addReadRecord(readRecord);
            if (flag == 0){
                return HttpResult.fail(MsgEnum.DATA_ADD_FAILURE);
            }
            return HttpResult.success(MsgEnum.DATA_ADD_SUCCESS);
        }else {
            int flag1 = readRecordDao.editReadRecord(readRecord);
            if (flag1 == 0){
                return HttpResult.fail(MsgEnum.DATA_UPDATE_FAILURE);
            }
            return HttpResult.success(MsgEnum.DATA_UPDATE_SUCCESS);
        }
    }

    @Override
    public HttpResult getReadRecord(String userid, String bookid) {
        ReadRecord readRecord = new ReadRecord();
        readRecord.setUserid(userid);
        readRecord.setBookid(bookid);
        ReadRecord readRecord1 = readRecordDao.getReadRecord(readRecord);
        if (ObjectUtils.isEmpty(readRecord1)){
            return HttpResult.fail(MsgEnum.DATA_SELECT_FAILURE);
        }
        return HttpResult.success(MsgEnum.DATA_SELECT_SUCCESS,readRecord1);
    }
}
