package com.enver.itcompany.model;

import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name = "teams")
@AttributeOverride(name = "id", column = @Column(name = "team_id"))
public class Team extends AbstractEntity {

    @ManyToOne(optional = false, cascade = CascadeType.ALL)
    @JoinColumn(name = "project_id")
    private Project project;

    @OneToMany(mappedBy = "team", fetch = FetchType.EAGER)
    private Set<User> users;

    public Team() {
    }

    public Team(String name, Project project, Set<User> users) {
        super(name);
        this.project = project;
        this.users = users;
    }

    public Team(long id, String name, Project project, Set<User> users) {
        super(id, name);
        this.project = project;
        this.users = users;
    }

    public Project getProject() {
        return project;
    }

    public void setProject(Project project) {
        this.project = project;
    }

    public Set<User> getUsers() {
        return users;
    }

    public void setUsers(Set<User> users) {
        this.users = users;
    }
}
