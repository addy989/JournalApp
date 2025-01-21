package com.practice.edigest.practice.Controller;

import com.practice.edigest.practice.Entity.UserEntity;
import com.practice.edigest.practice.Service.UserEntityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/user")
public class UserEntityController {

    @Autowired
    UserEntityService userEntityService;


    @GetMapping
    public List<UserEntity> getAllUSer(){
        return userEntityService.findAllUser();
    }

    @PostMapping
    public void createuser(@RequestBody UserEntity User){
        userEntityService.CreateUSer(User);
    }

    @PutMapping("/{username}")
    public ResponseEntity<UserEntity> updateUser(@RequestBody UserEntity user, @PathVariable String username) {
        UserEntity userInDb = userEntityService.findByUserName(username);
        if (userInDb != null) {
            userInDb.setUsername(user.getUsername()); // Assuming the user object in request body has username property
            userInDb.setPassword(user.getPassword());
            userEntityService.CreateUSer(userInDb);
            return new ResponseEntity<>(userInDb, HttpStatus.OK); // Return OK status code with updated user
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND); // User not found
        }
    }



}
