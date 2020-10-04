package com.yusuf.travel.model;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "privacy")
public class Privacy {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long id;

	@Column(name = "privacy_type", nullable = false, unique = true)
	private String privacyType;

	@OneToMany(cascade = CascadeType.ALL, 
	        mappedBy = "privacyType", orphanRemoval = true)
	private List<Post> postList = new ArrayList<Post>();
	
	public Privacy() {
	}

	public Privacy(long id, String privacyType) {
		super();
		this.id = id;
		this.privacyType = privacyType;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getPrivacyType() {
		return privacyType;
	}

	public void setPrivacyType(String privacyType) {
		this.privacyType = privacyType;
	}

	public List<Post> getPostList() {
		return postList;
	}

	public void setPostList(List<Post> postList) {
		this.postList = postList;
	}

}
