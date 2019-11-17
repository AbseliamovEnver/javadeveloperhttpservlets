package com.enver.itcompany.model;

import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name = "specialties")
@AttributeOverride(name = "id", column = @Column(name = "specialty_id"))
@AttributeOverride(name = "name", column = @Column(name = "specialty"))
public class Specialty extends AbstractEntity {

    @ManyToMany(fetch = FetchType.EAGER,
            cascade = {CascadeType.DETACH,
                    CascadeType.MERGE,
                    CascadeType.REFRESH,
                    CascadeType.PERSIST},
            targetEntity = User.class)
    @JoinTable(name = "user_specialties",
            joinColumns = @JoinColumn(name = "specialty_id"),
            inverseJoinColumns = @JoinColumn(name = "user_id"),
            foreignKey = @ForeignKey(ConstraintMode.CONSTRAINT),
            inverseForeignKey = @ForeignKey(ConstraintMode.CONSTRAINT))
    private Set<User> users;

    public Specialty() {
    }

    public Specialty(String name, Set<User> users) {
        super(name);
        this.users = users;
    }

    public Specialty(long id, String name, Set<User> users) {
        super(id, name);
        this.users = users;
    }
}
