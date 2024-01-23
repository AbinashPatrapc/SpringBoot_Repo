package com.nt.controller;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.List;
import java.util.Map;

import org.apache.commons.io.IOUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import com.nt.entity.JobSeekerInfo;
import com.nt.model.JobSeekerData;
import com.nt.service.IJobSeekerMgmtService;

import jakarta.servlet.ServletContext;
import jakarta.servlet.http.HttpServletResponse;

@Controller
public class JobSeekerOperationController {
	@Autowired
	private Environment env;

	@Autowired
	private IJobSeekerMgmtService service;

	@GetMapping("/")
	public String showHomePage() {
		return "welcome";
	}

	@GetMapping("/register")
	public String showRegisterForm(@ModelAttribute("js") JobSeekerData data) {
		return "registerForm";
	}

	@PostMapping("/register")
	public String registerJsByUploadingFiles(@ModelAttribute("js") JobSeekerData data, Map<String, Object> map)
			throws Exception {
		// get Upload folder location from properties file
		String storedLocation = env.getRequiredProperty("upload.store");
		
		// if folder is not available then create a folder
		File file = new File(storedLocation);
		if (!file.exists())
			file.mkdir();

		// getting input Streams which representing upload file content
		MultipartFile resumefile = data.getResume();
		MultipartFile photofile = data.getPhoto();

		InputStream resumeStream = resumefile.getInputStream();
		InputStream photoStream = photofile.getInputStream();

		// Getting the uploaded file name
		String resumeFilename = resumefile.getOriginalFilename();
		String photoFilename = photofile.getOriginalFilename();

		// Creating Output Streams representing empty destination file
		OutputStream osResume = new FileOutputStream(file.getAbsolutePath() + "\\" + resumeFilename);
		OutputStream osPhoto = new FileOutputStream(file.getAbsolutePath() + "\\" + photoFilename);

		// Copy input stream data to output stream destination
		IOUtils.copy(resumeStream, osResume);// (source,destination)
		IOUtils.copy(photoStream, osPhoto);

		// close all streams
		resumeStream.close();
		photoStream.close();
		osResume.close();
		osPhoto.close();

		// prepare entity class object by setting data from model class
		JobSeekerInfo info = new JobSeekerInfo();
		info.setJsName(data.getJsName());
		info.setJsAddrs(data.getJsAddrs());
		info.setResumePath(file.getAbsolutePath() + "\\" + resumeFilename);
		info.setPhotoPath(file.getAbsolutePath() + "\\" + photoFilename);

		String msg = service.registerJobSeeker(info);
		map.put("file1", resumeFilename);
		map.put("file2", photoFilename);
		map.put("resultMsg", msg);

		return "show_result";
	}

	@GetMapping("/list")
	public String showReport(Map<String, Object> map) {
		List<JobSeekerInfo> list = service.fetchJobSeekerDetails();
		System.out.println("Size is::" + list.size());
		map.put("jslist", list);
		return "downloadpage";
	}

	@Autowired
	private ServletContext sc;

	@GetMapping("/downloadpage")
	public String fileDownload(HttpServletResponse res, @RequestParam("jsId") Integer id,
			@RequestParam("type") String type) throws Exception {
		// get the path of the file to be downloaded
		String filepath = null;
		if (type.equalsIgnoreCase("resume"))
			filepath = service.fetchResumePathByJsId(id);
		else
			filepath = service.fetchPhotoPathByJsId(id);
		System.out.println("File path is::" + filepath);
		// Create file object representing file to be downloaded
		File file = new File(filepath);
		// get the length of the file and make it as the response content length
		res.setContentLengthLong(file.length());
		// get mime type of the file make it as the response content type
		String mimeType = sc.getMimeType(filepath);
		mimeType = mimeType == null ? "application/octet-stream" : mimeType;
		res.setContentType(mimeType);
		// create inputstream pointing to the file
		InputStream is = new FileInputStream(file);
		// create outpurstream pointing to response object
		OutputStream os = res.getOutputStream();
		// Instructing the browser to give file content as downlodable file
		res.setHeader("Content-Disposition", "attachment;filename=" + file.getName());
		// write file content to response object
		IOUtils.copy(is, os);
		is.close();
		os.close();
		return null;
	}
}
