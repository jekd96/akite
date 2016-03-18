package org.clicker.config;

import org.clicker.domain.Client;
import org.clicker.service.ClientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ClientUUIDConfig {

    @Autowired
    ClientService clientService;

    @Bean(name = "currentClient")
    public Client currentClient(){
        return clientService.registerClient();
    }

}
