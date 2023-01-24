package com.godcoder.myrest.repository;

import com.godcoder.myrest.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

public class CustomizedUserRepositoryImpl implements CustomizedUserRepository {

    @Autowired
    JdbcTemplate jdbcTemplate;

    @PersistenceContext
    private EntityManager em;

    @Override
    public void findByUsernameCustom(User user) {
        //querydsl
    }

    @Override
    public List<User> findByUsernameJdbc(String username) {
        return jdbcTemplate.query(
                "SELECT * FROM USER WHERE username like ?",
                new Object[]{"%" + username + "%"},
                new BeanPropertyRowMapper(User.class));
    }

}
