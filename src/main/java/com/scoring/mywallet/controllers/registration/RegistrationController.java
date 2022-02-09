package com.scoring.mywallet.controllers.registration;

import com.scoring.mywallet.domains.registration.Employee;
import com.scoring.mywallet.domains.registration.EncodePassword;
import com.scoring.mywallet.services.registration.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.web.bind.annotation.*;



@RestController
@RequestMapping("api")
public class RegistrationController {

    @Autowired
    private EmployeeService employeeService;
    @Autowired
    private EncodePassword encodePassword;


    @PostMapping
    public Employee processRegistration(Employee employee) {
        String enPassword = encodePassword.encodePassword(employee.getPassword());
        employee.setPassword(enPassword);
       return employeeService.save(employee);


    }

}


