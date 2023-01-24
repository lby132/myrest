package com.godcoder.myrest.controller;

import com.godcoder.myrest.mapper.UserMapper;
import com.godcoder.myrest.model.Board;
import com.godcoder.myrest.model.User;
import com.godcoder.myrest.repository.UserRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Slf4j
@RestController
@RequestMapping("/api")
public class UserApiController {

    @Autowired
    private UserMapper userMapper;

    @Autowired
    private UserRepository repository;

    @GetMapping("/users")
    List<User> all(@RequestParam(required = false) String method, @RequestParam(required = false) String text) {
        List<User> users = null;
        if ("query".equals(method)) {
            users = repository.findByUsernameQuery(text);
        } else if ("nativeQuery".equals(method)) {
            users = repository.findByUsernameNativeQuery(text);
        } else if ("jdbc".equals(method)) {
            users = repository.findByUsernameJdbc(text);
        } else if ("mybatis".equals(method)) {
            users = userMapper.getUsers(text);
        } else {
            users = repository.findAll();
        }
        return users;
    }

    @PostMapping("/users")
    User newUser(@RequestBody User newUser) {
        return repository.save(newUser);
    }

    // Single item

    @GetMapping("/users/{id}")
    User one(@PathVariable Long id) {

        return repository.findById(id).orElse(null);
    }

    @PutMapping("/users/{id}")
    User replaceUser(@RequestBody User newUser, @PathVariable Long id) {

        return repository.findById(id)
                .map(user -> {
//                    user.setTitle(newUser.getTitle());
//                    user.setContent(newUser.getContent());
                    user.setBoards(newUser.getBoards());
                    for (Board board : user.getBoards()) {
                        board.setUser(user);
                    }
                    return repository.save(user);
                })
                .orElseGet(() -> {
                    newUser.setId(id);
                    return repository.save(newUser);
                });
    }

    @DeleteMapping("/users/{id}")
    void deleteUser(@PathVariable Long id) {
        repository.deleteById(id);
    }
}
