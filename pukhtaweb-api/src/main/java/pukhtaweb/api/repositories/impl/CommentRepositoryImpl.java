package pukhtaweb.api.repositories.impl;

import pukhtaweb.api.ConnectionManager;
import pukhtaweb.api.entities.CommentEntity;
import pukhtaweb.api.models.CommentCheck;
import pukhtaweb.api.models.CommentAdd;
import pukhtaweb.api.models.CommentBook;
import pukhtaweb.api.repositories.CommentRepository;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.sql.*;

@Repository
public class CommentRepositoryImpl implements CommentRepository {

    private static final String INSERT_USER_SQL = "INSERT INTO \"comment\" (user_id, book_id, comment, accept) VALUES (?, ?, ?, ?) RETURNING id";

    @Override
    public boolean check(int idComment) {
        System.out.println("count" + count(getBookId(idComment)));
        if (count(getBookId(idComment)) > 0) {
            return false;
        } else {
            return true;
        }
    }

    int count(int bookId) {
        CommentCheck count = new CommentCheck();
        try (Connection connection = ConnectionManager.getConnection();
             Statement statement = connection.createStatement();
             ResultSet resultSet = statement.executeQuery("SELECT COUNT(accept)\n" +
                     "\tFROM public.comment \n" +
                     "\tWHERE book_id=" + bookId + "and accept=true\n" +
                     "\t");
        ) {
            while (resultSet.next()) {
                count.setAccept(resultSet.getInt("count"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return count.getAccept();
    }

    int getBookId(int commentId) {
        CommentBook id_book = new CommentBook();
        try (Connection connection = ConnectionManager.getConnection();
             Statement statement = connection.createStatement();
             ResultSet resultSet = statement.executeQuery("SELECT c.book_id\n" +
                     "\tFROM public.comment c\n" +
                     "\tWHERE id=" + commentId);
        ) {
            while (resultSet.next()) {
                id_book.setBook_id(resultSet.getInt("book_id"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return id_book.getBook_id();
    }

    @Override
    public CommentAdd insert(CommentAdd comment) throws SQLException {
        try (Connection dbConnection = ConnectionManager.getConnection()) {
            try (PreparedStatement statement = dbConnection.prepareStatement(INSERT_USER_SQL)) {
                statement.setInt(1, comment.getUser_id());
                statement.setInt(2, comment.getBook_id());
                statement.setString(3, comment.getComment());
                statement.setBoolean(4, comment.getAccept());
                try (ResultSet generatedKeys = statement.executeQuery()) {
                    if (generatedKeys.next()) {
                        comment.setId(generatedKeys.getInt(1));
                    }
                }
            }
        }

        return comment;
    }

    @Override
    public int updateBook(int idComment) throws SQLException {
        Connection connection = ConnectionManager.getConnection();
        Statement statement = connection.createStatement();
        int resultSet = statement.executeUpdate("UPDATE public.bookslist SET  accept=true WHERE book_id=" + getBookId(idComment));
        return resultSet;

    }

    @Override
    public int update(int idComment) throws SQLException {
        Connection connection = ConnectionManager.getConnection();
        Statement statement = connection.createStatement();
        int resultSet = statement.executeUpdate("UPDATE public.comment SET  accept=true WHERE id=" + idComment);
        return resultSet;
    }


    @Override
    public List<CommentEntity> get(int id) throws SQLException {
        List<CommentEntity> comments = new ArrayList<>();
        try (Connection connection = ConnectionManager.getConnection();
             Statement statement = connection.createStatement();
             ResultSet resultSet = statement.executeQuery("SELECT  c.id, u.email, c.comment,c.accept FROM public.comment  c JOIN public.user u ON  c.user_id=u.id WHERE c.book_id=" + id)) {
            while (resultSet.next()) {
                comments.add(parseResultSet(resultSet));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return comments;
    }

    private CommentEntity parseResultSet(ResultSet resultSet) throws SQLException {
        CommentEntity com = new CommentEntity();

        com.setId(resultSet.getInt("id"));
        com.setUser(resultSet.getString("email"));
        com.setComment(resultSet.getString("comment"));
        if(resultSet.getBoolean("accept")==true)
            com.setAccept("+");
        else com.setAccept("-");

        return com;
    }
}