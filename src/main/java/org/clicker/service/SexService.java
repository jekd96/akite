package org.clicker.service;

import org.clicker.domain.Sex;
import org.clicker.repository.SexRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by Admin on 18.03.2016.
 */
@Service
public class SexService extends CommonService<SexRepository, Sex> {

    @Autowired
    public SexService(SexRepository sexRepository) {
        setRepository(sexRepository);
    }

}
