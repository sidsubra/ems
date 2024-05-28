package com.ems.ems.service.Implementation;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import com.ems.ems.dto.EmployeeDto;
import com.ems.ems.entity.Employee;
import com.ems.ems.exception.ResourceNotFoundException;
import com.ems.ems.mapper.EmployeeMapper;
import com.ems.ems.repository.EmployeeRepository;
import com.ems.ems.service.EmployeeService;

import lombok.AllArgsConstructor;


@Service
@AllArgsConstructor
public class EmployeeServiceImpl implements EmployeeService{

    private EmployeeRepository employeeRepository;

    @Override
    public EmployeeDto createEmployee(EmployeeDto employeeDto) {
        //To create employee - Received DTO needs to be converted to an employee entity object
        Employee employee = EmployeeMapper.mapToEmployee(employeeDto);
        //Entity object passed to database using the repository
        Employee savedEmployee = employeeRepository.save(employee);
        //Saved dto(data) is returned
        return EmployeeMapper.mapToEmployeeDto(savedEmployee);
    }

    @Override
    public EmployeeDto getEmployeeById(Long Id) {
       Employee employee = employeeRepository.findById(Id)
       .orElseThrow(() -> new ResourceNotFoundException("Employee does not exist with the given id :"+Id));
       return EmployeeMapper.mapToEmployeeDto(employee);
    }

     @Override
    public List<EmployeeDto> getAllEmployees() {
        List<Employee> employees = employeeRepository.findAll();
        return employees.stream().map((employee) -> EmployeeMapper.mapToEmployeeDto(employee))
                .collect(Collectors.toList());
    }

    @Override
    public EmployeeDto updateEmployee(Long employeeId, EmployeeDto updatedEmployee) {

        Employee employee = employeeRepository.findById(employeeId).orElseThrow(
                () -> new ResourceNotFoundException("Employee does not exist with the given id: " + employeeId)
        );

        employee.setFirstName(updatedEmployee.getFirstName());
        employee.setLastName(updatedEmployee.getLastName());
        employee.setEmail(updatedEmployee.getEmail());

        Employee updatedEmployeeObj = employeeRepository.save(employee);

        return EmployeeMapper.mapToEmployeeDto(updatedEmployeeObj);
    }

    @Override
    public void deleteEmployee(Long employeeId) {
        employeeRepository.deleteById(employeeId);
    }

    
    
}
