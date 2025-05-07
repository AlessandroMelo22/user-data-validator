package com.alessandromelo.service.validator;

import com.alessandromelo.model.User;
import org.springframework.stereotype.Component;

@Component
public class ValidatorEmail implements Validator{

    @Override
    public void validate(User user) {

        if(!(user.getEmail().matches("^[\\w-.]+@([\\w-]+\\.)+[\\w-]{2,4}$"))){
            throw new IllegalArgumentException("Invalid email format");
        }
    }
}
