package br.com.zupacademy.frederico.transacao_cartao.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.annotation.web.configurers.oauth2.server.resource.OAuth2ResourceServerConfigurer;
import org.springframework.security.config.http.SessionCreationPolicy;

@Configuration
@EnableWebSecurity
public class BasicConfiguration extends WebSecurityConfigurerAdapter {

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.csrf().disable();
        http.headers().httpStrictTransportSecurity().disable();
        http.authorizeRequests(request->
            request.antMatchers("/**").hasAuthority("SCOPE_client-scope")
        ).oauth2ResourceServer(OAuth2ResourceServerConfigurer::jwt)
        .sessionManagement(s-> s.sessionCreationPolicy(SessionCreationPolicy.STATELESS));
    }
}
