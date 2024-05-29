package ma.petproject.petproject.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
public class SecurityConfig {

    @Bean
    SecurityFilterChain defaultSecurityFilterChain(HttpSecurity http) throws Exception {
        http
                .csrf(csrf -> csrf.disable())
                .authorizeRequests(requests -> requests
                        .requestMatchers("/AddMedicalRecord", "/AddOwner", "/AddVeterinarian",
                                "/AddAct", "/AddAnimal", "/AddAppointment","ListAnimals",
                                "/ListMedicalRecords", "/ListVeterinarians", "/ListActs",
                                "/ListOwners", "/ListAnimals", "/DeleteVeterinarian", "/ListAppointments").hasRole("ADMIN")
                        .requestMatchers("/index", "/application", "/phpmyadmin/**",
                                "/", "/User/js/**", "/img/**", "/User/css/**", "/webjars/**",
                                "/User/sass/**", "/User/webfonts/**", "/User/images/**",
                                "/js/**", "/css/**", "/images/**", "/vendor/**", "/fonts/**").permitAll()
                        .anyRequest().authenticated()
                )
                .formLogin(form -> form
                        .loginPage("/signin")
                        .permitAll()
                        .defaultSuccessUrl("/ListVeterinarians")
                )
                .logout(logout -> logout
                        .logoutUrl("/logout")
                        .logoutSuccessUrl("/signin?logout")
                        .permitAll()
                );

        return http.build();
    }

    @Bean
    public InMemoryUserDetailsManager userDetailsService() {
        UserDetails admin = User.withUsername("AdminPureWell")
                .password(passwordEncoder().encode("PureWell"))
                .roles("ADMIN")
                .build();

        return new InMemoryUserDetailsManager(admin);
    }

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }
}
