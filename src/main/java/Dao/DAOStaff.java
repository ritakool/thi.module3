package Dao;

import context.DBContext;
import model.Department;
import model.Staff;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class DAOStaff {
    DAODepertment daoDepertment = new DAODepertment();
    Connection connection = null;
    PreparedStatement preparedStatement = null;
    ResultSet resultSet = null;

    // hiển thị toàn bộ danh sách nhân viên
    public List<Staff> getListStaff() throws ClassNotFoundException {
        List<Staff> staffList = new ArrayList<>();
        String sql = "SELECT * FROM staff";
        try {
            connection = new DBContext().getConnection();
            preparedStatement = connection.prepareStatement(sql);
            resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                int id = resultSet.getInt("id");
                String name = resultSet.getString("name");
                String email = resultSet.getString("email");
                String address = resultSet.getString("address");
                String phoneNumber = resultSet.getString("phoneNumber");
                int salary = resultSet.getInt("salary");
                int departmentId = resultSet.getInt("department");

                // Lấy thông tin phòng ban từ departmentId
                Department department = daoDepertment.getDepartmentByID(departmentId);

                Staff staff = new Staff(id, name, email, address, phoneNumber, salary, department);
                staffList.add(staff);
            }
        } catch (SQLException e) {
        }
        return staffList;
    }

    //thêm nhân viên
    public Staff addStaff(String name, String email, String address, String phoneNumber, int salary, int department) {
        Staff staff = null;
        String sql = "INSERT INTO staff(name, email, address, phonenumber, salary, department) VALUES (?, ?, ?, ?, ?, ?)";
        try {
            connection = new DBContext().getConnection();
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1, name);
            preparedStatement.setString(2, email);
            preparedStatement.setString(3, address);
            preparedStatement.setString(4, phoneNumber);
            preparedStatement.setInt(5, salary);
            preparedStatement.setInt(6, department);
            preparedStatement.executeUpdate();
        } catch (SQLException | ClassNotFoundException e) {
        }
        return staff;
    }

    public Staff updateStaffByID(int id, String name, String email, String address, String phoneNumber, int salary, int department) {
        Staff staff = null;
        String sql = "UPDATE staff SET name = ?, email = ?, address = ?, phonenumber = ?, salary = ?, department = ? WHERE id = ?;";
        try {
            connection = new DBContext().getConnection();
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1, name);
            preparedStatement.setString(2, email);
            preparedStatement.setString(3, address);
            preparedStatement.setString(4, phoneNumber);
            preparedStatement.setInt(5, salary);
            preparedStatement.setInt(6, department);
            preparedStatement.setInt(7, id);
            preparedStatement.executeUpdate();
        } catch (SQLException | ClassNotFoundException e) {
        }
        return staff;
    }

    public Staff getStaffByID(int id) {
        Staff staff = null;
        String sql = "SELECT * FROM staff WHERE id = ?;";
        try {
            connection = new DBContext().getConnection();
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setInt(1, id);
            resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                int idd = resultSet.getInt("id");
                String name = resultSet.getString("name");
                String email = resultSet.getString("email");
                String address = resultSet.getString("address");
                String phoneNumber = resultSet.getString("phoneNumber");
                int salary = resultSet.getInt("salary");
                int departmentId = resultSet.getInt("department");

                // Lấy thông tin phòng ban từ departmentId
                Department department = daoDepertment.getDepartmentByID(departmentId);
                staff = new Staff(idd, name, email, address, phoneNumber, salary, department);
            }
        } catch (SQLException | ClassNotFoundException e) {
        }
        return staff;
    }

    public boolean deleteStaffByID(int id) throws ClassNotFoundException {
        boolean isDelete = false;
        String sql = "DELETE staff FROM staff WHERE id = ?";
        try {
            connection = new DBContext().getConnection();
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setInt(1, id);
            return preparedStatement.executeUpdate() >= 1;
        } catch (SQLException e) {
        }
        return isDelete;
    }

    public List<Staff> searchStaffByname(String name){
        List<Staff> staffList = new ArrayList<>();
        String sql = "SELECT * FROM staff WHERE name LIKE ?;";
        try {
            connection = new DBContext().getConnection();
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1, "%" + name + "%");
            resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                int id = resultSet.getInt("id");
                String namee = resultSet.getString("name");
                String email = resultSet.getString("email");
                String address = resultSet.getString("address");
                String phoneNumber = resultSet.getString("phoneNumber");
                int salary = resultSet.getInt("salary");
                int departmentId = resultSet.getInt("department");

                // Lấy thông tin phòng ban từ departmentId
                Department department = daoDepertment.getDepartmentByID(departmentId);

                Staff staff = new Staff(id, namee, email, address, phoneNumber, salary, department);
                staffList.add(staff);
            }
        } catch (SQLException | ClassNotFoundException e){
        }
        return staffList;
    }

    public static void main(String[] args) throws ClassNotFoundException {
        DAOStaff dao = new DAOStaff();
        dao.deleteStaffByID(8);
    }
}
