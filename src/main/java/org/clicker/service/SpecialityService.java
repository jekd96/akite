package org.clicker.service;

import org.clicker.domain.Speciality;
import org.clicker.repository.SpecialityRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by Admin on 18.03.2016.
 */
@Service
public class SpecialityService extends CommonService<SpecialityRepository, Speciality> {
    @Autowired
    public SpecialityService(SpecialityRepository specialityRepository) {
        setRepository(specialityRepository);
    }
}
