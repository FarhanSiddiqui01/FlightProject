package repository;

import java.sql.Connection;
import java.sql.DriverManager;

public class BaseConnection {

     // step 2 build connection
    Connection con;

    BaseConnection(){
        openConnection();

    }

    public void openConnection(){
        try {
            Class.forName("com.mysql.jdbc.Driver");
            con = DriverManager.getConnection(
                    "jdbc:mysql://localhost:3306/dbs","root","qwerty12345");

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
