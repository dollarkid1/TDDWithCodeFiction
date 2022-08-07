package com.example.tddwithcodefiction.endpoints.unit.service;

import com.example.tddwithcodefiction.endpoints.unit.data.User;
import com.example.tddwithcodefiction.endpoints.unit.data.UserRepository;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import java.util.Optional;

import static org.mockito.ArgumentMatchers.anyLong;
import static org.mockito.BDDMockito.given;
import static org.mockito.Mockito.verify;

@RunWith(MockitoJUnitRunner.class)
public class UpdateUserServiceTest {

    @Mock
    UserRepository repository;
    @InjectMocks
    UpdateUserService service;


    @Test
    public void whenGivenID_shouldUpdateUser_ifFound(){
        User user = new User();
        user.setId(89L);
        user.setName("Test Name");

        User newUser = new User();
        user.setName("New Test Name");

        given(repository.findById(user.getId())).willReturn(Optional.of(user));
        service.updateUser(user.getId(), newUser);

        verify(repository).save(newUser);
        verify(repository).findById(user.getId());
    }
    @Test(expected = RuntimeException.class)
    public void should_throw_exception_when_user_doesnt_exist() {
        User user = new User();
        user.setId(89L);
        user.setName("Test Name");

        User newUser = new User();
        newUser.setId(90L);
        user.setName("New Test Name");

        given(repository.findById(anyLong())).willReturn(Optional.ofNullable(null));
        service.updateUser(user.getId(), newUser);
    }
}
