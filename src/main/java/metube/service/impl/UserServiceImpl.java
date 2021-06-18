package metube.service.impl;

import metube.config.Mapper;
import metube.domain.entities.User;
import metube.domain.model.UserServiceModel;
import metube.repository.UserRepository;
import metube.repository.UserRepositoryImpl;
import metube.service.UserService;
import org.apache.commons.codec.digest.DigestUtils;

public class UserServiceImpl implements UserService {

    private final UserRepositoryImpl userRepository = new UserRepositoryImpl();
    private final Mapper mapper = new Mapper();

    @Override
    public void register(String username, String email, String password, String confirmPassword) {
        UserServiceModel userServiceModel = new UserServiceModel();

        userServiceModel.setUsername(username);
        userServiceModel.setEmail(email);
        userServiceModel.setPassword(password);
        this.userRepository.save(mapper.map(userServiceModel,User.class));
    }

    @Override
    public User login(String username, String password) {
        User user = this.userRepository.findByUsername(username);
        if (user==null){
            return null;
        }

        if (!user.getPassword().equals(password)){
         return null;
        }
        return user;
    }
}
