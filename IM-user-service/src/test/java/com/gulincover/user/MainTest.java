package com.gulincover.user;

import com.gulincover.user.dao.UserInfoMapper;
import com.gulincover.utils.tools.JjwtUtils;
import io.jsonwebtoken.Claims;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class MainTest {
    @Autowired
    UserInfoMapper userInfoMapper;
    @Test
    void test1() {
        String token = "eyJhbGciOiJIUzI1NiJ9.eyJqdGkiOiJudWxsIiwic3ViIjoiMTIzNDU2QHFxLmNvbSIsImlhdCI6MTYwOTk0MDA3OCwiZXhwIjoxNjEwOTQwMDc4fQ.aQfJ68J6w1qdaXdy_jQYKAMFn1n9owMMTpmx6S4c-1A";
        JjwtUtils jjwtUtils = new JjwtUtils();
        jjwtUtils.setSigningKey("html");
        jjwtUtils.setTtl(10000000000L);
        Claims claims = jjwtUtils.parseJwt(token);
        System.out.println(claims.getId());
        System.out.println(claims.getSubject());
        System.out.println(claims.getIssuedAt());
    }

    @Test
    void test2() {
        System.out.println(userInfoMapper.selectById(1232412412L));
    }
}
