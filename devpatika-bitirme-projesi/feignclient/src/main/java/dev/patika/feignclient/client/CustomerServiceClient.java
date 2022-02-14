package dev.patika.feignclient.client;

import dev.patika.feignclient.model.Customer;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;


@FeignClient(name = "CustomerServiceAPI",url = "http://localhost:8080")
public interface CustomerServiceClient {
    @RequestMapping(method = RequestMethod.GET,value = "/api/customers/ssid/{customerSsid}")
    ResponseEntity<Customer> getCustomerBySsid(@PathVariable String customerSsid);
}
