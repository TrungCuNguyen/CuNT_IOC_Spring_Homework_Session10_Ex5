package org.example.ex4_5_ss10_ioc.service;

import org.example.ex4_5_ss10_ioc.entity.Doctor;
import org.example.ex4_5_ss10_ioc.repository.DoctorRepository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public class DoctorService {

    private final DoctorRepository doctorRepository;

    public DoctorService(DoctorRepository doctorRepository) {
        this.doctorRepository = doctorRepository;
    }

    // Lấy danh sách bác sĩ có phân trang
    public Page<Doctor> getDoctors(int page, int limit) {
        Pageable pageable = PageRequest.of(page - 1, limit);
        return doctorRepository.findAll(pageable);
    }

    // Lấy bác sĩ theo ID
//    public Doctor getDoctorById(Long id) {
//        return doctorRepository.findById(id)
//                .orElseThrow(() -> new ResourceNotFoundException("Không tìm thấy bác sĩ với ID: " + id));
//    }

    // Tạo mới bác sĩ
    public Doctor createDoctor(Doctor doctor) {
        return doctorRepository.save(doctor);
    }
}
