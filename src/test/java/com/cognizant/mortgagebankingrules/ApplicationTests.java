package com.cognizant.mortgagebankingrules;

import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;

import com.cognizant.mortgagebankingrules.domain.services.RuleClassService;
import com.cognizant.mortgagebankingrules.domain.services.RuleDomainService;
import com.cognizant.mortgagebankingrules.domain.services.RuleService;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
class ApplicationTests {


}
