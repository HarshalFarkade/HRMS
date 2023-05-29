package com.vhyom.saas.repository;

import com.vhyom.saas.dto.OvertimeRequestDto;
import com.vhyom.saas.entity.VseOvertimeRequest;
import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

@Repository
public interface OvertimeRequestRepository extends JpaRepository<VseOvertimeRequest,Integer> {

@Transactional
@Modifying
@Query("INSERT INTO VseOvertimeRequest (user, category, fromDate, toDate, notes, createdBy) " +
        "SELECT emp,cat, :fromDate, :toDate, :notes, :createdBy " +
        "FROM VshEmployee emp, VshOvertimeCategory cat " +
        "WHERE emp.id = :user AND cat.id = :category")
void createOvertimeRequest(@Param("user") Integer user,
                           @Param("category") Integer category,
                           @Param("fromDate") LocalDate fromDate,
                           @Param("toDate") LocalDate toDate,
                           @Param("notes") String notes,
                           @Param("createdBy") Integer createdBy);

    @Query("SELECT new com.vhyom.saas.dto.OvertimeRequestDto  (over.uuid,over.user.id,over.category.id,over.fromDate,over.toDate,over.notes,over.createdBy,over.createdOn,over.lastModifiedBy,over.lastModifiedOn,over.isActive) FROM VseOvertimeRequest over")
    List<OvertimeRequestDto> getAllOvertimeRequest();

    @Query("SELECT new com.vhyom.saas.dto.OvertimeRequestDto  (over.uuid,over.user.id,over.category.id,over.fromDate,over.toDate,over.notes,over.createdBy,over.createdOn,over.lastModifiedBy,over.lastModifiedOn,over.isActive) FROM VseOvertimeRequest over Where over.uuid=?1")
    OvertimeRequestDto getAllOvertimeRequestByUuid(String uuid);

//    @Transactional
//    @Modifying
//    @Query(value = "UPDATE VseOvertimeRequest over SET over.lastModifiedBy=:lastModifiedBy, over.lastModifiedOn=:lastModifiedOn, over.isActive=:isActive Where over.uuid=:uuid ")
//    void deleteOvertimeRequestByUuid(@Param("lastModifiedBy")Integer lastModifiedBy,
//                                     @Param("lastModifiedOn")LocalDateTime lastModifiedOn,
//                                     @Param("isActive") boolean isActive,
//                                     @Param("uuid")String uuid);
//    @Transactional
//    @Modifying
//    @Query(value = "UPDATE VseOvertimeRequest over SET over.category.id=:category, over.fromDate=:fromDate,over.toDate=:toDate,over.notes=:notes,over.lastModifiedBy=:lastModifiedBy,over.lastModifiedOn=:lastModifiedOn Where over.uuid=:uuid")
//    void updateOvertimeRequestByUuid(@Param("category") Integer category,
//                                     @Param("fromDate") LocalDate fromDate,
//                                     @Param("toDate") LocalDate toDate,
//                                     @Param("notes")String notes,
//                                     @Param("lastModifiedBy") Integer lastModifiedBy,
//                                     @Param("lastModifiedOn") LocalDateTime lastModifiedOn,
//                                     @Param("uuid")String uuid);
}
