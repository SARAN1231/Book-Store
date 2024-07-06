package com.saran.Book_store_server.Services;

import com.saran.Book_store_server.Models.LoginDto;
import com.saran.Book_store_server.Models.UserModel;
import com.saran.Book_store_server.Repository.UserRepository;
import org.mindrot.jbcrypt.BCrypt;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    private final UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public ResponseEntity<Object> SignUp(UserModel user) {
        try {
            UserModel userModel = userRepository.findUserByEmail(user.getEmail());
            if (userModel != null) {
                return new ResponseEntity<>("User Already Exists", HttpStatus.BAD_REQUEST);
            }
            String hashedpass = BCrypt.hashpw(user.getPassword(), BCrypt.gensalt()); // salt refers that bcrypt algorithm add some extra strings(SALT) to hash the pass for more security
            user.setPassword(hashedpass);
            userRepository.save(user);
            user.setPassword(null);  // To ensure the password is not returned // pass is null after saving to repo so no prblm,
        // i need to send the user credentials to the client to say  that he ia authenticated user
            return new ResponseEntity<>(user, HttpStatus.CREATED);
        }
        catch (Exception e) {
            return new ResponseEntity<>(e.getMessage(), HttpStatus.BAD_REQUEST);
        }
    }


    public ResponseEntity<Object> Login(LoginDto user) {
        try {
            UserModel userModel = userRepository.findUserByEmail(user.email());
            if (userModel == null) {
                return new ResponseEntity<>("User Not Found", HttpStatus.NOT_FOUND);
            }
            boolean s = BCrypt.checkpw(user.password(), userModel.getPassword());
            if (s) {
                        userModel.setPassword(null);

                return new ResponseEntity<>(userModel, HttpStatus.OK);
            }
            return new ResponseEntity<>("Invalid Credentials", HttpStatus.NOT_FOUND);
        }
        catch (Exception e) {
            return new ResponseEntity<>(e.getMessage(), HttpStatus.BAD_REQUEST);
        }
    }
}
