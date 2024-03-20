package com.gasutility.service;

import com.gasutility.model.ServiceRequest;

public interface ServiceRequestService {

	    ServiceRequest updateServiceRequest(Long id, ServiceRequest serviceRequest);
	    ServiceRequest getServiceRequest(Long id);
		ServiceRequest createServiceRequest(ServiceRequest serviceRequest);
}
