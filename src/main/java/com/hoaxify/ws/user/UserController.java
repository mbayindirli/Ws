package com.hoaxify.ws.user;



import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;



//create işlemii genellikle post metotla oluşturulur
// Jackson library sayesinde client tarafından gelen Json Objesi(Key,Value) ilgili sınıfın key eşitlemesi sonrası Value setlemei işlemini yapar .
// Yani bizim cliient tarafından gönderdiğimiz Obje böylelikle User tipine cast edilmiş olur.
@RestController
//Client tarafında proxy ayarı yaptığımızdan @CrossOrigin notasyonuna gerek kalmadı
//@CrossOrigin//bu notasyon sunucu ve clientin farklı portlarda çalışmasına rağmen haberleşmesini sağladı
public class UserController {
    @Autowired
    private UserService userService;
    @PostMapping("/api/1.0/users")
    public void createUser(@RequestBody User  user){
       userService.cretaUser(user);
    }
}
