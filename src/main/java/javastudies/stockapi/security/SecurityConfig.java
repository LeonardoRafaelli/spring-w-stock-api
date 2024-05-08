package javastudies.stockapi.security;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configurers.AbstractHttpConfigurer;
import org.springframework.security.config.annotation.web.configurers.LogoutConfigurer;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
public class SecurityConfig {

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {

        http.csrf(AbstractHttpConfigurer::disable);

        http.authorizeHttpRequests(request ->
                request.requestMatchers("/my-stocks/register").permitAll()
                        .anyRequest().authenticated())
                .formLogin(formLogin -> {
                    formLogin.loginPage("/my-stocks/login")
                            .successForwardUrl("/my-stocks/user/");
                })
                .logout(LogoutConfigurer::permitAll);

        return http.build();
    }

}
