package com.healthinsurance.www.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.healthinsurance.www.entity.PaymentPage;

//@Repository
//@EnableJpaRepositories
//public interface PaymentRepository extends JpaRepository<PaymentPage, String> {
//	 @Query("SELECT p FROM PaymentPage p JOIN p.register r WHERE r.email = :email")
//	 PaymentPage findByRegisterationPageEmail(@Param("email") String email);
//
//
//	 
//
//}
@Repository
@EnableJpaRepositories
public interface PaymentRepository extends JpaRepository<PaymentPage, String> {
    @Query("SELECT p FROM PaymentPage p JOIN p.register r WHERE r.customerId = :customerId")
    List<PaymentPage> findByRegisterationPageCustomerId(@Param("customerId") String customerId);
    
    List<PaymentPage> findAllByRegisterEmail(String email);
    
    List<PaymentPage> findByUserId(String userId);
    
    List<PaymentPage>findByRegisterCustomerId(String string);
    
}