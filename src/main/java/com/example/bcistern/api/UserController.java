package com.example.bcistern.api;

import com.example.bcistern.model.User;
import com.example.bcistern.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

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
    public String showStudent(){
        return userService.showStudent().toString();
    }

    //@PostMapping
    //public void registerNewUser(@RequestBody User user){userService.addNewUser(user);}

    @DeleteMapping
    public void deleteUser(@RequestBody Long id) {userService.deleteUser(id);}

    @RequestMapping(value = "{id}", method = RequestMethod.GET)
    public String getStudent(@RequestBody Long id){return userService.findStudentById(id).toString();}

    @RequestMapping(value = "find/{email}", method = RequestMethod.GET)
    public String getStudentmail(@RequestBody String email){return userService.findStudentByEmail(email).toString();}

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
    public String userLogin(@RequestBody String mail){
        Optional<User> user = userService.findStudentByEmail(mail);
        userService.userLogin(mail);
        return user.toString() + "login successful";
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
