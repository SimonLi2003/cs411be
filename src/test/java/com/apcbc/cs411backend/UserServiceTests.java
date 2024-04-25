package com.apcbc.cs411backend;

import com.apcbc.cs411backend.user.UserRepository;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Captor;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith(MockitoExtension.class)
public class UserServiceTests {
    @Mock
    private UserRepository userRepository;

    // whenUserDoesNotExist_addNewUser_shouldSaveUser

    // whenUserExist_addNewUser_shouldNotSaveUser

    //
}
