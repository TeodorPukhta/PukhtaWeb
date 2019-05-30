package pukhtaweb.api.repositories;
import pukhtaweb.api.entities.BookEntity;
import pukhtaweb.api.entities.DetailsEntity;

public interface DetailRepository {
    DetailsEntity getBook (int id) throws ClassNotFoundException, Exception;
}