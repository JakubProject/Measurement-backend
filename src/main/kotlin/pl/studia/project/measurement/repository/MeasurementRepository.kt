package pl.studia.project.measurement.repository

import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.data.jpa.repository.Query
import org.springframework.stereotype.Repository
import pl.studia.project.measurement.dao.Measurement

// WARSTA KOMUNIKACJI Z BAZĄ DANYCH
// ZAPYTANIA SQL SĄ GENEROWANE AUTOMATYCZNIE PRZEZ JPA


// JPA - Spring Boot JPA is a Java specification
// for managing relational data in Java applications.
// It allows us to access and persist data
// between Java object/ class and relational database.
// JPA follows Object-Relation Mapping (ORM).
@Repository
interface MeasurementRepository : JpaRepository<Measurement, Long>

