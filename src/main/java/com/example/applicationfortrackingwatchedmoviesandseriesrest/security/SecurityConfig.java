package com.example.applicationfortrackingwatchedmoviesandseriesrest.security;

import com.example.applicationfortrackingwatchedmoviesandseriesrest.service.UserDetailsServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.BeanIds;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

@Configuration
@EnableWebSecurity
@EnableGlobalMethodSecurity(securedEnabled = true, jsr250Enabled = true, prePostEnabled = true)
public class SecurityConfig extends WebSecurityConfigurerAdapter
{

	@Autowired
	private UserDetailsServiceImpl userDetailsService;

	@Override
	protected void configure(HttpSecurity http) throws Exception
	{
		http
				.authorizeRequests()
				.antMatchers("/auth/*")
				.permitAll()

				// .antMatchers("/admin").hasRole("ADMIN")
				.anyRequest().authenticated()

				.and()
				.formLogin()
				.loginPage("/auth/login")
				// .loginProcessingUrl("/auth/login-successful")
				// .usernameParameter("email").passwordParameter("password")
				// .permitAll()

				// .and()
				// .logout()
				// .logoutUrl("/auth/logout")
				// .deleteCookies("JSESSIONID")
				.and()
				.csrf().disable().cors();
		// .and()
		// .logout().invalidateHttpSession(true)
		// .clearAuthentication(true).permitAll();
	}

	@Override
	public void configure(AuthenticationManagerBuilder authenticationManagerBuilder) throws Exception
	{
		authenticationManagerBuilder.userDetailsService(userDetailsService);
	}

	@Override
	public void configure(WebSecurity web) throws Exception
	{
		web
				.ignoring()
				.antMatchers("/resources/**", "/static/**", "/css/**", "/js/**", "/images/**", "/fonts/**", "/scss/**");
	}

	@Bean(BeanIds.AUTHENTICATION_MANAGER)
	@Override
	public AuthenticationManager authenticationManagerBean() throws Exception
	{
		return super.authenticationManagerBean();
	}

	/*
	AuthenticationManager authenticationManager;

	@Autowired
	UserDetailsService userDetailsService;
	@Bean
	public AuthenticationManager authenticationManager(HttpSecurity httpSecurity, UserDetailsService userDetailsService, BCryptPasswordEncoder bCryptPasswordEncoder) throws Exception
	{
		AuthenticationManagerBuilder authenticationManagerBuilder = httpSecurity.getSharedObject(AuthenticationManagerBuilder.class);
		authenticationManagerBuilder.userDetailsService(userDetailsService)
				.passwordEncoder(bCryptPasswordEncoder);
		return authenticationManagerBuilder.build();
	}

	@Bean
	public AuthenticationManager authenticationManager(
			UserDetailsService userDetailsService,
			PasswordEncoder passwordEncoder)
	{
		DaoAuthenticationProvider authenticationProvider = new DaoAuthenticationProvider();
		authenticationProvider.setUserDetailsService(userDetailsService2(bCryptPasswordEncoder()));
		authenticationProvider.setPasswordEncoder(bCryptPasswordEncoder());

		return new ProviderManager(authenticationProvider);
	}

	@Bean
	public BCryptPasswordEncoder bCryptPasswordEncoder()
	{
		return new BCryptPasswordEncoder();
	}

	@Bean
	public UserDetailsService userDetailsService()
	{
		UserDetails userDetails = User.withDefaultPasswordEncoder()
				.username("user")
				.password("password")
				.roles("USER")
				.accountLocked(false)
				.build();

		return new InMemoryUserDetailsManager(userDetails);
	}

	@Bean
	public AuthenticationManager authenticationManager(AuthenticationConfiguration authenticationConfiguration) throws Exception
	{
		return authenticationConfiguration.getAuthenticationManager();
	}

	@Bean
	public UserDetailsService userDetailsService2(BCryptPasswordEncoder bCryptPasswordEncoder)
	{
		return new CustomDetailsService(bCryptPasswordEncoder);
	}


	@Bean
	public SecurityFilterChain filterChain(HttpSecurity http) throws Exception
	{

		AuthenticationManagerBuilder authenticationManagerBuilder = http.getSharedObject(AuthenticationManagerBuilder.class);
		authenticationManagerBuilder.userDetailsService(userDetailsService);
		authenticationManager = authenticationManagerBuilder.build();

		http.csrf().disable().cors().disable().authorizeHttpRequests().requestMatchers("/register", "/login").permitAll()
				.anyRequest().authenticated()
				.and()
				.authenticationManager(authenticationManager)
				.sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS);
		return http.build();
	}

	//OVA E DOBRO
	@Bean
	public SecurityFilterChain filterChain(HttpSecurity http) throws Exception
	{
		http.csrf()
				.disable()
				.authorizeHttpRequests()
				.requestMatchers(HttpMethod.DELETE)
				.hasRole("ADMIN")
				.requestMatchers("/admin/**")
				.hasAnyRole("ADMIN")
				.requestMatchers("/user/**")
				.hasAnyRole("USER", "ADMIN")
				.requestMatchers("/login/**")
				.anonymous()
				.anyRequest()
				.authenticated()
				.and()
				.httpBasic()
				.and()
				.sessionManagement()
				.sessionCreationPolicy(SessionCreationPolicy.STATELESS);

		return http.build();
	}

	@Bean
	public SecurityFilterChain filterChain(HttpSecurity http) throws Exception
	{
		http.csrf()
				.disable()
				.authorizeHttpRequests()
				.requestMatchers("/**")
				.permitAll()
				.anyRequest()
				.authenticated()
				.and()
				.formLogin()
				.loginPage("/login")
				.permitAll();
		//.and()
		//.httpBasic();
		return http.build();
	}

	@Bean
	public WebSecurityCustomizer webSecurityCustomizer()
	{
		return (web) -> web.ignoring().requestMatchers("/static/images/*", "/templates/**", "/static/**");
	}

	@Override
	protected void configure(HttpSecurity http) throws Exception
	{
		http
				.authorizeRequests()
				.requestMatchers("/**")
				.permitAll()
				.anyRequest().authenticated()
				.and()
				.csrf().disable().cors();
	}

*/
}