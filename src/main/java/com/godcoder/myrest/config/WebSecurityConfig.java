//package com.godcoder.myrest.config;
//
//import lombok.RequiredArgsConstructor;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
//import org.springframework.security.config.annotation.web.builders.HttpSecurity;
//import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
//import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
//import org.springframework.security.crypto.password.PasswordEncoder;
//import org.springframework.security.web.SecurityFilterChain;
//import org.springframework.security.web.authentication.AuthenticationFailureHandler;
//
//import javax.sql.DataSource;
//
//@Configuration
//@EnableWebSecurity
//@RequiredArgsConstructor
//public class WebSecurityConfig {
//
//    @Autowired
//    private final DataSource dataSource;
//
//    @Bean
//    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
//        http
//                .authorizeHttpRequests((requests) -> requests
//                        .requestMatchers()
//                        .authenticated()
//                        .antMatchers("/", "/account/register", "/css/**", "/board/list", "/board/form").permitAll()
//                        .anyRequest().authenticated()
//                        .and()
//                )
//                .formLogin((form) -> form
//                        .loginPage("/account/login")
//                        .permitAll()
//                        .and()
//                )
//                .logout((logout) -> logout.permitAll());
//
//        return http.build();
//
//    }
//
//    private void configureGlobal(AuthenticationManagerBuilder auth) throws Exception {
//        System.out.println("auth = " + auth);
//        auth.jdbcAuthentication()
//                .dataSource(dataSource)
//                .passwordEncoder(passwordEncoder())
//                .usersByUsernameQuery("select username,password,enabled "
//                        + "from user "
//                        + "where username = ?")
//                .authoritiesByUsernameQuery("select u.username, r.name "
//                        + "from user_role ur inner join user u on ur.user_id = u.id "
//                        + "inner join role r on ur.role_id = r.id "
//                        + "where u.username = ?");
//    }
//
//    @Bean
//    public PasswordEncoder passwordEncoder() {
//        return new BCryptPasswordEncoder();
//    }
//}
