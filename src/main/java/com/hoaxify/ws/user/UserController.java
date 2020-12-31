package com.hoaxify.ws.user;



import com.hoaxify.ws.error.ApiError;
import com.hoaxify.ws.shared.GenericResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;


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
    @ResponseStatus(HttpStatus.CREATED)
    public ResponseEntity<?> createUser(@RequestBody User  user){
        String userName=user.getUsername();
        if(userName==null||userName.isEmpty()){
            ApiError apiError=new ApiError(400,"Validation Error","/api/1.0/users");
            Map<String,String> validError=new HashMap<>();
            validError.put("userName","Username not be null");
            apiError.setValidationError(validError);
          return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(apiError);
        }
       userService.cretaUser(user);
       // GenericResponse response=new GenericResponse("created User");
        return ResponseEntity.ok(new GenericResponse("created User"));
    }
}
