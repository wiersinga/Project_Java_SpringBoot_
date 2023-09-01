package com.testsring.test.dao;

import com.testsring.test.model.Customer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IClientDAO extends JpaRepository<Customer, Integer> {

    Customer findById(int id);

    Customer save(Customer customer);
     Customer deleteById(int id);
}
