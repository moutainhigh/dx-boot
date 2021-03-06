# shiro复习

## 参考资料
-----------------
shiro内容学习：https://www.iteye.com/blog/jinnianshilongnian-2018398

## **专业名词**
   对应测试在test文件夹下
   - SecurityUtils:中设置SecurityManager，可以获取Subject  
        - Subject：中设置包含用户登录信息，可以进行登录、角色、权限判断
   - SecurityManager：中设置有Realm信息
   - Realm：中包含有用户的登录、角色、权限信息，设置CredentialsMatcher加密方式、等
        - CredentialsMatcher：加密方式设置




```
1：
Authentication：身份认证/登录，验证用户是不是拥有相应的身份；

Authorization：授权，即权限验证，验证某个已认证的用户是否拥有某个权限；即判断用户是否能做事情，
                常见的如：验证某个用户是否拥有某个角色。或者细粒度的验证某个用户对某个资源是否具有某个权限；

Session Manager：会话管理，即用户登录后就是一次会话，在没有退出之前，它的所有信息都在会话中；会话可以是普通JavaSE环境的，也可以是如Web环境的；

Cryptography：加密，保护数据的安全性，如密码加密存储到数据库，而不是明文存储；

Web Support：Web支持，可以非常容易的集成到Web环境；

Caching：缓存，比如用户登录后，其用户信息、拥有的角色/权限不必每次去查，这样可以提高效率；

Concurrency：shiro支持多线程应用的并发验证，即如在一个线程中开启另一个线程，能把权限自动传播过去；

Testing：提供测试支持；

Run As：允许一个用户假装为另一个用户（如果他们允许）的身份进行访问；

Remember Me：记住我，这个是非常常见的功能，即一次登录后，下次再来的话不用登录了。


2：
principals：身份，即主体的标识属性，可以是任何东西，如用户名、邮箱等，唯一即可。
            一个主体可以有多个principals，但只有一个Primary principals，一般是用户名/密码/手机号。
credentials：证明/凭证，即只有主体知道的安全值，如密码/数字证书等。


3：




```



## swagger引入：
**swagger测试**
    -  [swagger地址测试](http://127.0.0.1:8082/swagger-ui.html)













