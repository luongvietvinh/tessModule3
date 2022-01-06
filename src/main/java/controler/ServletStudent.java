package controler;

import dao.ClassRoomDao;
import dao.StudenDao;
import model.ClassRoom;
import model.Student;
import service.StudenService;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.sql.SQLException;
import java.util.List;


@WebServlet(urlPatterns = "/student")
public class ServletStudent extends HttpServlet {
    StudenDao studenDao = new StudenDao();
    StudenService studenService = new StudenService();
    ClassRoomDao classRoomDao = new ClassRoomDao();


    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getParameter("action");
        if (action == null) {
            action = "";

        }
        switch (action) {
            case "create":
                List<ClassRoom> classRooms = classRoomDao.showListClasRoom();
                request.setAttribute("classrooms", classRooms);
                request.getRequestDispatcher("createStudent.jsp").forward(request, response);
                break;
            case "edit":
               classRooms = classRoomDao.showListClasRoom();
                request.setAttribute("classrooms", classRooms);
                request.getRequestDispatcher("editStudent.jsp").forward(request, response);
                break;
            case "delete":
                try {
                    deleteProduct(request, response);
                } catch (SQLException e) {
                    e.printStackTrace();
                }
                break;
            default:
                showList(request, response);
        }

    }


    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getParameter("action");
        if (action == null) {
            action = "";
        }
        switch (action) {
            case "create":
                try {
                    createProduct(request, response);
                } catch (SQLException e) {
                    e.printStackTrace();
                }
                break;
            case "edit":
                try {
                    editProduct(request, response);
                } catch (SQLException e) {
                    e.printStackTrace();
                }
                break;
            case "search":
                searchByName(request,response);
                break;
        }
    }

    public void searchByName (HttpServletRequest request, HttpServletResponse response) {
        String name = request.getParameter("search");

        RequestDispatcher dispatcher = request.getRequestDispatcher("showStudent.jsp");
        List<Student> studentList = studenDao.searchByName(name);;
        request.setAttribute("students", studentList);
        try {
            dispatcher.forward(request, response);
        } catch (ServletException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


    private void createProduct(HttpServletRequest request, HttpServletResponse response) throws SQLException, IOException {



        String name = request.getParameter("name");
        String date = request.getParameter("ngaysinh");
        String address = request.getParameter("address");
        String phoneNumber = request.getParameter("phoneNumber");
        String email = request.getParameter("email");
        int idCategory = Integer.parseInt(request.getParameter("idCategory"));
        studenService.add(new Student( name, date, address,phoneNumber,email, idCategory));
        try {
            response.sendRedirect("/student");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void editProduct(HttpServletRequest request, HttpServletResponse response) throws SQLException, IOException {
        int id = Integer.parseInt(request.getParameter("id"));
        String name = request.getParameter("name");
        String date = request.getParameter("ngaysinh");
        String address = request.getParameter("address");
        String phoneNumber = request.getParameter("phoneNumber");
        String email = request.getParameter("email");

        Student student = (new Student(id, name, date, address,phoneNumber,email));
        studenService.edit(id, student);

        response.sendRedirect("/student");
    }

    public void deleteProduct(HttpServletRequest request, HttpServletResponse response) throws SQLException, IOException {
        int id = Integer.parseInt(request.getParameter("id"));
        studenService.delete(id);

        response.sendRedirect("/student");
    }

    private void showList(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        RequestDispatcher dispatcher = request.getRequestDispatcher("showStudent.jsp");
        List<Student> studentList = studenDao.showListStudent();
        request.setAttribute("students", studentList);
        dispatcher.forward(request, response);
    }
}
