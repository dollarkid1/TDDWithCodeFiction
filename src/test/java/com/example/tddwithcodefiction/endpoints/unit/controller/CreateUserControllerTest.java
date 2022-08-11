package com.example.tddwithcodefiction.endpoints.unit.controller;

import com.example.tddwithcodefiction.endpoints.unit.data.User;
import com.example.tddwithcodefiction.endpoints.unit.service.CreateUserService;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultMatcher;

import static org.hamcrest.Matchers.*;
import static org.hamcrest.collection.IsCollectionWithSize.hasSize;
import static org.mockito.BDDMockito.given;
import static org.mockito.Mockito.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;


@RunWith(MockitoJUnitRunner.class)
@WebMvcTest(CreateUserController.class)

class CreateUserControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private CreateUserService service;


    @Test
    void createNewUser_whenPostUser() throws Exception {
        User user = new User();
        user.setName("Test Name");

        given(service.createNewUser(user)).willReturn(user);

        mockMvc.perform(post("/users")
                        .contentType(MediaType.APPLICATION_JSON).content(JsonUtil.toJson(user)))
                .andExpect(status().isCreated())
                .andExpect(jsonPath("$.name", is(user.getName())));
    }




}




























