package com.cu.back.train.repository.web;

import org.springframework.data.jpa.repository.JpaRepository;

import com.cu.back.train.entity.web.Test;

public interface TestRepository extends JpaRepository<Test, Integer> {

}
