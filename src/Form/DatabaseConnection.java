package Form;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.sql.*;
import java.util.ArrayList;
import javax.swing.JOptionPane;

public class DatabaseConnection {
    // Establish database connection
    public static Connection getConnection() throws SQLException {
        String url = "jdbc:mysql://localhost:3306/payroll_system"; // your DB name
        String user = "root"; // or your MySQL user
        String password = "root"; 
        return DriverManager.getConnection(url, user, password);
    }

    // Save all employees into the MySQL table
    public static void saveAllEmployeesToDatabase(ArrayList<Employee> employeeList) {
        try (Connection conn = getConnection()) {
            String sql = "REPLACE INTO employees "
                       + "(Name, ID, position, Contact, Days_Worked, Rate_Per_Day, RegularTotalAmount, "
                       + "Hours_Worked, Rate_Per_Hour, OvertimeTotalAmount, TotalAmount) "
                       + "VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
            PreparedStatement ps = conn.prepareStatement(sql);
            Statement stmt = conn.createStatement();
            stmt.executeUpdate("DELETE FROM employees");
            for (Employee emp : employeeList) {
                ps.setString(1, emp.getName());
                ps.setString(2, emp.getID());
                ps.setString(3, emp.getPosition());
                ps.setString(4, emp.getContact());
                ps.setDouble(5, emp.getDaysWorked());
                ps.setDouble(6, emp.getRatePerDay());
                ps.setDouble(7, emp.computeRegularPay());
                ps.setDouble(8, emp.getHoursWorked());
                ps.setDouble(9, emp.getRatePerHour());
                ps.setDouble(10, emp.computeOvertimePay());
                ps.setDouble(11, emp.computeTotalAmount());
                ps.executeUpdate();
            }

            System.out.println("✅ All data saved to MySQL.");
        } catch (SQLException e) {
            System.out.println("❌ Error saving to database: " + e.getMessage());
        }
    }

    // Load all employees from the MySQL table
    public static ArrayList<Employee> loadAllEmployeesFromDatabase() {
        ArrayList<Employee> employeeList = new ArrayList<>();

        try (Connection conn = getConnection()) {
            String sql = "SELECT * FROM employees";
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery(sql);

            while (rs.next()) {
                Employee emp = new Employee(
                        rs.getString("Name"),
                        rs.getString("ID"),
                        rs.getString("Position"),
                        rs.getString("Contact"),
                        rs.getDouble("Days_Worked"),
                        rs.getDouble("Rate_Per_Day"),
                        rs.getDouble("Hours_Worked"),
                        rs.getDouble("Rate_Per_Hour")
                );

                emp.setRegularTotalAmount(rs.getDouble("RegularTotalAmount"));
                emp.setOvertimeTotalAmount(rs.getDouble("OvertimeTotalAmount"));
                emp.setTotalAmount(rs.getDouble("TotalAmount"));

                employeeList.add(emp);
            }

            System.out.println("✅ All data loaded from MySQL.");
        } catch (SQLException e) {
            System.out.println("❌ Error loading from database: " + e.getMessage());
        }

        return employeeList;
    }
    
    public static void updateToSQL(Employee emp) {
    String url = "jdbc:mysql://localhost:3306/payroll_system";
    String user = "root";
    String password = "root";

    String sql = "UPDATE employees SET Name = ?, Position = ?, Contact = ?, Days_Worked = ?, " +
             "Rate_Per_Day = ?, Hours_Worked = ?, Rate_Per_Hour = ?, RegularTotalAmount = ?, " +
             "OvertimeTotalAmount = ?, TotalAmount = ? WHERE ID = ?";

    try (Connection conn = DriverManager.getConnection(url, user, password);
         PreparedStatement stmt = conn.prepareStatement(sql)) {

        stmt.setString(1, emp.getName());
        stmt.setString(2, emp.getPosition());
        stmt.setString(3, emp.getContact());
        stmt.setDouble(4, emp.getDaysWorked());
        stmt.setDouble(5, emp.getRatePerDay());
        stmt.setDouble(6, emp.getHoursWorked());
        stmt.setDouble(7, emp.getRatePerHour());
        stmt.setDouble(8, emp.computeRegularPay());
        stmt.setDouble(9, emp.computeOvertimePay());
        stmt.setDouble(10, emp.computeTotalAmount());
        stmt.setString(11, emp.getID()); // WHERE clause

        int rowsUpdated = stmt.executeUpdate();
        if (rowsUpdated > 0) {
            System.out.println("Employee updated successfully in MySQL.");
        } else {
            System.out.println("No record was updated. Check ID.");
        }

    } catch (SQLException e) {
        e.printStackTrace();
        JOptionPane.showMessageDialog(null, "SQL Update Error: " + e.getMessage());
    }
}
}