package pukhtaweb.api.controllres;

import pukhtaweb.api.entities.DetailsEntity;
import pukhtaweb.api.repositories.impl.DetailRepositoryImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.sql.SQLException;

@RestController
@CrossOrigin
public class DetailController {
    @Autowired
    DetailRepositoryImpl detailRepository;

    @GetMapping(value = "/api/list/{Id}/details")
    public ResponseEntity<DetailsEntity> details(@PathVariable int Id) throws SQLException {
        DetailsEntity det;
        det=detailRepository.getBook(Id);
        return new ResponseEntity<>(det, HttpStatus.OK);
    }
}