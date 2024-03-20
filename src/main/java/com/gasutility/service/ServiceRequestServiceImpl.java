package com.gasutility.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gasutility.model.ServiceRequest;
import com.gasutility.repository.ServiceRequestRepository;

@Service
public class ServiceRequestServiceImpl implements ServiceRequestService{

	
	@Autowired 
	private ServiceRequestRepository serviceRequestRepository;
	
	@Override
	public ServiceRequest createServiceRequest(ServiceRequest serviceRequest) {
		serviceRequest.setStatus("Pending");
        return serviceRequestRepository.save(serviceRequest);
	}

	@Override
	public ServiceRequest updateServiceRequest(Long id, ServiceRequest serviceRequest) {
		 ServiceRequest existingRequest = getServiceRequest(id);
	        if (existingRequest != null) {
	            existingRequest.setType(serviceRequest.getType());
	            existingRequest.setDetails(serviceRequest.getDetails());
	            existingRequest.setStatus(serviceRequest.getStatus());
	            return serviceRequestRepository.save(existingRequest);
	        }
	        return null;
	}

	@Override
	public ServiceRequest getServiceRequest(Long id) {
		return serviceRequestRepository.findById(id).orElse(null);
	}

	
}
