import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Doctor {
    private String doctorId;
    private String name;
    private List<String> specializations;
    private Map<String, List<String>> schedule;

    public Doctor() {
        this.specializations = new ArrayList<>();
        this.schedule = new HashMap<>();
    }

    public void setDoctorDetails(String doctorId, String name, List<String> specializations) {
        this.doctorId = doctorId;
        this.name = name;
        this.specializations.addAll(specializations);
    }

    public void addSlot(String day, String slot) {
        schedule.putIfAbsent(day, new ArrayList<>());
        schedule.get(day).add(slot);
    }

    public void removeSlot(String day, String slot) {
        if (schedule.containsKey(day)) {
            schedule.get(day).remove(slot);
        }
    }

    public void displayDoctorDetails() {
        System.out.println("Doctor ID: " + doctorId);
        System.out.println("Name: " + name);
        System.out.println("Specializations: " + specializations);
        System.out.println("Schedule: " + schedule);
    }

    public String getDoctorId() {
        return doctorId;
    }

    public Map<String, List<String>> getSchedule() {
        return schedule;
    }
}
