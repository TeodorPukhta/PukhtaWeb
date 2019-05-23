package pukhtaweb.api.repositories.impl;





import pukhtaweb.api.ConnectionManager;
import pukhtaweb.api.entities.User;
import pukhtaweb.api.repositories.UserRepository;
import org.springframework.stereotype.Repository;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;


@Repository
public class UserRepositoryImpl implements UserRepository {
    private static final String SELECT_ALL = "SELECT * FROM public.user";
    private static final String FIND_BY_ID = "SELECT * FROM public.user u  WHERE u.id=?";
    private static final String CREATE =
            "INSERT INTO public.user (\"email\",\"password\",\"firstname\",\"surname\",\"phone\",\"is_active\")\n" +
                    "VALUES(?,?,?,?,?,?) RETURNING id;";

    private static final String UPDATE = "UPDATE public.user  u SET  " +
            "\"email\" = ?,\"password\" = ?,\"firstname\" = ?,\"surname\" = ?,\"phone\" = ?,\"is_active\" = ?" +
            "WHERE u.id= ?";
    private static final String DELETE = "DELETE FROM public.user u WHERE u.id = ?";

    @Override
    public List<User> selectAll() {
        List<User> user = new ArrayList<>();
        try (
                Connection connection = ConnectionManager.getConnection();
                Statement statement = connection.createStatement();
                ResultSet resultSet = statement.executeQuery(SELECT_ALL)
        ) {
            while (resultSet.next()) {
                user.add(parseResultSet(resultSet));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return user;
    }

    @Override
    public User findById(Integer _id) throws SQLException {
        try (Connection connection = ConnectionManager.getConnection();
             PreparedStatement statement = connection.prepareStatement(FIND_BY_ID)) {
            statement.setInt(1, _id);
            ResultSet resultSet = statement.executeQuery();
            if (resultSet.next()) {
                return parseResultSet(resultSet);
            }

        }
        return null;

    }

    @Override
    public User insert(User entity) throws SQLException {
        try (Connection connection = ConnectionManager.getConnection();
             PreparedStatement statement = connection.prepareStatement(CREATE)) {
            setPreparedStatementData(statement, entity);
            try (ResultSet generatedKeys = statement.executeQuery()) {
                if (generatedKeys.next()) {
                    entity.setId(generatedKeys.getInt(1));
                }
            }
        }
        return entity;
    }

    @Override
    public int update(User entity) throws SQLException {
        try (Connection connection = ConnectionManager.getConnection();
             PreparedStatement statement = connection.prepareStatement(UPDATE)) {
            setPreparedStatementData(statement, entity);
            statement.setInt(7, entity.getId());
            return statement.executeUpdate();
        }
    }

    @Override
    public int delete(User entity) throws SQLException {
        try (Connection connection = ConnectionManager.getConnection();
             PreparedStatement statement = connection.prepareStatement(DELETE)) {
            statement.setInt(1, entity.getId());
            return statement.executeUpdate();
        }
    }

    private User parseResultSet(ResultSet resultSet) throws SQLException {
        Integer id = resultSet.getInt("id");
        String email = resultSet.getString("email");
        String password = resultSet.getString("password");
        String firstName = resultSet.getString("firstname");
        String surname = resultSet.getString("surname");
        String phone = resultSet.getString("phone");
        Boolean isActive = resultSet.getBoolean("is_active");
        return new User(id, email, password, firstName, surname, phone, isActive);
    }

    private void setPreparedStatementData(PreparedStatement statement, User entity) throws SQLException {
        statement.setString(1, entity.getEmail());
        statement.setString(2, entity.getPassword());
        statement.setString(3, entity.getFirstName());
        statement.setString(4, entity.getSurname());
        statement.setString(5, entity.getPhone());
        statement.setBoolean(6, entity.isActive());
    }

}