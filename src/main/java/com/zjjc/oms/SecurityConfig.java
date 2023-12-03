package com.zjjc.oms;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;

/**
 * Description: oms
 * Created by tangli on 2023/12/3 16:41
 */
@Configuration
public class SecurityConfig {
    @Bean
    public UserDetailsService userDetailsService() {
        // 这里使用了一个简单的内存中用户存储
        // 在实际应用中，您可能需要使用数据库来存储用户信息
        InMemoryUserDetailsManager manager = new InMemoryUserDetailsManager();
        manager.createUser(User.withUsername("")
                .username("user")
                .password("password")
                .roles("USER")
                .build());
        return manager;
    }

}