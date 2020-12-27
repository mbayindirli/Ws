package com.hoaxify.ws.user;



import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;



//create işlemii genellikle post metotla oluşturulur
// Jackson library sayesinde client tarafından gelen Json Objesi(Key,Value) ilgili sınıfın key eşitlemesi sonrası Value setlemei işlemini yapar .
// Yani bizim cliient tarafından gönderdiğimiz Obje böylelikle User tipine cast edilmiş olur.
@RestController
public class UserController {
    private final static Logger log= LoggerFactory.getLogger(UserController.class);
    @PostMapping("/api/1.0/users")
    public void createUser(@RequestBody User  user){
     log.info(user.toString());
    }
}