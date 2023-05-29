package com.vhyom.saas.service.impl;

import com.vhyom.saas.dto.ProjectDto;
import com.vhyom.saas.entity.VseProject;
import com.vhyom.saas.repository.VseProjectRepository;
import com.vhyom.saas.service.VseProjectService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.time.LocalDateTime;
import java.util.List;

@Service
public class VseProjectServiceImpl implements VseProjectService {

    @Autowired
    private VseProjectRepository vseProjectRepository;

    @Override
    public String createVseProject(VseProject vseProject, Integer client, Integer projectManager,Integer teamLeader) {
        this.vseProjectRepository.createVseProject(client,projectManager,teamLeader,vseProject.getName(),vseProject.getDescription(),vseProject.getStartDate(),vseProject.getEndDate(),vseProject.getRate(),vseProject.getRateType(), vseProject.getCreatedBy());
        return "Create VseProject Successfully";
    }

    @Override
    public List<ProjectDto> getAllProject() {
        return vseProjectRepository.getAllProject();
    }

    @Override
    public ProjectDto getProjectByUuid(String uuid) {
        ProjectDto project =vseProjectRepository.getProjectByUuid(uuid);
        if (project==null){
            System.out.println("Project not found");
        }
        return project;
    }
//
//    @Override
//    public String deleteProjectByUuid(String uuid, VseProject vseProject) {
//        this.vseProjectRepository.deleteProjectByUuid(vseProject.getLastModifiedBy(), LocalDateTime.now(),false,uuid);
//        return "Delete VseProject Successfully";
//    }
//
//    @Override
//    public String updateProjectByUuid(String uuid, Integer projectManager, Integer teamLeader, VseProject vseProject) {
//        this.vseProjectRepository.updateProjectByUuid(projectManager,teamLeader,vseProject.getStartDate(),vseProject.getEndDate(), vseProject.getLastModifiedBy(), LocalDateTime.now(),uuid);
//        return "Update VseProject Successfully";
//    }
}
