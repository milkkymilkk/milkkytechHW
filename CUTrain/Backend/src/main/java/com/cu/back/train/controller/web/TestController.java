package com.cu.back.train.controller.web;

import com.cu.back.train.entity.web.Test;
import com.cu.back.train.model.web.TestSearchModel;
import com.cu.back.train.service.web.TestService;
import com.cu.back.train.utils.Response;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@RestController
@RequestMapping("/test")
public class TestController {

	@Autowired
	private TestService testService;

	@GetMapping("/search")
	public List<TestSearchModel> getSearch(@RequestParam String name, @RequestParam String lastname) throws Exception {
		return testService.getSearch(name, lastname);
	}

	@GetMapping("/searchDetail")
	public Test getSearchDetail(@RequestParam Integer id) throws Exception {
		return testService.searchDetail(id);
	}

	@PostMapping("/save")
	public Integer save(@RequestBody TestSearchModel model) throws Exception {
		return testService.save(model);
	}

	@PostMapping("/update")
	public Integer update(@RequestBody TestSearchModel model) throws Exception {
		return testService.update(model);
	}
	
	@GetMapping("/delete")
	public void delete(@RequestParam Integer id) throws Exception {
		testService.delete(id);
	}

}
