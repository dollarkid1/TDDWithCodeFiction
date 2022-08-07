package com.example.tddwithcodefiction.endpoints.unit.service;

import com.example.tddwithcodefiction.endpoints.unit.data.User;
import com.example.tddwithcodefiction.endpoints.unit.data.UserRepository;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.ArgumentMatchers;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
public class CreateUserServiceTest {

    @Mock
    private UserRepository userRepository;
    @InjectMocks
    private CreateUserService userService;

    @Test
    public void whenSaveUser_shouldReturnAUser(){
        User user = new User();
        user.setName("TestName");

        when(userRepository.save(ArgumentMatchers.any(User.class))).thenReturn(user);

        User userCreated = userService.createNewUser(user);

        assertThat(userCreated.getName()).isSameAs(user.getName());

        verify(userRepository).save(user);
    }

}
