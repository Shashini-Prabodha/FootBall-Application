package lk.premierleague.pos.db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBConnection {
    private static lk.premierleague.pos.db.DBConnection dbConnection;
    private Connection connection;

    private DBConnection() throws SQLException,ClassNotFoundException {
        Class.forName("com.mysql.cj.jdbc.Driver");
        connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/PremierLeague", "root", "1023");
    }
    public static lk.premierleague.pos.db.DBConnection getInstance() throws SQLException,ClassNotFoundException {
        if(null==dbConnection){
            dbConnection= new lk.premierleague.pos.db.DBConnection();
        }
        return dbConnection;
    }
    public Connection getConnection(){
        return connection;
    }


}
