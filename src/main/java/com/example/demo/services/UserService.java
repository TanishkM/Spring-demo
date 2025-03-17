package com.example.demo.services;

import com.example.demo.models.persistence.entities.UserDO;
import com.example.demo.models.persistence.repositories.UserRepository;
import com.example.demo.models.response.UserVO;
import com.example.demo.utils.ConversionUtils;
import com.google.gson.Gson;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@Slf4j
@RequiredArgsConstructor
public class UserService {
    private final UserRepository userRepository;
    private final Gson gson = new Gson();

    public UserVO getUserById(Long id) {
        UserDO user = fetchUser(id);
        UserVO response = ConversionUtils.getUserVO(user);
        log.info("User found: {}", gson.toJson(response));
        return response;
    }

    public UserVO createUserById(String name, String email) {
        UserDO user = new UserDO(name, email);
        UserVO response = ConversionUtils.getUserVO(userRepository.save(user));
        log.info("User created: {}", gson.toJson(response));
        return response;
    }

    public UserVO updateUserById(Long id, String name, String email) {
        UserDO user = fetchUser(id);
        user.setName(name);
        user.setEmail(email);
        UserVO response = ConversionUtils.getUserVO(userRepository.save(user));
        log.info("User updated: {}", gson.toJson(response));
        return response;
    }

    public String deleteUserById(Long id) {
        userRepository.deleteById(id);
        log.info("User deleted with id: {}", id);
        return "User deleted with id: " + id;
    }

    private UserDO fetchUser(Long id) {
        Optional<UserDO> user = userRepository.findById(id);
        if (user.isEmpty()) {
            log.error("User not found with id: {}", id);
            throw new RuntimeException("User not found with id: " + id);
        }
        return user.get();
    }
}
