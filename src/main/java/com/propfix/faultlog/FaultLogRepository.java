package com.propfix.faultlog;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RestResource;

import com.propfix.jobtype.JobType;

public interface FaultLogRepository extends CrudRepository<FaultLog, Integer>{
	
	@RestResource(rel = "search-by-job-type", path = "jobType")
	List<FaultLog> getLogsByJobType(@Param("jobType") JobType jobType);
	
	@RestResource(rel = "search-by-status", path = "status")
	List<FaultLog> getLogsByStatus(@Param("status") String status);

}
