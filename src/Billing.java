public class Billing {
    private String billId;
    private String appointmentId;
    private double consultationFee;
    private double treatmentCost;
    private double totalCost;

    public void generateBill(String billId, String appointmentId, double consultationFee, double treatmentCost) {
        this.billId = billId;
        this.appointmentId = appointmentId;
        this.consultationFee = consultationFee;
        this.treatmentCost = treatmentCost;
        this.totalCost = consultationFee + treatmentCost;
    }

    public void displayBill() {
        System.out.println("Bill ID: " + billId);
        System.out.println("Appointment ID: " + appointmentId);
        System.out.println("Consultation Fee: " + consultationFee);
        System.out.println("Treatment Cost: " + treatmentCost);
        System.out.println("Total Cost: " + totalCost);
    }
}
