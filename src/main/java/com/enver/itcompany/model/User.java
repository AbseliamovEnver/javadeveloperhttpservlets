package com.enver.itcompany.model;

import javax.persistence.AttributeOverride;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import java.util.Set;

@Entity
@Table(name = "users")
@AttributeOverride(name = "id", column = @Column(name = "user_id"))
@AttributeOverride(name = "name", column = @Column(name = "first_name"))
public class User extends AbstractEntity {

    @Column(name = "last_name")
    private String lastName;


    private Specialty specialty;


    private Set<Skill> skills;

    public User() {
    }

    public User(String name, String lastName, Specialty specialty, Set<Skill> skills) {
        super(name);
        this.lastName = lastName;
        this.specialty = specialty;
        this.skills = skills;
    }

    public User(long id, String name, String lastName, Specialty specialty, Set<Skill> skills) {
        super(id, name);
        this.lastName = lastName;
        this.specialty = specialty;
        this.skills = skills;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public Specialty getSpecialty() {
        return specialty;
    }

    public void setSpecialty(Specialty specialty) {
        this.specialty = specialty;
    }

    public Set<Skill> getSkills() {
        return skills;
    }

    public void setSkills(Set<Skill> skills) {
        this.skills = skills;
    }
}
