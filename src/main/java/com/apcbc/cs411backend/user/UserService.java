package com.apcbc.cs411backend.user;

import com.apcbc.cs411backend.db.UserEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;



@Service
public class UserService {
    private final UserRepository userRepository;
    Long globalID = 1000L;

    @Autowired
    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    // ==========================================================================================================
    // |                                                CREATE                                                  |
    // ==========================================================================================================
    @Transactional
    public void addNewUser(String userName,
                           String userEmail,
                           String password) throws IllegalArgumentException, IllegalStateException {
        if (userName == null || userName.isEmpty()) {
            throw new IllegalArgumentException("user name cannot be null / empty!");
        }
        if (userEmail == null || userEmail.isEmpty()) {
            throw new IllegalArgumentException("user email cannot be null / empty!");
        }
        if (password == null || password.isEmpty()) {
            throw new IllegalArgumentException("password cannot be null / empty!");
        }

        Optional<UserEntity> optionalUser = userRepository.getUserEntityByUserEmail(userEmail);
        if (optionalUser.isPresent()) {
            throw new IllegalStateException("user already exist!");
        }

        userRepository.insert(globalID++, userEmail, userName, password);
    }

    // ==========================================================================================================
    // |                                                  READ                                                  |
    // ==========================================================================================================
    public List<UserEntity> getAllUsers() {
        return userRepository.getAllUsers();
    }

    public UserEntity getUserByEmail(String userEmail) throws IllegalStateException {
        Optional<UserEntity> optionalUser = userRepository.getUserEntityByUserEmail(userEmail);
        if (optionalUser.isEmpty()) {
            throw new IllegalStateException("user does not exist!");
        }

        return optionalUser.get();
    }

    public Long getUserByEmailAndPassword(String userEmail, String password) throws IllegalArgumentException, IllegalStateException {
        Optional<UserEntity> optionalUser = userRepository.getUserEntityByUserEmail(userEmail);
        if (optionalUser.isEmpty()) {
            throw new IllegalStateException("user does not exist!");
        }

        if (password == null || password.isEmpty()) {
            throw new IllegalStateException("password cannot be null / empty!");
        }

        UserEntity userEntity = optionalUser.get();
        if (!userEntity.password().equals(password)) {
            throw new IllegalArgumentException("password is incorrect!");
        }

        return userEntity.userID();
    }

    // ==========================================================================================================
    // |                                                 UPDATE                                                 |
    // ==========================================================================================================
    @Transactional
    public void updateAll(String stringUserID,
                          String newUserName,
                          String newUserEmail,
                          String newUserPassword) throws IllegalArgumentException, IllegalStateException {
        Long userID = Long.parseLong(stringUserID);
        updateName(userID, newUserName);
        updateEmail(userID, newUserEmail);
        updatePassword(userID, newUserPassword);
    }
    @Transactional
    public void updateEmail(Long userID,
                            String newUserEmail) throws IllegalArgumentException, IllegalStateException {
        if (newUserEmail == null || newUserEmail.isEmpty()) return;

        Optional<UserEntity> optionalUser = userRepository.getUserEntityByUserID(userID);
        if (optionalUser.isEmpty()) {throw new IllegalStateException("user does not exist!");}

        UserEntity user = optionalUser.get();
        if (user.userEmail() != null && user.userEmail().equals(newUserEmail)) {
            return;
        }

        if (userRepository.getUserEntityByUserEmail(newUserEmail).isPresent()) {
            throw new IllegalArgumentException("email has been taken!");
        }

        userRepository.updateUserEmailByUserID(userID, newUserEmail);
    }

    @Transactional
    public void updateName(Long userID,
                            String newUserName) throws IllegalStateException {
        if (newUserName == null || newUserName.isEmpty()) return;

        Optional<UserEntity> optionalUser = userRepository.getUserEntityByUserID(userID);
        if (optionalUser.isEmpty()) {throw new IllegalStateException("user does not exist!");}

        UserEntity user = optionalUser.get();
        if (user.userName() != null && user.userName().equals(newUserName)) {
            return;
        }

        userRepository.updateUserNameByUserID(userID, newUserName);
    }

    @Transactional
    public void updatePassword(Long userID,
                           String newPassword) throws IllegalStateException {
        if (newPassword == null || newPassword.isEmpty()) return;

        Optional<UserEntity> optionalUser = userRepository.getUserEntityByUserID(userID);
        if (optionalUser.isEmpty()) {throw new IllegalStateException("user does not exist!");}

        UserEntity user = optionalUser.get();
        if (user.password() != null && user.password().equals(newPassword)) {
            return;
        }

        userRepository.updatePasswordByUserID(userID, newPassword);
    }


    // ==========================================================================================================
    // |                                                DELETE                                                  |
    // ==========================================================================================================
    @Transactional
    public void deleteUserByID(String stringUserID) throws IllegalStateException {
        Long userID = Long.parseLong(stringUserID);
        userRepository.deleteUserEntityByUserID(userID);
    }
}
