package com.vidhuras.ceepl.service.serviceImpl;


import com.vidhuras.ceepl.entity.TeamMember;
import com.vidhuras.ceepl.repository.TeamMemberRepository;
import com.vidhuras.ceepl.service.TeamMemberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;
import java.io.File;
import java.io.IOException;
import java.util.List;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

@Service
public class TeamMemberServiceImpl implements TeamMemberService {

    private final TeamMemberRepository repository;

    @Autowired
    public TeamMemberServiceImpl(TeamMemberRepository repository) {
        this.repository = repository;
    }

    @Override
    public TeamMember addTeamMember(String name, String designation, MultipartFile image) throws IOException {
        String uploadDir = "uploads/";
        File uploadFolder = new File(uploadDir);
        if (!uploadFolder.exists()) {
            uploadFolder.mkdirs();
        }

        String fileName = System.currentTimeMillis() + "_" + image.getOriginalFilename();
        Path filePath = Paths.get(uploadDir, fileName);
        Files.write(filePath, image.getBytes());

        String imageUrl = "http://localhost:8080/uploads/" + fileName;

        TeamMember member = TeamMember.builder()
                .name(name)
                .designation(designation)
                .image(imageUrl)
                .build();

        return repository.save(member);
    }

    @Override
    public List<TeamMember> getAllTeamMembers() {
        return repository.findAll();
    }
}
