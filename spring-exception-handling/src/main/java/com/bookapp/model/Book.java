package com.bookapp.model;


import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class Book {
    private Integer bookId;
    private String title;
    private String author;
    private String category;

}
