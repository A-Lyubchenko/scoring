package com.scoring.mywallet.services.registration;


import com.scoring.mywallet.domains.registration.Employee;
import com.scoring.mywallet.repositories.registration.EmployeeRepositories;
import com.scoring.mywallet.services.Crud;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class EmployeeService implements Crud<Employee> {

    @Autowired
    private EmployeeRepositories employeeRepositories;


    @Override
    public Employee save(Employee employee) {
        return employeeRepositories.save(employee);
    }

    @Override
    public List<Employee> getAll() {
        return employeeRepositories.findAll();
    }

    @Override
    public Employee update(Employee employee) {
        return employeeRepositories.save(employee);
    }

    @Override
    public void delete(Employee employee) {
        employeeRepositories.delete(employee);
    }

    @Override
    public Employee getById(UUID id) {
        Optional<Employee> byId = employeeRepositories.findById(id);
        return byId.orElse(null);
    }

    public Optional<Employee> findUserByUserName(String name) {
        Employee userByUsername = employeeRepositories.findUserByUsername(name);
        return Optional.ofNullable(userByUsername);

    }

//    public Optional<User> findUserByEmail(String email) {
//        User userByEmail = userRepositories.findUserByEmail(email);
//        return Optional.ofNullable(userByEmail);
//
//    }

//    public boolean userExistByName(String name) {
//        return findUserByUserName(name).isPresent();
//    }
}

//    public boolean isUniqueEmail(User user) {
//        User entity = userRepositories.findUserByEmail(user.getEmail());
//
//        if (entity == null) {
//            return true;
//        }
//
//        UUID userId = user.getId();
//        UUID entityId = entity.getId();
//
//        return userId.equals(entityId);
//    }

//    public boolean isUniqueUserName(User user) {
//        User entity = userRepositories.findUserByUsername(user.getUsername());
//
//        if (entity == null) {
//            return true;
//        }
//
//        UUID userId = user.getId();
//        UUID entityId = entity.getId();
//
//        return userId.equals(entityId);
//    }


