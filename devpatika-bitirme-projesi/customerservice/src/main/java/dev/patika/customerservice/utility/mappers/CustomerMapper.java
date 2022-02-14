package dev.patika.customerservice.utility.mappers;

import dev.patika.customerservice.model.Customer;
import dev.patika.customerservice.model.CustomerDTO;
import org.mapstruct.Mapper;

@Mapper
public interface CustomerMapper {
    Customer mapFromCustomerDTOtoCustomer(CustomerDTO customerDTO);
    CustomerDTO mapFromCustomerToCustomerDTO(Customer customer);
}
