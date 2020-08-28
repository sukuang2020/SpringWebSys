package jp.co.fostone.springwebsys.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;

@Configuration
@EnableWebSecurity
@EnableGlobalMethodSecurity(securedEnabled = true, proxyTargetClass = true)
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {

	/**
	 * UserDetailsServiceをカスタマイズするクラス
	 */
	@Autowired
	private UserDetailsService userDetailsServiceimpl;

	/**
	 * パスワードをエンコード
	 * @return
	 */
	@Bean
	public PasswordEncoder passwordEncoder() {
		return new BCryptPasswordEncoder();
	}

	/**
	 * ログインの認証をカスタマイズする
	 */
	@Autowired
	public void configure(AuthenticationManagerBuilder auth) throws Exception {
		auth
				.userDetailsService(userDetailsServiceimpl)
				.passwordEncoder(passwordEncoder());
	}

	/**
	 * ログイン機能・画面などをカスタマイズする
	 */
	@Override
	protected void configure(HttpSecurity http) throws Exception {
		http
				.headers()
				.frameOptions().sameOrigin()
				.and()
				.authorizeRequests()
				.antMatchers("/webjars/**", "/assets/**", "/css/**", "/img/**").permitAll() // 全ユーザーアクセス許可
				.antMatchers("/", "/index", "login*", "logout").permitAll() // 全ユーザーアクセス許可
                .antMatchers("/admin/**","/master/**").hasRole("ADMIN")
                .antMatchers("/adminap/**").hasRole("ADMINAP")
				.anyRequest().authenticated() //それ以外は全て認証無しの場合アクセス不可
				.and()
				// ログイン機能カスタマイズ
				.formLogin()
				.loginPage("/login") //ログインページ
				.usernameParameter("email")//inputタグのname
				.passwordParameter("password") //inputタグのname
				.defaultSuccessUrl("/myprofile") //ログインOKの場合
				//                .failureUrl("/login?error")
				.failureForwardUrl("/login_error") //ログインエラーの場合、LoginController.loginErrへ
				.permitAll()
				.and()
				.logout()
				.logoutRequestMatcher(new AntPathRequestMatcher("/logout"))
				.logoutSuccessUrl("/login?logout")
				.permitAll()
				.and()
				.exceptionHandling()
				.and();
//				.csrf().disable();
	}

}
