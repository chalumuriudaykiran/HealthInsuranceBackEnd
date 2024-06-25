package com.healthinsurance.www.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.healthinsurance.www.entity.RegisterationPage;

@Repository
public interface RegisterRepository extends JpaRepository<RegisterationPage, String>
{

	RegisterationPage findByEmail(String email);
	
	


}
