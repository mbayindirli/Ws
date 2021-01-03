package com.hoaxify.ws.user;

import org.springframework.beans.factory.annotation.Autowired;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class UniqeUserNameValidator implements ConstraintValidator <UniqeUserName,String>{
    @Autowired
    UserRepository userRepository;

    @Override
    public boolean isValid(String userName, ConstraintValidatorContext constraintValidatorContext) {
        User user=userRepository.findByUsername(userName);
        if(user==null){
            return true;
        }
        return false;
    }
}
