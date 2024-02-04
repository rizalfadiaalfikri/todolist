package com.rizalfadiaalfikri.library.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.rizalfadiaalfikri.library.entity.List;

@Repository
public interface ListRepository extends JpaRepository<List, Long> {
    Optional<List> findByStatus(boolean status);

    java.util.List<List> findByUserId(Long id);
}
