package com.enver.itcompany.model;

import javax.persistence.AttributeOverride;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import java.util.Set;

@Entity
@Table(name = "teams")
@AttributeOverride(name = "id", column = @Column(name = "team_id"))
public class Team extends AbstractEntity {

    private Set<User> users;

    public Team() {
    }

    public Team(String name, Set<User> users) {
        super(name);
        this.users = users;
    }

    public Team(long id, String name, Set<User> users) {
        super(id, name);
        this.users = users;
    }
}
