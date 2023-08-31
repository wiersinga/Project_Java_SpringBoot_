package com.testsring.test.dao;

import com.testsring.test.model.Client;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IClientDAO extends JpaRepository<Client, Integer> {

    Client findById(int id);

    Client save(Client client);



     Client deleteById(int id);
}
