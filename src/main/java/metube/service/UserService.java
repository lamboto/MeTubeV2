package metube.service;

import metube.domain.entities.User;

public interface UserService {
    void register(String username, String email, String password, String confirmPassword);

    User login(String username, String password);

    void getByUsername(String username);
}
