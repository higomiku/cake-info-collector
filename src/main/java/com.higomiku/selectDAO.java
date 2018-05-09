package com.higomiku;

import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * Created by takahashih51 on 2018/05/06.
 */
public class selectDAO {

    public static void selectMSRESTINF() throws Exception {

        try {
            /*SQL文を作成する*/
            String SQL = "SELECT * FROM MS_RESTINF";
            ResultSet result = JdbcCommon.selectSQL(SQL);

            /*クエリ結果を1レコードずつ出力していく*/
            while (result.next()) {
                /*getString()メソッドは、引数に指定されたフィールド名(列)の値をStringとして取得する*/
                int RestaurantId = result.getInt("REST_ID");
                int GroupId = result.getInt("GRP_ID");
                String RestaurantName = result.getString("REST_NAME");
                String RestaurantShortName = result.getString("REST_SHORTNAME");
                String RestaurantAddres = result.getString("REST_ADD");
                String RestaurantLatitude = result.getString("RESR_LATITUDE");
                String RestaurantLongitude = result.getString("REST_LONGITUDE");
                System.out.println(RestaurantId + ", " + GroupId + ", " + RestaurantName + "," + RestaurantShortName +
                        "," + RestaurantAddres + "," + RestaurantLatitude + "," + RestaurantLongitude);
            }

            /*ResultSetオブジェクトを閉じる*/
            result.close();
        }catch( SQLException e ) {

            /*エラーメッセージ出力*/
            System.out.println("Connection Failed. : " + e.toString());

            /*例外を投げちゃうぞ*/
            throw new Exception();
        }
    }
}
