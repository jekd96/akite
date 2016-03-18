package org.clicker.domain;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import javax.persistence.*;
import java.util.Date;

/**
 * Created by Admin on 18.03.2016.
 */
@Entity
@Table(name = "employees")
@Component
@Scope("prototype")
public class Employee  extends GenericEntity<Employee> {

    @Column(name = "name")
    private String name;
    @Column(name = "date_of_birth")
    private Date dateOfBirth;
    @JoinColumn(name = "position_id")
    @ManyToOne
    private Position position;
    @Column(name = "date_of_issue")
    private Date dateOfIssue;
    @Column(name = "phone")
    private String phone;
    @Column(name = "home_address")
    private String homeAddress;
    @Column(name = "place_of_residence")
    private String placeOfResidence;
    @Column(name = "series_passport_number")
    private String seriesPassportNumber;
    @Column(name = "indifikatsionny_code")
    private String indifikatsionnyCode;


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Date getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(Date dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    public Position getPosition() {
        return position;
    }

    public void setPosition(Position position) {
        this.position = position;
    }

    public Date getDateOfIssue() {
        return dateOfIssue;
    }

    public void setDateOfIssue(Date dateOfIssue) {
        this.dateOfIssue = dateOfIssue;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getHomeAddress() {
        return homeAddress;
    }

    public void setHomeAddress(String homeAddress) {
        this.homeAddress = homeAddress;
    }

    public String getPlaceOfResidence() {
        return placeOfResidence;
    }

    public void setPlaceOfResidence(String placeOfResidence) {
        this.placeOfResidence = placeOfResidence;
    }

    public String getSeriesPassportNumber() {
        return seriesPassportNumber;
    }

    public void setSeriesPassportNumber(String seriesPassportNumber) {
        this.seriesPassportNumber = seriesPassportNumber;
    }

    public String getIndifikatsionnyCode() {
        return indifikatsionnyCode;
    }

    public void setIndifikatsionnyCode(String indifikatsionnyCode) {
        this.indifikatsionnyCode = indifikatsionnyCode;
    }
}
