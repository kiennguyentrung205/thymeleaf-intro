package vn.edu.fpt.musicstore.services;

import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import vn.edu.fpt.musicstore.entities.User;
import vn.edu.fpt.musicstore.repositories.UserRepository;

@Service
public class UserService implements UserDetailsService {
    private UserRepository userRepository;
    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
    User user = userRepository.getUserByUsernameIgnoreCase(username);
    if (user == null) {
        throw new UsernameNotFoundException("User not found");
    }
    //tra ve 1 object thuoc kieu userdetail(Spring sec)
        //object nay goi la principal
    return org.springframework.security.core.userdetails.User
            .withUsername(user.getUsername())
            .password(user.getPassword())
            .authorities("ROLE_" + user.getRole())
            .build();
    }
}
