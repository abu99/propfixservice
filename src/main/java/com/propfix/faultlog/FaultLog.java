/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.propfix.faultlog;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import com.propfix.jobtype.JobType;

/**
 *
 * @author Y3850910
 */
@Entity
public class FaultLog implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "fault_log_id")
    private Integer faultLogId;
    @Basic(optional = false)
    @Column(name = "tenant_id")
    private String tenantId;
    @Basic(optional = false)
    @Column(name = "property_id")
    private String propertyId;
    @Basic(optional = false)
    @Column(name = "fault_description")
    private String faultDescription;
    @Basic(optional = false)
    @Column(name = "date_created")
    @Temporal(TemporalType.DATE)
    private Date dateCreated;
    @Basic(optional = false)
    @Column(name = "status")
    private String status;
    @Column(name = "accepted_by")
    private String acceptedBy;
    @Column(name = "date_accepted")
    @Temporal(TemporalType.DATE)
    private Date dateAccepted;
    @Column(name = "contractor_comment")
    private String contractorComment;
    @Column(name = "aknowledgement_status")
    private Boolean aknowledgementStatus;
    @Column(name = "repair_feedback")
    private String repairFeedback;
    @JoinColumn(name = "job_type_id", referencedColumnName = "job_type_id")
    @ManyToOne(optional = false)
    private JobType jobType;

    public FaultLog() {
    }

    public FaultLog(Integer faultLogId) {
        this.faultLogId = faultLogId;
    }

    public FaultLog(Integer faultLogId, String tenantId, String propertyId, JobType jobtype, String faultDescription, Date dateCreated, String status) {
        this.faultLogId = faultLogId;
        this.tenantId = tenantId;
        this.propertyId = propertyId;
        this.faultDescription = faultDescription;
        this.dateCreated = dateCreated;
        this.status = status;
        this.jobType = jobtype;
    }

    public Integer getFaultLogId() {
        return faultLogId;
    }

    public void setFaultLogId(Integer faultLogId) {
        this.faultLogId = faultLogId;
    }

    public String getTenantId() {
        return tenantId;
    }

    public void setTenantId(String tenantId) {
        this.tenantId = tenantId;
    }

    public String getPropertyId() {
        return propertyId;
    }

    public void setPropertyId(String propertyId) {
        this.propertyId = propertyId;
    }

    public String getFaultDescription() {
        return faultDescription;
    }

    public void setFaultDescription(String faultDescription) {
        this.faultDescription = faultDescription;
    }

    public Date getDateCreated() {
        return dateCreated;
    }

    public void setDateCreated(Date dateCreated) {
        this.dateCreated = dateCreated;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getAcceptedBy() {
        return acceptedBy;
    }

    public void setAcceptedBy(String acceptedBy) {
        this.acceptedBy = acceptedBy;
    }

    public Date getDateAccepted() {
        return dateAccepted;
    }

    public void setDateAccepted(Date dateAccepted) {
        this.dateAccepted = dateAccepted;
    }

    public String getContractorComment() {
        return contractorComment;
    }

    public void setContractorComment(String contractorComment) {
        this.contractorComment = contractorComment;
    }

    public Boolean getAknowledgementStatus() {
        return aknowledgementStatus;
    }

    public void setAknowledgementStatus(Boolean aknowledgementStatus) {
        this.aknowledgementStatus = aknowledgementStatus;
    }

    public String getRepairFeedback() {
        return repairFeedback;
    }

    public void setRepairFeedback(String repairFeedback) {
        this.repairFeedback = repairFeedback;
    }

    public JobType getJobType() {
		return jobType;
	}
    
    public void setJobType(JobType jobType) {
		this.jobType = jobType;
	}

}
