package com.example.sample.dao.db1;

import com.example.sample.entity.db1.OrangeEntity;

public interface OrangeDao {

	OrangeEntity getOrangleEntityList(String name);
	
	int save(OrangeEntity orangeEntity);
}
