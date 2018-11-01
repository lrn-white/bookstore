package com.liu.bookserver.dao;

import com.liu.bookserver.model.Chapter;
import org.apache.ibatis.annotations.Mapper;

/**
 * @author lrn
 * @createTime : 2018/10/31 14:02
 */
@Mapper
public interface ChapterDao {
    /**
     * 添加章节信息
     * @author : lrn
     * @createTime : 2018/10/31 17:19
     * @param chapter id 章节id
     * @param chapter bookid 书籍id
     * @param chapter cname 章节名
     * @param chapter cprice 章节单价
     * @return
     */
    int addChapter(Chapter chapter);

    /**
     * 修改章节信息
     * @author : lrn
     * @createTime : 2018/10/31 17:29
     * @param chapter id 章节id
     * @param chapter cname 章节名
     * @param chapter cprice 单价
     * @return
     */
    int editChapter(Chapter chapter);

    /**
     * 删除章节信息
     * @author : lrn
     * @createTime : 2018/10/31 19:33
     * @param id 章节id
     * @return
     */
    int delChapter(String id);
}
