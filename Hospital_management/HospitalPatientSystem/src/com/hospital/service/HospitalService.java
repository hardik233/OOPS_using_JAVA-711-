package com.hospital.service;

import java.util.ArrayList;
import com.hospital.patient.Patient;
import com.hospital.exception.*;

public class HospitalService {

    ArrayList<Patient> patients = new ArrayList<Patient>();

    public void addPatient(Patient p) throws Exception {

        if(p.age < 0 || p.age > 120) {
            throw new InvalidAgeException("Invalid Age");
        }

        for(Patient temp : patients){
            if(temp.patientId == p.patientId){
                throw new DuplicatePatientException("Patient already exists");
            }
        }

        patients.add(p);

        if(p.age > 60 && p.disease.equalsIgnoreCase("Heart Problem")) {
            System.out.println("Priority Patient – Immediate Attention Required");
        }

        System.out.println("Patient added successfully");
    }

    public void displayPatients() {

        System.out.println("All Patients:");

        for(Patient p : patients){
            System.out.println(p.patientId + "," + p.patientName + "," + p.age + "," + p.disease);
        }
    }

    public void searchPatient(int pid) throws Exception {

        boolean found = false;

        for(Patient p : patients){
            if(p.patientId == pid){
                System.out.println("Patient Found: " + p.patientId + "," + p.patientName + "," + p.age + "," + p.disease);
                found = true;
                break;
            }
        }

        if(!found){
            throw new PatientNotFoundException("Patient not found");
        }
    }
}