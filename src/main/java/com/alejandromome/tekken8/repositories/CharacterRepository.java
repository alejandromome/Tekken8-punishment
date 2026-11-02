package com.alejandromome.tekken8.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.alejandromome.tekken8.domain.entities.Character;

import java.util.List;
import java.util.Optional;

@Repository
public interface CharacterRepository extends JpaRepository<Character, Long> {
    Optional<Character> findByName(String name);
}
