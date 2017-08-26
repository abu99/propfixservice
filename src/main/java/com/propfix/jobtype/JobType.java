/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.propfix.jobtype;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.xml.bind.annotation.XmlTransient;

import com.propfix.contractor.ContractorJob;
import com.propfix.faultlog.FaultLog;

/**
 *
 * @author Y3850910
 */
@Entity
public class JobType implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "job_type_id")
    private Integer jobTypeId;
    @Basic(optional = false)
    @Column(name = "job_type")
    private String jobType;
    @Column(name = "description")
    private String description;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "jobType")
    private List<ContractorJob> contractorJobList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "jobType")
    private List<FaultLog> FaultLogList;

    public JobType() {
    }

    public JobType(Integer jobTypeId) {
        this.jobTypeId = jobTypeId;
    }

    public JobType(Integer jobTypeId, String jobType) {
        this.jobTypeId = jobTypeId;
        this.jobType = jobType;
    }

    public Integer getjobTypeId() {
        return jobTypeId;
    }

    public void setjobTypeId(Integer jobId) {
        this.jobTypeId = jobTypeId;
    }

    public String getjobType() {
        return jobType;
    }

    public void setjobType(String jobType) {
        this.jobType = jobType;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @XmlTransient
    public List<ContractorJob> getContractorJobList() {
        return contractorJobList;
    }

    public void setContractorJobList(List<ContractorJob> contractorJobList) {
        this.contractorJobList = contractorJobList;
    }

    @XmlTransient
    public List<FaultLog> getFaultLogList() {
        return FaultLogList;
    }

    public void setFaultLogList(List<FaultLog> FaultLogList) {
        this.FaultLogList = FaultLogList;
    }
    
}
