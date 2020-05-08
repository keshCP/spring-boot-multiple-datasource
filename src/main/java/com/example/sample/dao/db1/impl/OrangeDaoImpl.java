package com.example.sample.dao.db1.impl;

import java.sql.PreparedStatement;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.example.sample.dao.db1.OrangeDao;
import com.example.sample.entity.db1.OrangeEntity;

@Repository
public class OrangeDaoImpl implements OrangeDao{

	@Autowired
	@Qualifier("DB1")
	private JdbcTemplate db1JT;

	
	
	@Override
	public OrangeEntity getOrangleEntityList(String name) {
		String q="SELECT * FROM ORANGE where name=? ";

        try {

            return (OrangeEntity) db1JT.queryForObject(q, new Object[]{name}, new BeanPropertyRowMapper(OrangeEntity.class));

        }catch (Exception e){

            return  null;
        }
	}



	@Override
	public int save(OrangeEntity orangeEntity) {
		try {
		
		String q="insert into ORANGE (id,name) values('"+orangeEntity.getId()+"','"+orangeEntity.getName()+"')";
		
		db1JT.execute(q);
		
		return 1;
		}catch (Exception e) {
			// TODO: handle exception
			return -1;
		}
	}
	
	
	
	

	
	
}
