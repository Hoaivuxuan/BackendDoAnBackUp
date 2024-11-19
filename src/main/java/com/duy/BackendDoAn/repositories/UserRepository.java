package com.duy.BackendDoAn.repositories;

import com.duy.BackendDoAn.models.User;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.Optional;

public interface UserRepository extends JpaRepository<User, Long> {
    Optional<User> findByEmail(String email);
    boolean existsByEmail(String email);

    @Query("SELECT o FROM User o WHERE o.active = true AND (:keyword IS NULL OR :keyword = '' OR " +
            "o.name LIKE %:keyword% " +
            "OR o.address LIKE %:keyword% " +
            "OR o.phone_number LIKE %:keyword%)")
    Page<User> findAll(@Param("keyword") String keyword, Pageable pageable);
}
