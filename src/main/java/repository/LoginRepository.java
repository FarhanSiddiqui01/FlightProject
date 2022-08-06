package repository;

import domain.Admin;
import domain.User;

import java.sql.ResultSet;
import java.sql.Statement;

public class LoginRepository extends BaseConnection{

    public User authenticate(String username, String password){
        try {
            User user = null;
            String query = "Select * from login where username = '"+username+"' and password = '"+password+"'";
            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery(query);

            while (rs.next()){
                user = new User();
                user.populate(rs);
            }
            return user;
        }catch (Exception e){
            e.printStackTrace();
        }
        return null;
    }

    public Admin authenticatead(String username, String password){
        try {
            Admin admin = null;
            String query = "Select * from login where username = '"+username+"' and password = '"+password+"'";
            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery(query);

            while (rs.next()){
                admin = new Admin();
                admin.populate(rs);
            }
            return admin;
        }catch (Exception e){
            e.printStackTrace();
        }
        return null;
    }
}
