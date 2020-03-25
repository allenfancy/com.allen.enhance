package org.com.allen.enhance.basic.test;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import com.google.common.collect.Lists;

/**
 * @author allen.wu
 * @since 2020-02-22 12:03
 */
public class TestMain1 {

    private static final String URL = "http://api.bilibili.co/x/internal/passport-login/token/cache/delete";

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new FileReader("/Users/allen/Downloads/ak2.txt"));
        String line;
        List<String> lists = Lists.newArrayList();
        int count = 0;
        ExecutorService executorService = Executors.newFixedThreadPool(100);
        while ((line = br.readLine()) != null) {
            if (count == 5000) {
                for (int i = 0; i < count; i++) {
                    List<String> finalLists = lists;
                    int finalI = i;
                    executorService.execute(() -> {
                        HttpClientUtils.get(URL, finalLists.get(finalI));
                    });
                }
                count = 0;
                lists = Lists.newArrayList();
            } else {
                lists.add(line);
                count++;
            }

        }
        executorService.shutdown();
    }
}
