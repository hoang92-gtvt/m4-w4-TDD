package com.example.portfolio.configuration.security;

import com.example.portfolio.configuration.custom.CustomAccessDeniedHandler;
import com.example.portfolio.configuration.custom.RestAuthenticationEntryPoint;
import com.example.portfolio.configuration.filter.JwtAuthenticationFilter;
import com.example.portfolio.model.Coach;
import com.example.portfolio.model.Role;
import com.example.portfolio.model.RoleName;
import com.example.portfolio.service.coach.CoachService;
import com.example.portfolio.service.coach.ICoachService;
import com.example.portfolio.service.role.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.BeanIds;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;

import javax.annotation.PostConstruct;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Configuration
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {
    @Bean
    public ICoachService userService() {
        return new CoachService();
    }

    @Autowired
    private CoachService coachService;

    @Autowired
    private RoleService roleService;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Bean
    public JwtAuthenticationFilter jwtAuthenticationFilter() {
        return new JwtAuthenticationFilter();
    }

    @Bean(BeanIds.AUTHENTICATION_MANAGER)
    @Override
    public AuthenticationManager authenticationManager() throws Exception {
        return super.authenticationManager();
    }

    @Bean
    public RestAuthenticationEntryPoint restServicesEntryPoint() {
        return new RestAuthenticationEntryPoint();
    }

    @Bean
    public CustomAccessDeniedHandler customAccessDeniedHandler() {
        return new CustomAccessDeniedHandler();
    }

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder(10);
    }

    @PostConstruct
    public void init() {
        List<Coach> coaches = (List<Coach>) coachService.findAll();
        List<Role> roleList = (List<Role>) roleService.findAll();
        if (roleList.isEmpty()) {
            Role roleAdmin = new Role();
            roleAdmin.setId(1L);
            roleAdmin.setName(RoleName.ROLE_ADMIN.toString());
            roleService.save(roleAdmin);
            Role roleCoach = new Role();
            roleCoach.setId(2L);
            roleCoach.setName(RoleName.ROLE_COACH.toString());
            roleService.save(roleCoach);
        }
        if (coaches.isEmpty()) {
            Coach admin = new Coach();
            Set<Role> roles = new HashSet<>();
            roles.add(new Role(1L, RoleName.ROLE_ADMIN.toString()));
            admin.setEmail("admin");
            admin.setCoachId("");
            admin.setName("");
            admin.setPassword(passwordEncoder.encode("123456"));
            admin.setRoles(roles);
            coachService.save(admin);
        }
    }

    @Override
    public void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.userDetailsService(coachService).passwordEncoder(passwordEncoder());
    }

    @Override
    public void configure(WebSecurity web) throws Exception {
        web.ignoring().antMatchers("/swagger-ui.html/**",
                "/configuration/**",
                "/swagger-resources/**",
                "/v2/api-docs",
                "/webjars/**");
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.csrf().ignoringAntMatchers("/**");
        http.httpBasic().authenticationEntryPoint(restServicesEntryPoint());
        http.authorizeRequests()
                .antMatchers("/", "/login").permitAll()
                .antMatchers(HttpMethod.GET,
        "/categories/**").access("hasAnyRole('COACH','ADMIN')")
                .antMatchers(HttpMethod.POST,
        "/categories").access("hasRole('ADMIN')")
                .antMatchers(HttpMethod.PUT,
        "/categories/**").access("hasRole('ADMIN')")
                .antMatchers(HttpMethod.DELETE,
                        "/categories/**").access("hasRole('ADMIN')")
                .and().csrf().disable()
                .logout().logoutRequestMatcher(new AntPathRequestMatcher("/logout"));
        http.addFilterBefore(jwtAuthenticationFilter(), UsernamePasswordAuthenticationFilter.class)
                .exceptionHandling().accessDeniedHandler(customAccessDeniedHandler());
        http.sessionManagement()
                .sessionCreationPolicy(SessionCreationPolicy.STATELESS);
        http.cors();
    }
}
