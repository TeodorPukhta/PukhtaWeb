package pukhtaweb.api.controllres;

import pukhtaweb.api.entities.CommentEntity;
import pukhtaweb.api.entities.DetailsEntity;
import pukhtaweb.api.models.*;
import pukhtaweb.api.repositories.impl.CommentRepositoryImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.*;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

@RestController
@CrossOrigin
public class CommentController {
    @Autowired
    CommentRepositoryImpl CommentRepository;

    @PutMapping("/api/comment/{id}/accept")
    public void accept(@PathVariable int id)throws Exception{
        System.out.println("CommentId="+id);

        if( CommentRepository.check(id)){
            CommentRepository.update(id);
            CommentRepository.updateBook(id);
        }

    }

    @PostMapping("/api/comment/{idBook}/register")
    public CommentRegResponse register(@RequestBody CommentRegRequest regRequest, @PathVariable int idBook) throws Exception {

        CommentAdd newComment=new CommentAdd();
        newComment.setBook_id(idBook);
        newComment.setUser_id(5);
        newComment.setAccept(false);
        newComment.setComment(regRequest.getComment());
        CommentAdd insertedComment= CommentRepository.insert(newComment);


        CommentRegResponse regResponse = new CommentRegResponse();
        regResponse.setId(insertedComment.getId());
        return regResponse;
    }


    @GetMapping(value = "/api/comments/{idBook}/comment")
    public ResponseEntity<List<CommentEntity>> comment(@PathVariable int idBook) throws SQLException {
        System.out.println("idbook="+idBook);
        List<CommentEntity> comments= CommentRepository.get(idBook);
        if(comments.isEmpty()){
            comments.add(NoComment());
        }
        return new ResponseEntity<>(comments, HttpStatus.OK);
    }

    public CommentEntity NoComment(){

        CommentEntity not=new CommentEntity();
        not.setId(666);
        not.setUser("No comments");
        not.setAccept("----");
        not.setComment("----");
        return not;
    }
}