package org.management.library.dtos;

import lombok.*;

import javax.persistence.Entity;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class BookDto {
    private String bookName;
    private int pages;
    private String weight;
    private String authorFirstName;
    private String authorLastName;
    private String authorBio;
    private String categoryName;
    private String isAvailable;


}
