package com.employee.demo.model;

import jakarta.persistence.*;

@Entity
public class Project {

	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    @ManyToOne
    @JoinColumn(name = "client_id")
    private Client client;

    // Getters and setters
    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public String getName() { return name; }
    public void setName(String name) { this.name = name; }

    public Client getClient() { return client; }
    public void setClient(Client client) { this.client = client; }
}
