package com.apcbc.cs411backend.user;

import com.apcbc.cs411backend.db.UserEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/v1/user")
public class UserController {
    private final UserService userService;

    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }

    // ==========================================================================================================
    // |                                                CREATE                                                  |
    // ==========================================================================================================
    @PostMapping("/add")
    public void addNewUser(@RequestParam String userName,
                           @RequestParam String userEmail,
                           @RequestParam String password) throws IllegalArgumentException, IllegalStateException {
        userService.addNewUser(userName, userEmail, password);
    }

    @PostMapping("/login")
    public ResponseEntity<Long> userLogin(@RequestParam String userEmail, String password) throws IllegalArgumentException, IllegalStateException {
        Long userID = userService.getUserByEmailAndPassword(userEmail, password);
        return ResponseEntity.ok(userID);
    }

    // ==========================================================================================================
    // |                                                  READ                                                  |
    // ==========================================================================================================
    @GetMapping("/allUsers")
    public List<UserEntity> getAllUsers() {
        return userService.getAllUsers();
    }

    @GetMapping("/getUserByEmail")
    public UserEntity getUserByEmail(@RequestParam String userEmail) {
        return userService.getUserByEmail(userEmail);
    }


    // ==========================================================================================================
    // |                                                 UPDATE                                                 |
    // ==========================================================================================================
    @PutMapping("/updateAll")
    public void updateAll(@RequestParam String userID,
                          String newUserName,
                          String newUserEmail,
                          String newUserPassword) {
        userService.updateAll(userID, newUserName, newUserEmail, newUserPassword);
    }

    @PutMapping("/updateEmail")
    public void updateEmail(@RequestParam Long userID,
                            @RequestParam String newUserEmail
    ) throws IllegalArgumentException, IllegalStateException {
        userService.updateEmail(userID, newUserEmail);
    }

    @PutMapping("/updateName")
    public void updateName(@RequestParam Long userID,
                           @RequestParam String newUserName
    ) throws IllegalArgumentException, IllegalStateException {
        userService.updateName(userID, newUserName);
    }

    @PutMapping("/updatePassword")
    public void updatePassword(@RequestParam Long userID,
                               @RequestParam String newUserPassword
    ) throws IllegalArgumentException, IllegalStateException {
        userService.updatePassword(userID, newUserPassword);
    }


    // ==========================================================================================================
    // |                                                DELETE                                                  |
    // ==========================================================================================================
    @DeleteMapping("/deleteUser")
    public void deleteUserByID(@RequestParam String userID) throws IllegalStateException {
        userService.deleteUserByID(userID);
    }

}
