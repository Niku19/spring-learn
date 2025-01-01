package com.learn.springboot.learnjpaandhibernate.course.jdbc;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import com.learn.springboot.learnjpaandhibernate.course.Course;

@Component
public class CourseJdbcCommandLineRunner implements CommandLineRunner{

	@Autowired
	private CourseJdbcRepository repository;
	
	@Override
	public void run(String... args) throws Exception {
		repository.insert(new Course(1,"Learn AWS","Nikhil Pugalia"));
		repository.insert(new Course(2,"Learn Azure","Nikhil Pugalia"));
		repository.insert(new Course(3,"Learn GCP","Nikhil Pugalia"));
		repository.deleteById(2);
		System.out.println(repository.findById(1));
	}

}
