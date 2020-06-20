package com.telusko.springmvcboot;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.telusko.springmvcboot.model.Alien;

@Controller
public class HomeController {

	@Autowired
	AlienRepo repo;
	
	@ModelAttribute
	public void modelData(Model m) {
	
		m.addAttribute("name","Aliens");
	}
	
	@RequestMapping("/")
	public String home() {
		
		return "index";
	}
	@RequestMapping("add")
	public String add(@RequestParam("num1")int i,@RequestParam("num2") int j, Model m) {
		
		int num3 = i+j;
		
		m.addAttribute("num3", num3);
		return "result";
	}
	@PostMapping(value="addAlien")
	public String addAlien(@ModelAttribute("a1") Alien a) {
		
		repo.save(a);
		return "result";
	}
	
	@GetMapping("getAliens")
	public String getAliens(Model m) {
		
		
		m.addAttribute("result", repo.findAll());
		return "showAliens";
	}
	@GetMapping("getAlien")
	public String getAlien(@RequestParam int aid, Model m) {
		m.addAttribute("result", repo.getOne(aid));
		return "showAliens";
	}
	@GetMapping("getAlienByName")
	public String getAlienByName(@RequestParam String aname, Model m) {
		m.addAttribute("result", repo.findByAname(aname));//when DSL used
		
		//m.addAttribute("result", repo.find(aname));
		
		return "showAliens";
	}
}
