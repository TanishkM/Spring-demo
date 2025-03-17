package com.example.demo.models.response;


import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class UserVO {
    private Long id;

    private String name;

    private String email;

    private String created;

    private String updated;
}
