package com.libra.book_service.entity;


import jakarta.persistence.*;
import lombok.*;

@Entity
@Setter
@Getter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Books {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String title;

    private String isbn;

    private Integer publicationYear;

    private String status;

    private String qrCode;

    @ManyToOne
    @JoinColumn(name = "author_id", referencedColumnName = "id")
    private Authors authors;

    @ManyToOne
    @JoinColumn(name = "publisher_id", referencedColumnName = "id")
    private Publishers publishers;

}