package Form;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.sql.*;
import java.util.ArrayList;

public class DatabaseConnection {
    // Establish database connection
    public static Connection getConnection() throws SQLException {
        String url = "jdbc:mysql://localhost:3306/payroll_system"; // your DB name
        String user = "root"; // or your MySQL user
        String password = "root"; // default XAMPP password is "" or "root"
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
}