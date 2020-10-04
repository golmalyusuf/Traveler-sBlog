package com.yusuf.travel.dto;

import java.util.ArrayList;
import java.util.List;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import com.yusuf.travel.model.Locations;
import com.yusuf.travel.model.Privacy;
import com.yusuf.travel.model.User;

public class PostStatusDto {
	private long id;
	
	@NotNull @NotBlank
	private String status;
	
	@NotNull @NotBlank
	private String usermail;
	
	@NotNull @NotBlank
	private Long locationPointId;

	@NotNull @NotBlank
	private long privacyTypeId;
	
	private List<String> locationList;

	private String locationPointName;
	
	private String privacyString;
	
	
	public PostStatusDto() {
		super();
	}

	public PostStatusDto(String status, String usermail, Long locationPointId, long privacyTypeId, List<String> locationList) {
		super();
		this.status = status;
		this.usermail = usermail;
		this.locationPointId = locationPointId;
		this.privacyTypeId = privacyTypeId;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getUsermail() {
		return usermail;
	}

	public void setUsermail(String usermail) {
		this.usermail = usermail;
	}

	public Long getLocationPointId() {
		return locationPointId;
	}

	public void setLocationPointId(Long locationPointId) {
		this.locationPointId = locationPointId;
	}

	public long getPrivacyTypeId() {
		return privacyTypeId;
	}

	public void setPrivacyTypeId(long privacyTypeId) {
		this.privacyTypeId = privacyTypeId;
	}

	public List<String> getLocationList() {
		return locationList;
	}

	public void setLocationList(List<String> list) {
		this.locationList = list;
	}

	public String getLocationPointName() {
		return locationPointName;
	}

	public void setLocationPointName(String locationPointName) {
		this.locationPointName = locationPointName;
	}

	public String getPrivacyString() {
		return privacyString;
	}

	public void setPrivacyString(String privacyString) {
		this.privacyString = privacyString;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

}
