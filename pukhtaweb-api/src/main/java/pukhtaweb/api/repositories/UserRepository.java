package pukhtaweb.api.repositories;

import pukhtaweb.api.entities.User;

public interface UserRepository {

    User insert(User user) throws ClassNotFoundException, Exception;

}
