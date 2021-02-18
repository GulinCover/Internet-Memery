package com.gulincover.other;

import com.gulincover.api.entity.LikeInfo;
import com.gulincover.other.dao.LikeInfoMapper;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.HashMap;
import java.util.Map;

@SpringBootTest
public class MainTest {
    @Autowired
    LikeInfoMapper likeInfoMapper;
    @Test
    void test1() {
        LikeInfo likeInfo = new LikeInfo();
        Map<String, String> map = new HashMap<>();
        map.put("id", "23124");
        likeInfo.setId(123L);
        likeInfo.setUserId(covert(map.get("hell")));
        int i = likeInfoMapper.updateById(likeInfo);
        System.out.println(i);
    }

    Long covert(String abs) {
        return abs == null ? null : Long.valueOf(abs);
    }
}
