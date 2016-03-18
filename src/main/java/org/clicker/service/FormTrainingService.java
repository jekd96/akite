package org.clicker.service;

import org.clicker.domain.FormTraining;
import org.clicker.repository.FormTrainingRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by Admin on 18.03.2016.
 */
@Service
public class FormTrainingService extends CommonService<FormTrainingRepository, FormTraining> {

    @Autowired
    public FormTrainingService(FormTrainingRepository formTrainingRepository) {
        setRepository(formTrainingRepository);
    }

}
