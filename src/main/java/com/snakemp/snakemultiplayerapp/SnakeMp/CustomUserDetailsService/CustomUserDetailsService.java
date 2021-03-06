package com.snakemp.snakemultiplayerapp.SnakeMp.CustomUserDetailsService;

import com.snakemp.snakemultiplayerapp.SnakeMp.CustomUserDetails.CustomUserDetails;
import com.snakemp.snakemultiplayerapp.SnakeMp.User.User;
import com.snakemp.snakemultiplayerapp.SnakeMp.UserRepository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

@SuppressWarnings("ALL")
public class CustomUserDetailsService implements UserDetailsService {

    @Autowired
    private UserRepository repo;

    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
        User user = repo.findByEmail(email);
        if (user == null) {
            throw new UsernameNotFoundException("User not found");
        }
        return new CustomUserDetails(user);
    }
}
