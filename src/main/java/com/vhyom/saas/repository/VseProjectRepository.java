package com.vhyom.saas.repository;

import com.vhyom.saas.dto.ProjectDto;
import com.vhyom.saas.entity.VseProject;
import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

@Repository
public interface VseProjectRepository extends JpaRepository<VseProject ,Integer> {

    @Transactional
    @Modifying
    @Query("INSERT INTO VseProject (client, projectManager, teamLeader, name, description, startDate, endDate, rate, rateType, createdBy) " +
            "SELECT cli, emp, employee, :name, :description, :startDate, :endDate, :rate, :rateType, :createdBy " +
            "FROM VseClient cli, VshEmployee emp, VshEmployee employee " +
            "WHERE cli.id = :client AND emp.id = :projectManager AND employee.id = :teamLeader")
    void createVseProject(@Param("client") Integer client,
                          @Param("projectManager") Integer projectManager,
                          @Param("teamLeader") Integer teamLeader,
                          @Param("name") String name,
                          @Param("description") String description,
                          @Param("startDate") LocalDate startDate,
                          @Param("endDate") LocalDate endDate,
                          @Param("rate") BigDecimal rate,
                          @Param("rateType") Integer rateType,
                          @Param("createdBy") Integer createdBy);

    @Query("SELECT new com.vhyom.saas.dto.ProjectDto(pro.uuid,pro.client.id,pro.name,pro.description,pro.startDate,pro.endDate,pro.rate,pro.rateType,pro.projectManager.id,pro.teamLeader.id,pro.createdBy,pro.createdOn,pro.lastModifiedBy,pro.lastModifiedOn,pro.isActive) FROM VseProject pro")
    List<ProjectDto> getAllProject();


//    @Query("SELECT new com.vhyom.saas.dto.ProjectDto(pro.uuid,pro.client.id,pro.name,pro.description,pro.startDate,pro.endDate,pro.rate,pro.rateType,pro.projectManager.id,pro.teamLeader.id,pro.createdBy,pro.createdOn,pro.lastModifiedBy,pro.lastModifiedOn,pro.isActive) FROM VseProject pro Where pro.uuid=?1")
//    ProjectDto getProjectByUuid(String uuid);

//    @Transactional
//    @Modifying
//    @Query(value = "UPDATE VseProject pro SET pro.lastModifiedBy=:lastModifiedBy,pro.lastModifiedOn=:lastModifiedOn,pro.isActive=:isActive Where pro.uuid =:uuid")
//    void deleteProjectByUuid(@Param("lastModifiedBy")Integer lastModifiedBy,
//                             @Param("lastModifiedOn")LocalDateTime lastModifiedOn,
//                             @Param("isActive")boolean isActive,
//                             @Param("uuid")String uuid);


//    @Transactional
//    @Modifying
//    @Query(value = "UPDATE VseProject pro SET pro.projectManager.id=:projectManager,pro.teamLeader.id=:teamLeader,pro.startDate=:startDate,pro.endDate=:endDate,pro.lastModifiedBy=:lastModifiedBy,pro.lastModifiedOn=:lastModifiedOn Where pro.uuid=:uuid ")
//    void updateProjectByUuid(@Param("projectManager")Integer projectManager,
//                             @Param("teamLeader")Integer teamLeader,
//                             @Param("startDate") LocalDate startDate,
//                             @Param("endDate")LocalDate endDate,
//                             @Param("lastModifiedBy")Integer lastModifiedBy,
//                             @Param("lastModifiedOn") LocalDateTime lastModifiedOn,
//                             @Param("uuid")String uuid);






}
