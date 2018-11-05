package com.liu.bookserver.dao;

import com.liu.bookserver.model.ReadRecord;
import org.apache.ibatis.annotations.Mapper;

/**
 * @author lrn
 * @createTime : 2018/11/1 9:19
 */
@Mapper
public interface ReadRecordDao {

    /**
     * 查询阅读记录
     *
     * @param readRecord userid 用户id
     * @param readRecord bookid 书籍id
     * @return
     * @author : lrn
     * @createTime : 2018/11/1 15:00
     */
    ReadRecord getReadRecord(ReadRecord readRecord);

    /**
     * 新增阅读记录
     *
     * @param readRecord userid 用户id
     * @param readRecord bookid 书籍id
     * @param readRecord userid 用户id
     * @param readRecord userid 用户id
     * @return
     * @author : lrn
     * @createTime : 2018/11/1 15:14
     */
    int addReadRecord(ReadRecord readRecord);

    /**
     * 修改阅读记录
     *
     * @param readRecord userid 用户id
     * @param readRecord bookid 书籍id
     * @param readRecord userid 用户id
     * @param readRecord userid 用户id
     * @return
     * @author : lrn
     * @createTime : 2018/11/1 15:26
     */
    int editReadRecord(ReadRecord readRecord);
}
