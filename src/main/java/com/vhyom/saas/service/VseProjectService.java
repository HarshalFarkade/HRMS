package com.vhyom.saas.service;

import com.vhyom.saas.dto.ProjectDto;
import com.vhyom.saas.entity.VseProject;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface VseProjectService {

    String createVseProject(VseProject vseProject, Integer client, Integer projectManager,Integer teamLeader);

//    List<ProjectDto> getAllProject();
//
//    ProjectDto getProjectByUuid(String uuid);
//
//    String deleteProjectByUuid(String uuid,VseProject vseProject);
//
//    String updateProjectByUuid(String uuid,Integer projectManager,Integer teamLeader,VseProject vseProject);

}
