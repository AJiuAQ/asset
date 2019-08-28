package com.wjhwjh.asset.service;

import com.wjhwjh.asset.entity.User;

public interface TokenService {
    public String getToken(User user);
}
