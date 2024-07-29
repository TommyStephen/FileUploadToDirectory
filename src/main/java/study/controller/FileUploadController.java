package study.controller;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;


@RestController
public class FileUploadController {

	private static final String UPLOAD_DIR = "./uploads";

    @PostMapping("/upload")
    public ResponseEntity<String> uploadFile(
            @RequestHeader("Directory-Name") String directoryName,
            @RequestParam("file") MultipartFile file) {

        // Create the directory
        Path directoryPath = Paths.get(UPLOAD_DIR, directoryName);
        if (!Files.exists(directoryPath)) {
            try {
                Files.createDirectories(directoryPath);
            } catch (IOException e) {
                return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                        .body("Failed to create directory: " + e.getMessage());
            }
        }

        // Save the file
        Path filePath = directoryPath.resolve(file.getOriginalFilename());
        try {
            Files.copy(file.getInputStream(), filePath);
        } catch (IOException e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body("Failed to save file: " + e.getMessage());
        }

        return ResponseEntity.ok("File uploaded successfully to: " + filePath.toString());
    }
}
