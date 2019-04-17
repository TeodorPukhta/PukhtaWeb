package pukhtaweb.api.controllres;

import pukhtaweb.api.entities.User;
import pukhtaweb.api.models.UserRegRequest;
import pukhtaweb.api.models.UserRegResponse;
import pukhtaweb.api.repositories.UserRepository;
import pukhtaweb.api.repositories.impl.UserRepositoryImpl;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin
public class UserController {

    private final UserRepository userRepository;

    public UserController() {
        this.userRepository = new UserRepositoryImpl();
    }

    @PostMapping("/api/user/register")
    public UserRegResponse register(@RequestBody UserRegRequest regRequest) throws Exception {

        User newUser = new User();
        newUser.setEmail(regRequest.getEmail());
        newUser.setPhone(regRequest.getPhone());
        newUser.setPassword(regRequest.getPassword());
        newUser.setFirstName(regRequest.getFirstname());
        newUser.setSurname(regRequest.getSurname());
        newUser.setActive(true);

        User insertedUser = this.userRepository.insert(newUser);

        UserRegResponse regResponse = new UserRegResponse();
        regResponse.setUserId(insertedUser.getId());

        return regResponse;
    }

}