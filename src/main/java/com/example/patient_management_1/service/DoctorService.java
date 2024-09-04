package com.example.patient_management_1.service;

import java.util.NoSuchElementException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.patient_management_1.entity.Doctor;
import com.example.patient_management_1.repository.DoctorRepository;

@Service
public class DoctorService {
    
    @Autowired
    DoctorRepository doctorRepository;

    public Doctor getDoctorById(Long id){
        Doctor doctor = doctorRepository.findById(id).get();
        if (doctor == null) {
            throw new NoSuchElementException("doctor not found by id: " + id);
        }

        return doctor;
    }

    public void saveDoctor(Doctor doctor){
        Doctor dr = doctorRepository.findById(doctor.getId()).get();
        if (dr == null) {
            throw new NoSuchElementException("doctor not found by id: " + doctor.getId());
        }
        doctorRepository.save(doctor);
    }

    public void updateDoctor(Doctor doctor){
        Doctor dr = doctorRepository.findById(doctor.getId()).get();
        if (dr == null) {
            throw new NoSuchElementException("doctor not found by id: " + doctor.getId());
        }
        doctorRepository.save(doctor);
    }

    public void deleteDoctorById(Long id){
        Doctor doctor = doctorRepository.findById(id).get();
        if (doctor == null) {
            throw new NoSuchElementException("doctor not found by id: " + id);
        }
        doctorRepository.deleteById(id);
    }
}
