package com.enver.itcompany.model;

import javax.persistence.AttributeOverride;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "skills")
@AttributeOverride(name = "id", column = @Column(name = "skill_id"))
public class Skill extends AbstractEntity {

    public Skill() {
    }

    public Skill(String name) {
        super(name);
    }

    public Skill(long id, String name) {
        super(id, name);
    }
}
