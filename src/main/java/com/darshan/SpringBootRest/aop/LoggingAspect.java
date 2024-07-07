package com.darshan.SpringBootRest.aop;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

@Component
@Aspect
public class LoggingAspect
{
    private static final Logger LOGGER = LoggerFactory.getLogger(LoggingAspect.class);

    @Before("execution(* com.darshan.SpringBootRest.service.JobService.getJob(..)) || execution(* com.darshan.SpringBootRest.service.JobService.getAllJobs(..))" )
    public void logMethodCall (JoinPoint jp)
    {
        LOGGER.info("Method Called " + jp.getSignature().getName());
    }

    @After("execution(* com.darshan.SpringBootRest.service.JobService.getJob(..)) || execution(* com.darshan.SpringBootRest.service.JobService.getAllJobs(..))" )
    public void logMethodExecute (JoinPoint jp)
    {
        LOGGER.info("Method Executedd " + jp.getSignature().getName());
    }

    @AfterThrowing("execution(* com.darshan.SpringBootRest.service.JobService.getJob(..)) || execution(* com.darshan.SpringBootRest.service.JobService.getAllJobs(..))" )
    public void logMethodCrash (JoinPoint jp)
    {
        LOGGER.info("Method has issue " + jp.getSignature().getName());
    }

    @AfterReturning("execution(* com.darshan.SpringBootRest.service.JobService.getJob(..)) || execution(* com.darshan.SpringBootRest.service.JobService.getAllJobs(..))" )
    public void logMethodSuccess (JoinPoint jp)
    {
        LOGGER.info("Method is Successfully executed " + jp.getSignature().getName());
    }

}
