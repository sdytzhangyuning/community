package life.yuning.community.Service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

import life.yuning.community.Service.UserService;

@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Override
    public void create(String name, Integer age) {
        jdbcTemplate.update("insert into USER(NAME, AGE) values(?, ?)", name, age);
    }

    @Override
    public void deleteByName(String name) {
        jdbcTemplate.update("delete from USER where NAME = ?", name);
    }

    @Override
    public Integer getAllUsers() {
        return jdbcTemplate.queryForObject("select count(1) from USER", Integer.class);
    }

    @Override
    public void deleteAllUsers() {
        jdbcTemplate.update("delete from USER");
    }
}
