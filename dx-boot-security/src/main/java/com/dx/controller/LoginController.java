package com.dx.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Description: com.dx.sys.controller
 *
 * @author yaoj
 * @version 1.0
 * @copyright Copyright (c) 文理电信
 * @since 2019/10/12
 */
@RestController
public class LoginController {

    @Autowired(required = false)
    private AuthenticationManager authenticationManager;

    @GetMapping("/login")
    public Object login(String username, String password) {

        Authentication authenticate
                = authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(username, password));

        Object principal = authenticate.getPrincipal();

        return principal;
    }

}
