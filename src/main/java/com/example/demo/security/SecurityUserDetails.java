package com.example.demo.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service("userDetailsImpl")
public class SecurityUserDetails implements UserDetailsService {

    private final UserRepository  userRepository;

    @Autowired
    public SecurityUserDetails(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
         User user=userRepository.findByUsername(username).orElseThrow(()->new UsernameNotFoundException("User doesn't exist"));
         return SecurityUser.fromUser(user);
    }
}
