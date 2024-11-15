package com.example.OAuthSession.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
public class UserEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    // 전화번호
    private String phone_number;

    // 이름
    private String username;

    // 이메일
    private String oauth_email;

    // 소셜 제공
    private String provider;

    // 권한
    private String role;
}
