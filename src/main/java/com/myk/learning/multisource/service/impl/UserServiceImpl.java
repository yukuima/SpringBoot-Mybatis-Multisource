package com.myk.learning.multisource.service.impl;

import com.myk.learning.multisource.mapper.spring.UserMapper;
import com.myk.learning.multisource.model.spring.User;
import com.myk.learning.multisource.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


/**
 * User service
 * <p/>
 * Created in 2018.11.09
 * <p/>
 *
 * @author myk
 */
@Service
public class UserServiceImpl implements UserService {
    /**
     * The User mapper.
     */
    @Autowired
    UserMapper userMapper;

    @Override
    public List<User> selectAll() {
        return userMapper.findAll();
    }

    @Override
    public Boolean insertUser(User user) {
        return userMapper.insertSelective(user);
    }
}
