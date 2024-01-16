package customerServiceSpringBoot.customerServiceSpringBoot.controller;

import customerServiceSpringBoot.customerServiceSpringBoot.entity.User;
import customerServiceSpringBoot.customerServiceSpringBoot.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
@CrossOrigin(origins = "http://localhost:4200")
public class UserController {

    @Autowired
    private UserService userService;
    @GetMapping
    public List<User> getAllUser() {
        return userService.getAllCustomerList();
    }

    @GetMapping("/{id}")
    public User getProductById(@PathVariable Long id) {
        return userService.getUserById(id);
    }
    @PostMapping("/register")
    public User registerUser(@RequestBody User user) {
        return userService.registerUser(user);
    }

    @PostMapping("/login")
    public User loginUser(@RequestBody User user) {
        return userService.loginUser(user.getUsername(), user.getPassword());
    }

    @PostMapping("/admin")
    public User loginAdmin(@RequestBody User user) {

        return userService.loginAdmin(user.getUsername(), user.getPassword());
    }
    @DeleteMapping("/{id}")
    public void deleteProduct(@PathVariable Long id) {
        userService.deleteUser(id);
    }


    @PostMapping("/registerByAdmin")
    public User registerUserByAdmin(@RequestBody User user) {
        return userService.registerUserByAdmin(user);
    }

}
