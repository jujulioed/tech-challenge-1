package br.com.jujulioed.my_users.controllers;

import br.com.jujulioed.my_users.dtos.PasswordValidatonRequest;
import br.com.jujulioed.my_users.entities.User;
import br.com.jujulioed.my_users.services.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;


@RestController
@RequestMapping("/users")
public class UserController {
    private static final Logger logger = LoggerFactory.getLogger(UserController.class);

    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }


    @GetMapping
    public ResponseEntity<List<User>> findAllUsers(
            @RequestParam("page") int page,
            @RequestParam("size") int size
    ) {
        logger.info("Accessed the /users endpoint");
        var users = this.userService.findAllUsers(page, size);
        return ResponseEntity.ok(users);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Optional<User>> findUser(
            @PathVariable("id") Long id
    ) {
        logger.info("/users/{}", id);
        var user = this.userService.findUserById(id);
        return ResponseEntity.ok(user);
    }

    @PostMapping
    public ResponseEntity<Void> saveUser(
            @RequestBody User user
    ){
        logger.info("POST =>  /pessoas");
        logger.info(user.getUsername());
        this.userService.saveUser(user);
        return ResponseEntity.status(201).build();
    }

    @PutMapping("/{id}")
    public ResponseEntity<Void> updateUser(
            @PathVariable("id") Long id,
            @RequestBody User user
    ){
        logger.info("PUT => /pessoas/" + id);
        this.userService.updateUser(user, id);
        var status = HttpStatus.NO_CONTENT;
        return ResponseEntity.status(status.value()).build();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteUser(
            @PathVariable("id") Long id
    ){
        logger.info("DELETE => /users/{}", id);
        this.userService.delete(id);
        return ResponseEntity.ok().build();
    }

    @PostMapping("/validate-password")
    public ResponseEntity<String> validatePassword(
            @RequestBody PasswordValidatonRequest request) {
        logger.info("POST => Validate password endpoint accessed");
        boolean isValid = this.userService.validatePassword(request.username(), request.password());
        return ResponseEntity.ok(isValid ? "Valid Password" : "Invalid Password");
    }

}
