配置spring security
在spring security的版本迭代中，产生了多种配置方式，建造者模式，适配器模式等等设计模式的使用，spring security内部的认证flow也是错综复杂，在我一开始学习ss也产生了不少困惑，总结了一下配置经验：使用了springboot之后，spring security其实是有不少自动配置的，我们可以仅仅修改自己需要的那一部分，并且遵循一个原则，直接覆盖最需要的那一部分。这一说法比较抽象，举个例子。比如配置内存中的用户认证器。有两种配置方式

planA：

@Bean
protected UserDetailsService userDetailsService(){
    InMemoryUserDetailsManager manager = new InMemoryUserDetailsManager();
    manager.createUser(User.withUsername("user_1").password("123456").authorities("USER").build());
    manager.createUser(User.withUsername("user_2").password("123456").authorities("USER").build());
    return manager;
}
planB：

@Configuration
@EnableWebSecurity
public class SecurityConfiguration extends WebSecurityConfigurerAdapter {

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.inMemoryAuthentication()
                .withUser("user_1").password("123456").authorities("USER")
                .and()
                .withUser("user_2").password("123456").authorities("USER");
   }

   @Bean
   @Override
   public AuthenticationManager authenticationManagerBean() throws Exception {
       AuthenticationManager manager = super.authenticationManagerBean();
        return manager;
    }
}

你最终都能得到配置在内存中的两个用户，前者是直接替换掉了容器中的UserDetailsService，这么做比较直观；后者是替换了AuthenticationManager，当然你还会在SecurityConfiguration 复写其他配置，这么配置最终会由一个委托者去认证。如果你熟悉spring security，会知道AuthenticationManager和AuthenticationProvider以及UserDetailsService的关系，他们都是顶级的接口，实现类之间错综复杂的聚合关系…配置方式千差万别，但理解清楚认证流程，知道各个实现类对应的职责才是掌握spring security的关键。



password模式：

http://localhost:8080/oauth/token?username=user_1&password=123456&grant_type=password&scope=select&client_id=client_2&client_secret=123456

响应如下： 
{"access_token":"950a7cc9-5a8a-42c9-a693-40e817b1a4b0","token_type":"bearer","refresh_token":"773a0fcd-6023-45f8-8848-e141296cb3cb","expires_in":27036,"scope":"select"}

client模式：

http://localhost:8080/oauth/token?grant_type=client_credentials&scope=select&client_id=client_1&client_secret=123456

响应如下： 
{"access_token":"56465b41-429d-436c-ad8d-613d476ff322","token_type":"bearer","expires_in":25074,"scope":"select"}

在配置中，我们已经配置了对order资源的保护，如果直接访问： 
http://localhost:8080/order/1 
会得到这样的响应： 
{"error":"unauthorized","error_description":"Full authentication is required to access this resource"} 
（这样的错误响应可以通过重写配置来修改） 
而对于未受保护的product资源 
http://localhost:8080/product/1 
则可以直接访问，得到响应 
product id : 1

携带accessToken参数访问受保护的资源： 
使用password模式获得的token: 
http://localhost:8080/order/1?access_token=950a7cc9-5a8a-42c9-a693-40e817b1a4b0 
得到了之前匿名访问无法获取的资源： 
order id : 1

使用client模式获得的token: 
http://localhost:8080/order/1?access_token=56465b41-429d-436c-ad8d-613d476ff322 
同上的响应 
order id : 1



