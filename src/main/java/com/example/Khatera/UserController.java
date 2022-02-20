package com.example.Khatera;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "api/v1/user")
public class UserController {


    private final UserService mUserService;

    @Autowired
    public UserController(UserService userService) {
        mUserService = userService;
    }

    @GetMapping
    public List<UserClass> getUsers() {
        return mUserService.getUsers();
    }

    @PostMapping
    public void addUser(@RequestBody UserClass user) {
        mUserService.addUser(user);
    }

    @PutMapping(path = "{userId}")
    public void updateUser(
            @PathVariable("userId") Long userId,
            @RequestParam(required = false) String name,
            @RequestParam(required = false) String password,
            @RequestParam(required = false) String username
            ) {
        mUserService.updateUser(userId, name, password, username);

    }

    @DeleteMapping(path = "{userId}")
    public void deleteUser(@PathVariable("userId") Long userId) {
        mUserService.deleteUser(userId);
    }
}
