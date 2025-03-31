package application.petsybackend.controllers;

import application.petsybackend.dtos.user.UserDTO;
import application.petsybackend.dtos.user.UserRequest;
import application.petsybackend.entities.user.User;
import application.petsybackend.services.UserService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/user")
public class UserController {

    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @PostMapping
    public ResponseEntity<UserDTO> getUser(@RequestBody UserRequest request){
        UserDTO createdUser = userService.createUser(request);
        return ResponseEntity.status(HttpStatus.CREATED).body(createdUser);
    }
}
