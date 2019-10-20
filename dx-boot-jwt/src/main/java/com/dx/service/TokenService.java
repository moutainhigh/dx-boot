package com.dx.service;

import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;
import com.dx.bean.User;
import org.springframework.stereotype.Service;


/**
 * @author jinbin
 * @date 2018-07-08 21:04
 */
@Service
public class TokenService {

    public String getToken(User user) {
        String token = "";
        // 将 user id 保存到 token 里面
        token = JWT.create().withAudience(user.getId())
                // 以 password 作为 token 的密钥，最好用一个可配置的加密秘钥
                .sign(Algorithm.HMAC256(user.getPassword()));
        return token;
    }
}
