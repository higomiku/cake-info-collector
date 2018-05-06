package com.higomiku;

import twitter4j.*;
import twitter4j.conf.ConfigurationBuilder;

import java.util.List;

public class TwitterScraper {

    //ハッシュタグでtweetを取得するメソッド
    protected static void getTweetByHashTagName(String hashTagName){
        Twitter twitter = createTwitterInstance();
        Query query = new Query();
        query.setQuery("#" + hashTagName);

        QueryResult result = null;

        try {
            result = twitter.search(query);
            List<Status> tweetList = result.getTweets();
            System.out.println("tweetList = " + tweetList.size());

            for(Status tweet : tweetList){
                System.out.println("結果");
                System.out.println(tweet.getText());
            }
        } catch (TwitterException e) {
            e.printStackTrace();
            System.out.println("ERROR searchでエラーが発生しました");
        }



    }


    //ユーザ情報取得メソッド
    protected static void getUserInfo() {
        Twitter twitter = createTwitterInstance();
        User user = null;

        {
            try {
                user = twitter.verifyCredentials();
            } catch (TwitterException e) {
                e.printStackTrace();
            }
        }

        //ユーザ情報取得
        System.out.println("なまえ　　　：" + user.getName());
        System.out.println("ひょうじ名　：" + user.getScreenName());
        System.err.println("ふぉろー数　：" + user.getFriendsCount());
        System.out.println("ふぉろわー数：" + user.getFollowersCount());
    }


    //Twitterインスタンス生成
    protected static Twitter  createTwitterInstance(){
        // 初期化

//        Twitter twitter = new TwitterFactory().getInstance();


        ConfigurationBuilder cb = new ConfigurationBuilder();
        cb.setDebugEnabled(true)
                .setOAuthConsumerKey("cp4oMmjnSQd8P3RuTsQ5EAaqs")
                .setOAuthConsumerSecret("eie0tHGrjW7MiQr5fjGbLtJcaKKVF551ydKmQ9Bg8B0K0Uudit")
                .setOAuthAccessToken("264043200-1jTOvNAAqdbQFzumB9wJAuRZXAxrSEDdOQ6YUMEx")
                .setOAuthAccessTokenSecret("6KnWGTXfPRsDkZs6A1cZBEWjOGbQbTZDQ54kXITTcIIEL");
        TwitterFactory tf = new TwitterFactory(cb.build());
        Twitter twitter = tf.getInstance();
        return twitter;

    }
}
