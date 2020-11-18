package com.sinishaw.mvcthymeleafmysql.service;

import com.sinishaw.mvcthymeleafmysql.model.User;
import com.sinishaw.mvcthymeleafmysql.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserService {

    private UserRepository userRepository;

    @Autowired
    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public List<User> listAllUsers(){
        return userRepository.findAll();
    }

    public Optional<User> findUserById(Integer id){
        return userRepository.findById(id);
    }

    public User addUser(User user){
        return userRepository.save(user);
    }

    public void delete(Integer id) {
         userRepository.deleteById(id);
    }

    public List<User> saveAll(List<User> users){
        return userRepository.saveAll(users);
    }
}
