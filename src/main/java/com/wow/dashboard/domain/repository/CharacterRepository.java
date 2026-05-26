package com.wow.dashboard.domain.repository;

import com.wow.dashboard.domain.model.Character;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface CharacterRepository extends JpaRepository<Character, Long> {
    List<Character> findByAccount(Long userId);
    Optional<Character> findByGuid(Long guid);
}
