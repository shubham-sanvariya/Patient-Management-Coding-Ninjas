package com.example.patient_management_1.repository;

import org.springframework.data.repository.CrudRepository;
import com.example.patient_management_1.entity.Doctor;

public interface DoctorRepository extends CrudRepository<Doctor,Long>{
    
}
