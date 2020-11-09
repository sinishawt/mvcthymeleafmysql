package com.sinishaw.mvcthymeleafmysql.controller;

import com.sinishaw.mvcthymeleafmysql.model.Patient;
import com.sinishaw.mvcthymeleafmysql.model.Patients;
import com.sinishaw.mvcthymeleafmysql.service.PatientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import javax.validation.Valid;

@Controller
public class QuickAddPatientController {

    private PatientService patientService;

    @Autowired
    public QuickAddPatientController(PatientService patientService) {
        this.patientService = patientService;
    }

    @GetMapping("/add_patient_default")
    public String addPatientDefault(Model model){
        model.addAttribute("patient", new Patient());

        return "add_patient";
    }

    @PostMapping("/add_patient")
    public String addPatient(@Valid Patient patient, BindingResult result, Model model){
        Patient p = patientService.addPatient(patient);
       // System.out.println("date is" + patient.getDos());
        System.out.println("added Patient" + p.toString());
        return "redirect:/index";
    }

    @PostMapping("/bulk_add")
    public String bulkAddPatient(@Valid Patients patients, BindingResult result, Model model){
        for(Patient p: patients.getPatients()){
            patientService.addPatient(p);
        }
        return "redirect:/index";
    }


}
