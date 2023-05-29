package com.vhyom.saas.repository;

import com.vhyom.saas.dto.VssSubscriptiondto;
import com.vhyom.saas.entity.VssSubscription;
import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;

@Repository
public interface SubscriptionRepository extends JpaRepository<VssSubscription,Integer> {
    @Transactional
    @Modifying
    @Query("INSERT INTO VssSubscription (planName,planPrice,planType,totalUsers,description,createdBy)VALUES(:planName,:planPrice,:planType,:totalUsers,:description,:createdBy)")
    void createSubsciption(@Param("planName")String planName,
                              @Param("planPrice") BigDecimal planPrice,
                              @Param("planType")Integer planType,
                              @Param("totalUsers")Integer totalUsers,
                              @Param("description")String description,
                              @Param("createdBy")Integer createdBy);

    boolean existsByPlanName(@Param("planName") String planName);


   @Query("SELECT new com.vhyom.saas.dto.VssSubscriptiondto (sub.uuid,sub.planName,sub.planPrice,sub.planType,sub.totalUsers,sub.description,sub.createdBy,sub.createdOn,sub.lastModifiedBy,sub.lastModifiedOn,sub.isActive) FROM VssSubscription sub")
   List<VssSubscriptiondto>getAllSubscription();

    @Query("SELECT new com.vhyom.saas.dto.VssSubscriptiondto (sub.uuid,sub.planName,sub.planPrice,sub.planType,sub.totalUsers,sub.description,sub.createdBy,sub.createdOn,sub.lastModifiedBy,sub.lastModifiedOn,sub.isActive) FROM VssSubscription sub WHERE sub.uuid=?1")
    VssSubscriptiondto getSubscriptionByUuid(String uuid);

    @Transactional
    @Modifying
    @Query(value ="UPDATE VssSubscription sub SET sub.isActive=:isActive,sub.lastModifiedOn=:lastModifiedOn,sub.lastModifiedBy=:lastModifiedBy Where sub.uuid=:uuid")
    void deleteSubscription(@Param("isActive") boolean isActive,
                            @Param("lastModifiedOn") LocalDateTime lastModifiedOn,
                            @Param("lastModifiedBy") Integer lastModifiedBy,
                            @Param("uuid")String uuid);
    @Transactional
    @Modifying
    @Query(value = "UPDATE VssSubscription sub SET sub.planName=:planName, sub.planPrice=:planPrice,sub.planType=:planType,sub.totalUsers=:totalUsers,sub.description=:description,sub.lastModifiedBy=:lastModifiedBy,sub.lastModifiedOn=:lastModifiedOn WHERE sub.uuid=:uuid")
    void updateSubscriptionByUuid(@Param("planName") String planName,
                                  @Param("planPrice") BigDecimal planPrice,
                                  @Param("planType") Integer planType,
                                  @Param("totalUsers") Integer totalUsers,
                                  @Param("description") String description,
                                  @Param("lastModifiedBy") Integer lastModifiedBy,
                                  @Param("lastModifiedOn") LocalDateTime lastModifiedOn,
                                  @Param("uuid")String uuid);

    VssSubscription findByUuid(String uuid);
}


