package dev.patika.customerservice.service;

import dev.patika.customerservice.model.Customer;
import dev.patika.customerservice.model.CustomerDTO;
import dev.patika.customerservice.repository.CustomerRepository;
import dev.patika.customerservice.utility.exceptions.CustomerAlreadyExistsException;
import dev.patika.customerservice.utility.exceptions.NotFoundCustomerException;

import dev.patika.customerservice.utility.exceptions.WrongFormatException;
import dev.patika.customerservice.utility.mappers.CustomerMapper;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
@Slf4j
public class CustomerService {
    private final CustomerRepository repository;
    private final CustomerMapper mapper;


    public List<Customer> getAll() {
        return this.repository.findAll();
    }

    public Optional<Customer> getCustomerById(long customerId) {
       if (this.repository.existsAllById(customerId))
       {
           log.info("Customer found with "+customerId+ "customer id");
           return Optional.of(this.repository.findAllById(customerId));
       }else{
           log.warn("Customer not found with id :"+customerId);
           throw new NotFoundCustomerException("Customer not found with id "+customerId+ '!');
       }
    }
    public Optional<Customer> getCustomerBySsid(String ssid)  {
        if(this.repository.existsAllBySsid(ssid)){
            log.info("customer found with ssid : "+ssid);
            return Optional.of(repository.findAllBySsid(ssid));
        }else{
            log.warn("Customer not found with ssid "+ssid);
            throw new NotFoundCustomerException("Customer with SSID(" + ssid + ") not found!");
        }
    }
    public Optional<Customer> getCustomerByPhoneNo(String phoneNo)  {
        if (this.repository.existsAllByPhoneNo(phoneNo))
        {
            log.info("Customer found with "+phoneNo+ "customer Phone Number");
            return Optional.of(this.repository.findAllByPhoneNo(phoneNo));
        }else{
            log.warn("Customer not found with Phone Number :"+phoneNo);
            throw new NotFoundCustomerException("Customer not found with Phone Number"+phoneNo+ '!');
        }

    }

    public Optional<Customer> save(CustomerDTO customerDTO) {
        if (this.repository.existsAllBySsid(customerDTO.getSsid()))
            throw new CustomerAlreadyExistsException("Customer already exist with ssid "+customerDTO.getSsid());

        if (customerDTO.getSsid().charAt(customerDTO.getSsid().length()-1) % 2 == 1)
            throw new WrongFormatException("Last digit can not be odd number");

        if(this.repository.existsAllByPhoneNo(customerDTO.getPhoneNo()))
            throw new CustomerAlreadyExistsException("Customer already exist with phone no" + customerDTO.getPhoneNo());

        if(this.repository.existsAllByEmail(customerDTO.getEmail()))
            throw new CustomerAlreadyExistsException("Customer already exist with email " + customerDTO.getEmail());

        Customer customer=this.mapper.mapFromCustomerDTOtoCustomer(customerDTO);
            return Optional.of(this.repository.save(customer));
    }

    public Optional<Customer> updateById(long customerId, CustomerDTO customerDTO) {
        if (this.repository.existsById(customerId)){
            Customer customer = mapper.mapFromCustomerDTOtoCustomer(customerDTO);
            return Optional.of(this.repository.save(customer));
        }else{
            throw new NotFoundCustomerException("Customer not found with id "+customerId);
        }
    }

    public void deleteById(long customerId) {
       Customer customer=this.repository.findAllById(customerId);
       this.repository.delete(customer);
    }
}
