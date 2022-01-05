package model;

public class Student {
//
//    id int AI PK
//    name varchar(100)
//    ngaysinh date
//    address varchar(255)
//    phoneNumber varchar(200)
//    email varchar(50)
//    idClasRoom

    private int id;
    private String name;
    private String ngaysinh;
    private String address;
    private String phoneNumber;
    private String email;
    private int idClasRoom;
    private String nameClasRoom;


    public Student(String name, String ngaysinh, String address, String phoneNumber, String email, int idClasRoom) {
        this.name = name;
        this.ngaysinh = ngaysinh;
        this.address = address;
        this.phoneNumber = phoneNumber;
        this.email = email;
        this.idClasRoom = idClasRoom;

    }

    public Student(int id, String name, String ngaysinh, String address, String phoneNumber, String email, String nameclassroom) {
        this.id = id;
        this.name = name;
        this.ngaysinh = ngaysinh;
        this.address = address;
        this.phoneNumber = phoneNumber;
        this.email = email;
        this.nameClasRoom = nameclassroom;
    }

    public Student(int id, String name, String ngaysinh, String address, String phoneNumber, String email) {
        this.name = name;
        this.ngaysinh = ngaysinh;
        this.address = address;
        this.phoneNumber = phoneNumber;
        this.email = email;
    }


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getNgaysinh() {
        return ngaysinh;
    }

    public void setNgaysinh(String ngaysinh) {
        this.ngaysinh = ngaysinh;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public int getIdClasRoom() {
        return idClasRoom;
    }

    public String getNameClasRoom() {
        return nameClasRoom;
    }

    public void setNameClasRoom(String nameClasRoom) {
        this.nameClasRoom = nameClasRoom;
    }

    public void setIdClasRoom(int idClasRoom) {
        this.idClasRoom = idClasRoom;

    }

    @Override
    public String toString() {
        return "model.Student{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", date='" + ngaysinh + '\'' +
                ", address='" + address + '\'' +
                ", phoneNumber='" + phoneNumber + '\'' +
                ", email='" + email + '\'' +
                '}';
    }
}
