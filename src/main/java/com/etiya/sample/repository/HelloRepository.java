package com.etiya.sample.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.etiya.sample.model.HelloEntity;

public interface HelloRepository extends JpaRepository<HelloEntity, Long> {

	public HelloEntity findByHelloText(String name);
}
