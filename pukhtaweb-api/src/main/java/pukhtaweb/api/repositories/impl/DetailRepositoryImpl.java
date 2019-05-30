package pukhtaweb.api.repositories.impl;

import pukhtaweb.api.ConnectionManager;
import pukhtaweb.api.entities.BookEntity;
import pukhtaweb.api.entities.DetailsEntity;
import pukhtaweb.api.repositories.DetailRepository;
import org.springframework.stereotype.Repository;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
@Repository
public class DetailRepositoryImpl implements DetailRepository {
    @Override
    public DetailsEntity getBook(int id) throws SQLException {
        DetailsEntity det= new DetailsEntity();
        try (Connection connection = ConnectionManager.getConnection();
             Statement statement = connection.createStatement();
             ResultSet resultSet = statement.executeQuery("SELECT  b.id, b.name, b.genre, b.description,b.author, b.year, u.id, u.email, u.phone, u.firstname, u.surname FROM public.bookslist  a JOIN public.user u ON  a.user_id=u.id JOIN  public.book b ON a.book_id = b.id WHERE a.id="+id))
        { while (resultSet.next()) {
            det=parseResultSet(resultSet);
        }
        }
        catch (SQLException e) {
            e.printStackTrace();
        }
        return det;
    }
    private DetailsEntity parseResultSet(ResultSet resultSet) throws SQLException {
        DetailsEntity det = new DetailsEntity();
        det.setIdBook(resultSet.getInt("id"));
        det.setNameBook(resultSet.getString("name"));
        det.setGenreBook(resultSet.getString("genre"));
        det.setDescriptionBook(resultSet.getString("description"));
        det.setYearBook(resultSet.getString("year"));
        det.setAuthorBook(resultSet.getString("author"));

        det.setIdUser(resultSet.getLong("id"));
        det.setEmailUser(resultSet.getString("email"));
        det.setPhoneUser(resultSet.getString("phone"));
        det.setFirstNameUser(resultSet.getString("firstname"));
        det.setSurnameUser(resultSet.getString("surname"));
        return det;
    }
}