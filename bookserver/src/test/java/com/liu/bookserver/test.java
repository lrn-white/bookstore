package com.liu.bookserver;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.liu.bookserver.model.OrgUser;

/**
 * @author lrn
 * @createTime : 2018/10/30 13:53
 */
public class test {
    public static void main(String[] args) throws Exception {
        ObjectMapper mapper = new ObjectMapper();
        OrgUser user = new OrgUser();
        user.setId("1");
        user.setRowid(1);
        user.setUname("Sam");
        user.setUpassword("123456");
        user.setIsadmin(1);
        String json = mapper.writeValueAsString(user);
        System.out.println(json);

        OrgUser user1 = mapper.readValue(json,OrgUser.class);
        System.out.println(user1);
    }
}
