package dao;

import model.Student;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class StudenDao {

    protected Connection getConnection() {
        String jdbcURL = "jdbc:mysql://localhost:3306/quanlyhocvien";
        String jdbcUsername = "root";
        String jdbcPassword = "12345678";

        Connection connection = null;
        try {
            Class.forName("com.mysql.jdbc.Driver");
            connection = DriverManager.getConnection(jdbcURL, jdbcUsername, jdbcPassword);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return connection;
    }




    public void createStudentDao(Student student) {
        String saveCustomer = "INSERT INTO customer (full_name,passwords,email,phone,address,id_role,img) VALUES (?,?,?,?,?,?,?,)";
        try{
            PreparedStatement preparedStatement = getConnection().prepareStatement(saveCustomer);
            preparedStatement.setString(1, student.getName());
            preparedStatement.setString(2, student.getNgaysinh());
            preparedStatement.setString(3, student.getAddress());
            preparedStatement.setString(4, student.getPhoneNumber());
            preparedStatement.setString(5, student.getEmail());
            preparedStatement.setInt(6, student.getIdClasRoom());
            preparedStatement.execute();
        }catch (SQLException e){
            printSQLException(e);
        }
    }



    public List<Student> showListStudent() {
        String getall = "select student.* , clasroom.nameClasRoom from student join clasroom on student.idClasRoom = clasroom.idClasRoom";
        List<Student> studentList = new ArrayList<>();

        try (Connection connection = getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(getall)) {
            ResultSet rs = preparedStatement.executeQuery();
            while (rs.next()) {
                int id = rs.getInt("id");
                String name = rs.getString("name");
                String date = rs.getString("ngaysinh");
                String address = rs.getString("address");
                String phoneNumber = rs.getString("phoneNumber");
                String email = rs.getString("email");
                String nameclassroom = rs.getString("nameClasRoom");
                studentList.add(new Student(id, name, date, address,phoneNumber,email,nameclassroom));
            }
            return studentList;
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return null;
    }

 public List<Student> searchByName(String findname) {
        String getall = "select student.* , clasroom.nameClasRoom from student\n" +
                " join clasroom on student.idClasRoom = clasroom.idClasRoom where student.name like '%" + findname +"%\'";


        try {
            Statement statement = getConnection().createStatement();
            ResultSet rs = statement.executeQuery(getall);
            List<Student> studentList = new ArrayList<>();
            while (rs.next()) {
                int id = rs.getInt("id");
                String name = rs.getString("name");
                String date = rs.getString("ngaysinh");
                String address = rs.getString("address");
                String phoneNumber = rs.getString("phoneNumber");
                String email = rs.getString("email");
                String nameclassroom = rs.getString("nameClasRoom");
                studentList.add(new Student(id, name, date, address,phoneNumber,email,nameclassroom));
            }
            return studentList;
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return null;
    }



    public void deleteStudentDao(int id) {
        String deleteSQL = "DELETE  from student where id=?";
        try {
            PreparedStatement preparedStatement = getConnection().prepareStatement(deleteSQL);
            preparedStatement.setInt(1,id);
            preparedStatement.execute();
        }catch (Exception e){
            e.printStackTrace();
        }
    }




    public void updateStudentDao(int id, Student student) throws SQLException {
        String editProduct = "update student set name = ?,ngaysinh = ?, address =?,phoneNumber =?, email = ? where id = ?";

        try (Connection connection = getConnection();
             PreparedStatement statement = connection.prepareStatement(editProduct)){
            statement.setString(1,student.getName());
            statement.setString(2,student.getNgaysinh());
            statement.setString(3,student.getAddress());
            statement.setString(4,student.getPhoneNumber());
            statement.setString(5,student.getEmail());
            statement.setInt(6,id);

            statement.execute();
        }



    }
    private void printSQLException(SQLException ex) {
        for (Throwable e : ex) {
            if (e instanceof SQLException) {
                e.printStackTrace(System.err);
                System.err.println("SQLState: " + ((SQLException) e).getSQLState());
                System.err.println("Error Code: " + ((SQLException) e).getErrorCode());
                System.err.println("Message: " + e.getMessage());
                Throwable t = ex.getCause();
                while (t != null) {
                    System.out.println("Cause: " + t);
                    t = t.getCause();
                }
            }
        }
    }

}
