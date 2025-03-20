package mn.nomin.demo.services;

import mn.nomin.demo.core.BaseServiceImpl;
import mn.nomin.demo.entities.Employee;
import mn.nomin.demo.repositories.EmployeeRepository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

@Service
public class EmployeeServiceImpl extends BaseServiceImpl<Employee> implements EmployeeService {

    private final EmployeeRepository employeeRepository;

    public EmployeeServiceImpl(EmployeeRepository employeeRepository) {
        this.employeeRepository = employeeRepository;
    }

    @Override
    public JpaRepository<Employee, Long> getRepo() {
        return employeeRepository;
    }
}
