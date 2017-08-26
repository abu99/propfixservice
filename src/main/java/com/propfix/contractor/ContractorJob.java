/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.propfix.contractor;

import java.io.Serializable;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import com.propfix.jobtype.JobType;

/**
 *
 * @author Y3850910
 */
@Entity
public class ContractorJob implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "job_id")
    private Integer jobId;
    @Column(name = "description")
    private String description;
    @JoinColumn(name = "contractor_id", referencedColumnName = "contractor_id")
    @ManyToOne(optional = false)
    private Contractor contractorId;
    @JoinColumn(name = "job_type_id", referencedColumnName = "job_type_id")
    @ManyToOne(optional = false)
    private JobType jobType;

    public ContractorJob() {
    }

    public ContractorJob(Integer jobId, Contractor contractor, JobType jobType) {
        this.jobId = jobId;
        this.contractorId = contractor;
        this.jobType = jobType;
    }

    public Integer getJobId() {
        return jobId;
    }

    public void setJobId(Integer jobId) {
        this.jobId = jobId;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Contractor getContractorId() {
        return contractorId;
    }

    public void setContractorId(Contractor contractorId) {
        this.contractorId = contractorId;
    }

    public JobType getJobType() {
		return jobType;
	}
    
    public void setJobType(JobType jobType) {
		this.jobType = jobType;
	}
}
