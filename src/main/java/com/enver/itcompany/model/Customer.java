package com.enver.itcompany.model;

import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name = "customers")
@AttributeOverride(name = "id", column = @Column(name = "customer_id"))
public class Customer extends AbstractEntity {

    @OneToMany(mappedBy = "customer", fetch = FetchType.EAGER)
    private Set<Project> projects;

    public Customer() {
    }

    public Customer(String name) {
        super(name);
    }

    public Customer(long id, String name) {
        super(id, name);
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
