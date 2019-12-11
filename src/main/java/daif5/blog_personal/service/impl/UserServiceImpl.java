package daif5.blog_personal.service.impl;

import daif5.blog_personal.model.signinSignup.User;
import daif5.blog_personal.repository.UserRepository;
import daif5.blog_personal.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;
import java.util.Optional;

public class UserServiceImpl implements UserService {
    @Autowired
    UserRepository userRepository;
    @Override
    public Optional<User> findById(Long id) {
        return userRepository.findById(id);
    }

    @Override
    public Optional<User> findByUsername(String username) {
       return userRepository.findByUsername(username);
    }

    @Override
    public void save(User user) {
    userRepository.save(user);
    }

    @Override
    public List<User> findAll() {
        return userRepository.findAll();
    }

    @Override
    public void delete(User user) {
        userRepository.delete(user);
    }
}
