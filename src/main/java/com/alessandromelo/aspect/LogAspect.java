package com.alessandromelo.aspect;

import com.alessandromelo.model.User;
import com.alessandromelo.service.validator.ValidatorEmail;
import com.alessandromelo.service.validator.ValidatorName;
import com.alessandromelo.service.validator.ValidatorPassword;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

/*
    No primeiro Advice (@Before) eu crio um LOG antes da execução dos Validadores
    e mostro qual Validador está sendo executado no momento.

    No mesmo Advice aproveito que mostro o Validador e mostro também qual dado do Usuario está sendo validado
    Passo a passo:

        1- Object[] args = joinPoint.getArgs(); -> Recupero os argumentos do que são passados para o JoinPoint
        (No caso é so um Objeto do tipo User)

        2- User user = (User) args[0]; -> Armazeno o argumento em uma variavel do tipo User
        ja fazendo o cast do para o tipo User.

        3-  String nameClassvalidator = joinPoint.getTarget().getClass().getSimpleName(); ->
        Agora eu armazeno o nome da Classe que contem um JoinPoint (no caso os Validadores)

        4- Por último realizo uma verificação (se o nome da Classe do JoinPoint em questão for "ValidatorEmail"
        será impresso "Dado verificado: email", ....)

    No segundo Advice (@AfterThrowing) crio um LOG após qualquer excessão que seja lançada pelos Validadores

 */

@Component
@Aspect
public class LogAspect {

    @Before("execution(* com.alessandromelo.service.validator.*.*(..))")
    public void logBeforeValidation(JoinPoint joinPoint){
        System.out.println("[LOG] " + joinPoint.getTarget().getClass().getSimpleName() + " is running!");

        Object[] args = joinPoint.getArgs();
        User user = (User) args[0];

        if(joinPoint.getTarget() instanceof ValidatorName){
            System.out.println("[LOG] Validating name: " + user.getName());

        } else if (joinPoint.getTarget() instanceof ValidatorEmail) {
            System.out.println("[LOG] Validating email: " + user.getEmail());

        } else if (joinPoint.getTarget() instanceof ValidatorPassword) {
            System.out.println("[LOG] Validating password...");
        }
    }

    @AfterThrowing(pointcut = "execution(* com.alessandromelo.service.validator.*.*(..))", throwing = "exception")
    public void logAfterTrowing(JoinPoint joinPoint, Throwable exception){

        System.out.println("[LOG - EXCEPTION]: " + "Validation failed in " + joinPoint.getTarget().getClass().getSimpleName() + " - Reason: " + exception.getMessage()  + "!");
    }
}
