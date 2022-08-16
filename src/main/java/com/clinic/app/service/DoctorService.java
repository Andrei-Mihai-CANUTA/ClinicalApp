package com.clinic.app.service;

import com.clinic.app.entity.Department;
import com.clinic.app.entity.Doctor;
import com.clinic.app.repository.DoctorRepository;
import com.clinic.app.service.dto.DoctorDTO;
import com.clinic.app.service.mapper.DoctorMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@Service
@Transactional
public class DoctorService {

    private final DoctorRepository doctorRepository;
    private final DoctorMapper doctorMapper;

    public DoctorService(DoctorRepository doctorRepository, DoctorMapper doctorMapper) {
        this.doctorRepository = doctorRepository;
        this.doctorMapper = doctorMapper;
    }

    public void save(Department department, DoctorDTO doctorDTO) {
        Doctor doctor = doctorMapper.toEntity(doctorDTO);
        doctor.setDepartment(department);
        doctorRepository.save(doctor);
    }
}