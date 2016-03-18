package org.clicker.service;

import org.clicker.domain.Client;
import org.clicker.repository.ClientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Service;

@Service
public class ClientService {

    @Autowired
    ClientRepository repository;

    @Autowired
    ApplicationContext applicationContext;

    public Client registerClient(){
        String s = (new java.rmi.dgc.VMID()).toString();
        String uuid = s.substring(0, s.length() -6);

        Client client = repository.findOneByUuidEquals(uuid);
        if(client == null){
            client = new Client();
            client.setUUID(uuid);
            repository.save(client);
        }
        return client;
    }

}
