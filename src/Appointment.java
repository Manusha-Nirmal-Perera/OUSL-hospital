public class Appointment implements Comparable<Appointment> {
    private final String appointmentId;
    private final String patientId;
    private final String doctorId;
    private final String appointmentDate;
    private final boolean isEmergency;
    private String diagnosis;
    private String treatment;

    public Appointment(String appointmentId, String patientId, String doctorId, String appointmentDate, boolean isEmergency) {
        this.appointmentId = appointmentId;
        this.patientId = patientId;
        this.doctorId = doctorId;
        this.appointmentDate = appointmentDate;
        this.isEmergency = isEmergency;
    }

    @Override
    public int compareTo(Appointment other) {
        return Boolean.compare(other.isEmergency, this.isEmergency);
    }

    public void addDiagnosis(String diagnosis, String treatment) {
        this.diagnosis = diagnosis;
        this.treatment = treatment;
    }

    public void displayAppointmentDetails() {
        System.out.println("Appointment ID: " + appointmentId);
        System.out.println("Patient ID: " + patientId);
        System.out.println("Doctor ID: " + doctorId);
        System.out.println("Appointment Date: " + appointmentDate);
        System.out.println("Emergency: " + (isEmergency ? "Yes" : "No"));
        System.out.println("Diagnosis: " + diagnosis);
        System.out.println("Treatment: " + treatment);
    }

    public String getAppointmentId() {
        return appointmentId;
    }
}
