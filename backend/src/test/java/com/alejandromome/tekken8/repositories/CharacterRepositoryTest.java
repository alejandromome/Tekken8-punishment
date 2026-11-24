package com.alejandromome.tekken8.repositories;
import com.alejandromome.tekken8.domain.entities.Character;
import jakarta.persistence.EntityManager;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.data.jpa.test.autoconfigure.DataJpaTest;
import org.springframework.boot.jdbc.test.autoconfigure.AutoConfigureTestDatabase;
import org.springframework.boot.testcontainers.service.connection.ServiceConnection;
import org.testcontainers.junit.jupiter.Container;
import org.testcontainers.junit.jupiter.Testcontainers;
import org.testcontainers.postgresql.PostgreSQLContainer;
import static org.junit.jupiter.api.Assertions.*;

@DataJpaTest
@Testcontainers
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
public class CharacterRepositoryTest{
    @Autowired
    private CharacterRepository characterRepository;
    @Autowired
    private EntityManager entityManager;

    @Container
    @ServiceConnection
    public static PostgreSQLContainer postgreSQLContainer = new PostgreSQLContainer("postgres:16");

    @Test
    void safeAndFind(){
        Character character = new Character();
        character.setName("Yoshimitsu");
        Character savedCharacter = characterRepository.save(character);
        entityManager.flush();
        entityManager.clear();
        Character foundCharacter = characterRepository.findById(savedCharacter.getId()).orElse(null);
        assertNotNull(foundCharacter);
        assertEquals(savedCharacter.getName(), foundCharacter.getName());
    }
}
