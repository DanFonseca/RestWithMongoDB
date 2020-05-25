package br.com.restwithmongodb.demo.DTO;

import br.com.restwithmongodb.demo.Models.Entities.User;

public class AuthorDTO {
    private String name;
    private String id;

    public AuthorDTO(User user) {
        this.name = user.getName();
        this.id = user.getId();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getId() {
        return id;
    }

    public void setEmail(String id) {
        this.id = id;
    }
}
