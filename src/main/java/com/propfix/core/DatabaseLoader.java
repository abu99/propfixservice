package com.propfix.core;

import java.util.Date;

import org.glassfish.hk2.api.ContractIndicator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

import com.propfix.contractor.Contractor;
import com.propfix.contractor.ContractorJob;
import com.propfix.contractor.ContractorJobRepository;
import com.propfix.contractor.ContractorRepository;
import com.propfix.faultlog.FaultLog;
import com.propfix.faultlog.FaultLogRepository;
import com.propfix.jobtype.JobType;
import com.propfix.jobtype.JobTypeRepository;
import com.propfix.tenant.Tenant;
import com.propfix.tenant.TenantRepository;
import com.propfix.user.User;
import com.propfix.user.UserRepository;


@Component
public class DatabaseLoader implements ApplicationRunner{
	private final UserRepository users;
	private final TenantRepository tenants;
	private final ContractorRepository contractors;
	private final JobTypeRepository jobTypes;
	private final ContractorJobRepository jobs;
	private final FaultLogRepository logs;
	
	@Autowired
	public DatabaseLoader(UserRepository users, TenantRepository tenants,
			ContractorRepository contractors, JobTypeRepository jobTypes,
			ContractorJobRepository jobs, FaultLogRepository logs) {
		this.users = users;
		this.tenants = tenants;
		this.contractors = contractors;
		this.jobTypes = jobTypes;
		this.jobs = jobs;
		this.logs = logs;
	}

	@Override
	public void run(ApplicationArguments arg0) throws Exception {
		String [] roles = {"TENANT", "CONTRACTOR"};
		User user1 = new User("user1","12345","TENANT", roles);
		users.save(user1);
		User user2 = new User("user2","12345", "CONTRACTOR", roles);
		users.save(user2);
		User user3 = new User("user3","12345","TENANT", roles);
		users.save(user3);
		User user4 = new User("user4","12345", "CONTRACTOR", roles);
		users.save(user4);
		Tenant tenant1 = new Tenant("user1","test1","test1", "M", "user1@gmail.com", "ABC");
		tenants.save(tenant1);
		Tenant tenant2 = new Tenant("user3","test3","test3", "M", "user3@gmail.com", "DEF");
		tenants.save(tenant2);
		Contractor contractor1 = new Contractor("user2","demo","demo","M", "user2@gmail.com");
		contractors.save(contractor1);
		Contractor contractor2 = new Contractor("user4","demo","demo","M", "user4@gmail.com");
		contractors.save(contractor2);
		JobType jobType1 = new JobType(1, "Electricity");
		JobType jobType2 = new JobType(2, "Water Works");
		jobTypes.save(jobType1);
		jobTypes.save(jobType2);
		ContractorJob contractor1Job = new ContractorJob(1, contractor1, jobType1);
		ContractorJob contractor2Job = new ContractorJob(2, contractor2, jobType2);
		jobs.save(contractor1Job);
		jobs.save(contractor2Job);
		FaultLog log1 = new FaultLog(1, tenant1.getTenantId(), "ABC", jobType1, "heater failure", new Date(), "PENDING");
		FaultLog log2 = new FaultLog(2, tenant2.getTenantId(), "DEF", jobType2,  "heater failure", new Date(), "PENDING");
		logs.save(log1);
		logs.save(log2);
		
	}

}
