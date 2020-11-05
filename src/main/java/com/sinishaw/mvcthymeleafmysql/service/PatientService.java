package com.sinishaw.mvcthymeleafmysql.service;

import com.sinishaw.mvcthymeleafmysql.model.Patient;
import com.sinishaw.mvcthymeleafmysql.repository.PatientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PatientService {

    private PatientRepository patientRepository;

    @Autowired
    public PatientService(PatientRepository patientRepository) {
        this.patientRepository = patientRepository;
    }

    public Patient addPatient(Patient patient){
        return patientRepository.save(patient);
    }
}
