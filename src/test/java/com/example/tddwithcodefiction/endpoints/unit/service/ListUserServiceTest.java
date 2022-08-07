package com.example.tddwithcodefiction.endpoints.unit.service;

import com.example.tddwithcodefiction.endpoints.unit.data.User;
import com.example.tddwithcodefiction.endpoints.unit.data.UserRepository;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.BDDMockito.given;
import static org.mockito.Mockito.verify;

@RunWith(MockitoJUnitRunner.class)
public class ListUserServiceTest {

    @Mock
    private UserRepository repository;

    @InjectMocks
    private ListUserService service;

    @Test
    public void shouldReturnAllUsers(){
        List<User> users = new ArrayList<>();
        users.add(new User());

        given(repository.findAll()).willReturn(users);

        List<User> expected = service.listAllUsers();

        assertEquals(expected, users);
        verify(repository).findAll();
    }

}
