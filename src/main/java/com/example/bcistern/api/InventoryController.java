package com.example.bcistern.api;

import com.example.bcistern.model.*;
import com.example.bcistern.service.CourseService;
import com.example.bcistern.service.InventoryService;
import com.example.bcistern.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RequestMapping(path = "api/v1/buy")
@RestController
public class InventoryController {
    private final InventoryService inventoryService;
    private final UserService userService;
    private final CourseService courseService;

    @Autowired
    public InventoryController(InventoryService inventoryService, UserService userService, CourseService courseService) {
        this.inventoryService = inventoryService;
        this.userService = userService;
        this.courseService = courseService;
    }

    @PostMapping
    public String buyACourse(@RequestBody Inventory inventory){
        Optional<User> user = userService.findStudentById(inventory.getUser().getId());
        Optional<Course> course = courseService.findcourse(inventory.getCourse().getId());
        if(user.isPresent() && course.isPresent()){
            if(course.get().getPrice() > user.get().getMoney()){
                return "not enough money, you need: " + String.valueOf(course.get().getPrice() - user.get().getMoney());
            }
            else{
                if(inventoryService.findThatInv(inventory.getUser().getId(), inventory.getCourse().getId()).isPresent()){
                    return "already exist";
                }
                else{
                    if(course.get().is_active()){
                        Money money = new Money(course.get().getPrice() * -1, user.get().getId());
                        userService.userDeposit(money);
                        inventoryService.getCourse(inventory);
                        return "successful, " + user.get().getName() + "'s current money: " + user.get().getMoney();
                    }
                    else {return "course is not active";}
                }
            }
        }
        else {return "course or user not found";}
    }

    @RequestMapping(value = "get", method = RequestMethod.GET)
    public String getUserInventory(@RequestBody Long uid){
        return String.valueOf(inventoryService.showUserInventory(uid));
    }

    @GetMapping(value = "get_course_owners")
    public List<Inventory> getCourseOwners(@RequestBody Long cid){
        return inventoryService.showCourseOwners(cid);
    }
}
