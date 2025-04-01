package appointment;

import java.util.Scanner;

public class Main {
	public static void main(String args[]) {
		Scanner h = new Scanner(System.in);
		
		while (true) {
			System.out.println("Doctor Appointment System");
			System.out.println("1. Register");
			System.out.println("2. Show all appointments");
			
			System.out.println("Enter your choice: ");
			int choice = h.nextInt();
			h.nextLine();
			
			switch(choice) {
			case 1:
				Patient.registerPatient(h);
				System.out.println();
				break;
			case 2:
				Patient.displayPatients();
				System.out.println();
				break;
			}
		}
	}
}
