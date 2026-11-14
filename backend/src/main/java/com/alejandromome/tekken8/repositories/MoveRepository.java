package com.alejandromome.tekken8.repositories;

import com.alejandromome.tekken8.domain.entities.Move;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import com.alejandromome.tekken8.domain.entities.Character;

import java.util.List;

@Repository
public interface MoveRepository extends JpaRepository<Move, Long> {
    List<Move> findByCharacterId(Long characterId);
}
