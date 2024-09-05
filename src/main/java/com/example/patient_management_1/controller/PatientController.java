package com.example.patient_management_1.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.patient_management_1.entity.Patient;
import com.example.patient_management_1.service.PatientService;

@RestController
@RequestMapping("/patient")
public class PatientController {
    
    @Autowired
    PatientService patientService;

    @GetMapping("/{id}")
    public Patient getPatientById(@PathVariable Long id){
        return patientService.getPatientById(id);
    }

    @PostMapping("/add")
    public void savePatient(@RequestBody Patient patient){
        patientService.savePatient(patient);
    }
}
