package com.enver.itcompany.model;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.Set;

@Entity
@Table(name = "projects")
@AttributeOverride(name = "id", column = @Column(name = "project_id"))
public class Project extends AbstractEntity {

    @Column(name = "budget", nullable = false)
    private BigDecimal budget;

    @ManyToOne(optional = false, cascade = CascadeType.ALL)
    @JoinColumn(name = "customer_id")
    private Customer customer;

    @OneToMany(mappedBy = "project", fetch = FetchType.EAGER)
    private Set<Team> teams;

    public Project() {
    }

    public Project(String name, BigDecimal budget, Customer customer, Set<Team> teams) {
        super(name);
        this.budget = budget;
        this.customer = customer;
        this.teams = teams;
    }

    public Project(long id, String name, BigDecimal budget, Customer customer, Set<Team> teams) {
        super(id, name);
        this.budget = budget;
        this.customer = customer;
        this.teams = teams;
    }

    public BigDecimal getBudget() {
        return budget;
    }

    public void setBudget(BigDecimal budget) {
        this.budget = budget;
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    public Set<Team> getTeams() {
        return teams;
    }

    public void setTeams(Set<Team> teams) {
        this.teams = teams;
    }
}
