package org.clicker.repository;

import org.clicker.domain.Client;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ClientRepository  extends CrudRepository<Client, Long> {

    Client findOneByUuidEquals(String uuid);

}
