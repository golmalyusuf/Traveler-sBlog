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

@Entity
@Table(name = "locations")
public class Locations {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long id;

	@Column(name = "location_name", nullable = false, unique = true)
	private String locationName;
	 
	@OneToMany(cascade = CascadeType.ALL, 
	        mappedBy = "locationPoint", orphanRemoval = true)
	private List<Post> postList = new ArrayList<Post>();
	 
	public Locations() {
	}

	public Locations(long id, String locationName) {
		super();
		this.id = id;
		this.locationName = locationName;
	}
	
	public Locations(long id, String locationName, List<Post> postList) {
		super();
		this.id = id;
		this.locationName = locationName;
		this.postList = postList;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getLocationName() {
		return locationName;
	}

	public void setLocationName(String locationName) {
		this.locationName = locationName;
	}

	public List<Post> getPostList() {
		return postList;
	}

	public void setPostList(List<Post> postList) {
		this.postList = postList;
	}

}
