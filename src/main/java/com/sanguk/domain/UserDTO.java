package com.sanguk.domain;
import org.springframework.stereotype.Component;

import lombok.*;


@Data
public class UserDTO{
    private String id;
    private String password;
    private String email;

}