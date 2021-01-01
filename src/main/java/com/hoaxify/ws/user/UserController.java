package com.hoaxify.ws.user;


import com.hoaxify.ws.error.ApiError;
import com.hoaxify.ws.shared.GenericResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
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
    public GenericResponse createUser( @Valid @RequestBody  User  user){
//        String userName=user.getUserName();
//        String displayName=user.getDisplayName();
//        ApiError apiError=new ApiError(400,"Validation Error","/api/1.0/users");
//        Map<String,String> validError=new HashMap<>();
//        if(userName==null||userName.isEmpty()){
//            validError.put("userName","Username not be null");
//            apiError.setValidationError(validError);
//        }
//
//        if(displayName==null||displayName.isEmpty()){
//            validError.put("displayName","displayName not be null");
//            apiError.setValidationError(validError);
//        }
//        if (validError.size()>0){
//            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(apiError);
//        }
       userService.cretaUser(user);
       // GenericResponse response=new GenericResponse("created User");
        return new GenericResponse("created User");
    }

    @ExceptionHandler(MethodArgumentNotValidException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public ApiError handleValidationException(MethodArgumentNotValidException exception){
        ApiError apiError=new ApiError(400,"Validation Error","/api/1.0/users");
        Map<String,String> validationError=new HashMap<>();
        for (FieldError fieldError:exception.getBindingResult().getFieldErrors()) {
        validationError.put(fieldError.getField(),fieldError.getDefaultMessage());
        }
        apiError.setValidationError(validationError);
        return apiError;
   }

}
