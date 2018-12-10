package com.dx;

import org.springframework.boot.Banner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.security.oauth2.config.annotation.web.configuration.AuthorizationServerConfigurerAdapter;

@SpringBootApplication
public class DxBootApplication extends AuthorizationServerConfigurerAdapter {

    public static void main(String[] args) {
        SpringApplication app = new SpringApplication(DxBootApplication.class);
        app.setBannerMode(Banner.Mode.OFF);
        app.run(args);
    }

//    @Bean
//    protected UserDetailsService userDetailsService(){
////        InMemoryUserDetailsManager manager = new InMemoryUserDetailsManager();
////        manager.createUser(User.withUsername("user_1").password("123456").authorities("USER").build());
////        manager.createUser(User.withUsername("user_2").password("123456").authorities("USER").build());


//        UserDetailsManager userDetailsManager = new InMemoryUserDetailsManager();
//        UserDetails userDetails = User.withUsername("user_2").password("123456").authorities("USER").build();
//        userDetailsManager.createUser(userDetails);
//        return userDetailsManager;
//    }

}
