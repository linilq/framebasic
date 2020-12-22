package com.linilq.dbconn.guava;

import com.google.common.io.ByteSource;
import com.google.common.io.Resources;
import com.google.common.util.concurrent.RateLimiter;

import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;

public class GuavaTest {

    public static void main(String[] args) {
//        testRateLimit();g
        getSizeFromUrl("http://localhost:8080/images/k.jpg");
    }

    private static void testRateLimit() {
        RateLimiter rateLimiter = RateLimiter.create(100);

        for (int i = 0; i < 10; i++) {
            final Thread t = new Thread(new Runnable() {
                @Override
                public void run() {
                    double costTime = rateLimiter.acquire(100);
                    try {
                        Thread.sleep(1000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    System.out.println(Thread.currentThread().getName()+" costTime "+costTime);
                }
            });
            t.start();
        }
    }

    public static long getSizeFromUrl(String url) {
        long size = 0;
        try {
            ByteSource source = Resources.asByteSource(new URL(url));
            size = source.read().length;
        } catch (MalformedURLException e) {
            throw new PushException(String.format("invalid url: %s", url), e);
        } catch (IOException e) {
            throw new PushException(String.format("invalid url: %s", url), e);
        }
        return size;
    }
}
