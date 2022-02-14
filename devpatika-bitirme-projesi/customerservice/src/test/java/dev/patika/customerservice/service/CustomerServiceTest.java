package dev.patika.customerservice.service;

import dev.patika.customerservice.model.Customer;
import dev.patika.customerservice.model.CustomerDTO;
import dev.patika.customerservice.repository.CustomerRepository;
import dev.patika.customerservice.utility.mappers.CustomerMapper;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Collections;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class CustomerServiceTest {
    @Mock
    CustomerRepository repository;

    @Mock
    CustomerMapper mapper;

    @InjectMocks
    CustomerService customerService;

    @AfterEach
    public void tearDown(){repository.deleteAll();}
    @Test
    void getAll() {
        Customer customer = new Customer();
        customer.setSsid("212844002154");
        when(repository.findAll()).thenReturn(Collections.singletonList(customer));

        List<Customer> expected = customerService.getAll();

        assertEquals(expected.get(0).getSsid(), "212844002154");
    }

    @Test
    void save() {
        Customer expected = new Customer();
        expected.setSsid("212844002154");
        when(this.repository.existsAllBySsid(any())).thenReturn(Boolean.TRUE);
        when(this.repository.save(any())).thenReturn(expected);

        CustomerDTO customer = new CustomerDTO();
        Customer actual =this.customerService.save(customer).get();

        assertAll(
                () -> assertNotNull(actual),
                () -> assertEquals(expected, actual),
                () -> assertEquals(expected.getSsid(), actual.getSsid())
        );
    }

}
