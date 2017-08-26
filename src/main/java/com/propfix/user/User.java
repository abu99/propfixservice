/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.propfix.user;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToOne;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.propfix.contractor.Contractor;
import com.propfix.tenant.Tenant;


/**
 *
 * @author Y3850910
 */
@Entity
public class User implements Serializable {

    private static final long serialVersionUID = 1L;
    
    public static final PasswordEncoder PASSWORD_ENCODER = new BCryptPasswordEncoder();
    @Id
    @Basic(optional = false)
    @Column(name = "username")
    private String username;
    @Basic(optional = false)
    @Column(name = "password")
    @JsonIgnore
    private String password;
    @Basic(optional = false)
    @Column(name = "user_type")
    private String userType;
    @OneToOne(cascade = CascadeType.ALL, mappedBy = "user")
    private Contractor contractor;
    @OneToOne(cascade = CascadeType.ALL, mappedBy = "user")
    private Tenant tenant;
    @JsonIgnore
    private String[] roles;

    public User() {
    	super();
    }

    public User(String username) {
    	this();
        this.username = username;
    }

    public User(String username, String password, String userType, String[] roles) {
    	this();
        this.username = username;
        setPassword(password);
        this.userType = userType;
        this.roles = roles;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
		return password;
	}
    
    public void setPassword(String password) {
        this.password = PASSWORD_ENCODER.encode(password);
    }

    public String getUserType() {
        return userType;
    }

    public void setUserType(String userType) {
        this.userType = userType;
    }

    public Contractor getContractor() {
        return contractor;
    }

    public void setContractor(Contractor contractor) {
        this.contractor = contractor;
    }

    public Tenant getTenant() {
        return tenant;
    }

    public void setTenant(Tenant tenant) {
        this.tenant = tenant;
    }
    
    public String[] getRoles() {
		return roles;
	}
    
    public void setRoles(String[] roles) {
		this.roles = roles;
	}
    
    
}
