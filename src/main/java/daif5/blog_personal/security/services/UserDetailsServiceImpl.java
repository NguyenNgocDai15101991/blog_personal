package daif5.blog_personal.security.services;

import daif5.blog_personal.model.signinSignup.User;
import daif5.blog_personal.repository.UserRepository;
import daif5.blog_personal.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Service
public class UserDetailsServiceImpl implements UserDetailsService {
    @Autowired
    UserRepository userRepository;
    @Autowired
    UserService userService;

    @Override
    @Transactional
    public UserDetails loadUserByUsername(String username)
            throws UsernameNotFoundException {
        if (username.contains("@")) {
            User user = userRepository.findByEmail(username)
                    .orElseThrow(() ->
                            new UsernameNotFoundException("User Not Found with -> username or email : " + username)
                    );

            return UserPrinciple.build(user);
        } else {
            User user = userRepository.findByUsername(username)
                    .orElseThrow(() ->
                            new UsernameNotFoundException("User Not Found with -> username or email : " + username)
                    );

            return UserPrinciple.build(user);
        }
    }

    public User getCurrentUser() {
        Optional<User> user;
        String userName;
        Object principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        if (principal instanceof UserDetails) {
            userName = ((UserDetails) principal).getUsername();
        } else {
            userName = principal.toString();
        }
        if (userRepository.existsByUsername(userName)) {
            user = userService.findByUsername(userName);
        } else {
            user = Optional.of(new User());
            user.get().setUsername("Anonymous");
        }
        return user.get();
    }
}
