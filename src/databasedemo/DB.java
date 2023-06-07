package databasedemo;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;

import static java.sql.DriverManager.getConnection;

public class DB {

    final  static  String url = "jdbc:oracle:thin:@localhost:1521:XE";
      static String user = "system";
      static String pass = "12345";
    static public  Connection  connect(String username , String password) throws SQLException {
        return  getConnection(url,username,password);

    }
    static public void  disconnect(Connection connection) throws SQLException {
        connection.close();
    }
    static  public ResultSet excuteQuery(String query) throws SQLException {
        Connection connection = DriverManager.getConnection(url,user,pass);
    return     connection.createStatement().executeQuery(query);
    }
}
