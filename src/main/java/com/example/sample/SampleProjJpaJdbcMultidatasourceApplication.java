package com.example.sample;

import java.util.UUID;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

import com.example.sample.dao.db1.OrangeDao;
import com.example.sample.dao.db2.AppleDao;
import com.example.sample.entity.db1.OrangeEntity;
import com.example.sample.entity.db2.AppleEntity;



@SpringBootApplication
public class SampleProjJpaJdbcMultidatasourceApplication {

	
	
	
	public static void main(String[] args) {
		SpringApplication.run(SampleProjJpaJdbcMultidatasourceApplication.class, args);
		
	
		
	}


	
	
	
	
	
	
}
