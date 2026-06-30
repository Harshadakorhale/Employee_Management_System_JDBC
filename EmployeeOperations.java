package employee_CRUD;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Scanner;

import com.mysql.cj.protocol.Resultset;

public class EmployeeOperations {

	Statement stmt;
	Scanner sc = new Scanner(System.in);

	public EmployeeOperations() {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/empdb", "root", "root");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	void createEmp() {
		try {
			System.out.println("Enter Employee Id : ");
			int eid = sc.nextInt();
			System.out.println("Enter Employee Name :");
			String name = sc.next();
			System.out.println("Enter Employee Salary :");
			double salary = sc.nextDouble();

			String sql = "INSERT INTO emp VALUES (\" + eid + \", '\" + name + \"', \" + salary + \")";

			stmt.executeUpdate(sql);
			System.out.println("Employee Inserted Successfully >>> ");
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	void readEmp() {
		try {
			ResultSet rs = stmt.executeQuery("SELECT * FROM EMP");
			System.out.println("ID\tName\tSalary");
			while (rs.next()) {
				System.out.println(rs.getInt(1) + "\t" + rs.getString(2) + "\t" + rs.getDouble(3));
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	void updateEmp() {
		try {
			System.out.println("Enter ID to Update :");
			int eid = sc.nextInt();

			System.out.println("Enter New Salary to Update :");
			double salary = sc.nextDouble();

			String sql = "UPDATE emp SET salary=" + salary + " WHERE eid=" + eid;
			int rows = stmt.executeUpdate(sql);
			System.out.println(rows + " record updated ");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	void deleteEmp() {
		try {
			System.out.println("Enter Id to delete ");
			int eid = sc.nextInt();
			String sql = "DELETE FROM emp WHERE eid=" + eid;
			int rows = stmt.executeUpdate(sql);
			System.out.println(rows + " record deleted");

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
