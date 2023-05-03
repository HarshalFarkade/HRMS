package com.vhyom.saas.repository;

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

    //@Query("SELECT CASE WHEN COUNT(s) > 0 THEN true ELSE false END FROM VssSubscription s WHERE s.planType = :planType")
    //boolean existsByPlanType(@Param("planType") String planType);

   @Query("SELECT sub.planName,sub.planPrice,sub.planType,sub.totalUsers,sub.description,sub.createdBy,sub.createdOn,sub.lastModifiedBy,sub.lastModifiedOn,sub.isActive FROM VssSubscription sub")
   List<Object[]>getAllSubscription();

    @Query("SELECT sub.planName,sub.planPrice,sub.planType,sub.totalUsers,sub.description,sub.createdBy,sub.createdOn,sub.lastModifiedBy,sub.lastModifiedOn,sub.isActive FROM VssSubscription sub WHERE sub.uuid=?1")
    List<Object[]>getSubscriptionByUuid(String uuid);

}


