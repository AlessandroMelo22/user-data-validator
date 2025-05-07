package com.alessandromelo;

import com.alessandromelo.config.AppConfig;
import com.alessandromelo.model.User;
import com.alessandromelo.service.UserService;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Main {
    public static void main(String[] args) {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(AppConfig.class);

        User user01 = new User("Michael Pereira", "michaelp33gmail.com", "mich@el123456");

        UserService userService = context.getBean(UserService.class);

        userService.registerUser(user01);

    }
}