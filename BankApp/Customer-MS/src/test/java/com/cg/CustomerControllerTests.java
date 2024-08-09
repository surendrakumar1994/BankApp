package com.cg;

import com.cg.controller.CustomerController;
import com.cg.dao.EducationLoanDao;
import com.cg.dao.HomeLoanDao;
import com.cg.dao.PersonalLoanDao;
import com.cg.serviceImpl.EducationServiceImpl;
import com.cg.serviceImpl.HomeServiceImpl;
import com.cg.serviceImpl.PersonalServiceImpl;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;

@WebMvcTest(CustomerController.class)
public class CustomerControllerTests {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private EducationServiceImpl educationLoanService;

    @MockBean
    private HomeServiceImpl homeLoanService;

    @MockBean
    private PersonalServiceImpl personalLoanService;

    @Autowired
    private ObjectMapper objectMapper;

    @BeforeEach
    public void setup() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    public void testApplyEducationLoanSuccess() throws Exception {
        EducationLoanDao eduLoanRequest = new EducationLoanDao();
        when(educationLoanService.applyEducationLoan(any(EducationLoanDao.class)))
                .thenReturn(eduLoanRequest);

        mockMvc.perform(post("/loan/education")
                .contentType(MediaType.APPLICATION_JSON)
                .content(objectMapper.writeValueAsString(eduLoanRequest)))
                .andExpect(status().isOk())
                .andExpect(content().string("customer education loan saved successfully"));
    }

    @Test
    public void testApplyEducationLoanFailure() throws Exception {
        when(educationLoanService.applyEducationLoan(any(EducationLoanDao.class)))
                .thenReturn(null);

        mockMvc.perform(post("/loan/education")
                .contentType(MediaType.APPLICATION_JSON)
                .content(objectMapper.writeValueAsString(new EducationLoanDao())))
                .andExpect(status().isNotAcceptable())
                .andExpect(content().string("customer education loan failed to save"));
    }

    @Test
    public void testApplyEducationLoanException() throws Exception {
        when(educationLoanService.applyEducationLoan(any(EducationLoanDao.class)))
                .thenThrow(new RuntimeException("Database error"));

        mockMvc.perform(post("/loan/education")
                .contentType(MediaType.APPLICATION_JSON)
                .content(objectMapper.writeValueAsString(new EducationLoanDao())))
                .andExpect(status().isNotAcceptable())
                .andExpect(content().string("Database error"));
    }

    @Test
    public void testApplyHomeLoanSuccess() throws Exception {
        HomeLoanDao homeLoanRequest = new HomeLoanDao();
        when(homeLoanService.applyHomeLoan(any(HomeLoanDao.class)))
                .thenReturn(homeLoanRequest);

        mockMvc.perform(post("/loan/home")
                .contentType(MediaType.APPLICATION_JSON)
                .content(objectMapper.writeValueAsString(homeLoanRequest)))
                .andExpect(status().isOk())
                .andExpect(content().string("customer home loan saved successfully"));
    }

    @Test
    public void testApplyHomeLoanFailure() throws Exception {
        when(homeLoanService.applyHomeLoan(any(HomeLoanDao.class)))
                .thenReturn(null);

        mockMvc.perform(post("/loan/home")
                .contentType(MediaType.APPLICATION_JSON)
                .content(objectMapper.writeValueAsString(new HomeLoanDao())))
                .andExpect(status().isNotAcceptable())
                .andExpect(content().string("customer home loan failed to save"));
    }

    @Test
    public void testApplyHomeLoanException() throws Exception {
        when(homeLoanService.applyHomeLoan(any(HomeLoanDao.class)))
                .thenThrow(new RuntimeException("Database error"));

        mockMvc.perform(post("/loan/home")
                .contentType(MediaType.APPLICATION_JSON)
                .content(objectMapper.writeValueAsString(new HomeLoanDao())))
                .andExpect(status().isNotAcceptable())
                .andExpect(content().string("Database error"));
    }

    @Test
    public void testApplyPersonalLoanSuccess() throws Exception {
        PersonalLoanDao personalLoanRequest = new PersonalLoanDao();
        when(personalLoanService.applyPersonalLoan(any(PersonalLoanDao.class)))
                .thenReturn(personalLoanRequest);

        mockMvc.perform(post("/loan/personal")
                .contentType(MediaType.APPLICATION_JSON)
                .content(objectMapper.writeValueAsString(personalLoanRequest)))
                .andExpect(status().isOk())
                .andExpect(content().string("customer personal loan saved successfully"));
    }

    @Test
    public void testApplyPersonalLoanFailure() throws Exception {
        when(personalLoanService.applyPersonalLoan(any(PersonalLoanDao.class)))
                .thenReturn(null);

        mockMvc.perform(post("/loan/personal")
                .contentType(MediaType.APPLICATION_JSON)
                .content(objectMapper.writeValueAsString(new PersonalLoanDao())))
                .andExpect(status().isNotAcceptable())
                .andExpect(content().string("customer personal loan failed to save"));
    }

    @Test
    public void testApplyPersonalLoanException() throws Exception {
        when(personalLoanService.applyPersonalLoan(any(PersonalLoanDao.class)))
                .thenThrow(new RuntimeException("Database error"));

        mockMvc.perform(post("/loan/personal")
                .contentType(MediaType.APPLICATION_JSON)
                .content(objectMapper.writeValueAsString(new PersonalLoanDao())))
                .andExpect(status().isNotAcceptable())
                .andExpect(content().string("Database error"));
    }
}
