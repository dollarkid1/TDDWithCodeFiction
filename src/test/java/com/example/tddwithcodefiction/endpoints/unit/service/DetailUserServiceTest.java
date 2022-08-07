package com.example.tddwithcodefiction.endpoints.unit.service;

import com.example.tddwithcodefiction.endpoints.unit.data.User;
import com.example.tddwithcodefiction.endpoints.unit.data.UserNotFoundException;
import com.example.tddwithcodefiction.endpoints.unit.data.UserRepository;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import java.util.Optional;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.mockito.ArgumentMatchers.anyLong;
import static org.mockito.BDDMockito.given;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
public class DetailUserServiceTest {

    @Mock
    private UserRepository repository;
    @InjectMocks
    DetailUserService service;

    @Test
    public void whenGivenID_shouldReturnUser_ifFound(){

        User user = new User();
        user.setId(89L);

        when(repository.findById(user.getId())).thenReturn(Optional.of(user));

        User expected = service.listUser(user.getId());

        assertThat(expected).isSameAs(user);
        verify(repository).findById(user.getId());
    }

    @Test(expected = UserNotFoundException.class)
    public void should_throw_exception_when_user_doesnt_exist(){
        User user = new User();
        user.setId(89L);
        user.setName("TestName");

        given(repository.findById(anyLong())).willReturn(Optional.ofNullable(null));
        service.listUser(user.getId());
    }
}
