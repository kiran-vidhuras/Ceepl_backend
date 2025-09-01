package com.vidhuras.ceepl.controller;

import com.vidhuras.ceepl.dto.AboutRequestDto;
import com.vidhuras.ceepl.dto.AboutResponseDto;
import com.vidhuras.ceepl.service.AboutService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.util.List;

@RestController
@RequestMapping("/about")
@CrossOrigin(origins = "*")
public class AboutController {

    private final AboutService service;

    @Autowired
    public AboutController(AboutService service) {
        this.service = service;
    }

    // JSON-only add (not used by frontend form, but kept for APIs)
    @PostMapping(value = "/addAbout", consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<AboutResponseDto> createAbout(@RequestBody AboutRequestDto dto) {
        return ResponseEntity.ok(service.addAbout(dto));
    }

    // Multipart add (used by HTML form)
    @PostMapping(value = "/add", consumes = MediaType.MULTIPART_FORM_DATA_VALUE)
    public ResponseEntity<AboutResponseDto> createAbout(
            @RequestParam("heading") String heading,
            @RequestParam("description") String description,
            @RequestParam("content") String content,
            @RequestParam("buttonText") String buttonText,
            @RequestParam("imagePath") MultipartFile imageFile
    ) throws IOException {

        AboutRequestDto dto = new AboutRequestDto();
        dto.setHeading(heading);
        dto.setDescription(description);
        dto.setContent(content);
        dto.setButtonText(buttonText);

        String uploadDir = System.getProperty("user.dir") + File.separator + "uploads" + File.separator + "about" + File.separator;
        File dir = new File(uploadDir);
        if (!dir.exists()) dir.mkdirs();

        String fileName = System.currentTimeMillis() + "_" + imageFile.getOriginalFilename();
        Path filePath = Paths.get(uploadDir, fileName);
        Files.copy(imageFile.getInputStream(), filePath, StandardCopyOption.REPLACE_EXISTING);

        // relative path (no leading slash!)
        dto.setImagePath("uploads/about/" + fileName);

        return ResponseEntity.ok(service.add(dto));
    }


    @PutMapping(value = "/update/{id}", consumes = MediaType.MULTIPART_FORM_DATA_VALUE)
    public ResponseEntity<AboutResponseDto> updateAbout(
            @PathVariable Long id,
            @RequestParam("heading") String heading,
            @RequestParam("description") String description,
            @RequestParam("content") String content,
            @RequestParam("buttonText") String buttonText,
            @RequestParam(value = "imagePath", required = false) MultipartFile imageFile
    ) throws IOException {

        AboutRequestDto dto = new AboutRequestDto();
        dto.setHeading(heading);
        dto.setDescription(description);
        dto.setContent(content);
        dto.setButtonText(buttonText);

        if (imageFile != null && !imageFile.isEmpty()) {
            String uploadDir = System.getProperty("user.dir") + File.separator + "uploads" + File.separator + "about" + File.separator;
            File dir = new File(uploadDir);
            if (!dir.exists()) dir.mkdirs();

            String fileName = System.currentTimeMillis() + "_" + imageFile.getOriginalFilename();
            Path filePath = Paths.get(uploadDir, fileName);
            Files.copy(imageFile.getInputStream(), filePath, StandardCopyOption.REPLACE_EXISTING);

            dto.setImagePath("uploads/about/" + fileName);
        }

        return ResponseEntity.ok(service.update(id, dto));
    }


    @GetMapping("/all")
    public List<AboutResponseDto> getAllAbouts() {
        return service.findAll();
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<String> deleteAbout(@PathVariable Long id) {
        boolean deleted = service.delete(id);
        if (deleted) {
            return ResponseEntity.ok("About section deleted successfully.");
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("About section not found.");
        }
    }

}
