package com.example.demo.controller;
import com.example.demo.model.User;
import com.example.demo.service.ServiceUser;
import com.example.demo.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api")
@CrossOrigin
public class UserController {
    @Autowired
    private ServiceUser serviceUser;
    @Autowired
    private UserService userService;

    @GetMapping("/users")
    public List<User> getAllUsers() {
        return userService.getAllUsers();
    }

    @PostMapping("/signup")
    public ResponseEntity<User> createUser(@RequestBody User user) {
        User createdUser = serviceUser.createUser(user);
        return ResponseEntity.ok(createdUser);
    }

    @PostMapping("/signin")
    public ResponseEntity<?> signIn(@RequestBody User loginRequest) {
        return ResponseEntity.ok(userService.signIn(loginRequest.getUsername(), loginRequest.getPassword()));
    }

    @GetMapping("/user")
    public ResponseEntity<User> getUser(@RequestParam(required = false) String username,
                                        @RequestParam(required = false) String email) {
        if (username != null) {
            return ResponseEntity.ok(serviceUser.getUserByUsername(username));
        } else if (email != null) {
            return ResponseEntity.ok(serviceUser.getUserByEmail(email));
        } else {
            return ResponseEntity.badRequest().build();
        }
    }
}
