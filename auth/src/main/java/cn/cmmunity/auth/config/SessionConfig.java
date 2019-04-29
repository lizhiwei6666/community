package cn.cmmunity.auth.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.connection.RedisPassword;
import org.springframework.data.redis.connection.RedisStandaloneConfiguration;
import org.springframework.data.redis.connection.jedis.JedisConnectionFactory;
import org.springframework.session.data.redis.config.annotation.web.http.EnableRedisHttpSession;

@EnableRedisHttpSession
@Configuration
public class SessionConfig {
        @Value("127.0.0.1")
        private String redisHost;

        @Value("6379")
        private int redisPort;

        @Value("123456")
        private String redisPwd;

        @Bean
        public JedisConnectionFactory connectionFactory() {
            RedisStandaloneConfiguration redisStandaloneConfiguration = new RedisStandaloneConfiguration();
            redisStandaloneConfiguration.setHostName(redisHost);
            redisStandaloneConfiguration.setDatabase(0);
            redisStandaloneConfiguration.setPassword(RedisPassword.of(redisPwd));
            redisStandaloneConfiguration.setPort(redisPort);

            return new JedisConnectionFactory(redisStandaloneConfiguration);
        }


}
