package com.vidhuras.ceepl.service.serviceImpl;

import com.vidhuras.ceepl.dto.AboutRequestDto;
import com.vidhuras.ceepl.dto.AboutResponseDto;
import com.vidhuras.ceepl.entity.About;
import com.vidhuras.ceepl.repository.AboutRepository;
import com.vidhuras.ceepl.service.AboutService;
import org.springframework.stereotype.Service;

import java.io.File;
import java.util.List;
import java.util.Optional;

@Service
public class AboutServiceImpl implements AboutService {

    private final AboutRepository repository;

    public AboutServiceImpl(AboutRepository repository) {
        this.repository = repository;
    }

    // Used by the multipart controller (/about/add)
    @Override
    public AboutResponseDto add(AboutRequestDto dto) {
        About entity = new About();
        entity.setHeading(dto.getHeading());
        entity.setDescription(dto.getDescription());
        entity.setContent(dto.getContent());
        entity.setButtonText(dto.getButtonText());
        entity.setImagePath(dto.getImagePath()); // e.g. "uploads/about/<file>"

        About saved = repository.save(entity);
        return toResponse(saved);
    }

    // JSON endpoint (/about/addAbout) — optional fallback/default image
    @Override
    public AboutResponseDto addAbout(AboutRequestDto dto) {
        About entity = new About();
        entity.setHeading(dto.getHeading());
        entity.setDescription(dto.getDescription());
        entity.setContent(dto.getContent());
        entity.setButtonText(dto.getButtonText());
        entity.setImagePath(
                (dto.getImagePath() == null || dto.getImagePath().isBlank())
                        ? "uploads/about/default.jpg"   // no leading slash
                        : dto.getImagePath()
        );

        About saved = repository.save(entity);
        return toResponse(saved);
    }

    @Override
    public List<AboutResponseDto> findAll() {
        return repository.findAll().stream()
                .map(this::toResponse)
                .toList();
    }


    @Override
    public boolean delete(Long id) {
        Optional<About> aboutOpt = repository.findById(id);
        if (aboutOpt.isPresent()) {
            About about = aboutOpt.get();

            // delete file from uploads
            if (about.getImagePath() != null) {
                String absolutePath = System.getProperty("user.dir") + File.separator + about.getImagePath();
                File file = new File(absolutePath);
                if (file.exists()) {
                    file.delete();
                }
            }

            repository.deleteById(id);
            return true;
        }
        return false;
    }


    // Update — update existing About by ID
    @Override
    public AboutResponseDto update(Long id, AboutRequestDto dto) {
        About entity = repository.findById(id)
                .orElseThrow(() -> new RuntimeException("About not found with id: " + id));

        entity.setHeading(dto.getHeading());
        entity.setDescription(dto.getDescription());
        entity.setContent(dto.getContent());
        entity.setButtonText(dto.getButtonText());

        // Only update image if new file provided
        if (dto.getImagePath() != null && !dto.getImagePath().isBlank()) {
            entity.setImagePath(dto.getImagePath());
        }

        About saved = repository.save(entity);
        return toResponse(saved);
    }

    private AboutResponseDto toResponse(About a) {
        AboutResponseDto r = new AboutResponseDto();
        r.setId(a.getId());
        r.setHeading(a.getHeading());
        r.setContent(a.getContent());
        r.setDescription(a.getDescription());
        r.setButtonText(a.getButtonText());
        r.setImagePath(a.getImagePath());
        return r;
    }


}
