package pukhtaweb.api.controllres;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import pukhtaweb.api.entities.BookEntity;
import pukhtaweb.api.entities.ListEntity;
import pukhtaweb.api.entities.User;
import pukhtaweb.api.models.BookRegRequest;
import pukhtaweb.api.models.ListAddResponse;
import pukhtaweb.api.models.ListDataResponse;
import pukhtaweb.api.repositories.BookRepository;
import pukhtaweb.api.repositories.ListRepository;
import pukhtaweb.api.repositories.UserRepository;
import pukhtaweb.api.repositories.impl.BookRepositoryImpl;
import pukhtaweb.api.repositories.impl.ListRepositoryImpl;
import pukhtaweb.api.repositories.impl.UserRepositoryImpl;

import java.sql.SQLException;
import java.util.List;

@RestController
@CrossOrigin
public class ListController{
//    @Autowired
//    ListRepositoryImpl listRepository;
//
//
//    @GetMapping(value = "/api/list")
//    public ResponseEntity<List<ListDataResponse>> getAllUsers() throws SQLException {
//        List<ListDataResponse> listEntities = listRepository.selectAll2();
//        return new ResponseEntity<>(listEntities, HttpStatus.OK);
//    }
//
//    @PostMapping("/api/list/add")
//    public ResponseEntity register(@RequestBody ListAddRequest request) throws Exception {
//        ListEntity listEntity = new ListEntity();
//        listEntity.setBookId(request.getBookId());
//        listEntity.setUserId(request.getUserId());
//        listEntity.setListTimestamp(LocalDateTime.now());
//        ListEntity insertedListEntity = listRepository.insert(listEntity);
//        ListAddResponse regResponse = new ListAddResponse();
//        regResponse.setId(insertedListEntity.getId());
//        return new ResponseEntity<>(regResponse, HttpStatus.OK);
//    }

    @Autowired
    ListRepositoryImpl listRepository;

    @GetMapping(value = "/api/list")
    public ResponseEntity<List<ListDataResponse>> getAllUsers() throws SQLException {
        List<ListDataResponse> listEntities = listRepository.selectAll2();
        return new ResponseEntity<>(listEntities, HttpStatus.OK);
    }

}
