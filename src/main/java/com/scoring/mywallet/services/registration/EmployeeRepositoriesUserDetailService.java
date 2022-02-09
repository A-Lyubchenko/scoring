package com.scoring.mywallet.services.registration;


import com.scoring.mywallet.domains.registration.Employee;
import com.scoring.mywallet.repositories.registration.EmployeeRepositories;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class EmployeeRepositoriesUserDetailService implements UserDetailsService {

    @Autowired
    private EmployeeRepositories userRepositories;


    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Employee employeeByUsername = userRepositories.findUserByUsername(username);
        if (employeeByUsername!=null)
            return employeeByUsername;
        throw new UsernameNotFoundException("User not found");
    }
}
