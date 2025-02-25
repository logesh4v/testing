package HMS_System;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class StaffDatabase {

    public void addStaff(Staff staff) throws SQLException {
        String query = "INSERT INTO staff (name, contact_number) VALUES (?, ?)";
        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement psmt = conn.prepareStatement(query)) {

            psmt.setString(1, staff.getName());
            psmt.setString(2, staff.getContactNumber());
            psmt.executeUpdate();

            System.out.println("Staff added successfully!");
        }
    }

    public List<Staff> getAllStaff() throws SQLException {
        List<Staff> staffList = new ArrayList<>();
        String query = "SELECT * FROM staff";
        try (Connection conn = DatabaseConnection.getConnection();
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(query)) {

            while (rs.next()) {
                Staff staff = new Staff(
                    rs.getString("name"),
                    rs.getString("contact_number")
                );
                staff.setId(rs.getInt("id"));
                staffList.add(staff);
            }
        }
        return staffList;
    }

    public void updateStaff(int id, Staff staff) throws SQLException {
        String query = "UPDATE staff SET name = ?, contact_number = ? WHERE id = ?";
        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement psmt = conn.prepareStatement(query)) {

            psmt.setString(1, staff.getName());
            psmt.setString(2, staff.getContactNumber());
            psmt.setInt(3, id);
            int rowsAffected = psmt.executeUpdate();

            if (rowsAffected > 0) {
                System.out.println("Staff updated successfully!");
            } else {
                System.out.println("Failed to update staff.");
            }
        }
    }

    public void deleteStaff(int id) throws SQLException {
        String query = "DELETE FROM staff WHERE id = ?";
        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement psmt = conn.prepareStatement(query)) {

            psmt.setInt(1, id);
            int rowsAffected = psmt.executeUpdate();

            if (rowsAffected > 0) {
                System.out.println("Staff deleted successfully!");
            } else {
                System.out.println("Failed to delete staff.");
            }
        }
    }
}


