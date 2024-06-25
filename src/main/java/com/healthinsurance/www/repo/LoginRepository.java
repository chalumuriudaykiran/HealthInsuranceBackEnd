package com.healthinsurance.www.repo;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.healthinsurance.www.entity.LoginPage;

@Repository
public interface LoginRepository extends JpaRepository<LoginPage,String>
{

	 LoginPage findByUname(String uname);
	
	Optional<LoginPage> findByuname(String uname);

//	void save(Optional<LoginPage> login);


}
