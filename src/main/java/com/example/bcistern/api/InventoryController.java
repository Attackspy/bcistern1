package com.example.bcistern.api;

import com.example.bcistern.model.Course;
import com.example.bcistern.model.Inventory;
import com.example.bcistern.model.Money;
import com.example.bcistern.model.User;
import com.example.bcistern.service.CourseService;
import com.example.bcistern.service.InventoryService;
import com.example.bcistern.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

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

    //@PostMappinp
    //public void giftCourse(@RequestBody Inventory inventory){
    //    inventoryService.getCourse(inventory);
    //}

    @PostMapping
    public String buyACourse(@RequestBody Inventory inventory){
        Optional<User> user = userService.findStudentById(inventory.getUser_id());
        Optional<Course> course = courseService.findcourse(inventory.getCourse_id());
        if(user.isPresent() && course.isPresent()){
            if(course.get().getPrice() > user.get().getMoney()){
                return "not enough money, you need: " + String.valueOf(course.get().getPrice() - user.get().getMoney());
            }
            else{
                if(inventoryService.findThatInv(inventory.getUser_id(),inventory.getCourse_id()).isPresent()){
                    return "already exist";
                }
                else{
                    Money money = new Money(course.get().getPrice() * -1, user.get().getId());
                    userService.userDeposit(money);
                    inventoryService.getCourse(inventory);
                    return "successful, " + user.get().getName() + "'s current money: " + user.get().getMoney();
                }
            }
        }
        else {
            return "course or user not found";
        }
    }

    @RequestMapping(value = "get", method = RequestMethod.GET)
    public String getUserInventory(@RequestBody Long uid){
        return String.valueOf(inventoryService.showUserInventory(uid));
    }

    @RequestMapping(value = "get_course_owners", method = RequestMethod.GET)
    public String getCourseOwners(@RequestBody Long cid){
        return String.valueOf(inventoryService.showCourseOwners(cid));
    }
}
