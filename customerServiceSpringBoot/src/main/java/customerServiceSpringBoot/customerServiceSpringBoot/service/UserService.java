package customerServiceSpringBoot.customerServiceSpringBoot.service;

import customerServiceSpringBoot.customerServiceSpringBoot.entity.User;
import customerServiceSpringBoot.customerServiceSpringBoot.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    public List<User> getAllCustomerList() {
        return userRepository.findAll();
    }
    public User registerUser(User user) {
        Optional<User> existingUser = userRepository.findByUsername(user.getUsername());
        if (existingUser.isPresent()) {
            throw new RuntimeException("Username already exists");
        }

        existingUser = userRepository.findByEmail(user.getEmail());
        if (existingUser.isPresent()) {
            throw new RuntimeException("Email already exists");
        }

        existingUser = userRepository.findByPhone(user.getPhone());
        if (existingUser.isPresent()) {
            throw new RuntimeException("Phone number already exists");
        }
        user.setOtp("123456");
        return userRepository.save(user);
    }

    public User loginUser(String username, String password) {
        Optional<User> userOptional = userRepository.findByUsername(username);

        if (!userOptional.isPresent() || !userOptional.get().getPassword().equals(password)) {
            throw new RuntimeException("Invalid username or password");
        }
        return userOptional.get();
    }


    public User loginAdmin(String username, String password) {
        Optional<User> userOptional = userRepository.findByUsername(username);

        if (!userOptional.isPresent() || !userOptional.get().getPassword().equals(password)) {
            throw new RuntimeException("Invalid username or password");
        }
        return userOptional.get();
    }

    public void deleteUser(Long id) {
        userRepository.deleteById(id);
    }

    public User getUserById(Long id) {
        return userRepository.findById(id).orElse(null);
    }


    public User registerUserByAdmin(User user) {
        user.setOtp("123456");
        return userRepository.save(user);
    }
}

