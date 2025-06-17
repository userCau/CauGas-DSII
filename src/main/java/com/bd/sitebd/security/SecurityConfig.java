package com.bd.sitebd.security;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.core.userdetails.*;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

import com.bd.sitebd.repository.UserRepository;

@Configuration
public class SecurityConfig {

    private final UserRepository userRepository;

    public SecurityConfig(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Bean
    public UserDetailsService userDetailsService() {
        return username -> userRepository.findByUsername(username)
                .map(user -> User.withUsername(user.getUsername())
                        .password(user.getPassword())
                        .roles(user.getRole())
                        .build())
                .orElseThrow(() -> new UsernameNotFoundException("Usuário não encontrado"));
    }

    @Bean
public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
   http
    .authorizeHttpRequests(auth -> auth
        .requestMatchers("/", "/login", "/register", "/css/**", "/img/**").permitAll()
        .requestMatchers("/listagem").hasRole("ADMIN")
        .requestMatchers("/cadastro").hasAnyRole("ADMIN", "USER")
        .anyRequest().authenticated()
    )
    .formLogin(form -> form
        .loginPage("/login")
        .defaultSuccessUrl("/", true)
        .permitAll()
    )
    .logout(logout -> logout
        .logoutSuccessUrl("/")
        .permitAll()
    )
    .csrf(csrf -> csrf.disable()) 
    .securityContext(context -> context
        .requireExplicitSave(false) 
    );

    return http.build();
}


    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }
}
