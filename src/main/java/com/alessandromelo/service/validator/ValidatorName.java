package com.alessandromelo.service.validator;

import com.alessandromelo.model.User;
import org.springframework.stereotype.Component;

@Component
public class ValidatorName implements Validator{

    @Override
    public void validate(User user) {

        if(user.getName() == null || user.getName().trim().isEmpty()){
            throw new NullPointerException("Name cannot be null or empty");
        }

    }
}
