package com.linilq.dbconn.constructor;

public class Level2 extends Level1 {

    public Level2(){
        this("linilq");
    }
    public Level2(String name){
        super(name);
    }

    public static void main(String[] args) {
        Level2 level2 = new Level2();

    }
}
