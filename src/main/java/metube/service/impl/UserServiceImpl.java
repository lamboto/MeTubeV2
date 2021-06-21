package metube.service.impl;

import metube.config.Mapper;
import metube.domain.entities.User;
import metube.domain.model.UserCreateServiceModel;
import metube.domain.model.UserLoginServiceModel;
import metube.repository.UserRepositoryImpl;
import metube.service.UserService;

public class UserServiceImpl implements UserService {

    private final UserRepositoryImpl userRepository = new UserRepositoryImpl();
    private final Mapper mapper = new Mapper();

    @Override
    public void register(String username, String email, String password, String confirmPassword) {
        UserCreateServiceModel userCreateServiceModel = new UserCreateServiceModel();

        userCreateServiceModel.setUsername(username);
        userCreateServiceModel.setEmail(email);
        userCreateServiceModel.setPassword(password);
        this.userRepository.save(mapper.map(userCreateServiceModel, User.class));
    }

    @Override
    public User login(String username, String password) {
        User user = this.userRepository.findByUsername(username);
        if (user == null) {
            return null;
        }

        if (!user.getPassword().equals(password)) {
            return null;
        }
        return user;
    }

    public void getByUsername(String username) {
        this.userRepository.findByUsername(username);
    }
}
