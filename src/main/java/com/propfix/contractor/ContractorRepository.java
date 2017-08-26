package com.propfix.contractor;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RestResource;

public interface ContractorRepository extends CrudRepository<Contractor, String>{
	
}
