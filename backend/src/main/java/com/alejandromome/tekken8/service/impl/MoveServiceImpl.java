package com.alejandromome.tekken8.service.impl;

import com.alejandromome.tekken8.domain.entities.Move;
import com.alejandromome.tekken8.repositories.CharacterRepository;
import com.alejandromome.tekken8.repositories.MoveRepository;
import com.alejandromome.tekken8.service.MoveService;
import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVParser;
import org.apache.commons.csv.CSVRecord;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Reader;
import java.nio.charset.StandardCharsets;
import java.util.List;
import java.util.Optional;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import com.alejandromome.tekken8.domain.entities.Character;

@Service
@RequiredArgsConstructor
public class MoveServiceImpl implements MoveService {
    private final MoveRepository moveRepository;
    private final CharacterRepository characterRepository;

    private static final Pattern STARTUP_PATTERN = Pattern.compile("\\d+");
    private static final Pattern BLOCK_PATTERN = Pattern.compile("[+-]?\\d+");

    @Override
    public Integer importMoves(InputStream inputStream, String characterName) throws IOException {
        Character character = characterRepository.findByName(characterName).orElseThrow(() -> new EntityNotFoundException("Character not found with name: " + characterName));
        CSVFormat format = CSVFormat.DEFAULT.builder()
                .setHeader()
                .setSkipHeaderRecord(true)
                .build();
        int rows = 0;
        try (Reader reader = new InputStreamReader(inputStream, StandardCharsets.UTF_8);
             CSVParser parser = CSVParser.parse(reader, format)) {
            for (CSVRecord record : parser) {
                String name = record.get("Name");
                String command = record.get("Command");
                String hitLevel = record.get("Hit level");
                String damage = record.get("Damage");
                String startFrame = record.get("Start up frame");
                String blockFrame = record.get("Block frame");
                String hitFrame = record.get("Hit frame");
                String notes = record.get("Notes");
                Integer cleanStartUp = parseStartup(record.get("Start up frame"));
                Integer cleanBlockFrame = parseBlockFrame(record.get("Block frame"));
                Move move = Move.builder().command(command)
                        .hitLevel(hitLevel)
                        .damage(damage)
                        .startFrame(startFrame)
                        .blockFrame(blockFrame)
                        .hitFrame(hitFrame)
                        .notes(notes)
                        .cleanStartUp(cleanStartUp)
                        .cleanBlockFrame(cleanBlockFrame)
                        .character(character)
                        .name(name)
                        .build();

                rows++;
                moveRepository.save(move);
            }
        }
        return rows++;
    }

    @Override
    public List<Move> findAllMovesByCharacterId(Long id) {
        return moveRepository.findByCharacterId(id);
    }

    private Integer parseStartup(String cleanStartup){
        if (cleanStartup == null || cleanStartup.isBlank()){
            return null;
        }
        Matcher matcher = STARTUP_PATTERN.matcher(cleanStartup);
        return matcher.find() ? Integer.parseInt(matcher.group()) : 0;
    }

    private Integer parseBlockFrame(String cleanBlock){
        if (cleanBlock == null || cleanBlock.isBlank()){
            return null;
        }
        Matcher matcher = BLOCK_PATTERN.matcher(cleanBlock);
        return matcher.find() ? Integer.parseInt(matcher.group()) : 0;
    }
}
