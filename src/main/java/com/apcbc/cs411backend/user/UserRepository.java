package com.apcbc.cs411backend.user;

import com.apcbc.cs411backend.db.UserEntity;
import org.springframework.data.jdbc.repository.query.Modifying;
import org.springframework.data.jdbc.repository.query.Query;
import org.springframework.data.repository.ListCrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface UserRepository extends ListCrudRepository<UserEntity, Long> {
    @Query("SELECT * FROM Users")
    List<UserEntity> getAllUsers();

    @Query("SELECT * FROM Users WHERE user_email = :userEmail")
    Optional<UserEntity> getUserEntityByUserEmail(String userEmail);

    @Query("SELECT * FROM Users WHERE user_id = :userID")
    Optional<UserEntity> getUserEntityByUserID(Long userID);

    @Modifying
    @Query("UPDATE Users SET user_email = :newUserEmail WHERE user_id = :userID")
    void updateUserEmailByUserID(Long userID, String newUserEmail);

    @Modifying
    @Query("UPDATE Users SET user_name = :newUserName WHERE user_id = :userID")
    void updateUserNameByUserID(Long userID, String newUserName);

    @Modifying
    @Query("UPDATE Users SET password = :newPassword WHERE user_id = :userID")
    void updatePasswordByUserID(Long userID, String newPassword);

    @Modifying()
    @Query("DELETE FROM Users WHERE user_id = :userID")
    void deleteUserEntityByUserID(Long userID);

    @Modifying
    @Query("INSERT INTO Users(user_id, user_email, user_name, password) VALUES (:userID, :userEmail, :userName, :password)")
    void insert(Long userID, String userEmail, String userName, String password);
}
