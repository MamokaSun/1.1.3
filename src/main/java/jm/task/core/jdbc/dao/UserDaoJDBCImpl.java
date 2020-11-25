package jm.task.core.jdbc.dao;

import jm.task.core.jdbc.model.User;
import jm.task.core.jdbc.util.Util;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class UserDaoJDBCImpl implements UserDao {
    public UserDaoJDBCImpl() {
    }

    public void createUsersTable() {
        String sqlCommand = "CREATE TABLE IF NOT EXISTS user(Id BIGINT PRIMARY KEY AUTO_INCREMENT,Name VARCHAR(20), LastName VARCHAR(20), Age TINYINT)";
        try {
            Util.getConection().executeUpdate(sqlCommand);
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }

    public void dropUsersTable() {
        try {
            Util.getConection().executeUpdate("DROP TABLE IF EXISTS user");
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }

    public void saveUser(String name, String lastName, byte age) {
        try {
            Util.getConection().executeUpdate("INSERT User(Name, LastName, Age) VALUES ( '" + name + "', '" + lastName + "', '" + age +"')");
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }

    public void removeUserById(long id) {
        try {
            Util.getConection().executeUpdate("DELETE FROM user WHERE Id = " + id);
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }

    public List<User> getAllUsers() {
        try {
            ResultSet resultSet = Util.getConection().executeQuery("SELECT * FROM user");
            List<User> arr = new ArrayList<>();
            while (resultSet.next()){
                String name = resultSet.getString(2);
                String lastName = resultSet.getString(3);
                byte age = resultSet.getByte(4);
                arr.add(new User(name,lastName,age));
            }
            return arr;
        } catch (SQLException throwables){ }
        return null;
    }

    public void cleanUsersTable() {
        try {
            Util.getConection().executeUpdate("DELETE FROM user ");
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }
}
