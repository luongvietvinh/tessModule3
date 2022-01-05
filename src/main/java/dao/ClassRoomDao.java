package dao;

import model.ClassRoom;
import model.Student;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class ClassRoomDao {
    protected Connection getConnection() {
        String jdbcURL = "jdbc:mysql://localhost:3306/quanlyhocvien";
        String jdbcUsername = "root";
        String jdbcPassword = "12345678";

        java.sql.Connection connection = null;
        try {
            Class.forName("com.mysql.jdbc.Driver");
            connection = DriverManager.getConnection(jdbcURL, jdbcUsername, jdbcPassword);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return connection;
    }

    public List<ClassRoom> showListClasRoom() {
        String getall = "SELECT * FROM clasroom";
        List<ClassRoom> classRooms = new ArrayList<>();

        try (Connection connection = getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(getall)) {
            ResultSet rs = preparedStatement.executeQuery();
            while (rs.next()) {
                int id = rs.getInt("idClasRoom");
                String name = rs.getString("nameClasRoom");

                classRooms.add(new ClassRoom(id, name));
            }
            return classRooms;
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return null;
    }
//
//    public static void main(String[] args) {
//        ClassRoomDao classRoomDao = new ClassRoomDao();
//        List<ClassRoom> classRooms = classRoomDao.showListStudent();
//        for (ClassRoom c: classRooms) {
//            System.out.println(c);
//        }
//
//    }


}
