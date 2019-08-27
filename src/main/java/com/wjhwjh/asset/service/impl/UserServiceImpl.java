package com.wjhwjh.asset.service.impl;

import com.wjhwjh.asset.entity.User;
import com.wjhwjh.asset.repository.UserRepository;
import com.wjhwjh.asset.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * @author wjhwjh
 * @description a
 * Created in 17:11 2019/8/27
 */
public class UserServiceImpl implements UserService {

    @Autowired
    UserRepository userRepository;

    public User save(User user){
        user.preInsert();
        userRepository.save(user);
        return user;
    }

}
