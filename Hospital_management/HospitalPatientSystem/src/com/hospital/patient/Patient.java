package com.hospital.patient;

public class Patient {

    int patientId;
    String patientName;
    int age;
    String disease;

    public Patient(int patientId, String patientName, int age, String disease)
    {
        this.patientId =patientId;
        this.patientName =patientName;
        this.age =age;
        this.disease =disease;
    }
    public int getPatientId()
    {
        return patientId;
    }
    public String getPatientName()
    {
        return patientName;
    }
    public int getAge()
    {
        return age;
    }
    public String getDisease()
    {
        return disease;
    }
    public void setPatientId(int patientId)
    {
        this.patientId =patientId;
    }
    public void setPatientName(String patientName)
    {
        this.patientName =patientName;
    }
    public void setAge(int age)
    {
        this.age =age;
    }
    public void setDisease(String disease)
    {
        this.disease =disease;
    }
    public void displayPatient()
    {
        System.out.println("Patient Id: " + patientId);
        System.out.println("Patient Name: " + patientName);
        System.out.println("Age: " + age);
        System.out.println("Disease: "+ disease);
    }
}
