package main;
import java.util.Scanner;

import implementation.ExpenseServiceImpl;
import model.Expense;
import service.ExpenseService;

public class ExpenseMain {
	 public static void main(String[] args) {

	        Scanner sc = new Scanner(System.in);

	        ExpenseService service = new ExpenseServiceImpl();

	        while (true) {

	            System.out.println("\n===== Personal Expense Analyser =====");
	            System.out.println("1. Add Expense");
	            System.out.println("2. View Expenses");
	            System.out.println("3. Delete Expense");
	            System.out.println("4. Total Expense");
	            System.out.println("5. Exit");

	            System.out.print("Enter Choice: ");
	            int choice = sc.nextInt();

	            switch (choice) {

	                case 1:
	                    System.out.print("Enter ID: ");
	                    int id = sc.nextInt();

	                    sc.nextLine();
	                    System.out.print("Enter Category: ");
	                    String category = sc.nextLine();

	                    System.out.print("Enter Amount: ");
	                    double amount = sc.nextDouble();

	                    sc.nextLine();
	                    System.out.print("Enter Date: ");
	                    String date = sc.nextLine();

	                    System.out.print("Enter Description: ");
	                    String desc = sc.nextLine();

	                    Expense exp = new Expense(id, category, amount, date, desc);
	                    service.addExpense(exp);
	                    break;

	                case 2:
	                    service.viewAllExpenses();
	                    break;

	                case 3:
	                    System.out.print("Enter Expense ID to Delete: ");
	                    int delId = sc.nextInt();
	                    service.deleteExpense(delId);
	                    break;

	                case 4:
	                    service.totalExpense();
	                    break;

	                case 5:
	                    System.out.println("Thank You 😊");
	                    System.exit(0);

	                default:
	                    System.out.println("Invalid Choice!");
	            }
	        }
	    }
}
