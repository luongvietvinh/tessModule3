package service;

import dao.StudenDao;
import model.Student;

import java.sql.SQLException;
import java.util.List;

public class StudenService {

    StudenDao studenDao = new StudenDao();

    List<Student> studentList = studenDao.showListStudent();

    public void add(Student student) {
        studenDao.createStudentDao(student);
        studentList = studenDao.showListStudent();
    }

    public void delete (int id) {
        studenDao.deleteStudentDao(id);
        studenDao.showListStudent();
    }

    public void edit(int id ,Student student) throws SQLException {
        studenDao.updateStudentDao(id,student);
        studenDao.showListStudent();
    }
}
