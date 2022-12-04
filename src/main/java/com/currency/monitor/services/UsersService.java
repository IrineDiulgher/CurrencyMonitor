package com.currency.monitor.services;

import com.currency.monitor.datasource.UserDAO;
import com.currency.monitor.entities.User;
import com.currency.monitor.entities.UserRole;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
import java.util.Optional;

@Service
public class UsersService implements UserDetailsService {
    private final BCryptPasswordEncoder bCryptPasswordEncoder;

    @Autowired
    private UserDAO userDAO;

    public UsersService(BCryptPasswordEncoder bCryptPasswordEncoder) {
        this.bCryptPasswordEncoder = bCryptPasswordEncoder;
    }

    @Override
    public UserDetails loadUserByUsername(String username)
            throws UsernameNotFoundException {
        System.out.println("username=" + username);
        return userDAO.findByUsername(username)
                .orElseThrow(() ->
                        new UsernameNotFoundException(
                                String.format("User %s not found", username)));
    }

    public List<User> getUsers() {
        return userDAO.findAll();
    }

    public User createUser(String username, String password, String emailAddress, String phoneNumber, String confirmPassword) {
        if (userDAO.findByUsername(username).isPresent()){
            return null;
        }
        User user = new User();
        user.setUsername(username);
        user.setPassword(bCryptPasswordEncoder.encode(password));
        user.setUserRole(UserRole.USER);
        user.setEmail(emailAddress);
        user.setPhoneNumber(phoneNumber);
        user.setMemberSince(new Date());
        return userDAO.save(user);
    }

    public void deleteUser(long id) {
        userDAO.deleteById(id);
    }

    public Optional<User> getUser(String username){
        return userDAO.findByUsername(username);
    }

}
