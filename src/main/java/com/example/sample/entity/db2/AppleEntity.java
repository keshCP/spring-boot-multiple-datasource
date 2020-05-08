package com.example.sample.entity.db2;

import java.util.UUID;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "APPLE")
public class AppleEntity {

	/**
	 * String id,associate with id in APPLE table.Max length = 50. Primary
	 */
	@Id
	private String id = UUID.randomUUID().toString();
	
	@Column(length=30)
	private String name;


	public String getId() {
		return id;
	}


	public void setId(String id) {
		this.id = id;
	}


	public String getName() {
		return name;
	}


	public void setName(String name) {
		this.name = name;
	}


	@Override
	public String toString() {
		return "AppleEntity [id=" + id + ", name=" + name + "]";
	}
	
	
	
	
	
}
