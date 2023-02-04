package example;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class DBInfo {

    Connection conn=null;
    PreparedStatement prst=null;
    ResultSet rs=null;

    String url="jdbc:mariadb://[ip]:[port]/[테이블 명]";
    String dbUserId="[계정]";
    String dbPassword="[password]";
}
