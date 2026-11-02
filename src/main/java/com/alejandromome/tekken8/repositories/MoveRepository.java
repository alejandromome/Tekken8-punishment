package com.alejandromome.tekken8.repositories;

import com.alejandromome.tekken8.domain.entities.Move;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface MoveRepository extends JpaRepository<Move, Long> {
    List<Move> findByCharacter_id(Long id);
    List<Move> findByCharacter_idAndDamage(Long id, Long damage);
    List<Move> findAllByDamage(Long damage);
    List<Move> findAllByDamageGreaterThan(Long damage);
    List<Move> findAllByDamageLessThan(Long damage);
    List<Move> findAllByCharacter_idAndStartFrameLessThanEqualOrderByDamageDesc(Long id, Long startFrame);

}
