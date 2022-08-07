package com.example.tddwithcodefiction.endpoints.unit.service;

import com.example.tddwithcodefiction.endpoints.unit.data.User;
import com.example.tddwithcodefiction.endpoints.unit.data.UserRepository;
import org.junit.Test;
import org.junit.jupiter.api.BeforeEach;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import java.util.Optional;

import static org.mockito.ArgumentMatchers.anyLong;
import static org.mockito.BDDMockito.given;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
public class DeleteUserServiceTest {

    @Mock
    UserRepository repository;

    @InjectMocks
    DeleteUserService service;

    User user;

    @BeforeEach
    void setUp(){
        user = new User();
    }

    @Test
    public void whenGivenId_shouldDeleteUser_ifFound(){
        User user = new User();
        user.setName("TestName");
        user.setId(1L);

        when(repository.findById(user.getId())).thenReturn(Optional.of(user));

        service.deleteUser(user.getId());
        verify(repository).deleteById(user.getId());
    }

    @Test(expected = RuntimeException.class)
    public void shouldThrowExceptionWhenUserDoesNotExist(){
        user.setId(89L);
        user.setName("TestName");

        given(repository.findById(anyLong())).willReturn(Optional.ofNullable(null));
        service.deleteUser(user.getId());
    }
}
