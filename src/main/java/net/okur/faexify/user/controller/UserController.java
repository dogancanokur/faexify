package net.okur.faexify.user.controller;

import lombok.extern.slf4j.Slf4j;
import net.okur.faexify.shared.GenericResponse;
import net.okur.faexify.user.entity.User;
import net.okur.faexify.user.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Slf4j
public class UserController {
    private final UserService service;

    @Autowired
    public UserController(UserService service) {
        this.service = service;
    }

    // rest cogul kullanmayi tavsiye ediyor
//    @CrossOrigin // gui de proxy ayari sayesinde gerek kalmadi
    @PostMapping("/api/v1.0/users")
    public GenericResponse createUser(@RequestBody User user) {
        user = service.saveUser(user);
        log.info(user.toString());
        return new GenericResponse("user created");
    }

}