package com.ufc.br.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;

import com.ufc.br.security.UserDetailsServiceImplementacao;

@Configuration
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {

	@Autowired
	private UserDetailsServiceImplementacao userDetailsImplementacao;

	// Definir regras da aplicação
	@Override
	protected void configure(HttpSecurity http) throws Exception {
		http.csrf().disable().authorizeRequests().antMatchers("/")
		.permitAll().antMatchers("/usuario/formulario")
		.permitAll().antMatchers("/inicio")
		.permitAll().antMatchers("/usuario/salvar")
		.permitAll().antMatchers("/usuario/inicio")
		.permitAll().antMatchers("/pedido/listar").hasRole("CLIENTE")
		.antMatchers("/pedido/formulario").hasRole("CLIENTE").antMatchers("/prato/formulario").hasRole("ADMIN").
		antMatchers("/prato/listar").permitAll()
		.antMatchers("/prato/vizualizar").permitAll()
		.anyRequest().authenticated().and().formLogin().loginPage("/usuario/logar")
				.defaultSuccessUrl("/inicio/logado").permitAll().permitAll()

				.and().logout().logoutSuccessUrl("/usuario/logar?logout").permitAll();

	}

	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
		auth.userDetailsService(userDetailsImplementacao).passwordEncoder(new BCryptPasswordEncoder());

	}

	// ignorar esses arquivos que esses arquivos apareçam
	@Override
	public void configure(WebSecurity web) throws Exception {
		web.ignoring().antMatchers("/css/**", "/js/**", "/img/**", "ImagensProdutos/**", "/resources/**");
	}
}
