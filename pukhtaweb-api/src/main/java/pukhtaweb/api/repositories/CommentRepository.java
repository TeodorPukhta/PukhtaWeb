package pukhtaweb.api.repositories;
import pukhtaweb.api.entities.CommentEntity;
import pukhtaweb.api.models.CommentAdd;
import java.util.List;

public interface CommentRepository {

 boolean check (int idComment)throws ClassNotFoundException, Exception;
    CommentAdd insert (CommentAdd comment) throws ClassNotFoundException, Exception;
    List<CommentEntity> get (int id) throws ClassNotFoundException, Exception;
    int update ( int idComment) throws ClassNotFoundException, Exception;
    int updateBook (int idComment) throws ClassNotFoundException, Exception;
}
