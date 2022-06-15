package Database;
import java.sql.SQLException;
import java.util.List;

import models.*;

public interface UserDao {
    public int insert(User user)
        throws SQLException;
    public void delete(int id)
        throws SQLException;
    public User getUser(int id)
        throws SQLException;
    public List<User> getUsers()
        throws SQLException;
    public void update(User emp)
        throws SQLException;
}
