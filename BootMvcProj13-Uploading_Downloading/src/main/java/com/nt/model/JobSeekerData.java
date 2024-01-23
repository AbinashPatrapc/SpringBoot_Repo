package com.nt.model;

import java.io.Serializable;

import org.springframework.web.multipart.MultipartFile;

import lombok.Data;
@Data
public class JobSeekerData implements Serializable {

	private static final long serialVersionUID = 1L;
	private Integer jsId;
	private String jsName;
	private String jsAddrs;
	private MultipartFile resume;
	private MultipartFile photo;

}
