package model;

public class ClassRoom {
    private int idClassRoom;
    private String nameClassRoom;

    public ClassRoom(int idClassRoom, String nameClassRoom) {
        this.idClassRoom = idClassRoom;
        this.nameClassRoom = nameClassRoom;
    }

    public int getIdClassRoom() {
        return idClassRoom;
    }

    public void setIdClassRoom(int idClassRoom) {
        this.idClassRoom = idClassRoom;
    }

    public String getNameClassRoom() {
        return nameClassRoom;
    }

    public void setNameClassRoom(String nameClassRoom) {
        this.nameClassRoom = nameClassRoom;
    }

    @Override
    public String toString() {
        return "ClassRoom{" +
                "idClassRoom=" + idClassRoom +
                ", nameClassRoom='" + nameClassRoom + '\'' +
                '}';
    }
}
