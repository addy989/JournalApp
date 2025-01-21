package com.practice.edigest.practice.Service;

import com.practice.edigest.practice.Entity.UserEntity;
import com.practice.edigest.practice.Repository.UserEntityRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserEntityService {

    @Autowired
    UserEntityRepo userEntityRepo;

    public List<UserEntity> findAllUser(){
        return userEntityRepo.findAll();
    }

    public void CreateUSer(UserEntity user){
        userEntityRepo.save(user);

    }

    public UserEntity findByUserName(String Username){
        return userEntityRepo.findByUsername(Username);
    }
}
