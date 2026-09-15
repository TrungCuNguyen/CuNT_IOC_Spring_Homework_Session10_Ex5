package org.example.ex4_5_ss10_ioc.controller;

import org.example.ex4_5_ss10_ioc.dto.request.DoctorDto;
import org.example.ex4_5_ss10_ioc.dto.response.ApiResponse;
import org.example.ex4_5_ss10_ioc.dto.response.PageMeta;
import org.example.ex4_5_ss10_ioc.entity.Doctor;
import org.example.ex4_5_ss10_ioc.service.DoctorService;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/doctors")
public class DoctorController {

    private final DoctorService doctorService;

    public DoctorController(DoctorService doctorService) {
        this.doctorService = doctorService;
    }

    // GET /api/v1/doctors?page=1&limit=10 -> Trả về danh sách có ApiResponse wrapper & meta
    @GetMapping
    public ResponseEntity<ApiResponse<List<Doctor>>> getDoctors(
            @RequestParam(defaultValue = "1") int page,
            @RequestParam(defaultValue = "10") int limit) {

        Page<Doctor> doctorPage = doctorService.getDoctors(page, limit);

        PageMeta meta = new PageMeta(
                doctorPage.getTotalElements(),
                page,
                limit,
                doctorPage.getTotalPages()
        );

        return ResponseEntity.ok(ApiResponse.success(doctorPage.getContent(), meta));
    }

    // GET /api/v1/doctors/{id} -> Trả về 1 bác sĩ hoặc 404 nếu không tìm thấy
//    @GetMapping("/{id}")
//    public ResponseEntity<ApiResponse<Doctor>> getDoctorById(@PathVariable Long id) {
//        Doctor doctor = doctorService.getDoctorById(id);
//        return ResponseEntity.ok(ApiResponse.success(doctor));
//    }

    // POST /api/v1/doctors -> Tạo mới bác sĩ
    @PostMapping
    public ResponseEntity<ApiResponse<Doctor>> createDoctor(@RequestBody Doctor doctor) {
        Doctor createdDoctor = doctorService.createDoctor(doctor);
        return ResponseEntity.status(HttpStatus.CREATED).body(ApiResponse.success(createdDoctor));
    }
}
