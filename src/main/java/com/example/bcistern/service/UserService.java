package com.example.bcistern.service;

import com.example.bcistern.dao.UserRepository;
import com.example.bcistern.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class UserService {

    private final UserRepository userRepository;

    @Autowired
    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public List<User> showStudent(){
        return userRepository.findAll();
    }

    public void addNewUser(@RequestBody User user) {
        userRepository.save(user);
    }

    public void deleteUser(@RequestParam Long id){
        userRepository.deleteUserById(id);
    }

    public Optional<User> findStudentById(@RequestParam Long id){return userRepository.findById(id);}
}
