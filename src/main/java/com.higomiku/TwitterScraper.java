package com.higomiku;

import twitter4j.Twitter;
import twitter4j.TwitterException;
import twitter4j.TwitterFactory;
import twitter4j.User;
import twitter4j.conf.ConfigurationBuilder;

public class TwitterScraper {

    protected static void testScrapeFromTwitter(){
        // 初期化
        Twitter twitter = new TwitterFactory().getInstance();


//        ConfigurationBuilder cb = new ConfigurationBuilder();
//        cb.setDebugEnabled(true)
//                .setOAuthConsumerKey("cp4oMmjnSQd8P3RuTsQ5EAaqs")
//                .setOAuthConsumerSecret("eie0tHGrjW7MiQr5fjGbLtJcaKKVF551ydKmQ9Bg8B0K0Uudit")
//                .setOAuthAccessToken("264043200-1jTOvNAAqdbQFzumB9wJAuRZXAxrSEDdOQ6YUMEx")
//                .setOAuthAccessTokenSecret("6KnWGTXfPRsDkZs6A1cZBEWjOGbQbTZDQ54kXITTcIIEL");
//        TwitterFactory tf = new TwitterFactory(cb.build());
//        Twitter twitter = tf.getInstance();
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
}
