package com.higomiku;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 * Created by takahashih51 on 2018/05/06.
 */

public class JdbcCommon {

    /*接続先サーバー名を"localhost"で与えることを示している*/
    static String servername = "rds-mysql-server.csujtx2sgccn.ap-northeast-1.rds.amazonaws.com";

    /*接続するデータベース名をsenngokuとしている*/
    static String databasename = "CAKEMAPDB";

    /*データベースの接続に用いるユーザ名をrootユーザとしている*/
    static String user = "higomiku";

    /*データベースの接続に用いるユーザのパスワードを指定している*/
    static String password = "higomiku001";

    /*取り扱う文字コードをUTF-8文字としている*/
    static String serverencoding = "UTF-8";

    /*データベースをあらわすURLを設定している*/
    static String url = "jdbc:mysql://" + servername + "/" + databasename;

        /*MySQLの場合、URLの形式は次のようになります。
          jdbc:mysql://(サーバ名)/(データベース名)*/

        /*↑データベースをあらわすURL（データベースURL)は、データベースに接続する場合に
        必要となる情報をセットした文字列である。
        この文字列の構造は、"jdbc"、サブプロトコル、サブネームの３つの部分から構成される。*/

    /*接続を表すConnectionオブジェクトを初期化*/
    static Connection con = null;

    public static ResultSet selectSQL(String SQL) throws Exception {
        try{

            /*クラスローダによりJDBCドライバを読み込んでいることを示している。
            引数は、データベースにアクセスするためのJDBCドライバのクラス名である。*/
            Class.forName( "com.mysql.jdbc.Driver" ).newInstance();

            /*DriverManagerクラスのgetConnectionメソッドを使ってデータベースに接続する。*/
            con = DriverManager.getConnection( url, user, password );

            /*データベースの接続後に、sql文をデータベースに直接渡すのではなく、
            sqlコンテナの役割を果たすオブジェクトに渡すためのStatementオブジェクトを作成する。*/
            Statement st = con.createStatement();

            /*SQL文を作成する*/
            String sqlStr = "SELECT * FROM MS_RESTINF";

            /*SQL文を実行した結果セットをResultSetオブジェクトに格納している*/
            ResultSet result = st.executeQuery( SQL );

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

            /*Statementオブジェクトを閉じる*/
            st.close();

            /*Connectionオブジェクトを閉じる*/
            con.close();

            return result;
        }
        catch( SQLException e ){

            /*エラーメッセージ出力*/
            System.out.println( "Connection Failed. : " + e.toString() );

            /*例外を投げちゃうぞ*/
            throw new Exception();

        }catch (ClassNotFoundException e){

            /*エラーメッセージ出力*/
            System.out.println("ドライバを読み込めませんでした " + e);
        }
        finally{
            try{
                if( con != null ){
                    con.close();
                }
            }
            catch(Exception e){

                /*エラーメッセージ出力*/
                System.out.println( "Exception2! :" + e.toString() );

                /*例外を投げちゃうぞ*/
                throw new Exception();
            }
        }
        return null;
    }

}
