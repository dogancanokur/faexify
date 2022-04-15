package net.okur.faexify.user.services.impl;

import net.okur.faexify.user.entity.User;
import net.okur.faexify.user.repository.UserRepository;
import net.okur.faexify.user.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {

    private final UserRepository repository;
    private final PasswordEncoder passwordEncoder;

    @Autowired
    public UserServiceImpl(UserRepository repository) {
        this.repository = repository;
        this.passwordEncoder = new BCryptPasswordEncoder();
    }

    @Override
    public User saveUser(User user) {
        // password encode
        System.out.println(user.getPassword());
        user.setPassword(this.passwordEncoder.encode(user.getPassword()));
        repository.save(user);
        return user;
    }
}
