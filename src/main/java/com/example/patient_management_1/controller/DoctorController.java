package com.example.patient_management_1.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.patient_management_1.entity.Doctor;
import com.example.patient_management_1.service.DoctorService;

@RestController
@RequestMapping("/doctor")
public class DoctorController {
    
    @Autowired
    DoctorService doctorService;

    @GetMapping("/{id}")
    public Doctor getDoctorById(@PathVariable Long id){
        return doctorService.getDoctorById(id);
    }

    @PostMapping("/add/{patientId}")
    public void saveDoctorForPatient(@PathVariable Long patientId, @RequestBody Doctor doctor){
        doctorService.saveDoctor(patientId,doctor);
    }

    @PutMapping("/update")
    public void updateDoctor(@RequestBody Doctor doctor){
        doctorService.updateDoctor(doctor);
    }
}
