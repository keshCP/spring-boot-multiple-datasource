package com.example.sample;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.sample.dao.db1.OrangeDao;
import com.example.sample.dao.db2.AppleDao;
import com.example.sample.entity.db2.AppleEntity;


@RestController
public class TestController {

  

    /////use jdbc template
	@Autowired
	private static OrangeDao orangeDao;
	
	////use jpa repository
	@Autowired
	private static AppleDao appleDao;
  
  

  @PostMapping("/apple/{name}")
  public String appleTest(@PathVariable("name") String name) {
    

	AppleEntity appleEntity=new AppleEntity();
	appleEntity.setName(name);
	System.out.print("AA:"+name);
    
    return appleDao.save(appleEntity).toString();
    
    
    
    
    
  }

}
