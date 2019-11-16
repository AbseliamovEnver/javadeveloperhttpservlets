package com.enver.itcompany.model;

import javax.persistence.AttributeOverride;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import java.math.BigDecimal;
import java.util.Set;

@Entity
@Table(name = "projects")
@AttributeOverride(name = "id", column = @Column(name = "project_id"))
public class Project extends AbstractEntity {

    @Column(name = "budget", nullable = false)
    private BigDecimal budget;

    private Set<Team> teams;

    public Project() {
    }

    public Project(BigDecimal budget, Set<Team> teams) {
        this.budget = budget;
        this.teams = teams;
    }

    public Project(String name, BigDecimal budget, Set<Team> teams) {
        super(name);
        this.budget = budget;
        this.teams = teams;
    }

    public Project(long id, String name, BigDecimal budget, Set<Team> teams) {
        super(id, name);
        this.budget = budget;
        this.teams = teams;
    }

    public BigDecimal getBudget() {
        return budget;
    }

    public void setBudget(BigDecimal budget) {
        this.budget = budget;
    }

    public Set<Team> getTeams() {
        return teams;
    }

    public void setTeams(Set<Team> teams) {
        this.teams = teams;
    }
}
