package appointment;

import java.util.*;
import java.sql.*;

public class Patient {
	public static void registerPatient(Scanner h) {
		System.out.println("Enter Name: ");
		String name = h.nextLine();
		System.out.println("Enter Age: ");
		int age = h.nextInt();
		h.nextLine();
		System.out.println("Enter your Problem");
		String problem = h.nextLine();
		
		// starts here
		String sql = "insert into patient (name, age, problem) values (?,?,?)";
		
		try (Connection conn = DBConnection.getConnection();
				PreparedStatement stmt = conn.prepareStatement(sql)){
			stmt.setString(1, name);
			stmt.setInt(2, age);
			stmt.setString(3, problem);
			
			stmt.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	public static void displayPatients() {
		String sql = "Select * from patient";
		
		try (Connection conn = DBConnection.getConnection();
				PreparedStatement stmt = conn.prepareStatement(sql);
				ResultSet rs = stmt.executeQuery()){
			
			System.out.println("\nList of Patients:");
	        System.out.println("-------------------------------------");

	        while (rs.next()) {
	            System.out.println("ID: " + rs.getInt("id"));
	            System.out.println("Name: " + rs.getString("name"));
	            System.out.println("Age: " + rs.getInt("age"));
	            System.out.println("Problem: " + rs.getString("problem"));
	            System.out.println("-------------------------------------");
	        }
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}

//			System.out.println("\n---------------------------------------------------");
//	        System.out.printf("| %-5s | -20s | %-3s | %-30s |\n", "ID", "Name", "Age", "Problem");
//	        System.out.println("---------------------------------------------------");
//%
//	        while (rs.next()) {
//	            System.out.printf("| %-5d | %-20s | %-3d | %-30s |\n",
//	                    rs.getInt("id"),
//	                    rs.getString("name"),
//	                    rs.getInt("age"),
//	                    rs.getString("problem"));
//	        }
//
//	        System.out.println("---------------------------------------------------");