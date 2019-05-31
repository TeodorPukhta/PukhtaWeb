package pukhtaweb.api.controllres;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import pukhtaweb.api.models.ListDataResponse;
import pukhtaweb.api.repositories.impl.ListRepositoryImpl;

import java.sql.SQLException;
import java.util.List;

@RestController
@CrossOrigin
public class ListController{

    @Autowired
    ListRepositoryImpl listRepository;

    @GetMapping(value = "/api/list")
    public ResponseEntity<List<ListDataResponse>> getAllUsers() throws SQLException {
        List<ListDataResponse> listEntities = listRepository.selectAll2();
        return new ResponseEntity<>(listEntities, HttpStatus.OK);
    }

}
