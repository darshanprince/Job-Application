package com.darshan.SpringBootRest.controller;

import com.darshan.SpringBootRest.model.JobPost;
import com.darshan.SpringBootRest.model.User;
import com.darshan.SpringBootRest.service.JobService;
import com.darshan.SpringBootRest.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(origins = "http://localhost:3000")
public class JobController
{
    @Autowired
    private JobService service;

    @GetMapping(path ="jobPosts", produces = {"application/json"})
    public List<JobPost> getAllJobs()
    {
        return service.getAllJobs();
    }

    @GetMapping("jobPost/{postId}")
    public JobPost getJob(@PathVariable("postId") int postId)
    {
        return service.getJob(postId);
    }

    @PostMapping(path= "jobPost", consumes = {"application/json"})
    public JobPost addPost(@RequestBody JobPost jobPost)
    {
        service.addJob(jobPost);
        return service.getJob(jobPost.getPostId());
    }

    @PutMapping("jobPost")
    public JobPost updateJob(@RequestBody JobPost jobPost)
    {
        service.updateJob(jobPost);
        return service.getJob(jobPost.getPostId());
    }

    @DeleteMapping("jobPost/{postId}")
    public String deleteJob(@PathVariable int postId)
    {
        service.deleteJob(postId);
        return "Deleted";
    }

    @GetMapping("load")
    public String load()
    {
        service.load();
        return "success";
    }

    @GetMapping("jobPosts/keyword/{keyword}")
    public List<JobPost> searchByKeyword(@PathVariable("keyword") String keyword)
    {
       return service.search(keyword);
    }
}
