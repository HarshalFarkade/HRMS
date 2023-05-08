package com.vhyom.saas.repository;

import com.vhyom.saas.entity.VshEmployee;
import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import java.time.LocalDateTime;
import java.util.Date;

@Repository
public interface EmployeeRepository extends JpaRepository<VshEmployee,Integer> {

    @Transactional
    @Modifying
    @Query(value = "INSERT INTO VshEmployee(partnerId,partnerNumber,emailId,password,salt,profilePhoto,firstName,lastName,dateOfBirth,mobileNumber,phoneNumber,createdBy)VALUES(:partnerId,:partnerNumber,:emailId,:password,:salt,:profilePhoto,:firstName,:lastName,:dateOfBirth,:mobileNumber,:phoneNumber,:createdBy)")
    void createEmployee(@Param("partnerId")Integer partnerId,
                        @Param("partnerNumber")String partnerNumber,
                        @Param("emailId")String emailId,
                        @Param("password") String password,
                        @Param("salt")String salt,
                        @Param("profilePhoto")String profilePhoto,
                        @Param("firstName")String firstName,
                        @Param("lastName")String lastName,
                        @Param("dateOfBirth")Date dateOfBirth,
                        @Param("mobileNumber") String mobileNumber,
                        @Param("phoneNumber")String phoneNumber,
                        @Param("createdBy") int createdBy);


    boolean existsByEmailId(String value);

}
