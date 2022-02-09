package com.scoring.mywallet.repositories.registration;


import com.scoring.mywallet.domains.registration.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface EmployeeRepositories extends JpaRepository<Employee, UUID> {
    Employee findUserByUsername(String username);
    Employee findUserByEmail(String email);
}
