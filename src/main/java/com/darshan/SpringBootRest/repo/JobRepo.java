package com.darshan.SpringBootRest.repo;


import com.darshan.SpringBootRest.model.JobPost;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public interface JobRepo extends JpaRepository<JobPost, Integer>
{

    List<JobPost> findByPostProfileContainsOrPostDescContains(String postProfile, String postDesc);

}
//public List<JobPost> getAllJobs()
//{
//    return jobs;
//}
//
//public void addJob(JobPost job)
//{
//    jobs.add(job);
//}
//
//public JobPost getJob(int postId)
//{
//    for(JobPost job: jobs)
//    {
//        if(job.getPostId() ==postId)
//            return job;
//    }
//    return null;
//}
//
//public void updateJob(JobPost jobPost) {
//    for (JobPost jobPost1 : jobs) {
//        if (jobPost1.getPostId() == jobPost.getPostId()) {
//            jobPost1.setPostProfile(jobPost.getPostProfile());
//            jobPost1.setPostDesc(jobPost.getPostDesc());
//            jobPost1.setReqExperience(jobPost.getReqExperience());
//            jobPost1.setPostTechStack(jobPost.getPostTechStack());
//        }
//    }
//}
//
//public void deleteJob(int postId)
//{
//    for(JobPost jobPost: jobs)
//    {
//        if(jobPost.getPostId()==postId)
//            jobs.remove(jobPost);
//    }
//}