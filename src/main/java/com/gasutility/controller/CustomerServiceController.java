package com.gasutility.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.gasutility.model.Customer;
import com.gasutility.model.ServiceRequest;
import com.gasutility.service.CustomerService;
import com.gasutility.service.ServiceRequestService;

@RestController
@RequestMapping("/api")
public class CustomerServiceController {

	@Autowired
	private CustomerService customerService;
	
	@Autowired
	private ServiceRequestService serviceRequestService;
	
	
	@PostMapping("/customers")
    public Customer createCustomer(@RequestBody Customer customer) {
        return customerService.createCustomer(customer);
    }

    @PostMapping("/servicerequests")
    public ServiceRequest createServiceRequest(@RequestBody ServiceRequest serviceRequest) {
        return serviceRequestService.createServiceRequest(serviceRequest);
    }

    @PutMapping("/servicerequests/{id}")
    public ServiceRequest updateServiceRequest(@PathVariable Long id, @RequestBody ServiceRequest serviceRequest) {
        return serviceRequestService.updateServiceRequest(id, serviceRequest);
    }

    @GetMapping("/servicerequests/{id}")
    public ServiceRequest getServiceRequest(@PathVariable Long id) {
        return serviceRequestService.getServiceRequest(id);
    }
}
