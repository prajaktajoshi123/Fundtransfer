package com.demo.fundtransfer.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.demo.fundtransfer.model.Customer;
import com.google.common.base.Optional;

@Repository
public interface LoginRepository extends JpaRepository<Customer, Long> {

	Optional<Customer> findByUserNameAndPassword(String username, String password);

}
