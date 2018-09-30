package com.cts.osp.kt.osp.dao;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.cts.osp.kt.osp.entity.Policy;


@Repository
public interface PolicyRepository extends  CrudRepository<Policy, Long> {

	Policy findByname(String name);
	Policy findById(Long id);
	

}
