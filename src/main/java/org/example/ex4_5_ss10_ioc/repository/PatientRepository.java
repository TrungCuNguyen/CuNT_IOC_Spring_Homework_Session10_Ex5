package org.example.ex4_5_ss10_ioc.repository;

import org.example.ex4_5_ss10_ioc.entity.Patient;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PatientRepository extends JpaRepository<Patient, Long> {
}
