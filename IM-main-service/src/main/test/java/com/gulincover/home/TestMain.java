package com.gulincover.home;

import com.gulincover.home.dao.UserInfoMapper;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class TestMain {
    @Autowired
    private UserInfoMapper userInfoMapper;

    @Test
    public void test() {
        System.out.println(userInfoMapper.selectById(1));
    }
}
