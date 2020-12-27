package com.hoaxify.ws.user;

import lombok.Data;

@Data
//lombok Kütüphanesini ekledik
// Lombook ile glen @Data notasyonu sayesinde getter setter toString metotlarını generate etmeye gerek kalmadı o bizim yerimize bu işi yapmış oldu
public class User {
    private String username;
    private String displayName;
    private String password;

}
