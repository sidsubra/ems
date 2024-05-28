//Employee class maps to a table named employees in database
//JPA (Java Persistence API) is a framework to map Java objects to database tables and vice versa
//JPA itself does not provide the actual implementation but rather specifies the rules that implementations should follow.
// Hibernate is an implementation of the JPA specification.  Hibernate is a tool that follows the rules laid out by JPA to make database interactions in Java applications easier and more efficient.

package com.ems.ems.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
//@Entity - This annotation marks the class as a JPA entity, indicating that instances of this class are mapped to records in a relational database table.
@Entity
@Table(name = "employees")
public class Employee {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id;

    @Column(name = "first_name")
    private String firstName;

    @Column(name = "last_name")
    private String lastName;

    @Column(name = "email_id",nullable = false,unique = true)
    private String email;
}
