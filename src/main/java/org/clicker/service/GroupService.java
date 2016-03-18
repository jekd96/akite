package org.clicker.service;

import org.clicker.domain.Group;
import org.clicker.repository.GroupRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Admin on 07.10.2015.
 */
@Service
public class GroupService extends CommonService<GroupRepository, Group> {
    @Autowired
    public GroupService(GroupRepository groupRepository) {
        setRepository(groupRepository);
    }
}
