package metube.repository;

import metube.config.DataBaseConnector;
import metube.domain.entities.Tube;
import metube.domain.entities.User;
import metube.exception.SqlException;
import metube.query.Query;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class UserRepositoryImpl implements UserRepository {

    DataBaseConnector connector = new DataBaseConnector();


    @Override
    public void save(User user) {
        try (Connection connection = connector.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(Query.INSERT_USER)) {
            preparedStatement.setString(1, user.getUsername());
            preparedStatement.setString(2, user.getPassword());
            preparedStatement.setString(3, user.getEmail());
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            SqlException.printSQLException(e);
        }

    }

    @Override
    public void update(User entity) {

    }

    @Override
    public List<User> findAll() {
        List<User> users = new ArrayList<>();

        try (Connection connection = this.connector.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(Query.SELECT_ALL_USERS)) {


            ResultSet rs = preparedStatement.executeQuery();


            while (rs.next()) {
                String username = rs.getString("username");
                String password = rs.getString("password");
                String email = rs.getString("email");

                users.add(new User(username, password, email));
            }
        } catch (SQLException e) {
            SqlException.printSQLException(e);
        }

        return users;
    }

    @Override
    public User findById(Integer id) {
        User user = null;
        try (Connection connection = connector.getConnection();

             PreparedStatement preparedStatement = connection.prepareStatement(Query.SELECT_USER_BY_ID)) {
            preparedStatement.setInt(1, id);

            ResultSet rs = preparedStatement.executeQuery();

            while (rs.next()) {
                String username = rs.getString("username");
                String password = rs.getString("password");
                String email = rs.getString("email");

                user = new User(id, username, password, email);
            }
        } catch (SQLException e) {
            SqlException.printSQLException(e);
        }
        return user;
    }

    public User findByUsername(String username) {
        User user = null;
        try (Connection connection = connector.getConnection();

             PreparedStatement preparedStatement = connection.prepareStatement(Query.SELECT_USER_BY_USERNAME)) {
            preparedStatement.setString(1, username);

            ResultSet rs = preparedStatement.executeQuery();

            while (rs.next()) {
                int id = rs.getInt("id");
                String password = rs.getString("password");
                String email = rs.getString("email");
                user = new User(id, username, password, email);
            }
        } catch (SQLException e) {
            SqlException.printSQLException(e);
        }
        return user;
    }

    @Override
    public long size() {
        int size = 0;
        try (Connection connection = connector.getConnection();

             PreparedStatement preparedStatement = connection.prepareStatement(Query.SELECT_COUNT_OF_ALL_USERS)) {

            ResultSet rs = preparedStatement.executeQuery();


            if (rs != null) {
                rs.last();
                size = rs.getRow();
            }
        } catch (SQLException e) {
            SqlException.printSQLException(e);
        }
        return size;
    }
}
