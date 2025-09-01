package com.vidhuras.ceepl.service;


import com.vidhuras.ceepl.dto.TeamMemberRequestDto;
import com.vidhuras.ceepl.dto.TeamMemberResponseDto;
import com.vidhuras.ceepl.entity.TeamMember;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;

public interface TeamMemberService {

    TeamMember addTeamMember(String name, String designation, MultipartFile image) throws IOException;

    List<TeamMember> getAllTeamMembers();
}