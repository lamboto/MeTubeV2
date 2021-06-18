package metube.service;

import metube.domain.entities.User;
import metube.domain.model.UserServiceModel;

public interface UserService {
    void register(String username,String email,String password,String confirmPassword);

    User login(String username, String password);
}
