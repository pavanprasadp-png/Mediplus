import java.util.Scanner;
import model.Patient;
import service.PatientService;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        PatientService ps = new PatientService();

        while (true) {
            System.out.println("\n===== HOSPITAL MANAGEMENT SYSTEM =====");
            System.out.println("1. Add Patient");
            System.out.println("2. View Patients");
            System.out.println("3. Update Patient Disease");
            System.out.println("4. Delete Patient");
            System.out.println("0. Exit");
            System.out.print("Enter choice: ");

            int choice;
            try {
                choice = Integer.parseInt(sc.nextLine());
            } catch (NumberFormatException e) {
                System.out.println("Please enter a number.");
                continue;
            }

            switch (choice) {
                case 1 -> {
                    System.out.print("Name: ");    String name = sc.nextLine();
                    System.out.print("Age: ");     int age = Integer.parseInt(sc.nextLine());
                    System.out.print("Gender: ");  String gender = sc.nextLine();
                    System.out.print("Phone: ");   String phone = sc.nextLine();
                    System.out.print("Disease: "); String disease = sc.nextLine();
                    ps.addPatient(new Patient(0, name, age, gender, phone, disease));
                }
                case 2 -> ps.viewPatients();
                case 3 -> {
                    System.out.print("Patient ID: "); int id = Integer.parseInt(sc.nextLine());
                    System.out.print("New disease: "); ps.updateDisease(id, sc.nextLine());
                }
                case 4 -> {
                    System.out.print("Patient ID: "); ps.deletePatient(Integer.parseInt(sc.nextLine()));
                }
                case 0 -> {
                    System.out.println("Goodbye!");
                    sc.close();
                    return;
                }
                default -> System.out.println("Invalid choice.");
                    
            }
        }
    }
}