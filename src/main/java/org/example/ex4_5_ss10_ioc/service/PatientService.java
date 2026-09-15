package org.example.ex4_5_ss10_ioc.service;

import org.example.ex4_5_ss10_ioc.entity.Patient;
import org.example.ex4_5_ss10_ioc.exception.ResourceNotFoundException;
import org.example.ex4_5_ss10_ioc.repository.PatientRepository;
import org.springframework.stereotype.Service;

@Service
public class PatientService {

    private final PatientRepository patientRepository;

    public PatientService(PatientRepository patientRepository) {
        this.patientRepository = patientRepository;
    }

    public Patient getPatientById(Long id) {
        return patientRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Không tìm thấy bệnh nhân với ID: " + id));
    }

    public Patient createPatient(Patient patient) {
        return patientRepository.save(patient);
    }
}
