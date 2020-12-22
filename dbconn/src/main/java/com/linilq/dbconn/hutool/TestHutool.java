package com.linilq.dbconn.hutool;

import cn.hutool.core.date.DateUtil;

public class TestHutool {

/*static{
    try {
        Thread.sleep(5000);
    } catch (InterruptedException e) {
        e.printStackTrace();
    }
}*/

static{
    new Thread(new Runnable() {
        @Override
        public void run() {
            try {
                Thread.sleep(5000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }).start();
}
    public static void main(String[] args) {
        System.out.println(DateUtil.offsetHour(DateUtil.date(),1));;
        System.out.println(DateUtil.date());
        System.out.println(DateUtil.hour(DateUtil.date(),true)) ;
    }
}
