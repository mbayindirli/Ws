package com.hoaxify.ws.auth;


import com.hoaxify.ws.error.ApiError;
import com.hoaxify.ws.user.User;
import com.hoaxify.ws.user.UserRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RestController;

import java.util.Base64;


@RestController
public class AuthController {
    @Autowired
    UserRepository userRepository;
    PasswordEncoder passwordEncoder= new BCryptPasswordEncoder();
    Logger logger= LoggerFactory.getLogger(AuthController.class);
    @PostMapping("api/1.0/auth")
    ResponseEntity<?> handleAuth(@RequestHeader(name = "Authorization",required = false)String authorization){
        if(authorization==null){
            ApiError apiError=new ApiError(401,"unauthorized","api/1.0/auth");
           return  ResponseEntity.status(HttpStatus.UNAUTHORIZED).body(apiError);

        }
   logger.info(authorization);
        String splitBasicAuth=authorization.split("Basic ")[1];
        String decoded=new String(Base64.getDecoder().decode(splitBasicAuth));
        logger.info(decoded);
        String userName=decoded.split(":")[0];
        String password=decoded.split(":")[1];
       User inDb=  userRepository.findByUserName(userName);
       if(inDb==null){
           ApiError apiError=new ApiError(401,"User Bulunamadı","api/1.0/auth");
           return  ResponseEntity.status(HttpStatus.UNAUTHORIZED).body(apiError);
       }
       String hashedPassword=inDb.getPassword();
       if(!passwordEncoder.matches(password,hashedPassword)){
           ApiError apiError=new ApiError(401,"Şifre Hatalı","api/1.0/auth");
           return  ResponseEntity.status(HttpStatus.UNAUTHORIZED).body(apiError);
       }


//username,displayname,image 1 yontem
//        HashMap<String,String> response=new HashMap<>();
//       response.put("userName",inDb.getUserName());
//       response.put("displayName",inDb.getDisplayName());
//       response.put("image",inDb.getImage());
        //2 yontem direk User doneriz JsonIgnore ile de Password gelmemesini sağlarız
        return ResponseEntity.ok().body(inDb);
    }
}
