package com.example.demo.utils;

import com.example.demo.models.persistence.entities.UserDO;
import com.example.demo.models.response.UserVO;
import org.springframework.stereotype.Component;

@Component
public class ConversionUtils {
    public static UserVO getUserVO(UserDO user) {
        return new UserVO(user.getId(), user.getName(), user.getEmail(), user.getCreated().toString(), user.getUpdated().toString());
    }
}
