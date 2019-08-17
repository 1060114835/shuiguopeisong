package com.example.fruitdelivery.modules.home.self;

public class MessageWrap {
    public final int message;
    public final int flag;
    public static MessageWrap getInstance(int message,int flag){
        return new MessageWrap(message,flag);
    }

    private MessageWrap(int message,int flag){
        this.message = message;
        this.flag = flag;
    }
}
