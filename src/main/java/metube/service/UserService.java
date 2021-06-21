package metube.service;

import metube.domain.model.UserCreateServiceModel;
import metube.domain.model.UserLoginServiceModel;

public interface UserService {
    void register(String username,String email,String password,String confirmPassword);

        UserLoginServiceModel login(String username, String password);
}
