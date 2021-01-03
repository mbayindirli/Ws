package com.hoaxify.ws.user;


import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

@Data
@Entity
//lombok Kütüphanesini ekledik
// Lombook ile glen @Data notasyonu sayesinde getter setter toString metotlarını generate etmeye gerek kalmadı o bizim yerimize bu işi yapmış oldu
public class User {
    @Id
    @GeneratedValue
    private Long id;
    
    @NotNull(message = "{username.be.not.message}")
    @UniqeUserName
    @Size(min = 3,max = 255)
    @Column(unique = true)
    private String username;

    @NotNull
    @Size(min = 3,max = 255)
    private String displayName;

    @NotNull
    @JsonIgnore//json olustururken bu değeri ignore et
    @Pattern(regexp = "^(?=.*?[A-Z])(?=(.*[a-z]){1,})(?=(.*[\\d]){1,})(?=(.*[\\W]){1,})(?!.*\\s).{8,}$",message = "{password.pattern.message}",flags = Pattern.Flag.UNICODE_CASE)
    @Size(min = 8,max = 255)
    private String password;

    private String image;


    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getDisplayName() {
        return displayName;
    }

    public void setDisplayName(String displayName) {
        this.displayName = displayName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }
}
