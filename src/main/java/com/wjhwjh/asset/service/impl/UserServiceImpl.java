package com.wjhwjh.asset.service.impl;

import com.wjhwjh.asset.entity.User;
import com.wjhwjh.asset.repository.SysUserTypeRepository;
import com.wjhwjh.asset.repository.UserRepository;
import com.wjhwjh.asset.service.TokenService;
import com.wjhwjh.asset.service.UserService;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author wjhwjh
 * @description a
 * Created in 17:11 2019/8/27
 */
@Service
public class UserServiceImpl implements UserService {

    @Autowired
    UserRepository userRepository;

    @Autowired
    TokenService tokenService;

    @Autowired
    SysUserTypeRepository sysUserTypeRepository;

    public User save(User user) {
        user.preInsert();
        user.setType(sysUserTypeRepository.findByName(user.getType().getName()));
        return userRepository.save(user);
    }

    /**
     * 通过登录名获取用户，获取用户信息后同时更新token值
     *
     * @param user user
     * @return user
     */
    public User findByLoginName(User user) {
        if (user == null) {
            return null;
        }
        String loginName = user.getLoginName();
        if (StringUtils.isEmpty(loginName)) {
            return null;
        }
        user = userRepository.findByLoginName(loginName);
        user.setToken(tokenService.getToken(user));
        user = userRepository.saveAndFlush(user);
        return user;
    }

    public User saveAndFlush(User user) {
        return userRepository.saveAndFlush(user);
    }

}
