package com.libra.book_service.repository.specification;

import com.libra.book_service.entity.Books;
import org.springframework.data.jpa.domain.Specification;

public class BookSpecification {

    public static Specification<Books> hasTitle(String title) {
        return (root, query, criteriaBuilder) ->
            criteriaBuilder.like(root.get("title"), "%" + title + "%");
    }

    public static Specification<Books> hasIsbn(String isbn) {
        return (root, query, criteriaBuilder) ->
            criteriaBuilder.equal(root.get("isbn"), isbn);
    }

    public static Specification<Books> hasPublicationYear(Integer year) {
        return (root, query, criteriaBuilder) ->
            criteriaBuilder.equal(root.get("publicationYear"), year);
    }

    public static Specification<Books> hasStatus(String status) {
        return (root, query, criteriaBuilder) ->
            criteriaBuilder.equal(root.get("status"), status);
    }
}