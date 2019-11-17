package com.enver.itcompany.model;

import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name = "skills")
@AttributeOverride(name = "id", column = @Column(name = "skill_id"))
public class Skill extends AbstractEntity {

    @ManyToMany(fetch = FetchType.EAGER,
            cascade = {CascadeType.DETACH,
                    CascadeType.MERGE,
                    CascadeType.REFRESH,
                    CascadeType.PERSIST},
            targetEntity = User.class)
    @JoinTable(name = "user_skills",
            joinColumns = @JoinColumn(name = "skill_id"),
            inverseJoinColumns = @JoinColumn(name = "user_id"),
            foreignKey = @ForeignKey(ConstraintMode.CONSTRAINT),
            inverseForeignKey = @ForeignKey(ConstraintMode.CONSTRAINT))
    private Set<User> users;

    public Skill() {
    }

    public Skill(String name, Set<User> users) {
        super(name);
        this.users = users;
    }

    public Skill(long id, String name, Set<User> users) {
        super(id, name);
        this.users = users;
    }
}
