package org.colivera.curso.springboot.error.springbooterror.domain;

public class User {
    private Long id;
    private String name;
    private String lastName;

    private Role role;

    public User() {
    }

    public User(Long id, String name, String lastName) {
        this.id = id;
        this.name = name;
        this.lastName = lastName;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public Role getRole() {
        return role;
    }

    public String getRoleName() {
        return role.getName();
    }

    public void setRole(Role role) {
        this.role = role;
    }
}
