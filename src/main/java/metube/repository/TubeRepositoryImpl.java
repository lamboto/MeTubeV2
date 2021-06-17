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

public class TubeRepositoryImpl implements TubeRepository {

    DataBaseConnector connector = new DataBaseConnector();


    @Override
    public void save(Tube tube) {
        try (Connection connection = connector.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(Query.INSERT_TUBE)) {
            preparedStatement.setString(1, tube.getAuthor());
            preparedStatement.setString(2, tube.getDescription());
            preparedStatement.setString(3, tube.getYoutubeId());
            preparedStatement.setLong(4, tube.getViews());
            preparedStatement.setInt(5, tube.getUserId());
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            SqlException.printSQLException(e);
        }
    }

    @Override
    public List<Tube> findAll() {
        List<Tube> tubes = new ArrayList<>();

        try (Connection connection = this.connector.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(Query.SELECT_ALL_TUBES)) {


            ResultSet rs = preparedStatement.executeQuery();


            while (rs.next()) {
                String title = rs.getString("title");
                String author = rs.getString("author");
                String description = rs.getString("description");
                String youtube_id = rs.getString("youtube_id");
                long views = rs.getLong("views");

                tubes.add(new Tube(title, author, description, youtube_id, views));
            }
        } catch (SQLException e) {
            SqlException.printSQLException(e);
        }

        return tubes;
    }


    @Override
    public Tube findById(Integer id) {
        Tube tube = null;
        try (Connection connection = connector.getConnection();

             PreparedStatement preparedStatement = connection.prepareStatement(Query.SELECT_TUBE_BY_ID)) {
            preparedStatement.setInt(1, id);

            ResultSet rs = preparedStatement.executeQuery();

            while (rs.next()) {
                String title = rs.getString("title");
                String author = rs.getString("author");
                String description = rs.getString("description");
                String youtube_id = rs.getString("youtube_id");
                long views = rs.getLong("views");
                tube = new Tube(id, title, author, description, youtube_id, views);
            }
        } catch (SQLException e) {
            SqlException.printSQLException(e);
        }
        return tube;
    }


    @Override
    public long size() {
        int size = 0;
        try (Connection connection = connector.getConnection();

             PreparedStatement preparedStatement = connection.prepareStatement(Query.SELECT_COUNT_OF_ALL_TUBES)) {

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