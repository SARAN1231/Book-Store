package com.saran.Book_store_server.Controller;

import com.saran.Book_store_server.Models.LoginDto;
import com.saran.Book_store_server.Models.UserModel;
import com.saran.Book_store_server.Services.UserService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("auth")
@CrossOrigin("*")
public class UserController {

    private final UserService userService;
    public UserController(UserService userService) {
        this.userService = userService;
    }

    @PostMapping("SignUp")
    public ResponseEntity<Object> signUp(@RequestBody UserModel user) {
        return userService.SignUp(user);
    }

    @PostMapping("Login")
    public ResponseEntity<Object> login(@RequestBody LoginDto user) {
        return userService.Login(user);
    }
}
