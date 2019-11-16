package com.enver.itcompany.model;

import javax.persistence.AttributeOverride;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "specialties")
@AttributeOverride(name = "id", column = @Column(name = "specialty_id"))
@AttributeOverride(name = "name", column = @Column(name = "specialty"))
public class Specialty extends AbstractEntity {

    public Specialty() {
    }

    public Specialty(String name) {
        super(name);
    }

    public Specialty(long id, String name) {
        super(id, name);
    }
}
