package com.hoaxify.ws.user;

import lombok.Data;

@Data
//lombok Kütüphanesini ekledik ve Lombook ile glen @Data ntasyonu sayesinde getter setter toSAtrig metotlarını generate etmeye gerek kalmadı
public class User {
    private String username;
    private String displayName;
    private String password;

}
