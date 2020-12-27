package com.hoaxify.ws.user;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service//sadece okunurluğu artırmak için
public class UserService {
    UserRepository userRepository;
    @Autowired//constructor ile dependancy injection yapmak buada injection yapılan class bir tane olduğundan @Autowired zorunl değil dazha fazla olsaydı zorunlu olurdu
    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public void cretaUser(User user){
        userRepository.save(user);
    }
}
