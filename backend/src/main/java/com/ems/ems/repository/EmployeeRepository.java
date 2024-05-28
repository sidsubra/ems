package com.ems.ems.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.ems.ems.entity.Employee;

//Repository is a middleman between your application code and the database that abstracts away the complexity of interacting with the database directly.
//JpaRepository is a repository provided by the Spring Data JPA framework, designed to work with JPA (Java Persistence API)
//By extending JpaRepository, it inherits a set of methods such as save, findById, findAll, delete, etc., which can be used to perform common database operations, without needing to write SQL queries manually.

public interface EmployeeRepository extends JpaRepository<Employee,Long> {

}
