package com.cts.osp.kt.osp;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.cts.osp.kt.osp.entity.Policy;
import com.cts.osp.kt.osp.service.PolicyService;

@RunWith(SpringRunner.class)
@SpringBootTest
public class FsdServiceApplicationTests {

	@Test
	public void contextLoads() {
	}

	@Autowired
	PolicyService policyService;
	//Success scenario
	@Test
	public void testfindById() {
		Policy policy = policyService.findById(400L);
		Assert.assertEquals("wqeqwe2", policy.getDetails());
	}
	
	@Test
	public void testErrorfindById() {
		Policy policy = policyService.findById(400L);
		Assert.assertNotEquals("Negetive scenario", policy.getDetails());
	}
	@Test
	public void testupdate() {
		Policy policy=new Policy();
		policy.setId(401L);
		policy.setName("name401");
		
		Policy policy2 = policyService.update(policy);
		Assert.assertEquals("name401", policy2.getName());
	}
	
	@Test
	public void testErrorupdate() {
		Policy policy=new Policy();
		policy.setId(40155L);
		policy.setName("name401");
		
		Policy policy2 = policyService.update(policy);
		policy2.getName();
		
		Assert.assertNotEquals("name401", policy2.getName());
	}

}
