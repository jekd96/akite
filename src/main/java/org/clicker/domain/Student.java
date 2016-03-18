package org.clicker.domain;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import javax.persistence.*;
import java.util.Date;

/**
 * Created by Admin on 29.01.2016.
 */
@Entity
@Table(name = "students")
@Component
@Scope("prototype")
public class Student extends GenericEntity<Student> {

    @Column(name = "name")
    private String name;
    @Column(name = "surname")
    private String surname;
    @Column(name = "patronymic")
    private String patronymic;
    @Column(name = "year_birth")
    private Date yearBirth;
    @Column(name = "year_revenue")
    private Date yearRevenue;
    @JoinColumn(name = "group_id")
    @ManyToOne
    private Group group;
    @JoinColumn(name = "speciality_id")
    @ManyToOne
    private Speciality speciality;
    @Column(name = "phone_student")
    private String phoneStudent;
    @Column(name = "phone_parents")
    private String phoneParents;
    @Column(name = "address")
    private String address;
    @JoinColumn(name = "sex_id")
    @ManyToOne
    private Sex sex;
    @Column(name = "passport_data")
    private String passportData;
    @Column(name = "indifikatsionny_code")
    private String indifikatsionnyCode;
    @JoinColumn(name = "form_training_id")
    @ManyToOne
    private FormTraining formTraining;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public Date getYearBirth() {
        return yearBirth;
    }

    public void setYearBirth(Date yearBirth) {
        this.yearBirth = yearBirth;
    }

    public Date getYearRevenue() {
        return yearRevenue;
    }

    public void setYearRevenue(Date yearRevenue) {
        this.yearRevenue = yearRevenue;
    }


    public Group getGroup() {
        return group;
    }

    public void setGroup(Group group) {
        this.group = group;
    }

    public String getPatronymic() {
        return patronymic;
    }

    public void setPatronymic(String patronymic) {
        this.patronymic = patronymic;
    }

    public Speciality getSpeciality() {
        return speciality;
    }

    public void setSpeciality(Speciality speciality) {
        this.speciality = speciality;
    }

    public String getPhoneStudent() {
        return phoneStudent;
    }

    public void setPhoneStudent(String phoneStudent) {
        this.phoneStudent = phoneStudent;
    }

    public String getPhoneParents() {
        return phoneParents;
    }

    public void setPhoneParents(String phoneParents) {
        this.phoneParents = phoneParents;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public Sex getSex() {
        return sex;
    }

    public void setSex(Sex sex) {
        this.sex = sex;
    }

    public String getPassportData() {
        return passportData;
    }

    public void setPassportData(String passportData) {
        this.passportData = passportData;
    }

    public String getIndifikatsionnyCode() {
        return indifikatsionnyCode;
    }

    public void setIndifikatsionnyCode(String indifikatsionnyCode) {
        this.indifikatsionnyCode = indifikatsionnyCode;
    }

    public FormTraining getFormTraining() {
        return formTraining;
    }

    public void setFormTraining(FormTraining formTraining) {
        this.formTraining = formTraining;
    }
}
