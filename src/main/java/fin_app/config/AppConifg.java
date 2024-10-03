package fin_app.config;

import fin_app.repositories.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

@Configuration
@RequiredArgsConstructor
public class AppConifg {

    private final UserRepository userRepository;

    @Bean
    public UserDetailsService userDetailsService() {
        return username ->
            userRepository.findByEmail(username).orElseThrow(() -> new UsernameNotFoundException("User not found."));

    }
}
