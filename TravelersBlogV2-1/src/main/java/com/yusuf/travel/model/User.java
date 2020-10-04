package com.yusuf.travel.model;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;

@Entity
@Table(name = "users")
public class User {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long id;

	@Column(name = "first_name", nullable = false)
	@NotBlank(message = "Frist Name is mandatory")
	private String firstName;

	@Column(name = "last_name", nullable = false)
	@NotBlank(message = "Last Name is mandatory")
	private String lastName;

	@Column(name = "email", nullable = false, unique = true)
	@NotBlank(message = "Email is mandatory")
	private String email;

	@Column(name = "password", nullable = false, unique = true)
	@NotBlank(message = "Password is mandatory")
	private String password;

	@Column(name = "roles", nullable = false)
	private String role;
	
	@OneToMany(cascade = CascadeType.ALL, 
	        mappedBy = "userpost", orphanRemoval = true)
	private List<Post> postList = new ArrayList<Post>();

	public User() { 
	}

	public User(String firstName, String lastName, String email, String password, String role) {
		this.firstName = firstName;
		this.lastName = lastName;
		this.email = email;
		this.password = password;
		this.role = role;
	}

	public User(long id, String firstName, String lastName, String email, String password, String role, List<Post> postList) {
		super();
		this.id = id;
		this.firstName = firstName;
		this.lastName = lastName;
		this.email = email;
		this.password = password;
		this.postList = postList;
		this.role = role;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public List<Post> getPostList() {
		return postList;
	}

	public void setPostList(List<Post> postList) {
		this.postList = postList;
	}

	public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
	}
}
