package com.alessandromelo.service.validator;

import com.alessandromelo.model.User;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class ValidatorPassword implements Validator{

    @Value("${minimum.password.length}")
    private Integer minimumSize;

    @Override
    public void validate(User user) {

        if(user.getPassword().length() < this.minimumSize){
            throw new IllegalArgumentException("Password must be at least " + this.minimumSize + " characters");
        }
    }
}
