package pukhtaweb.api.controllres;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import pukhtaweb.api.entities.User;
import pukhtaweb.api.models.UserRegRequest;
import pukhtaweb.api.models.UserRegResponse;
import pukhtaweb.api.repositories.UserRepository;
import pukhtaweb.api.repositories.impl.UserRepositoryImpl;

import java.sql.SQLException;
import java.util.List;

@RestController
@CrossOrigin
public class UserController {

    @Autowired
    UserRepositoryImpl userRepository;

    @GetMapping(value = "/api/user")
    public ResponseEntity<List<User>> getAllUsers() {
        List<User> userEntities = userRepository.selectAll();
        return new ResponseEntity<>(userEntities, HttpStatus.OK);
    }

    @GetMapping(value = "/api/user/{user_id}")
    public ResponseEntity<User> getBook(@PathVariable Integer user_id) throws SQLException {
        User book = userRepository.findById(user_id);
        return new ResponseEntity<>(book, HttpStatus.OK);

    }

    @PostMapping("/api/user/register")
    public ResponseEntity<UserRegResponse> register(@RequestBody UserRegRequest regRequest) throws Exception {

        User newUser = new User();
        newUser.setEmail(regRequest.getEmail());
        newUser.setPassword(regRequest.getPassword());
        newUser.setFirstName(regRequest.getFirstName());
        newUser.setSurname(regRequest.getSurname());
        newUser.setPassword(regRequest.getPassword());
        newUser.setPhone(regRequest.getPhone());
        newUser.setActive(true);
        User insertedUser = this.userRepository.insert(newUser);
        UserRegResponse regResponse = new UserRegResponse();
        regResponse.setUserId(insertedUser.getId());
        return new ResponseEntity<>(regResponse, HttpStatus.OK);
    }


}