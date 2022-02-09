package com.scoring.mywallet.controllers.registration;

import com.scoring.mywallet.domains.registration.Employee;
import com.scoring.mywallet.domains.registration.EncodePassword;
import com.scoring.mywallet.services.registration.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.validation.Valid;


@Controller
@RequestMapping("registration")
public class RegistrationController {
    private final String userClassName = User.class.getSimpleName().toLowerCase();
    @Autowired
    private EmployeeService employeeService;
    @Autowired
    private EncodePassword encodePassword;

    @GetMapping("register")
    public String registerForm(@ModelAttribute("user") User user) {
        return "main/registration";
    }

    @PostMapping
    public String processRegistration(@Valid Employee employee, BindingResult bindingResult) {
        if (!employeeService.isUniqueUserName(user)) {
            bindingResult.addError(new FieldError(userClassName, User.Fields.username,
                    "Username already in use, choose other."));
        }
        if (!employeeService.isUniqueEmail(user)) {
            bindingResult.addError(new FieldError(userClassName, User.Fields.email,
                    "Email already in use, choose other."));
        }
        if (bindingResult.hasErrors())
            return "main/registration";


        String enPassword = encodePassword.encodePassword(employee.getPassword());
        employee.setPassword(enPassword);
        employeeService.save(employee);
        return "redirect:/login";
    }

    @GetMapping("index")
    public String mainPage() {
        return "main/index";
    }

}


