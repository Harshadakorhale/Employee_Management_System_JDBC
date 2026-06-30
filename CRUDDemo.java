package employee_CRUD;

import java.util.Scanner;

public class CRUDDemo {

	public static void main(String[] args) {
		
		EmployeeOperations op = new EmployeeOperations();
		Scanner sc = new Scanner(System.in);
		
		while(true) {
			System.out.println("\n--- MENU ---");
            System.out.println("1. Create Employee");
            System.out.println("2. Read Employee");
            System.out.println("3. Update Employee");
            System.out.println("4. Delete Employee");
            System.out.println("5. Exit");

            System.out.print("Enter choice: ");
            int choice = sc.nextInt();

            switch (choice) {
                case 1:
                    op.createEmp();
                    break;
                case 2:
                    op.readEmp();
                    break;
                case 3:
                    op.updateEmp();
                    break;
                case 4:
                    op.deleteEmp();
                    break;
                case 5:
                    System.exit(0);
                default:
                	System.out.println("Invalid choice");
            }
		}
	}
}
