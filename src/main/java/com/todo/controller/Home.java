package com.todo.controller;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.todo.dao.TodoDao;
import com.todo.entities.Todo;

@Controller
public class Home {
	
	@Autowired
	private TodoDao todoDao;
	
	@RequestMapping("/home")
	public String home(Model model) {
		
		List<Todo> list=this.todoDao.getAll();
		model.addAttribute("todos",list);
		model.addAttribute("page", "home");
		return "index";
	}
	
	@RequestMapping("/add")
	public String addTodo(Model model) {
		model.addAttribute("page","add");
		
		return "index";
	}
	
	@RequestMapping(value = "/saveTodo",method = RequestMethod.POST)
	public String saveTodo(@ModelAttribute("todo") Todo t,Model m) {
		m.addAttribute("page","home");
		t.setDate(new Date());
		this.todoDao.save(t);
		
		return "index";
	}
}
