package com.learn.rest.webservices.restfulwebservices.user;

import java.time.LocalDate;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.validation.constraints.Past;
import javax.validation.constraints.Size;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
public class User {
	@Id
	@GeneratedValue
	private Integer id;
	
	// @JsonProperty customizes json key name/ json property name
	@Size(min=2,message = "Name should have atleast 2 characters")
	//@JsonProperty("user_name")
	private String name;
	
	@Past(message = "Birthdate should be before the current date")
	private LocalDate birthDate;
	
	@OneToMany(mappedBy = "user")
	@JsonIgnore
	private List<Post> posts;
	
	protected User() {
		
	}
	
	public User(Integer id, String name, LocalDate birthDate) {
		this.id = id;
		this.name = name;
		this.birthDate = birthDate;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public LocalDate getBirthDate() {
		return birthDate;
	}

	public void setBirthDate(LocalDate birthDate) {
		this.birthDate = birthDate;
	}

	public List<Post> getPosts() {
		return posts;
	}

	public void setPosts(List<Post> posts) {
		this.posts = posts;
	}

	@Override
	public String toString() {
		return "User [id=" + id + ", name=" + name + ", birthDate=" + birthDate + "]";
	}
}
