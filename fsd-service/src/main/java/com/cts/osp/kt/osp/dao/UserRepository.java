package com.cts.osp.kt.osp.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.cts.osp.kt.osp.entity.AppUser;


@Repository
public interface UserRepository extends  JpaRepository<AppUser, Long> {

	AppUser findByUsername(String userName);
 
}
