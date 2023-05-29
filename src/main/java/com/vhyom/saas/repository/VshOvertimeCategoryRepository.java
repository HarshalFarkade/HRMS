package com.vhyom.saas.repository;

import com.vhyom.saas.entity.VshOvertimeCategory;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface VshOvertimeCategoryRepository extends JpaRepository<VshOvertimeCategory,Integer> {

}
