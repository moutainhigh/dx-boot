package com.dx.security.app;

import com.dx.security.app.jwt.ImoocJwtTokenEnhancer;
import com.dx.security.core.properties.SecurityProperties;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.connection.RedisConnectionFactory;
import org.springframework.security.oauth2.provider.token.TokenEnhancer;
import org.springframework.security.oauth2.provider.token.TokenStore;
import org.springframework.security.oauth2.provider.token.store.JwtAccessTokenConverter;
import org.springframework.security.oauth2.provider.token.store.JwtTokenStore;
import org.springframework.security.oauth2.provider.token.store.redis.RedisTokenStore;

/**
 * Description:token存储策略
 * token存储到redis,默认是在内存不行
 *
 * @author yaoj
 * @version 1.0
 * @copyright Copyright (c) 文理电信
 * @since 2019-01-03
 */
@Configuration
public class TokenStoreConfig {

	@Autowired
	private RedisConnectionFactory redisConnectionFactory;

	/**
	 * 配置redis存储token
	 * @Description: 配置文件有 imooc.security.oauth2.storeType = redis 时才生效
	 * @param @return   
	 * @return TokenStore  
	 * @throws
	 * @author lihaoyang
	 * @date 2018年3月16日
	 */
	@Bean
	@ConditionalOnProperty(prefix = "imooc.security.oauth2" , name = "storeType" , havingValue = "redis")
	public TokenStore redisTokenStore(){
		return new RedisTokenStore(redisConnectionFactory);
	}
	
	/**
	 * JWT配置
	 * ClassName: JwtTokenConfig 
	 * @Description:\
	 * 	@ConditionalOnProperty是说，有前缀imooc.security.oauth2.storeType = jwt 的配置时，这个类里的配置才生效
	 * 	matchIfMissing =true 意思是当配置文件里不配置imooc.security.oauth2.storeType = jwt时，配置是生效的
	 * @author lihaoyang
	 * @date 2018年3月16日
	 */
	@Configuration
	@ConditionalOnProperty(prefix = "imooc.security.oauth2" , name = "storeType" , havingValue = "jwt" , matchIfMissing = true)
	public static class JwtTokenConfig{
		
		@Autowired
		private SecurityProperties securityProperties;
		
		/**
		 * 配置jwt
		 * @Description: 
		 * 		通过jwtAccessTokenConverter，将uuid转换成JWT
		 * @param @return   
		 * @return TokenStore  
		 * @throws
		 * @author lihaoyang
		 * @date 2018年3月16日
		 */
		@Bean
		public TokenStore jwtTokenStore(){
			return new JwtTokenStore(jwtAccessTokenConverter());
		}
		
		/**
		 * 给JWT加签名
		 * @Description: 给JWT加签名
		 * @param @return   
		 * @return JwtAccessTokenConverter  
		 * @throws
		 * @author lihaoyang
		 * @date 2018年3月16日
		 */
		@Bean
		public JwtAccessTokenConverter jwtAccessTokenConverter(){
			JwtAccessTokenConverter jwtAccessTokenConverter = new JwtAccessTokenConverter();
			jwtAccessTokenConverter.setSigningKey(securityProperties.getOauth2().getJwtSigningKey());//jwt签名
			return jwtAccessTokenConverter;
		}
		
		/**
		 * JWT增强器
		 * @Description: 扩展JWT所包含的信息
		 * @param @return   
		 * @return TokenEnhancer  
		 * @throws
		 * @author lihaoyang
		 * @date 2018年3月16日
		 */
		@Bean
		@ConditionalOnMissingBean(name = "jwtTokenEnhancer")
		public TokenEnhancer jwtTokenEnhancer(){
			return new ImoocJwtTokenEnhancer();
		}
	}
	
}
