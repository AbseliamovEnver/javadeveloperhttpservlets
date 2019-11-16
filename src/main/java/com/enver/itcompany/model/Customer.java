package com.enver.itcompany.model;

import javax.persistence.AttributeOverride;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import java.util.Set;

@Entity
@Table(name = "customers")
@AttributeOverride(name = "id", column = @Column(name = "customers_id"))
public class Customer extends AbstractEntity {

    private Set<Project> projects;

    public Customer() {
    }

    public Customer(String name, Set<Project> projects) {
        super(name);
        this.projects = projects;
    }

    public Customer(long id, String name, Set<Project> projects) {
        super(id, name);
        this.projects = projects;
    }

    public Set<Project> getProjects() {
        return projects;
    }

    public void setProjects(Set<Project> projects) {
        this.projects = projects;
    }
}
