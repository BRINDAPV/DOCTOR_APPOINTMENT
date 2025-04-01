package appointment;

import java.util.*;
import java.sql.*;

public class CurdOperation {
	public static void updatePatient(Scanner h) {
        System.out.println("Enter Patient ID to update: ");
        int id = h.nextInt();
        h.nextLine();
        
        System.out.println("Enter new Name: ");
        String name = h.nextLine();
        System.out.println("Enter new Age: ");
        int age = h.nextInt();
        h.nextLine();
        System.out.println("Enter new Problem: ");
        String problem = h.nextLine();
        
        String sql = "UPDATE patient SET name = ?, age = ?, problem = ? WHERE id = ?";
        
        try (Connection conn = DBConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setString(1, name);
            stmt.setInt(2, age);
            stmt.setString(3, problem);
            stmt.setInt(4, id);
            
            int rowsUpdated = stmt.executeUpdate();
            if (rowsUpdated > 0) {
                System.out.println("Patient details updated successfully!");
            } else {
                System.out.println("No patient found with ID: " + id);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static void deletePatient(Scanner h) {
        System.out.println("Enter Patient ID to delete: ");
        int id = h.nextInt();
        h.nextLine();
        
        String sql = "DELETE FROM patient WHERE id = ?";
        
        try (Connection conn = DBConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setInt(1, id);
            
            int rowsDeleted = stmt.executeUpdate();
            if (rowsDeleted > 0) {
                System.out.println("Patient deleted successfully!");
            } else {
                System.out.println("No patient found with ID: " + id);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }


}
