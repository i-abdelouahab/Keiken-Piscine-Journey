package org.management.library.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Table(name = "categories")
public class Category implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int categoryId;

    @Column(name = "categoryName", nullable = false, length = 30)
    private String categoryName;

    @OneToMany(mappedBy = "category")
    @JsonIgnore
    private List<Book> books;

    public Category(String categoryName) {
        this.categoryName = categoryName;
    }
}

