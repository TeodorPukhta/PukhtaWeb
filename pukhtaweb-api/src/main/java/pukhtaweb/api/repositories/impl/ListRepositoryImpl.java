package pukhtaweb.api.repositories.impl;

        import pukhtaweb.api.ConnectionManager;
        import pukhtaweb.api.entities.ListEntity;
        import pukhtaweb.api.models.ListDataResponse;
        import pukhtaweb.api.repositories.ListRepository;
        import org.springframework.stereotype.Repository;

        import java.sql.*;
        import java.util.ArrayList;
        import java.util.List;

@Repository
public class ListRepositoryImpl implements ListRepository {
    private static final String SELECT_ALL = "SELECT * FROM public.bookslist";
    private static final String SELECT_ALL2 = "SELECT a.id, u.surname, b.name, a.accept FROM public.bookslist a JOIN public.\"user\" u ON  a.user_id=u.id JOIN  public.\"book\" b ON a.book_id = b.id";
    private static final String CREATE = "INSERT INTO \"bookslist\" (\"user_id\",\"book_id\",\"accept\")\n" + "VALUES(?,?,?) RETURNING id;";
    public static void main(String[] args) throws SQLException {
        new ListRepositoryImpl().insert(new ListEntity(0, 1, 1));
        new ListRepositoryImpl().selectAll().forEach(System.out::println);

    }

    @Override
    public ListEntity insert(ListEntity entity) throws SQLException {
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
    public List<ListEntity> selectAll() throws SQLException {
        List<ListEntity> entities = new ArrayList<>();
        try (
                Connection connection = ConnectionManager.getConnection();
                Statement statement = connection.createStatement();
                ResultSet resultSet = statement.executeQuery(SELECT_ALL)
        ) {
            while (resultSet.next()) {
                entities.add(parseResultSet(resultSet));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return entities;
    }

    @Override
    public List<ListDataResponse> selectAll2() throws SQLException {
        List<ListDataResponse> entities = new ArrayList<>();
        try (
                Connection connection = ConnectionManager.getConnection();
                Statement statement = connection.createStatement();
                ResultSet resultSet = statement.executeQuery(SELECT_ALL2)
        ) {
            while (resultSet.next()) {
                entities.add(parseResultSet2(resultSet));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return entities;
    }

    @Override
    public ListEntity findById(Integer id) throws SQLException {
        return null;
    }

    @Override
    public int update(ListEntity entity) throws SQLException {
        return 0;
    }

    @Override
    public int delete(ListEntity entity) throws SQLException {
        return 0;
    }

    private ListEntity parseResultSet(ResultSet resultSet) throws SQLException {
        Integer id = resultSet.getInt("id");
        Integer userId = resultSet.getInt("user_id");
        Integer bookId = resultSet.getInt("book_id");
        return new ListEntity(id, userId, bookId);
    }
    private ListDataResponse parseResultSet2(ResultSet resultSet) throws SQLException {
        Integer id = resultSet.getInt("id");
        String user = resultSet.getString("surname");
        String book = resultSet.getString("name");
        String accept;
        if( resultSet.getBoolean("accept")){
            accept = "+";
        }else{
            accept ="-";
        }

        return new ListDataResponse(id,user,book,accept);
    }
    private void setPreparedStatementData(PreparedStatement statement, ListEntity entity) throws SQLException {
        statement.setInt(1, entity.getUserId());
        statement.setInt(2, entity.getBookId());
        statement.setBoolean(3,entity.getAccept());
    }
}