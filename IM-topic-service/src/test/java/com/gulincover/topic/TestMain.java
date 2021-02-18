package com.gulincover.topic;

import com.gulincover.utils.tools.FileAccessNameGenerator;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

@SpringBootTest
public class TestMain {

    @Test
    public void test1() {
//        ODIzYzU3ZDMtYWJmZi00YzQ1LWFjMmMtZjhjOWQ4NTEzMTVj
//        9f50aa1f-018c-4fb3-8c9c-5e547d69b1c2
//        System.out.println(FileAccessNameGenerator.creator());
        System.out.println(Long.decode("1234"));
    }

    @Test
    public void test() throws IOException {
        URL url = new URL("http://www.baidu.com");
        HttpURLConnection httpURLConnection = (HttpURLConnection) url.openConnection();
        httpURLConnection.setRequestMethod("GET");
        httpURLConnection.setConnectTimeout(3000);
        httpURLConnection.setDoOutput(true);
        httpURLConnection.setDoInput(true);
        httpURLConnection.setUseCaches(false);
        httpURLConnection.setInstanceFollowRedirects(true);

        int responseCode = httpURLConnection.getResponseCode();
        if (200 == responseCode) {
            BufferedReader br = new BufferedReader(new InputStreamReader(httpURLConnection.getInputStream()));
            String line = null;
            while ((line = br.readLine()) != null) {
                System.out.println(line);
            }
        }
    }
}

