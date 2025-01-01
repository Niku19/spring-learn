package com.learn.springboot.learnjpaandhibernate.course;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import com.learn.springboot.learnjpaandhibernate.course.jpa.CourseJpaRepository;
import com.learn.springboot.learnjpaandhibernate.course.springdatajpa.CourseSpringDataJpaRepository;

@Component
public class CourseCommandLineRunner implements CommandLineRunner{

	@Autowired
	private CourseSpringDataJpaRepository repository;
	
	@Override
	public void run(String... args) throws Exception {
		repository.save(new Course(1,"Learn AWS","Nikhil Pugalia"));
		repository.save(new Course(2,"Learn Azure","Nikhil Pugalia"));
		repository.save(new Course(3,"Learn GCP","Nikhil Pugalia"));
		repository.deleteById((long) 2);
		System.out.println(repository.findById((long) 1));
		System.out.println(repository.findById((long) 3));
		System.out.println(repository.findByName("Learn AWS"));
	}

}
