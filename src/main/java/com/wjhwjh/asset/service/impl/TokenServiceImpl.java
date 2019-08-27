package com.wjhwjh.asset.service.impl;

import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;
import com.wjhwjh.asset.common.utils.JWTUtils;
import com.wjhwjh.asset.common.web.Servlets;
import com.wjhwjh.asset.entity.AssetUser;
import com.wjhwjh.asset.service.TokenService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mobile.device.DeviceUtils;
import org.springframework.stereotype.Service;

@Service
public class TokenServiceImpl implements TokenService {

    @Autowired
    JWTUtils jwtUtils;

    @Override
    public String getToken(AssetUser assetUser) {
        String token = "";
//        token = JWT.create().withAudience(assetUser.getId().toString()).sign(Algorithm.HMAC256(assetUser.getPassword()));
        token = jwtUtils.generateToken(assetUser, DeviceUtils.getCurrentDevice(Servlets.getRequest()));
        return token;
    }
}
