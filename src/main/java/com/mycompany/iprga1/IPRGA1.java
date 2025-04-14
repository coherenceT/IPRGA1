/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.iprga1;

/**
 *
 * @author lab_services_student
 */
import java.util.Scanner;

public class IPRGA1 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Login login = new Login();
        boolean exit = false;

        while (!exit) {
            System.out.println("\n=== Welcome to the User Authentication System ===");
            System.out.println("Please select an option:");
            System.out.println("1. Register");
            System.out.println("2. Login");
            System.out.println("3. Exit");
            System.out.print("Your choice: ");
            String choice = scanner.nextLine();

            switch (choice) {
                case "1":
                    // Registration process
                    System.out.print("Enter username (must contain '_' and be ≤ 5 characters): ");
                    String regUsername = scanner.nextLine();

                    System.out.print("Enter password (≥ 8 chars, 1 uppercase, 1 number, 1 special char): ");
                    String regPassword = scanner.nextLine();

                    System.out.print("Enter SA cell number (include international code, e.g., +27831234567): ");
                    String regCellNumber = scanner.nextLine();

                    String registrationResult = login.registerUser(regUsername, regPassword, regCellNumber);
                    System.out.println(registrationResult);
                    break;

                case "2":
                    // Login process
                    System.out.print("Enter username: ");
                    String loginUsername = scanner.nextLine();

                    System.out.print("Enter password: ");
                    String loginPassword = scanner.nextLine();

                    boolean loginSuccess = login.loginUser(loginUsername, loginPassword);
                    System.out.println(login.returnLoginStatus());
                    break;

                case "3":
                    // Exit the application
                    System.out.println("Exiting the application. Goodbye!");
                    exit = true;
                    break;

                default:
                    System.out.println("Invalid option selected. Please try again.");
                    break;
            }
        }

        scanner.close();
    }
}
