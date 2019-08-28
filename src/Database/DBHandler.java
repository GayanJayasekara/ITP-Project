package Database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;


public class DBHandler extends Configs {

    Connection dbConnection;

    public Connection getConnection(){

        String connectionString = "jdbc:mysql://" + Configs.dbHost + ":" + Configs.dbPort + "/" + Configs.dbName+"?autoReconnect=true&useSSL=false";

        try {
            Class.forName("com.mysql.jdbc.Driver");
        }
        catch (ClassNotFoundException e){

            e.printStackTrace();
        }

        try {
            dbConnection = DriverManager.getConnection(connectionString, Configs.dbUser, Configs.dbPW);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return dbConnection;
    }
}
