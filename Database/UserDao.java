package Database;
import java.sql.SQLException;
import java.util.ArrayList;
import models.*;

public interface UserDao {
    public int insert(User user) throws SQLException;
    public void delete(int id) throws SQLException;
    public User getUser(String username, String password) throws SQLException;
    public ArrayList<User> getUsers() throws SQLException;
    public ArrayList<User> getAdmins() throws SQLException;
    public void update(User user, int id) throws SQLException;
}