package org.management.library.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "authors")
public class Author implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int authorId;

    @Column(name = "firstName", nullable = false, length = 30)
    private String firstName;

    @Column(name = "lastName", nullable = false, length = 30)
    private String lastName;

    @Column(name = "bio", nullable = false, length = 500)
    private String bio;

    @OneToMany(mappedBy = "author")
    @JsonIgnore
    private List<Book> books;

    public Author(String authorFirstName, String authorLastName, String authorBio) {
        this.firstName = authorFirstName;
        this.lastName = authorLastName;
        this.bio = authorBio;
    }
}

