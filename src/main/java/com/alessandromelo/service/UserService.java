package com.alessandromelo.service;

import com.alessandromelo.model.User;
import com.alessandromelo.service.validator.Validator;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {

    private List<Validator> validator;

    public UserService(List<Validator> validator){
        this.validator = validator;
    }

    public void registerUser(User user){

        for(int i = 0; i < this.validator.size(); i++){

            validator.get(i).validate(user);
        }
        System.out.println("User registered successfully");
    }
}
