package com.vhyom.saas.controller;

import com.vhyom.saas.dto.ProjectDto;
import com.vhyom.saas.entity.VseProject;
import com.vhyom.saas.service.VseProjectService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RequestMapping("api/v1/Project")
@CrossOrigin(originPatterns = {"http://localhost:5173"}, allowCredentials = "true")
@RestController
public class VseProjectController {

    @Autowired
    private VseProjectService vseProjectService;

    private final Logger LOGGER = LoggerFactory.getLogger(getClass());


    @PostMapping("/createProject") /* This API  is  for Creating VshProject  */
    public String createVseProject(@RequestBody VseProject vseProject, @RequestParam Integer client,@RequestParam Integer projectManager,@RequestParam Integer teamLeader){
        LOGGER.info("VseProjectController :createVseProject is Started");
        return vseProjectService.createVseProject(vseProject, client, projectManager, teamLeader);
    }

//    @GetMapping("/getAllProject") /*This API is For Getting All project details*/
//    public List<ProjectDto>getAllProject(){
//        LOGGER.info("VseProjectController :GetAllProject is Started");
//        return vseProjectService.getAllProject();
//    }
//
//    @GetMapping("/getProject/{uuid}") /* This API is For Getting Details of Project by uuid */
//    public ProjectDto getProjectByUuid(@PathVariable String uuid){
//        LOGGER.info("VseProjectController :GetProject is Started");
//        return vseProjectService.getProjectByUuid(uuid);
//    }
//
//    @PutMapping("/deleteProject/{uuid}") /*This API is for deleting the project */
//    public String deleteProjectByUuid(@PathVariable String uuid,@RequestBody VseProject vseProject){
//        LOGGER.info("VseProjectController :Delete  Project is Started");
//        return vseProjectService.deleteProjectByUuid(uuid, vseProject);
//    }
//
//    @PutMapping("/updateProject/{uuid}") /*This API is For Updating Project */
//    public String updateProjectByUuid(@PathVariable String uuid,@RequestBody VseProject vseProject, @RequestParam Integer projectManager,@RequestParam Integer teamLeader){
//        LOGGER.info("VseProjectController :Update  Project is Started");
//        return vseProjectService.updateProjectByUuid(uuid, projectManager, teamLeader, vseProject);
//    }

}
