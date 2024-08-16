package com.example.hello.employee;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.http.ProblemDetail;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@WebMvcTest(EmployeeController.class)
class EmployeeControllerSlicingTest {

    @Autowired
    private MockMvc mvc;

    @MockBean
    private EmployeeService employeeService;

    @Test
    @DisplayName("Employee not found")
    public void case01() throws Exception {
        // Arrange
        when(employeeService.getById(5)).thenThrow(new EmployeeNotFoundException("Mock not found"));
        // Act and Assert
        MvcResult mvcResult =this.mvc.perform(get("/employee/5").accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isNotFound()).andReturn();

        // Convert response to JSON object
        String response = mvcResult.getResponse().getContentAsString();
        ObjectMapper mapper = new ObjectMapper();
        ProblemDetail problemDetail = mapper.readValue(response, ProblemDetail.class);

        assertEquals("Mock not found", problemDetail.getDetail());
        assertEquals("/employee/5", problemDetail.getInstance().toString());
    }

}