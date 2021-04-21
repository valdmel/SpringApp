package com.example.springApp.service.customer.facade;

import com.example.springApp.domain.Birthplace;
import com.example.springApp.domain.Customer;
import com.example.springApp.dto.CustomerDTO;
import com.example.springApp.mapper.CustomerMapper;
import com.example.springApp.service.customer.CustomerService;
import static org.junit.Assert.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.mapstruct.factory.Mappers;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import static org.mockito.Mockito.*;
import org.mockito.Spy;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.boot.test.context.SpringBootTest;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

@SpringBootTest
@RunWith(MockitoJUnitRunner.class)
class CustomerFacadeTest {

    @InjectMocks
    private CustomerFacade customerFacade;

    @Mock
    private CustomerService customerService;

    @Spy
    private final CustomerMapper customerMapper = Mappers.getMapper(CustomerMapper.class);

    private Customer customer;
    private CustomerDTO customerDTO;
    private List<Customer> customers;
    private List<CustomerDTO> customersDTO;

    @BeforeEach
    public void init() {
        customer = new Customer();
        customerDTO = new CustomerDTO();

        customer.setId(1L);
        customer.setFirstName("First Name");
        customer.setLastName("Last Name");
        customer.setAge(18);
        customer.setBirthplace(new Birthplace("Country", "City"));
        customer.setGender("Undefined");
        customer.setNationality("Undefined");

        customerDTO.setId(1L);
        customerDTO.setFirstName("First Name");
        customerDTO.setLastName("Last Name");
        customerDTO.setAge(18);
        customerDTO.setBirthplace(new Birthplace("Country", "City"));
        customerDTO.setGender("Undefined");
        customerDTO.setNationality("Undefined");

        customers = new ArrayList<>(Collections.singletonList(customer));
        customersDTO = new ArrayList<>(Collections.singletonList(customerDTO));
    }

    @Test
    public void shouldCreateAnExistingCustomer() {
        when(customerMapper.mapCustomerDTOToCustomer(any())).thenReturn(customer);
        when(customerService.createCustomer(any())).thenReturn(customer);
        when(customerMapper.mapCustomerToCustomerDTO(any())).thenReturn(customerDTO);

        CustomerDTO customerDTOResult = customerFacade.createCustomer(customerDTO);

        assertNotNull(customerDTOResult);
        assertEquals(customerDTO.getFirstName(), customerDTOResult.getFirstName());
        assertEquals(customerDTO.getLastName(), customerDTOResult.getLastName());
        assertEquals(customerDTO.getAge(), customerDTOResult.getAge());
        assertEquals(customerDTO.getBirthplace(), customerDTOResult.getBirthplace());
        assertEquals(customerDTO.getGender(), customerDTOResult.getGender());
        assertEquals(customerDTO.getNationality(), customerDTOResult.getNationality());
    }

    @Test
    public void shouldFindByIdAExistingCustomer() {
        when(customerMapper.mapCustomerToCustomerDTO(any())).thenReturn(customerDTO);
        when(customerService.findCustomerById(1L)).thenReturn(customer);

        CustomerDTO customerDTOResult = customerFacade.findCustomerById(1L);

        assertNotNull(customerDTOResult);
        assertEquals(customerDTO.getFirstName(), customerDTOResult.getFirstName());
        assertEquals(customerDTO.getLastName(), customerDTOResult.getLastName());
        assertEquals(customerDTO.getAge(), customerDTOResult.getAge());
        assertEquals(customerDTO.getBirthplace(), customerDTOResult.getBirthplace());
        assertEquals(customerDTO.getGender(), customerDTOResult.getGender());
        assertEquals(customerDTO.getNationality(), customerDTOResult.getNationality());
    }

    @Test
    public void shouldFindAllCustomers() {
        when(customerMapper.mapCustomersToCustomersDTO(any())).thenReturn(customersDTO);
        when(customerService.findAllCustomers()).thenReturn(customers);

        List<CustomerDTO> customersDTOResult = customerFacade.findAllCustomers();

        assertNotNull(customersDTOResult);
        assertTrue(customersDTOResult.size() > 0);
        assertEquals(customersDTO.get(0).getFirstName(), customersDTOResult.get(0).getFirstName());
        assertEquals(customersDTO.get(0).getLastName(), customersDTOResult.get(0).getLastName());
        assertEquals(customersDTO.get(0).getAge(), customersDTOResult.get(0).getAge());
        assertEquals(customersDTO.get(0).getBirthplace(), customersDTOResult.get(0).getBirthplace());
        assertEquals(customersDTO.get(0).getGender(), customersDTOResult.get(0).getGender());
        assertEquals(customersDTO.get(0).getNationality(), customersDTOResult.get(0).getNationality());
    }

    @Test
    public void shouldUpdateAnExistingCustomer() {
        when(customerMapper.mapCustomerDTOToCustomer(any())).thenReturn(customer);
        when(customerService.updateCustomer(any())).thenReturn(customer);
        when(customerMapper.mapCustomerToCustomerDTO(any())).thenReturn(customerDTO);

        CustomerDTO customerDTOResult = customerFacade.updateCustomer(customerDTO);

        assertNotNull(customerDTOResult);
        assertEquals(customerDTO.getFirstName(), customerDTOResult.getFirstName());
        assertEquals(customerDTO.getLastName(), customerDTOResult.getLastName());
        assertEquals(customerDTO.getAge(), customerDTOResult.getAge());
        assertEquals(customerDTO.getBirthplace(), customerDTOResult.getBirthplace());
        assertEquals(customerDTO.getGender(), customerDTOResult.getGender());
        assertEquals(customerDTO.getNationality(), customerDTOResult.getNationality());
    }

    @Test
    public void shouldDeleteByIdAnExistingCustomerAndTheCustomerListBecomeEmpty() {
        when(customerMapper.mapCustomersToCustomersDTO(any())).thenReturn(new ArrayList<>());
        when(customerService.deleteCustomerById(1L)).thenReturn(new ArrayList<>());

        List<CustomerDTO> customersDTOResult = customerFacade.deleteCustomerById(1L);

        assertNotNull(customersDTOResult);
        assertTrue(customersDTOResult.isEmpty());
    }

    @Test
    public void shouldDeleteAnExistingCustomerAndTheCustomerListBecomeEmpty() {
        when(customerMapper.mapCustomerDTOToCustomer(any())).thenReturn(customer);
        when(customerService.deleteCustomer(any())).thenReturn(new ArrayList<>());
        when(customerMapper.mapCustomersToCustomersDTO(any())).thenReturn(new ArrayList<>());

        List<CustomerDTO> customersDTOResult = customerFacade.deleteCustomer(customerDTO);

        assertNotNull(customersDTOResult);
        assertTrue(customersDTOResult.isEmpty());
    }
}