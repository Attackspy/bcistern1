package com.example.bcistern.service;

import com.example.bcistern.dao.UserRepository;
import com.example.bcistern.model.Money;
import com.example.bcistern.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

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

    public Optional<User> findStudentByEmail(@RequestParam String email){ return userRepository.findUserByEmail(email);}

    public void userLogin(@RequestParam String email){
        LocalDateTime date = LocalDateTime.now();
        userRepository.userLogin(date, email);
    }

    public void userDeposit(@RequestBody Money money){
        userRepository.changeMoney(userRepository.findById(money.getUserId()).get().getMoney() + money.getAmount(), money.getUserId());
    }
}
