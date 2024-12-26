import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        Map<String, Patient> patients = new HashMap<>();
        Map<String, Doctor> doctors = new HashMap<>();
        List<Appointment> appointments = new ArrayList<>();
        List<Billing> bills = new ArrayList<>();

        Doctor doctor1 = new Doctor();
        doctor1.setDoctorDetails("D001", "Dr. Sunil", Arrays.asList("specialization 1", "specialization 2"));
        doctor1.addSlot("Monday", "10:00 AM");
        doctor1.addSlot("Monday", "10:30 AM");
        doctor1.addSlot("Monday", "11:00 AM");
        doctor1.addSlot("Monday", "11:30 AM");
        doctor1.addSlot("Monday", "12:00 PM");

        doctor1.addSlot("Wednesday", "10:00 AM");
        doctor1.addSlot("Wednesday", "10:30 AM");
        doctor1.addSlot("Wednesday", "11:00 AM");
        doctor1.addSlot("Wednesday", "11:30 AM");
        doctor1.addSlot("Wednesday", "12:00 PM");

        doctor1.addSlot("Friday", "10:00 AM");
        doctor1.addSlot("Friday", "10:30 AM");
        doctor1.addSlot("Friday", "11:00 AM");
        doctor1.addSlot("Friday", "11:30 AM");
        doctor1.addSlot("Friday", "12:00 PM");

        doctors.put(doctor1.getDoctorId(), doctor1);

        Doctor doctor2 = new Doctor();
        doctor2.setDoctorDetails("D002", "Dr. Jayanthi", Arrays.asList("specialization 3", "specialization 4"));
        doctor2.addSlot("Tuesday", "10:00 AM");
        doctor2.addSlot("Tuesday", "10:30 AM");
        doctor2.addSlot("Tuesday", "11:00 AM");
        doctor2.addSlot("Tuesday", "11:30 AM");
        doctor2.addSlot("Tuesday", "12:00 PM");

        doctor2.addSlot("Saturday", "10:00 AM");
        doctor2.addSlot("Saturday", "10:30 AM");
        doctor2.addSlot("Saturday", "11:00 AM");
        doctor2.addSlot("Saturday", "11:30 AM");
        doctor2.addSlot("Saturday", "12:00 PM");

        doctors.put(doctor2.getDoctorId(), doctor2);

        Patient patient1 = new Patient();
        patient1.setPatientDetails("P001", "Manusha", 22, "0758908057", "17D, somewhere, gampaha");
        patients.put(patient1.getPatientId(), patient1);

        Patient patient2 = new Patient();
        patient2.setPatientDetails("P002", "Nirmal", 22, "0712580691", "18D, somewhere Gampaha");
        patients.put(patient2.getPatientId(), patient2);

        // Main Menu
        while (true) {
            System.out.println("\n=== Hospital Management System ===");
            System.out.println("1. Register a New Patient");
            System.out.println("2. View Patient Details");
            System.out.println("3. Add Doctor");
            System.out.println("4. View Doctor Details");
            System.out.println("5. Book an Appointment");
            System.out.println("6. Add Medical History");
            System.out.println("7. Generate Bill");
            System.out.println("8. Exit");
            System.out.print("Enter your choice: ");
            int optionChoice = scanner.nextInt();

            switch (optionChoice) {
                case 1: // Register a new patient
                    System.out.print("Enter Patient ID: ");
                    String newPatientId = scanner.next();
                    System.out.print("Enter Name: ");
                    scanner.nextLine();
                    String newName = scanner.nextLine();
                    System.out.print("Enter Age: ");
                    int newAge = scanner.nextInt();
                    System.out.print("Enter Contact Number: ");
                    String newContact = scanner.next();
                    System.out.print("Enter Address: ");
                    scanner.nextLine();
                    String newAddress = scanner.nextLine();

                    Patient newPatient = new Patient();
                    newPatient.setPatientDetails(newPatientId, newName, newAge, newContact, newAddress);
                    patients.put(newPatientId, newPatient);
                    System.out.println("Patient registered successfully!");
                    break;

                case 2: // View patient details
                    System.out.print("Enter Patient ID: ");
                    String patientId = scanner.next();
                    Patient patient = patients.get(patientId);
                    if (patient != null) {
                        patient.displayPatientDetails();
                    } else {
                        System.out.println("Patient not found.");
                    }
                    break;

                case 3: // Add a doctor
                    System.out.print("Enter Doctor ID: ");
                    String newDoctorId = scanner.next();
                    System.out.print("Enter Name: ");
                    scanner.nextLine();
                    String newDoctorName = scanner.nextLine();
                    System.out.print("Enter Specializations (comma-separated): ");
                    String specializations = scanner.nextLine();
                    List<String> specializationList = Arrays.asList(specializations.split(","));

                    Doctor newDoctor = new Doctor();
                    newDoctor.setDoctorDetails(newDoctorId, newDoctorName, specializationList);
                    doctors.put(newDoctorId, newDoctor);

                    // Add slots for the new doctor
                    while (true) {
                        System.out.print("Do you want to add a slot for this doctor? (yes/no): ");
                        String slotAddingChoice = scanner.next().toLowerCase();
                        scanner.nextLine(); // Consume newline
                        if (slotAddingChoice.equals("yes")) {
                            System.out.print("Enter Day (e.g., Monday): ");
                            String day = scanner.nextLine();
                            System.out.print("Enter Time Slot (e.g., 10:00 AM): ");
                            String timeSlot = scanner.nextLine();
                            newDoctor.addSlot(day, timeSlot);
                            System.out.println("Slot added successfully!");
                        } else if (slotAddingChoice.equals("no")) {
                            break;
                        } else {
                            System.out.println("Invalid input. Please type 'yes' or 'no'.");
                        }
                    }

                    System.out.println("Doctor added successfully!");
                    break;

                case 4: // View doctor details
                    System.out.print("Enter Doctor ID: ");
                    String doctorId = scanner.next();
                    Doctor doctor = doctors.get(doctorId);
                    if (doctor != null) {
                        doctor.displayDoctorDetails();
                    } else {
                        System.out.println("Doctor not found.");
                    }
                    break;

                case 5: // Book an appointment
                    System.out.print("Enter Patient ID: ");
                    String apPatientId = scanner.next();
                    Patient apPatient = patients.get(apPatientId);

                    if (apPatient == null) {
                        System.out.println("Invalid Patient ID.");
                        break;
                    }

                    System.out.print("Enter Doctor ID: ");
                    String apDoctorId = scanner.next();
                    Doctor apDoctor = doctors.get(apDoctorId);

                    if (apDoctor == null) {
                        System.out.println("Invalid Doctor ID.");
                        break;
                    }

                    System.out.print("Enter Appointment Date (e.g., Monday): ");
                    String apDate = scanner.next();

                    System.out.println("Available Slots:");
                    List<String> availableSlots = apDoctor.getSchedule().get(apDate);
                    if (availableSlots == null || availableSlots.isEmpty()) {
                        System.out.println("No slots available for the selected date.");
                        break;
                    }

                    for (int i = 0; i < availableSlots.size(); i++) {
                        System.out.println((i + 1) + ". " + availableSlots.get(i));
                    }

                    System.out.print("Choose a slot: ");
                    int slotChoice = scanner.nextInt();
                    if (slotChoice < 1 || slotChoice > availableSlots.size()) {
                        System.out.println("Invalid choice.");
                        break;
                    }

                    String chosenSlot = availableSlots.get(slotChoice - 1);
                    apDoctor.removeSlot(apDate, chosenSlot);

                    String appointmentId = "A" + (appointments.size() + 1);
                    Appointment newAppointment = new Appointment(appointmentId, apPatientId, apDoctorId, apDate + " " + chosenSlot, false);
                    appointments.add(newAppointment);
                    System.out.println("Appointment booked successfully!");
                    break;

                case 6: // Add medical history
                    System.out.print("Enter Patient ID: ");
                    String mhPatientId = scanner.next();
                    Patient mhPatient = patients.get(mhPatientId);

                    if (mhPatient == null) {
                        System.out.println("Invalid Patient ID.");
                        break;
                    }

                    System.out.print("Enter Diagnosis: ");
                    scanner.nextLine(); // consume newline
                    String diagnosis = scanner.nextLine();
                    System.out.print("Enter Treatment: ");
                    String treatment = scanner.nextLine();
                    mhPatient.addMedicalHistory(diagnosis, treatment);
                    System.out.println("Medical history updated successfully!");
                    break;

                case 7: // Generate a bill
                    System.out.print("Enter Appointment ID: ");
                    String billAppointmentId = scanner.next();
                    Appointment billAppointment = appointments.stream()
                            .filter(appointment -> appointment.getAppointmentId().equals(billAppointmentId))
                            .findFirst()
                            .orElse(null);

                    if (billAppointment == null) {
                        System.out.println("Invalid Appointment ID.");
                        break;
                    }

                    System.out.print("Enter Consultation Fee: ");
                    double consultationFee = scanner.nextDouble();
                    System.out.print("Enter Treatment Cost: ");
                    double treatmentCost = scanner.nextDouble();

                    String billId = "B" + (bills.size() + 1);
                    Billing newBill = new Billing();
                    newBill.generateBill(billId, billAppointmentId, consultationFee, treatmentCost);
                    bills.add(newBill);
                    System.out.println("Bill generated successfully!");
                    newBill.displayBill();
                    break;

                case 8: // Exit
                    System.out.println("Exiting the system. Goodbye!");
                    scanner.close();
                    return;

                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }
    }
}
