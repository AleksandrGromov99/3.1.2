package ru.gromov.spring.model;

import jakarta.persistence.*;

@Entity
@Table(name = "users")
public class User {
    @Column(name = "name")
    private String name;
    @Column(name = "age")
    private int age;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private long id;

    public User(String name, int age, long id) {
        this.name = name;
        this.age = age;
        this.id = id;
    }

    public User() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }
}
