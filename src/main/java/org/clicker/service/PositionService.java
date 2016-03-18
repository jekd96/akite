package org.clicker.service;

import org.clicker.domain.Position;
import org.clicker.repository.PositionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by Admin on 18.03.2016.
 */
@Service
public class PositionService extends CommonService<PositionRepository, Position> {
    @Autowired
    public PositionService(PositionRepository positionRepository) {
        setRepository(positionRepository);
    }
}
