package com.doctorapp.model;
import lombok.*;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class JWTUser {
    @Id
    @GeneratedValue
    private Integer userid;
    @Column(unique = true)
    private String username;
    private String password;

    public JWTUser(String username , String password){
        this.username = username;
        this.password = password;
    }
}