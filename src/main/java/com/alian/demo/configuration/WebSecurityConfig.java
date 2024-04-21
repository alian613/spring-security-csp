package com.alian.demo.configuration;

import com.alian.security.csp.ContentSecurityPolicy;
import com.alian.security.csp.ContentSecurityPolicyBuilder;
import com.alian.security.csp.nonce.CspNonceRepository;
import com.alian.security.csp.nonce.CspNonceToken;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configurers.LogoutConfigurer;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.csrf.CsrfFilter;

@Configuration
@EnableWebSecurity
public class WebSecurityConfig {

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {

        CspNonceRepository cspNonceRepository = cspNonceRepository();
        CspNonceToken cspNonceToken = cspNonceRepository.generateToken();
        String nonce = cspNonceToken.token();
        http.addFilterBefore(new CspNonceTokenFilter(cspNonceRepository, cspNonceToken), CsrfFilter.class);

        ContentSecurityPolicy contentSecurityPolicy = new ContentSecurityPolicyBuilder().defaultSrc().self().src(
                        "https://fonts.googleapis.com/css2")
                .and()
                .scriptSrc().self().src(
                        "https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/js/bootstrap.bundle.min.js")
                .and()
                .styleSrc().self().src(
                        "https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css",
                        "https://fonts.googleapis.com/css2").nonce(nonce)
                .and()
                .fontSrc().self().src(
                        "https://fonts.googleapis.com",
                        "https://fonts.gstatic.com")
                .and()
                .imgSrc().self().data()
                .and()
                .writer("form-action 'self'; frame-ancestors 'self'; ").build();

        http.headers(headers -> headers.contentSecurityPolicy(csp ->
                csp.policyDirectives(contentSecurityPolicy.toString())));
        http
                .authorizeHttpRequests((requests) -> requests
                        .requestMatchers("/css/**").permitAll()
                        .anyRequest().authenticated()
                )
                .formLogin((form) -> form
                        .loginPage("/login")
                        .permitAll()
                )
                .logout(LogoutConfigurer::permitAll);

        return http.build();
    }

    @Bean
    public CspNonceRepository cspNonceRepository() {
        return new CspNonceRepository();
    }
}
