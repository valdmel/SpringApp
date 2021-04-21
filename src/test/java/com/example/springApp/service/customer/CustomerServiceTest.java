package com.example.springApp.service.customer;

import com.example.springApp.domain.Birthplace;
import com.example.springApp.domain.Customer;
import com.example.springApp.entity.BirthplaceEntity;
import com.example.springApp.entity.CustomerEntity;
import com.example.springApp.exception.CustomerNotFoundException;
import com.example.springApp.mapper.CustomerMapper;
import com.example.springApp.repository.CustomerRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.mapstruct.factory.Mappers;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Spy;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.boot.test.context.SpringBootTest;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Optional;
import static org.junit.Assert.*;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.when;

@SpringBootTest
@RunWith(MockitoJUnitRunner.class)
class CustomerServiceTest {

    @InjectMocks
    private CustomerServiceImpl customerService;

    @Mock
    private CustomerRepository customerRepository;

    @Spy
    private final CustomerMapper customerMapper = Mappers.getMapper(CustomerMapper.class);

    private Customer customer;
    private CustomerEntity customerEntity;
    private List<Customer> customers;
    private List<CustomerEntity> customersEntity;

    @BeforeEach
    public void init() {
        customerEntity = new CustomerEntity();
        customer = new Customer();

        customer.setId(1L);
        customer.setFirstName("First Name");
        customer.setLastName("Last Name");
        customer.setAge(18);
        customer.setBirthplace(new Birthplace("Country", "City"));
        customer.setGender("Undefined");
        customer.setNationality("Undefined");

        BirthplaceEntity birthplaceEntity = new BirthplaceEntity();

        birthplaceEntity.setCountry("Country");
        birthplaceEntity.setCity("City");

        customerEntity.setId(1L);
        customerEntity.setFirstName("First Name");
        customerEntity.setLastName("Last Name");
        customerEntity.setAge(18);
        customerEntity.setBirthplace(birthplaceEntity);
        customerEntity.setGender("Undefined");
        customerEntity.setNationality("Undefined");

        customers = new ArrayList<>(Collections.singletonList(customer));
        customersEntity = new ArrayList<>(Collections.singleton(customerEntity));
    }

    @Test
    public void shouldTryToCreateAnExistingCustomer() {
        when(customerRepository.findCustomerByFirstName(any())).thenReturn(Optional.of(customerEntity));
        when(customerMapper.mapCustomerEntityToCustomer(any())).thenReturn(customer);
        when(customerRepository.save(any())).thenReturn(customerEntity);

        Customer customerResult = customerService.createCustomer(customer);

        assertNotNull(customerResult);
        assertEquals(customer.getFirstName(), customerResult.getFirstName());
        assertEquals(customer.getLastName(), customerResult.getLastName());
        assertEquals(customer.getAge(), customerResult.getAge());
        assertEquals(customer.getBirthplace(), customerResult.getBirthplace());
        assertEquals(customer.getGender(), customerResult.getGender());
        assertEquals(customer.getNationality(), customerResult.getNationality());
    }

    @Test
    public void shouldCreateAnUnexistingCustomer() {
        when(customerRepository.findCustomerByFirstName(any())).thenReturn(Optional.empty());
        when(customerMapper.mapCustomerToCustomerEntity(any())).thenReturn(customerEntity);
        when(customerMapper.mapCustomerEntityToCustomer(any())).thenReturn(customer);
        when(customerRepository.save(any())).thenReturn(customerEntity);

        Customer customerResult = customerService.createCustomer(customer);

        assertNotNull(customerResult);
        assertEquals(customer.getFirstName(), customerResult.getFirstName());
        assertEquals(customer.getLastName(), customerResult.getLastName());
        assertEquals(customer.getAge(), customerResult.getAge());
        assertEquals(customer.getBirthplace(), customerResult.getBirthplace());
        assertEquals(customer.getGender(), customerResult.getGender());
        assertEquals(customer.getNationality(), customerResult.getNationality());
    }

