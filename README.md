# EMS
 Full Stack Employee Management System

# Details

Projects based on 'Full-Stack Java Development with Spring Boot 3 & React - Ramesh Fadatare (Java Guides)'

# Backend

Backend powered by java and spring boot. 
1. CRUD operations handles through APIs created using controllers. 
2. Controllers convert the incoming json object to Data Transfer Object (DTO) using @RequestBody annotation. DTOs are used to transfer data between client and server. DTOs need to resemble the incoming json.
3. DTOs received need to be converted to entity objects for storing in database using mapper. Each entity corresponds to a table in the database, and each instance of an entity corresponds to a row in that table.
4. Once DTO is converted to entity, it is ready for DB operations. DB operations are handled using JpaRepository. Each operation is mentioned in Services.
