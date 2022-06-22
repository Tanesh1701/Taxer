package Database;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import models.User;

public class UserDaoAccesser implements UserDao{
    static Connection connection = DatabaseConnection.getConnection();

    @Override
    public int insert(User user) throws SQLException {
        String query = "insert into users(userfullname, "+"username, "+ "email, " + "password)" + " VALUES (?, ?, ?, ?)";
        PreparedStatement ps = connection.prepareStatement(query);
        ps.setString(1, user.getFullName());
        ps.setString(2, user.getUserName());
        ps.setString(3, user.getEmail());
        ps.setString(4, user.getPassword());
        int n = ps.executeUpdate();
        return n;
    }

    @Override
    public void delete(int id) throws SQLException{
        String query = "delete from users where id =?";
        PreparedStatement ps = connection.prepareStatement(query);
        ps.setInt(1, id);
        ps.executeUpdate();
    }

    @Override
    public User getUser(String username, String password) throws SQLException {
  
        String query = "select * from users where username=? and password=?";
        PreparedStatement ps = connection.prepareStatement(query);
  
        ps.setString(1, username);
        ps.setString(2, password);
        User user = new User();
        ResultSet rs = ps.executeQuery();
        boolean check = false;
  
        while (rs.next()) {
            check = true;
            user.setId(rs.getInt("id"));
            user.setFullName(rs.getString("userfullname"));
            user.setUserName(rs.getString("username"));
            user.setEmail(rs.getString("email"));
            user.setPassword(rs.getString("password"));
        }
  
        if (check == true) {
            return user;
        }
        else
            return null;
    }

    @Override
    public ArrayList<User> getUsers() throws SQLException {
        String query = "select * from users";
        PreparedStatement ps = connection.prepareStatement(query);
        ResultSet rs = ps.executeQuery();
        ArrayList<User> ls = new ArrayList<User>();
  
        while (rs.next()) {
            User user = new User();
            user.setId(rs.getInt("id"));
            user.setFullName(rs.getString("userfullname"));
            user.setUserName(rs.getString("username"));
            user.setEmail(rs.getString("email"));
            user.setPassword(rs.getString("password"));
            ls.add(user);
        }
        return ls;
    }

    @Override
    public void update(User user) throws SQLException {
  
        String query = "update users set userfullname=?, " + " username=?, " + " email=?, " + " password=? " + " where emp_id = ?";
        PreparedStatement ps = connection.prepareStatement(query);
        ps.setString(1, user.getFullName());
        ps.setString(2, user.getUserName());
        ps.setString(3, user.getEmail());
        ps.setString(4, user.getPassword());
        ps.setInt(5, user.getId());
        ps.executeUpdate();
    }
}
