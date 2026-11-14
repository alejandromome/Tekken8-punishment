package com.alejandromome.tekken8.config;

import com.alejandromome.tekken8.domain.entities.Character;
import com.alejandromome.tekken8.repositories.CharacterRepository;
import com.alejandromome.tekken8.service.MoveService;
import org.springframework.core.io.Resource;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@RequiredArgsConstructor
public class DataInit implements CommandLineRunner {
    private final CharacterRepository characterRepository;
    private final MoveService moveService;
    @Value("classpath:static/*.csv")
    private Resource[] csvFiles;

    @Override
    public void run(String... args) throws Exception {
        if (characterRepository.count()==0){
            List<Character> characters = List.of(Character.builder().name("Alisa").build(),
                    Character.builder().name("Asuka").build(),
                    Character.builder().name("Bob").build(),
                    Character.builder().name("Clive").build(),
                    Character.builder().name("Anna").build(),
                    Character.builder().name("Armor-king").build(),
                    Character.builder().name("Azucena").build(),
                    Character.builder().name("Miary-zo").build(),
                    Character.builder().name("Bryan").build(),
                    Character.builder().name("Claudio").build(),
                    Character.builder().name("Devil-jin").build(),
                    Character.builder().name("Dragunov").build(),
                    Character.builder().name("Eddy").build(),
                    Character.builder().name("Feng").build(),
                    Character.builder().name("Heihachi").build(),
                    Character.builder().name("Hwoarang").build(),
                    Character.builder().name("Jack-8").build(),
                    Character.builder().name("Jin").build(),
                    Character.builder().name("Jun").build(),
                    Character.builder().name("Kazuya").build(),
                    Character.builder().name("King").build(),
                    Character.builder().name("Kuma").build(),
                    Character.builder().name("Lars").build(),
                    Character.builder().name("Law").build(),
                    Character.builder().name("Lee").build(),
                    Character.builder().name("Leo").build(),
                    Character.builder().name("Leroy").build(),
                    Character.builder().name("Lidia").build(),
                    Character.builder().name("Lili").build(),
                    Character.builder().name("Nina").build(),
                    Character.builder().name("Panda").build(),
                    Character.builder().name("Paul").build(),
                    Character.builder().name("Raven").build(),
                    Character.builder().name("Reina").build(),
                    Character.builder().name("Shaheen").build(),
                    Character.builder().name("Steve").build(),
                    Character.builder().name("Victor").build(),
                    Character.builder().name("Xiaoyu").build(),
                    Character.builder().name("Fahkumram").build(),
                    Character.builder().name("Kunimitsu").build(),
                    Character.builder().name("Yoshimitsu").build(),
                    Character.builder().name("Zafina").build());
            characterRepository.saveAll(characters);
            if (csvFiles != null) {
                for (Resource csvFile : csvFiles) {
                    if (csvFile.getFilename() != null) {
                        String characterName = csvFile.getFilename().replace(".csv", "");
                        moveService.importMoves(csvFile.getInputStream(), characterName);
                    }
                }
            }
        }


    }
}

