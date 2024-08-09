package com.cg;

import com.cg.controller.LoanValidationController;
import com.cg.entity.Cibil;
import com.cg.entity.PaymentHistory;
import com.cg.repository.LoanRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;

@WebMvcTest(LoanValidationController.class)
public class LoanApplicationTests {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private LoanRepository loanRepository;

    @BeforeEach
    public void setup() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    public void testGetCibil() throws Exception {
        // Mock the behavior of Cibil entity if necessary
        Cibil mockCibil = new Cibil();
        // Optionally set properties of mockCibil if needed

        mockMvc.perform(get("/validate/cibil/{pan}", "1234567890")
                .accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.propertyName").value(mockCibil.getPropertyName())); // Adjust according to the actual properties of Cibil
    }

    @Test
    public void testGetPaymentHistory() throws Exception {
        PaymentHistory mockPaymentHistory = new PaymentHistory();
        // Optionally set properties of mockPaymentHistory if needed

        when(loanRepository.findAllById(any())).thenReturn(Collections.singletonList(mockPaymentHistory));

        mockMvc.perform(get("/validate/payment/{pan}", "1234567890")
                .accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$[0].propertyName").value(mockPaymentHistory.getPropertyName())); // Adjust according to the actual properties of PaymentHistory
    }

    @Test
    public void testLoanDetails() throws Exception {
        PaymentHistory mockPaymentHistory = new PaymentHistory();
        // Optionally set properties of mockPaymentHistory if needed

        when(loanRepository.findAllById(any())).thenReturn(Collections.singletonList(mockPaymentHistory));

        mockMvc.perform(get("/validate/loanDetails/{pan}", "1234567890")
                .accept(MediaType.APPLICATION_JSON));
         //       .andExpect(status().isOk())
         //     .andExpect(jsonPath("$[0].propertyName").value(mockPaymentHistory.getPropertyName())); // Adjust according to the actual properties of PaymentHistory
    }
}
