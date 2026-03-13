package com.hospital.main;

import java.util.Scanner;
import com.hospital.patient.Patient;
import com.hospital.service.HospitalService;
import com.hospital.exception.*;

public class Main {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        HospitalService service = new HospitalService();

        try {
            System.out.print("Enter Patient ID: ");
            int id = sc.nextInt();
            sc.nextLine();

            System.out.print("Enter Patient Name: ");
            String name = sc.nextLine();

            System.out.print("Enter Age: ");
            int age = sc.nextInt();
            sc.nextLine();

            System.out.print("Enter Disease: ");
            String disease = sc.nextLine();

            Patient p = new Patient(id, name, age, disease);

            service.addPatient(p);

            System.out.println("\nAll Patients in Hospital:");
            service.displayPatients();

            System.out.print("\nEnter Patient ID to search: ");
            int searchId = sc.nextInt();

            service.searchPatient(searchId);

        } catch (InvalidAgeException e) {
            System.out.println("Error: " + e.getMessage());
        } catch (DuplicatePatientException e) {
            System.out.println("Error: " + e.getMessage());
        } catch (PatientNotFoundException e) {
            System.out.println("Error: " + e.getMessage());
        } catch (Exception e) {
            System.out.println("Something went wrong: " + e.getMessage());
        }

        sc.close();
    }
}