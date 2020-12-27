package com.hoaxify.ws.user;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Data
@Entity
//lombok Kütüphanesini ekledik
// Lombook ile glen @Data notasyonu sayesinde getter setter toString metotlarını generate etmeye gerek kalmadı o bizim yerimize bu işi yapmış oldu
public class User {
    @Id
    @GeneratedValue
    private Long id;
    private String username;
    private String displayName;
    private String password;

}
