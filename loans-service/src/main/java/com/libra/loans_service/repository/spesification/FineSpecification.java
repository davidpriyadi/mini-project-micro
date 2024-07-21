package com.libra.loans_service.repository.spesification;

import com.libra.loans_service.entity.Fines;
import org.springframework.data.jpa.domain.Specification;

import java.time.LocalDate;

public class FineSpecification {

    public static Specification<Fines> hasUserId(Long userId) {
        return (root, query, criteriaBuilder) ->
            criteriaBuilder.equal(root.get("userId"), userId);
    }

    public static Specification<Fines> hasStatus(Fines.FineStatus status) {
        return (root, query, criteriaBuilder) ->
            criteriaBuilder.equal(root.get("status"), status);
    }

    public static Specification<Fines> hasLoanId(Long loanId) {
        return (root, query, criteriaBuilder) ->
            criteriaBuilder.equal(root.get("loanId"), loanId);
    }

    public static Specification<Fines> hasAmount(Double amount) {
        return (root, query, criteriaBuilder) ->
            criteriaBuilder.equal(root.get("amount"), amount);
    }

    public static Specification<Fines> hasReason(String reason) {
        return (root, query, criteriaBuilder) ->
            criteriaBuilder.like(root.get("reason"), "%" + reason + "%");
    }

    public static Specification<Fines> hasIssuedDate(LocalDate issuedDate) {
        return (root, query, criteriaBuilder) ->
            criteriaBuilder.equal(root.get("issuedDate"), issuedDate);
    }

    public static Specification<Fines> hasPaidDate(LocalDate paidDate) {
        return (root, query, criteriaBuilder) ->
            criteriaBuilder.equal(root.get("paidDate"), paidDate);
    }

    public static Specification<Fines> hasBookId(Long bookId) {
        return (root, query, criteriaBuilder) ->
           criteriaBuilder.equal(root.get("loan").get("bookId"), bookId);
    }
}
