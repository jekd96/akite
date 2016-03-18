package org.clicker.domain;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

/**
 * Created by Admin on 18.03.2016.
 */
@Entity
@Table(name = "speciality")
@Component
@Scope("prototype")
public class Speciality extends GenericEntity<Speciality> {

    @Column(name = "name_speciality")
    private String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

}
