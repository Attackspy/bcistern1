package com.example.bcistern.api;

import com.example.bcistern.model.Money;
import com.example.bcistern.model.User;
import com.example.bcistern.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RequestMapping(path = "api/v1/user")
@RestController
public class UserController {

    private final UserService userService;

    @Autowired
    public UserController(UserService userService){
        this.userService = userService;
    }

    @GetMapping
    public List<User> showStudent(){
        return userService.showStudent();
    }

    //@PostMapping
    //public void registerNewUser(@RequestBody User user){userService.addNewUser(user);}

    @DeleteMapping
    public void deleteUser(@RequestBody Long id) {userService.deleteUser(id);}

    @RequestMapping(value = "{id}", method = RequestMethod.GET)
    public Optional<User> getStudent(@RequestBody Long id){return userService.findStudentById(id);}

    @RequestMapping(value = "find/{email}", method = RequestMethod.GET)
    public Optional<User> getStudentmail(@RequestBody String email){return userService.findStudentByEmail(email);}

    @PostMapping
    public String userRegister(@RequestBody User user) {
        if(!userService.findStudentByEmail(user.getEmail()).isPresent()){
            userService.addNewUser(user);
            return "successfully registered";
        }
        else{
            return "email already exist!";
        }
    }

    @RequestMapping(value = "login_old", method = RequestMethod.PUT)
    public User userLogin(@RequestBody String mail){
        Optional<User> user = userService.findStudentByEmail(mail);
        userService.userLogin(mail);
        return user.get();
    }

    @RequestMapping(value = "money", method = RequestMethod.PUT)
    public String userMoney(@RequestBody Money money){
        userService.userDeposit(money);
        return userService.findStudentById(money.getUserId()).get().getName() + " : " + String.valueOf(userService.findStudentById(money.getUserId()).get().getMoney());
    }
    /*
    @RequestMapping(value = "login", method = RequestMethod.PUT)
    public String fullLogin(@RequestBody String email, String password){
        Optional<User> user = userService.findStudentByEmail(email);
        if(user.isPresent()){
            if(user.get().getPassword().equals(password)){
                userService.userLogin(email);
                return "!!!!";
            }
            else {return "sifre hatali";}
        }
        else {return "eposta hatali";}
    }
    */
}
