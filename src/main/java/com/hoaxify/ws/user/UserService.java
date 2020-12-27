package com.hoaxify.ws.user;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service//sadece okunurluğu artırmak için
public class UserService {
    @Autowired
    UserRepository userRepository;
    public void cretaUser(User user){
        userRepository.save(user);
    }
}
