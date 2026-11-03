package service;
import db.DBConnection;
import model.Patient;
import java.sql.*;

public class PatientService {

    // CREATE
    public void addPatient(Patient p) {
        String sql = "INSERT INTO patients(name,age,gender,phone,disease) VALUES(?,?,?,?,?)";
        try (Connection con = DBConnection.getConnection();
             PreparedStatement ps = con.prepareStatement(sql)) {
            ps.setString(1, p.getName());
            ps.setInt(2, p.getAge());
            ps.setString(3, p.getGender());
            ps.setString(4, p.getPhone());
            ps.setString(5, p.getDisease());
            ps.executeUpdate();
            System.out.println("Patient added successfully.");
        } catch (SQLException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }

    // READ
    public void viewPatients() {
        String sql = "SELECT * FROM patients";
        try (Connection con = DBConnection.getConnection();
             Statement st = con.createStatement();
             ResultSet rs = st.executeQuery(sql)) {
            System.out.printf("%-5s %-20s %-5s %-8s %-12s %-15s%n",
                "ID", "Name", "Age", "Gender", "Phone", "Disease");
            while (rs.next()) {
                Patient p = new Patient(rs.getInt("patient_id"), rs.getString("name"),
                    rs.getInt("age"), rs.getString("gender"),
                    rs.getString("phone"), rs.getString("disease"));
                p.displayInfo();
            }
        } catch (SQLException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }

    // UPDATE
    public void updateDisease(int id, String disease) {
        String sql = "UPDATE patients SET disease=? WHERE patient_id=?";
        try (Connection con = DBConnection.getConnection();
             PreparedStatement ps = con.prepareStatement(sql)) {
            ps.setString(1, disease);
            ps.setInt(2, id);
            int rows = ps.executeUpdate();
            System.out.println(rows > 0 ? "Updated." : "Patient not found.");
        } catch (SQLException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }

    // DELETE
    public void deletePatient(int id) {
        String sql = "DELETE FROM patients WHERE patient_id=?";
        try (Connection con = DBConnection.getConnection();
             PreparedStatement ps = con.prepareStatement(sql)) {
            ps.setInt(1, id);
            int rows = ps.executeUpdate();
            System.out.println(rows > 0 ? "Deleted." : "Patient not found.");
        } catch (SQLException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }
}