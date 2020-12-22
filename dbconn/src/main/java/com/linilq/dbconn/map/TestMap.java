package com.linilq.dbconn.map;

import java.util.HashSet;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import java.util.function.BiConsumer;
import java.util.function.BiFunction;
import java.util.function.Function;

public class TestMap {


    public static void main(String[] args) {
       final ConcurrentHashMap<String, Set<String>> concurrentHashMap = new ConcurrentHashMap<>();
       final ConcurrentHashMap<String, String> kk = new ConcurrentHashMap<>();


        for (int i = 0; i < 100; i++) {
            Set<String> stringSet = new HashSet<>();
            stringSet.add(i+"value");
            concurrentHashMap.put(i+"str",stringSet);
        }

        String temp = kk.putIfAbsent("linilq","mmmm");

        temp = kk.putIfAbsent("linilq","kkkkkk");

        System.out.println(temp);
      /*  new Thread(new Runnable() {
            @Override
            public void run() {
                for (int i = 0; i < 100; i++) {
                    Set<String> stringSet = new HashSet<>();
                    stringSet.add(i*8+"value");
                    try {
                        Thread.sleep(20);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    concurrentHashMap.remove(i+"str");
                }

            }
        }).start();

      new Thread(new Runnable() {
            @Override
            public void run() {
                for (int i = 0; i < 100; i++) {
                    String value = i*2+"value";
                    try {
                        Thread.sleep(10);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    concurrentHashMap.compute(i + "str", new BiFunction<String, Set<String>, Set<String>>() {
                        @Override
                        public Set<String> apply(String s, Set<String> strings) {
                            strings.add(value);
                            return strings;
                        }
                    });
                }

            }
        }).start();

        new Thread(new Runnable() {
            @Override
            public void run() {
                for (int i = 0; i < 100; i++) {
                    String value = i*3+"value";
                    try {
                        Thread.sleep(10);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    concurrentHashMap.compute(i + "str", new BiFunction<String, Set<String>, Set<String>>() {
                        @Override
                        public Set<String> apply(String s, Set<String> strings) {
                            strings.add(value);
                            return strings;
                        }
                    });
                }

            }
        }).start();*/
    }
}
