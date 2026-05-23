package com.automaticaply.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.automaticaply.repository.ApplicationRepository;
import com.automaticaply.repository.JobRepository;
import com.automaticaply.service.JobService;

@Controller
public class PageController {

	@Autowired
	private JobService jobService;
	
	 @Autowired
	    private JobRepository jobRepository;

	    @Autowired
	    private ApplicationRepository applicationRepository;

	    @GetMapping("/")
	    public String dashboard(Model model) {

	        Long userId = 1L;

	        long totalJobs = jobRepository.count();

	        long appliedJobs =
	                applicationRepository
	                .findByUserId(userId)
	                .size();

	        long matchedJobs = totalJobs;

	        model.addAttribute("totalJobs", totalJobs);

	        model.addAttribute("appliedJobs", appliedJobs);

	        model.addAttribute("matchedJobs", matchedJobs);

	        return "index";
	    }
    
    @GetMapping("/jobs")
	public String jobs(Model model) {

	    model.addAttribute("jobs", jobService.getAllJobs());

	    return "jobs";
	}
    
    @GetMapping("/upload-resume")
    public String uploadPage() {

        return "upload-resume";
    }

    
    
    
//    @GetMapping("/applied-jobs")
//    public String appliedJobs() {
//
//        return "applied-jobs";
//    }
//    
//    @PostMapping("/apply-job")
//    public String applyJob(
//            @RequestParam Long jobId) {
//
//        System.out.println("Applied Job ID: " + jobId);
//
//        return "redirect:/jobs";
//    }
}