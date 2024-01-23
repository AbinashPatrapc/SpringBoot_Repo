package com.nt.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.nt.entity.JobSeekerInfo;
import com.nt.repository.IRepoJobSeekerInfo;
@Service
public class JobSeekerMgmtImpl implements IJobSeekerMgmtService {
    @Autowired
	private IRepoJobSeekerInfo repo;
	@Override
	public String registerJobSeeker(JobSeekerInfo info) {
		return "Job Seeker is Saved with "+repo.save(info).getJsId()+" id value";
	}
	@Override
	public List<JobSeekerInfo> fetchJobSeekerDetails() {
		List<JobSeekerInfo>list=repo.findAll();
		return list;
	}
	@Override
	public String fetchResumePathByJsId(Integer jsId) {
		return repo.getPhotoPathByjsId(jsId);
	}
	@Override
	public String fetchPhotoPathByJsId(Integer jsId) {
		return repo.getPhotoPathByjsId(jsId);
	}

}
