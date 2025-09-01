package com.vidhuras.ceepl.controller;


import com.vidhuras.ceepl.entity.TeamMember;
import com.vidhuras.ceepl.service.TeamMemberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;

@RestController
@RequestMapping("/team")
@CrossOrigin(origins = "*")
public class TeamMemberController {

    private final TeamMemberService service;

    @Autowired
    public TeamMemberController(TeamMemberService service) {
        this.service = service;
    }

    // Add Team Member
    @PostMapping("/add")
    public TeamMember addTeamMember(@RequestParam("name") String name,
                                    @RequestParam("designation") String designation,
                                    @RequestParam("image") MultipartFile image) throws IOException {
        return service.addTeamMember(name, designation, image);
    }

    // Get all team members
    @GetMapping("/all")
    public List<TeamMember> getAllTeamMembers() {
        return service.getAllTeamMembers();
    }
}
