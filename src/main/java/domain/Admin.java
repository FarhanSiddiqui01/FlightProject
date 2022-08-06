package domain;

import java.sql.ResultSet;
import java.sql.SQLException;

public class Admin {
    private Long id;
    private String userName;
    private String password;
    private String type;

    public Admin() {
    }

    public Admin(Long id, String userName, String password, String type) {
        this.id = id;
        this.userName = userName;
        this.password = password;
        this.type = type;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    @Override
    public String toString() {
        return "Admin{" +
                "id=" + id +
                ", userName='" + userName + '\'' +
                ", password='" + password + '\'' +
                ", type='" + type + '\'' +
                '}';
    }

    public void populate(ResultSet rs) throws SQLException {
        this.setId(Long.parseLong(rs.getString("id")));
        this.setUserName(rs.getString("username"));
        this.setPassword(rs.getString("password"));
        this.setType(rs.getString("type"));
    }
}
