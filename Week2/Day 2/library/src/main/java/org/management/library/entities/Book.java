package org.management.library.entities;

import lombok.*;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

@Entity
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Table(name = "books")
public class Book implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int bookId;

    @Column(name = "bookName", nullable = false, length = 200)
    private String bookName;

    @Column(name = "pages", nullable = false)
    private int pages;

    @Column(name = "weight", length = 10)
    private String weight;

    @Column(name = "isAvailable", nullable = false)
    private String isAvailable="false";

    @ManyToOne
    @JoinColumn(name = "categoryId", nullable = false)
    private Category category;

    @ManyToOne
    @JoinColumn(name = "authorId", nullable = false)
    private Author author;

    @OneToMany(mappedBy = "book")
    private List<Reservation> reservations;


    public Book(String bookName, int pages, String weight, Category category, Author author, String isAvailable) {
        this.bookName = bookName;
        this.category = category;
        this.pages = pages;
        this.weight = weight;
        this.author = author;
        this.isAvailable = isAvailable;
    }
}

