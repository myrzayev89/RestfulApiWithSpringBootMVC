package com.myrzayev.restfulapi.service;

import com.myrzayev.restfulapi.entity.User;
import com.myrzayev.restfulapi.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class UserService implements UserDetailsService {

    @Autowired
    private UserRepository userRepo;

    public List<User> listAll() {
        return userRepo.findAll();
    }

    public User getByUsername(String username) {
        return userRepo.findByUsername(username);
    }

    public User getById(int id) {
        return userRepo.findById(id).get();
    }

    public void create(User p) {
        userRepo.save(p);
    }

    public void delete(int id) {
        userRepo.deleteById(id);
    }

    public User findByUsername(String username) {
        return userRepo.findByUsername(username);
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User user = userRepo.findByUsername(username);
        if (user != null) {
            org.springframework.security.core.userdetails.User.UserBuilder builder = org.springframework.security.core.userdetails.User.withUsername(username);
            builder.disabled(false);
            builder.password(user.getPassword());
            String[] authoritiesArr = new String[]{"ADMIN"};
            builder.authorities(authoritiesArr);
            return builder.build();
        } else {
            throw new UsernameNotFoundException("User not found!");
        }
    }
}
