package com.etiya.sample.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.etiya.sample.model.HelloEntity;
import com.etiya.sample.model.HelloForm;
import com.etiya.sample.repository.HelloRepository;

@Controller
public class HelloController {

	@Autowired
	private HelloRepository helloRepository;
	
	@RequestMapping(value="/", method= RequestMethod.GET)
	public String mainPage(Model model){
		model.addAttribute("helloForm",new HelloForm());
		return "main";
	}
	
	@RequestMapping(value="/hello", method= RequestMethod.POST)
	public String helloPost(@ModelAttribute(value="helloForm") HelloForm helloForm,Model model){
		HelloEntity entity = new HelloEntity();
		entity.setHelloText(helloForm.getName());
		HelloEntity tmpEntity = helloRepository.save(entity);
		model.addAttribute("name", tmpEntity.getHelloText());
		return "hello";
	}
	
	@RequestMapping(value="/hello/{name}", method = RequestMethod.GET)
	public @ResponseBody HelloEntity entityFromDb(@PathVariable String name){
		
		HelloEntity tmpEntity = helloRepository.findByHelloText(name);
		return tmpEntity;
		
	}
	
	@RequestMapping(value="/hellos", method = RequestMethod.GET)
	public @ResponseBody List<HelloEntity> getEntities(){
		
		return helloRepository.findAll();
	}
	
	@RequestMapping(value="/hello/{name}", method = RequestMethod.DELETE)
	public void deleteEntity(@PathVariable String name){
		HelloEntity tmpEntity = helloRepository.findByHelloText(name);
		helloRepository.delete(tmpEntity);
	}
	
	
}
