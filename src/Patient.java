import java.util.*;

public class Patient {
    private String patientId;
    private String name;
    private int age;
    private String contactNumber;
    private String address;
    private List<String> medicalHistory;

    public Patient() {
        this.medicalHistory = new ArrayList<>();
    }

    public void setPatientDetails(String patientId, String name, int age, String contactNumber, String address) {
        this.patientId = patientId;
        this.name = name;
        this.age = age;
        this.contactNumber = contactNumber;
        this.address = address;
    }

    public void addMedicalHistory(String diagnosis, String treatment) {
        medicalHistory.add("Diagnosis: " + diagnosis + ", Treatment: " + treatment);
    }

    public void displayPatientDetails() {
        System.out.println("Patient ID: " + patientId);
        System.out.println("Name: " + name);
        System.out.println("Age: " + age);
        System.out.println("Contact Number: " + contactNumber);
        System.out.println("Address: " + address);
        System.out.println("Medical History: " + medicalHistory);
    }

    public String getPatientId() {
        return patientId;
    }
}
