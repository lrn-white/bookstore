package com.liu.userserver.utils;

import java.util.UUID;

/**
 * UUID处理
 * @author lrn
 * @createTime : 2018/10/26 17:15
 */
public class UUIDTool {
    /**
     * 自动生成32位UUID
     * @author : lrn
     * @createTime : 2018/10/26 17:18
     * @param
     * @return
     */
    public static String getUUID() {
        return UUID.randomUUID().toString().replace("-", "");
    }
}
