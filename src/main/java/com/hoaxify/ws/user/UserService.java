package com.hoaxify.ws.user;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service//sadece okunurluğu artırmak için
public class UserService {

    PasswordEncoder passwordEncoder;
    UserRepository userRepository;
    @Autowired//constructor ile dependancy injection yapmak buada injection yapılan class bir tane olduğundan @Autowired zorunl değil dazha fazla olsaydı zorunlu olurdu
    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
        this.passwordEncoder=new BCryptPasswordEncoder();
    }

    public void cretaUser(User user){
       user.setPassword(passwordEncoder.encode(user.getPassword()));
        userRepository.save(user);
    }
}
