package sg.edu.rp.c346.id19020303.petboardingapp;

import java.io.Serializable;
import java.util.Date;

public class Message implements Serializable {

    private String name;
    private int days;
    private String petType;
    private Date boardDate;
    private boolean isVaccinated;

    @Override
    public String toString() {
        return "Message{" +
                "boardDate='" + boardDate + '\'' +
                ", name='" + name + '\'' +
                ", days='" + days + '\'' +
                ", petType='" + petType + '\'' +
                ", vaccinated='" + isVaccinated + '\'' +
                '}';
    }

    public Message() {
// Default constructor required for calls to snapshot.toObject(Message.class)
    }

    public Message(String name, String petType, Date boardDate, boolean isVaccinated, int days) {
        this.name = name;
        this.petType = petType;
        this.boardDate = boardDate;
        this.isVaccinated = isVaccinated;
        this.days = days;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getDays() {
        return days;
    }

    public void setDays(int days) {
        this.days = days;
    }

    public String getPetType() {
        return petType;
    }

    public void setPetType(String petType) {
        this.petType = petType;
    }

    public Date getBoardDate() {
        return boardDate;
    }

    public void setBoardDate(Date boardDate) {
        this.boardDate = boardDate;
    }

    public boolean getVaccinated() {
        return isVaccinated;
    }

    public void setVaccinated(boolean vaccinated) {
        isVaccinated = vaccinated;
    }
}
