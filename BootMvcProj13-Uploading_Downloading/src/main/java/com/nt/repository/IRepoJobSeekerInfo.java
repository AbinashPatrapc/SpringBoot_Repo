package com.nt.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.nt.entity.JobSeekerInfo;

public interface IRepoJobSeekerInfo extends JpaRepository<JobSeekerInfo, Integer>{

	@Query("SELECT resumePath FROM JobSeekerInfo WHERE jsId=:id")
	public String getResumePathByjsId(Integer id);
	@Query("SELECT photoPath FROM JobSeekerInfo WHERE jsId=:id")
	public String getPhotoPathByjsId(Integer id);
	
}
