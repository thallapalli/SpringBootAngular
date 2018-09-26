package com.cts.osp.kt.osp.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cts.osp.kt.osp.dao.PolicyRepository;
import com.cts.osp.kt.osp.entity.Policy;
@Service
public class PolicyService {
	@Autowired
	
	PolicyRepository policyRepository; 
	
	public Policy save(Policy policy) {
		return policyRepository.save(policy);
	}

	public Policy update(Policy policy) {
		return policyRepository.save(policy);
	}

	public Policy findByname(String name) {
		return policyRepository.findByname(name);
	}
	public Iterable<Policy> findAll() {
		return policyRepository.findAll();
	}

	

}
