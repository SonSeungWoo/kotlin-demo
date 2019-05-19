package me.seungwoo.config

import me.seungwoo.account.AccountService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder
import org.springframework.security.config.annotation.web.builders.HttpSecurity
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter
import org.springframework.security.crypto.password.PasswordEncoder

/**
 * Created by Leo.
 * User: ssw
 * Date: 2019-05-19
 * Time: 16:28
 */
@EnableWebSecurity
class SecurityConfig(@Autowired private val accountService: AccountService,
                     @Autowired private val passwordEncoder: PasswordEncoder): WebSecurityConfigurerAdapter() {

    companion object {
        const val LOGIN_SUCCESS_URL: String = "/success"
    }

    override fun configure(auth: AuthenticationManagerBuilder) {
        auth
                .userDetailsService(accountService)
                .passwordEncoder(passwordEncoder)
    }

    override fun configure(http: HttpSecurity) {
        http.anonymous()
                .and()
                .formLogin()
                .successForwardUrl(LOGIN_SUCCESS_URL)
                .and()
                .authorizeRequests()
                .anyRequest().authenticated()
    }
}
