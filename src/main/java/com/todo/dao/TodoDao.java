package com.todo.dao;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate5.HibernateTemplate;
import org.springframework.stereotype.Component;

import com.todo.entities.Todo;

@Component
public class TodoDao {
	@Autowired
	private HibernateTemplate hibernateTemplate;
	
	
	
	public HibernateTemplate getHibernateTemplate() {
		return hibernateTemplate;
	}

	public void setHibernateTemplate(HibernateTemplate hibernateTemplate) {
		this.hibernateTemplate = hibernateTemplate;
	}

	@Transactional
	public int save(Todo todo) {
		Integer t=(Integer) hibernateTemplate.save(todo);
		return t;
	}
	
	public List<Todo> getAll(){
		List<Todo> list = this.hibernateTemplate.loadAll(Todo.class);
		
		return list;
	}
}
