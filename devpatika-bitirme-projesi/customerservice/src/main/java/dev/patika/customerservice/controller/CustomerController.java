package dev.patika.customerservice.controller;

import dev.patika.customerservice.model.Customer;
import dev.patika.customerservice.model.CustomerDTO;
import dev.patika.customerservice.service.CustomerService;
import dev.patika.customerservice.utility.exceptions.NotFoundCustomerException;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import javax.ws.rs.PathParam;
import java.util.List;

@RestController
@RequestMapping("api/customers")
@RequiredArgsConstructor
public class CustomerController {
    private final CustomerService service;

    @GetMapping
    public List<Customer> getAllCustomer(){
        return this.service.getAll();
    }

    @GetMapping("/id/{customerId}")
    public ResponseEntity<Customer> getCustomerById(@PathVariable long customerId)  {
        return new ResponseEntity<>(this.service.getCustomerById(customerId).get(), HttpStatus.OK);
    }

    @GetMapping("/ssid/{customerSsid}")
    public ResponseEntity<Customer> getCustomerBySsid(@PathVariable String customerSsid)  {
        return  new ResponseEntity<>(this.service.getCustomerBySsid(customerSsid).get(),HttpStatus.OK);
    }

    @GetMapping("/phoneNo/{customerPhoneNo}")
    public ResponseEntity<Customer> getCustomerByPhoneNo(@PathVariable String customerPhoneNo)  {
        return new ResponseEntity<>(this.service.getCustomerByPhoneNo(customerPhoneNo).get(),HttpStatus.OK);
    }

    @PostMapping
    public Customer saveCustomer(@Valid @RequestBody CustomerDTO customerDTO){
        return this.service.save(customerDTO).get();
    }

    @PutMapping
    public Customer updateCustomer(@RequestParam long customerId,@Valid @RequestBody CustomerDTO customerDTO){
        return this.service.updateById(customerId,customerDTO).get();
    }
    @DeleteMapping
    public String deleteCustomer(@RequestParam long customerId){
        this.service.deleteById(customerId);
        return "Deleted customer with Id :" +customerId;
    }

}
