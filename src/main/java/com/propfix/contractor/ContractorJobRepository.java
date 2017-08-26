package com.propfix.contractor;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RestResource;
import com.propfix.jobtype.JobType;

public interface ContractorJobRepository extends CrudRepository<ContractorJob, Integer>{

	@RestResource(rel = "search-by-job-type", path = "jobType")
	List<ContractorJob> getJobsByJobType(@Param("jobType") JobType faultId);
}
