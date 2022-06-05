package com.example.demo.security;

import javax.persistence.*;

@Entity
@Table(name="users")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Column(name="username")
    private String username;
    @Column(name="password")
    private String password;
    @Column(name="role")
    @Enumerated(value=EnumType.STRING)
    private Role role;
    @Column(name="status")
    @Enumerated(value=EnumType.STRING)
    private Status status;
    public Status getStatus()
    {
        return this.status;
    }
    public Role getRole()
    {
        return this.role;
    }

    public String getUsername() {
        return username;
    }
    public String getPassword()
    {
        return password;
    }
    public int getId()
    {
        return id;
    }
    public void setId(int id)
    {
        this.id=id;
    }
    public void setUsername(String username)
    {
        this.username=username;
    }
    public void setPassword(String password)
    {
        this.password=password;
    }
    public void setRole(Role role)
    {
        this.role=role;
    }
    public void setStatus(Status status)
    {
        this.status=status;
    }

}
