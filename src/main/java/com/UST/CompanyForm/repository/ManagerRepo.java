package com.UST.CompanyForm.repository;

import com.UST.CompanyForm.entity.Manager;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ManagerRepo extends JpaRepository<Manager,Long> {
}
