package com.higomiku;

import twitter4j.*;

public class Main{
    public static void main(String[]args){
        System.out.println("HelloWorld");

        //引数のハッシュタグ名を取得
        //String hash_tag_name = args[0];
        String hash_tag_name = "サマーランド";
        TwitterScraper.getTweetByHashTagName(hash_tag_name);

    }
}