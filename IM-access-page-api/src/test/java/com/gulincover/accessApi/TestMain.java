package com.gulincover.accessApi;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import javax.security.auth.callback.Callback;
import java.util.Objects;
import java.util.regex.Pattern;

@SpringBootTest
public class TestMain {
    @Test
    void test1() {
//        String str = "eyJhbGciOiJIUzI1NiJ9.eyJqdGkiOiI0MTI0MTIzNTEyNDUxMiIsInN1YiI6IjEyMzQ1Njc4OTEwIiwiaWF0IjoxNjEwNDU3NjU3LCJkYXRlS2V5IjoiYWJzIiwiZXhwIjoxNjIwNDU3NjU3fQ.vnco-B3ScP3b_Vdyv7rO3YOMb5A7pUV1RIm00BM2eXQ";
//        JjwtUtils jjwtUtils = new JjwtUtils();
//        Claims claims = jjwtUtils.parseJwt(str);
//
//        System.out.println(claims.get("dateKey"));
//        System.out.println(claims.getId());
//        System.out.println(claims.getIssuedAt());
//        System.out.println(claims.getSubject());
//        System.out.println(claims.getAudience());
//        Map<String, String> map = new HashMap<>();
//        map.put("abs","123");
//        System.out.println(map.get("123"));
//        Integer i = 200;
//        System.out.println(i == null);

        if (!Objects.isNull(null))
            System.out.println(Pattern.compile("^[0-9]*$").matcher(null).matches());
    }

    @Test
    void test2() {
        T t = new T();
        t.setExe(this::ttt);
        t.start();
        t.setExe(this::t);
        t.start();
    }

    void ttt() {
        System.out.println("ttt");
        System.out.println(Thread.currentThread());
    }
    void t() {
        System.out.println("t");
        System.out.println(Thread.currentThread());
    }

    class T extends Thread {
        private Runnable exe;

        public void setExe(Runnable exe) {
            this.exe = exe;
        }

        @Override
        public synchronized void start() {
            this.exe.run();
        }
    }

}













