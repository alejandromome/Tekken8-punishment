package com.alejandromome.tekken8.config;


import com.alejandromome.tekken8.service.MoveService;
import jakarta.annotation.Resource;
import lombok.RequiredArgsConstructor;
import lombok.Value;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;
import java.io.InputStream;
import java.io.InputStreamReader;

import java.io.IOException;

@RequiredArgsConstructor
@RestController
public class LoaderConfig {
    private final MoveService moveService;

    @PostMapping("/moves/import")

    public Integer importCsv(@RequestParam("file") MultipartFile file) throws IOException {
        return moveService.importMoves(file.getInputStream(), file.getName().replace(".csv", ""));
    }
}
