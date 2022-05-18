package com.expense;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.cache.RedisCacheConfiguration;
import org.springframework.data.redis.serializer.GenericJackson2JsonRedisSerializer;
import org.springframework.data.redis.serializer.RedisSerializationContext;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

import java.time.Duration;

@SpringBootApplication
@EnableCaching
public class MsExpenseApplication {

	public static void main(String[] args) {
		SpringApplication.run(MsExpenseApplication.class, args);
	}

	@Configuration
	@EnableWebMvc
	public class WebConfig extends WebMvcConfigurerAdapter {
		@Override
		public void addCorsMappings(CorsRegistry registry) {
			registry.addMapping("/**");
/*			registry.addMapping("/**")
					.allowedOrigins("http://192.168.25.24:3000")
					.allowedMethods("PUT", "DELETE", "GET", "POST")
					.allowedHeaders("header1", "header2", "header3")
					.exposedHeaders("header1", "header2")
					.allowCredentials(false).maxAge(3600);*/
		}
	}

	@Bean
	public RedisCacheConfiguration cacheConfiguration() {
		return RedisCacheConfiguration.defaultCacheConfig()
				.entryTtl(Duration.ofMinutes(1))
				.disableCachingNullValues();
	}

}
