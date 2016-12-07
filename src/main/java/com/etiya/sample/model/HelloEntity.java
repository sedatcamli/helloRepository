package com.etiya.sample.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="HELLOENTITY")
public class HelloEntity {
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Long helloId;
	private String helloText;
	
	public Long getHelloId() {
		return helloId;
	}
	public void setHelloId(Long helloId) {
		this.helloId = helloId;
	}
	public String getHelloText() {
		return helloText;
	}
	public void setHelloText(String helloText) {
		this.helloText = helloText;
	}
	
	

}
