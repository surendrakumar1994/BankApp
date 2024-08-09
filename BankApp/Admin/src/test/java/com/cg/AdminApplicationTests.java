package com.cg;

import com.cg.controller.AdminController;
import com.cg.dao.Cibil;
import com.cg.dao.PaymentHistory;
import com.cg.entity.Customer;
import com.cg.repo.CustomerRepository;

import org.h2.command.dml.MergeUsing.When;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.mockito.stubbing.OngoingStubbing;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.web.client.RestTemplate;

import java.util.*;
import java.util.stream.Collectors;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;

@WebMvcTest(AdminController.class)
public class AdminApplicationTests {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private RestTemplate restTemplate;

    @MockBean
    private CustomerRepository customerRepository;

    @BeforeEach
    public void setup() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    public void testApproveLoan() throws Exception {
        // Create mock objects
        Cibil mockCibil = new Cibil();
        mockCibil.setLow(false);

        PaymentHistory mockPaymentHistory = new PaymentHistory(null, false);
        mockPaymentHistory.setPending(true);

        // Mock RestTemplate calls
   //     when(restTemplate.getForObject(anyString(), any())).thenReturn(mockCibil).thenReturn(mockPaymentHistory);

        // Mock repository behavior
  //      when(customerRepository.saveByPanId(anyString(), anyBoolean())).thenReturn(new Customer());

        // Perform the POST request and verify the response
        mockMvc.perform(post("/admin/approveAndReject")
                .contentType(MediaType.APPLICATION_JSON)
                .content("{\"pan\":\"1234567890\"}"))
                .andExpect(status().isAccepted())
                .andExpect(jsonPath("$").value("loan approved"));
    }

    @Test
    public void testPasswordReset() throws Exception {
        // Mock repository behavior
     //   When(customerRepository.saveCustomerByPassword(anyString(), anyString())).thenReturn(new Customer());

        // Perform the POST request and verify the response
        mockMvc.perform(post("/admin/passwordReset")
                .contentType(MediaType.APPLICATION_JSON)
                .content("{\"panId\":\"1234567890\",\"password\":\"newpassword\"}"))
                .andExpect(status().isAccepted())
                .andExpect(jsonPath("$").value("passwordReset approved"));
    }

    private OngoingStubbing<Object> when(Object saveCustomerByPassword) {
		// TODO Auto-generated method stub
		return null;
	}

	@Test
    public void testRequestApproval() throws Exception {
        // Mock repository behavior
     //   when(customerRepository.saveLoanFlagByTrue(anyString(), anyString())).thenReturn(new Customer());

        // Perform the POST request and verify the response
        mockMvc.perform(post("/admin/requestApproval")
                .contentType(MediaType.APPLICATION_JSON)
                .content("{\"panId\":\"1234567890\",\"loanFlag\":\"true\"}"))
                .andExpect(status().isAccepted())
                .andExpect(jsonPath("$").value("requestAprroval completed"));
    }

    @Test
    public void testPendingLoans() throws Exception {
        // Create mock list of PaymentHistory
        List<PaymentHistory> mockPaymentHistories = Arrays.asList(
                new PaymentHistory(null, false) {{ setPending(true); }},
                new PaymentHistory(null, false) {{ setPending(false); }},
                new PaymentHistory(null, false) {{ setPending(false); }}
        );

        // Mock RestTemplate call
  //(restTemplate.getForObject(anyString(), any())).thenReturn(mockPaymentHistories);

        // Perform the POST request and verify the response
        mockMvc.perform(post("/admin/pendingLoans")
                .contentType(MediaType.APPLICATION_JSON)
                .content("{\"panId\":\"1234567890\"}"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$").value(2L));
    }

    @Test
    public void testListLoans() throws Exception {
        // Create mock list of PaymentHistory
        List<PaymentHistory> mockPaymentHistories = Arrays.asList(
                new PaymentHistory(null, false) {{ setPending(true); }},
                new PaymentHistory(null, false) {{ setPending(false); }}
        );

        // Mock RestTemplate call
   //     when(restTemplate.getForObject(anyString(), any())).thenReturn(mockPaymentHistories);

        // Perform the POST request and verify the response
        mockMvc.perform(post("/admin/listLoans")
                .contentType(MediaType.APPLICATION_JSON)
                .content("{\"panId\":\"1234567890\"}"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$[0].pending").value(true))
                .andExpect(jsonPath("$[1].pending").value(false));
    }
}