    @Test
    public void shouldFindByIdAnExistingCustomer() {
        when(customerRepository.existsById(any())).thenReturn(true);
        when(customerMapper.mapCustomerEntityToCustomer(any())).thenReturn(customer);
        when(customerRepository.findById(any())).thenReturn(Optional.of(customerEntity));

        Customer customerResult = customerService.findCustomerById(1L);

        assertNotNull(customerResult);
        assertEquals(customer.getFirstName(), customerResult.getFirstName());
        assertEquals(customer.getLastName(), customerResult.getLastName());
        assertEquals(customer.getAge(), customerResult.getAge());
        assertEquals(customer.getBirthplace(), customerResult.getBirthplace());
        assertEquals(customer.getGender(), customerResult.getGender());
        assertEquals(customer.getNationality(), customerResult.getNationality());
    }

    @Test
    public void shouldTryToFindByIdAnUnexistingCustomerAndThrowAnException() {
        when(customerRepository.existsById(any())).thenReturn(false);

        Exception exception = assertThrows(CustomerNotFoundException.class, () -> customerService.findCustomerById(1L));

        assertEquals("Customer with id = " + customer.getId() + " was not found!", exception.getMessage());
    }

    @Test
    public void shouldFindAllExistingCustomers() {
        when(customerRepository.findAll()).thenReturn(customersEntity);
        when(customerMapper.mapCustomerEntitiesToCustomers(any())).thenReturn(customers);

        List<Customer> customersResult = customerService.findAllCustomers();

        assertTrue(customersResult.size() > 0);
    }

    @Test
    public void shouldTryToUpdateAnExistingCustomer() {
        when(customerRepository.findCustomerByFirstName(any())).thenReturn(Optional.of(customerEntity));
        when(customerMapper.mapCustomerToCustomerEntity(any())).thenReturn(customerEntity);
        when(customerMapper.mapCustomerEntityToCustomer(any())).thenReturn(customer);
        when(customerRepository.save(any())).thenReturn(customerEntity);

        Customer customerResult = customerService.updateCustomer(customer);

        assertNotNull(customerResult);
        assertEquals(customer.getFirstName(), customerResult.getFirstName());
        assertEquals(customer.getLastName(), customerResult.getLastName());
        assertEquals(customer.getAge(), customerResult.getAge());
        assertEquals(customer.getBirthplace(), customerResult.getBirthplace());
        assertEquals(customer.getGender(), customerResult.getGender());
        assertEquals(customer.getNationality(), customerResult.getNationality());
    }

    @Test
    public void shouldTryToUpdateANonExistingCustomerAndThrowAnException() {
        when(customerRepository.findCustomerByFirstName(any())).thenReturn(Optional.empty());

        Exception exception = assertThrows(CustomerNotFoundException.class, () -> customerService.updateCustomer(customer));

        assertEquals("Customer " + customer.getFirstName() + " " + customer.getLastName() + " does not exists!", exception.getMessage());
    }

    @Test
    public void shouldDeleteByIdAnExistingCustomer() {
        when(customerRepository.existsById(any())).thenReturn(true);
        doNothing().when(customerRepository).deleteById(any());
        when(customerRepository.findAll()).thenReturn(Collections.emptyList());
        when(customerMapper.mapCustomerEntitiesToCustomers(any())).thenReturn(Collections.emptyList());

        List<Customer> customersResult = customerService.deleteCustomerById(1L);

        assertNotNull(customersResult);
        assertTrue(customersResult.isEmpty());
    }

    @Test
    public void shouldTryToDeleteByIdAnUnexistingCustomerAndThrowAnException() {
        when(customerRepository.existsById(any())).thenReturn(false);

        Exception exception = assertThrows(CustomerNotFoundException.class, () -> customerService.deleteCustomerById(1L));

        assertEquals("Customer with id = " + customer.getId() + " was not found!", exception.getMessage());
    }

    @Test
    public void shouldDeleteAnExistingCustomer() {
        when(customerMapper.mapCustomerToCustomerEntity(any())).thenReturn(customerEntity);
        doNothing().when(customerRepository).delete(any());
        when(customerRepository.findAll()).thenReturn(Collections.emptyList());
        when(customerMapper.mapCustomerEntitiesToCustomers(any())).thenReturn(Collections.emptyList());

        List<Customer> customersResult = customerService.deleteCustomer(customer);

        assertNotNull(customersResult);
        assertTrue(customersResult.isEmpty());
    }
}